package com.bduman.nextgen.httpclient.jaxrs;

import com.bduman.nextgen.httpclient.HttpRequest;
import com.bduman.nextgen.httpclient.jaxrs.invocationbuilder.IInvocationBuilder;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import java.util.Optional;

public class DefaultInvocationBuilder implements IInvocationBuilder {
    @Override
    public Invocation build(Invocation.Builder builder, String method, String url, HttpRequest request) {
        Optional<String> bodyOptional = request.getBody();

        if (bodyOptional.isEmpty()) {
            Invocation result = builder.build(method);
            return result;
        }

        String body = bodyOptional.get();
        // FIX: Entity format
        Entity<String> json = Entity.json(body);
        Invocation result = builder.build(method, json);

        return result;
    }
}
