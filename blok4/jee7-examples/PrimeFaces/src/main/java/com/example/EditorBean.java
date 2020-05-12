package com.example;

import javax.faces.bean.ManagedBean;

// http://localhost:8080/PrimeFaces/
@ManagedBean(name = "editor")
public class EditorBean {

	private String value = "This editor is provided by PrimeFaces";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}