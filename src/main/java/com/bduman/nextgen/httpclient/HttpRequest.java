package com.bduman.nextgen.httpclient;

import java.util.Map;
import java.util.Optional;

public class HttpRequest {
    private Optional<Map<String, String>> headers;
    private Optional<String> body;

    public HttpRequest() {
        this.body = Optional.empty();
        this.headers = Optional.empty();
    }

    public Optional<Map<String, String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Optional<Map<String, String>> headers) {
        this.headers = headers;
    }

    public Optional<String> getBody() {
        return body;
    }

    public void setBody(Optional<String> body) {
        this.body = body;
    }
}
