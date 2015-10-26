package com.kyip.api.templateproject.external.resource;

import io.dropwizard.views.View;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kyip.api.templateproject.external.views.DemoView;

public class TemplateResourceImpl implements TemplateResource {

	private static final Logger logger = LoggerFactory.getLogger(TemplateResourceImpl.class);

	@Override
	public Response getAnyString(String anyString) throws Exception {
		return Response.ok(anyString).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("utf-8")).build();
	}

	@Override
	public View getAnyStringInView(String anyString) throws Exception {
		DemoView v = new DemoView();
		v.setAnyString(anyString);
		return v;
	}
}
