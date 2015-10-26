package com.kyip.api.templateproject.external.resource;

import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/kyip/v1/test")
public interface TemplateResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnyString(@QueryParam("anyString") String anyString) throws Exception;

	@GET
	@Path("/html")
	@Produces(MediaType.TEXT_HTML)
	public View getAnyStringInView(@QueryParam("anyString") String anyString) throws Exception;

}
