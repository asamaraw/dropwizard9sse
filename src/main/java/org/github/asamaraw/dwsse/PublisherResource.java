package org.github.asamaraw.dwsse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/publish")
public class PublisherResource {
    @GET
    public Response register(@QueryParam("msg") String msg) {
        EventPublisher.pub(msg);
        return Response.ok().build();
    }
}
