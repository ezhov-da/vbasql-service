package ru.ezhov.vbasql.service;

public class ToSqlResponse {
    private String text;

    public ToSqlResponse() {
    }

    public ToSqlResponse(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ToSqlResponse{" +
                "text='" + text + '\'' +
                '}';
    }
}
