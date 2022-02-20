package com.bduman.nextgen.httpclient.jaxrs;

import com.bduman.nextgen.httpclient.HttpRequest;
import com.bduman.nextgen.httpclient.HttpResponse;
import com.bduman.nextgen.httpclient.IHttpClient;
import com.bduman.nextgen.httpclient.jaxrs.invocationbuilder.IInvocationBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

public class DefaultHttpClient implements IHttpClient {
    private WebTarget webTarget;
    private IInvocationBuilder invocationBuilder;

    public DefaultHttpClient(WebTarget webTarget, IInvocationBuilder invocationBuilder) {
        this.webTarget = webTarget;
        this.invocationBuilder = invocationBuilder;
    }

    @Override
    public HttpResponse send(String method, String url, HttpRequest request) {
        Invocation.Builder builder = webTarget.path(url).request();
        Invocation invocation = invocationBuilder.build(builder, method, url, request);

        Response response = invocation.invoke();
        int statusCode = response.getStatus();
        HttpResponse result = new HttpResponse(statusCode);

        if (response.hasEntity()) {
            String responseBody = response.readEntity(String.class);
            result.setBody(Optional.of(responseBody));
        }

        return result;
    }
}
