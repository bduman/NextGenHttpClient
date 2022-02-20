package com.bduman.nextgen.httpclient;

import com.bduman.nextgen.httpclient.jaxrs.DefaultHttpClient;
import com.bduman.nextgen.httpclient.jaxrs.DefaultInvocationBuilder;
import com.bduman.nextgen.httpclient.jaxrs.HeaderDecorator;
import com.bduman.nextgen.httpclient.jaxrs.IInvocationBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        IHttpClient client = buildHttpClient("https://reqbin.com/");
        HttpRequest request = new HttpRequest();

        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Bearer {token}");
        request.setHeaders(Optional.of(headers));

        HttpResponse response = client.send("GET", "/echo/get/json", request);
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        Optional<String> bodyOptional = response.getBody();
        if (bodyOptional.isPresent()) {
            String body = bodyOptional.get();
            System.out.println("Body: " + body);
        }
    }

    private static IHttpClient buildHttpClient(String uri) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(uri);
        IInvocationBuilder invocationBuilder = new DefaultInvocationBuilder();
        invocationBuilder = new HeaderDecorator(invocationBuilder);
        IHttpClient result = new DefaultHttpClient(webTarget, invocationBuilder);

        return result;
    }
}
