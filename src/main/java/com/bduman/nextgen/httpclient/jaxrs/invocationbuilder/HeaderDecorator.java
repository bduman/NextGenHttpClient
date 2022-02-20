package com.bduman.nextgen.httpclient.jaxrs.invocationbuilder;

import com.bduman.nextgen.httpclient.HttpRequest;

import javax.ws.rs.client.Invocation;
import java.util.Map;
import java.util.Optional;

public class HeaderDecorator implements IInvocationBuilder {

    private final IInvocationBuilder decorated;

    public HeaderDecorator(IInvocationBuilder decorated) {
        this.decorated = decorated;
    }

    @Override
    public Invocation build(Invocation.Builder builder, String method, String url, HttpRequest request) {
        Optional<Map<String, Object>> headersOptional = request.getHeaders();

        if (headersOptional.isPresent()) {
            Map<String, Object> headers = headersOptional.get();
            headers.forEach(builder::header);
        }

        return decorated.build(builder, method, url, request);
    }
}
