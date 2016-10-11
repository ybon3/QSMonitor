package com.dtc.test.qsm.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Record extends JavaScriptObject {
	protected Record() {}

	public final native String getPage() /*-{
		return this.page;
	}-*/;

	public final native String[] getParamList() /*-{
		var result = [];

		for (var key in this.parameter) {
			result.push(key);
		}

		return result;
	}-*/;

	public final native String getValue(String key) /*-{
		return this.parameter[key];
	}-*/;
}
