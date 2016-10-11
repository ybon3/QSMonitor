package com.dtc.test.qsm.client;

import com.google.gwt.event.shared.GwtEvent;

public class RecordEvent extends GwtEvent< RecordHandler> {
	public static final Type< RecordHandler> TYPE = new Type< RecordHandler>();

	public final Record record;

	public RecordEvent(Record record) {
		this.record = record;
	}

	@Override
	public Type< RecordHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(RecordHandler handler) {
		handler.onRecord(this);
	}
}