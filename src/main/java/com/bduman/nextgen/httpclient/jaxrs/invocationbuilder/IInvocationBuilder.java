package com.bduman.nextgen.httpclient.jaxrs.invocationbuilder;

import com.bduman.nextgen.httpclient.HttpRequest;

import javax.ws.rs.client.Invocation;

public interface IInvocationBuilder {
    Invocation build(Invocation.Builder builder, String method, String url, HttpRequest request);
}
