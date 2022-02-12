package com.bduman.nextgen.httpclient;

import java.util.Optional;

public class HttpResponse {
    private int statusCode;
    private Optional<String> body;

    public HttpResponse(int statusCode) {
        this.statusCode = statusCode;
        this.body = Optional.empty();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Optional<String> getBody() {
        return body;
    }

    public void setBody(Optional<String> body) {
        this.body = body;
    }
}
