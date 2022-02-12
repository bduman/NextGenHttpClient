package com.bduman.nextgen.httpclient;

public interface IHttpClient {
    HttpResponse send(String method, String url, HttpRequest request);
}
