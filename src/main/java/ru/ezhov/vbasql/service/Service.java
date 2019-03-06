package ru.ezhov.vbasql.service;

import ru.ezhov.vba.SqlCutOff;
import ru.ezhov.vba.VbaGeneration;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vbasql")
public class Service {

    @GET
    public Response info() {
        return Response.ok().header("Access-Control-Allow-Origin", "*").entity("All good").build();
    }

    @OPTIONS
    @Path("/toSql")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response toSql(){
        return Response
                .ok()
                .header("Access-Control-Allow-Headers", "x-requested-with")
                .header("Access-Control-Allow-Method", "POST")
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }


    @POST
    @Path("/toSql")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response toSql(
            @FormParam("addADODB") boolean addADODB,
            @FormParam("useConnectionString") boolean useConnectionString,
            @FormParam("addExecuteADODB") boolean addExecuteADODB,
            @FormParam("connectionString") String connectionString,
            @FormParam("variable") String variable,
            @FormParam("query") String query
    ) {
        VbaGeneration vbaGeneration = new VbaGeneration(useConnectionString, addADODB, addExecuteADODB, query, connectionString, variable);
        ToSqlResponse toSqlResponse;
        try {
            toSqlResponse = new ToSqlResponse(vbaGeneration.generate());
            return Response.ok().header("Access-Control-Allow-Origin", "*").entity(toSqlResponse).build();
        } catch (Exception e) {
            toSqlResponse = new ToSqlResponse("Ошибка при обработке запроса: \n" + e.getMessage());
            return Response.serverError().header("Access-Control-Allow-Origin", "*").entity(toSqlResponse).build();
        }
    }

    @OPTIONS
    @Path("/toVba")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response toVba(){
        return Response
                .ok()
                .header("Access-Control-Allow-Headers", "x-requested-with")
                .header("Access-Control-Allow-Method", "POST")
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }

    @POST
    @Path("/toVba")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response toVba(@FormParam("query") String text) {
        SqlCutOff sqlCutOff = new SqlCutOff();
        ToSqlResponse toSqlResponse;
        try {
            toSqlResponse = new ToSqlResponse(sqlCutOff.getSqlText(text));
            return Response.ok().header("Access-Control-Allow-Origin", "*").entity(toSqlResponse).build();
        } catch (Exception e) {
            toSqlResponse = new ToSqlResponse("Ошибка при обработке запроса: \n" + e.getMessage());
            return Response.serverError().header("Access-Control-Allow-Origin", "*").entity(toSqlResponse).build();
        }
    }
}
