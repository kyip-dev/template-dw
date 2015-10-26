package com.kyip.api.templateproject.external.views;

public class DemoView extends BaseView {

	private String anyString;

	public DemoView() {
		this.setSectionTemplatePath("/views/demo.ftl");
	}

	public String getAnyString() {
		return anyString;
	}

	public void setAnyString(String anyString) {
		this.anyString = anyString;
	}

}
