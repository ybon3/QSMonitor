package com.dtc.test.qsm.client;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.dtc.test.qsm.server.dao.orm.tables.pojos.Author;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

import us.dontcareabout.gwt.client.GFEP;

public class MyEP extends GFEP {
	static final RpcServiceAsync rpc = GWT.create(RpcService.class);
	private static Viewport vp = new Viewport();

	@UiField TextButton btnQuery = new TextButton("Query");
	@UiField TextButton btnAdd = new TextButton("Add");
	@UiField TextButton btnUpdate = new TextButton("Update");
	@UiField TextButton btnDelete = new TextButton("Delete");
	TextArea textArea = new TextArea();


	@Override
	protected void start() {
		Margins margin = new Margins(5);
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(new Label("HELLO"), new VerticalLayoutData(-1, -1, margin));

		HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
		HorizontalLayoutData hld = new HorizontalLayoutData(0.25, 1, margin);
		hlc.add(btnQuery, hld);
		hlc.add(btnAdd, hld);
		hlc.add(btnUpdate, hld);
		hlc.add(btnDelete, hld);
		vlc.add(hlc, new VerticalLayoutData(1, 50));

		vlc.add(textArea, new VerticalLayoutData(1, 1, margin));

		btnQuery.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				rpc.getAllAuthor(new AsyncCallback<List<Author>>() {
					@Override
					public void onSuccess(List<Author> result) {
						String value = "";
						for (Author r : result) {
							value += r.getFirstName() + " | " + r.getDate() + " | " + r.getTime() + "\n";
						}
						textArea.setValue(value);
					}

					@Override
					public void onFailure(Throwable caught) {}
				});
			}
		});

		btnAdd.addSelectHandler(new SelectHandler() {
			java.util.Date now = new java.util.Date();
			Author data = new Author(999, "Bruno", "Mars", new Date(now.getTime()), new Time(now.getTime()));
			@Override
			public void onSelect(SelectEvent event) {
				rpc.addAuthor(data, new AsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {}
					@Override
					public void onFailure(Throwable caught) {}
				});
			}
		});

		btnUpdate.addSelectHandler(new SelectHandler() {
			java.util.Date now = new java.util.Date();
			Author data = new Author(999, "WTF", "", new Date(now.getTime()), new Time(now.getTime()));
			@Override
			public void onSelect(SelectEvent event) {
				rpc.updateAuthor(data, new AsyncCallback<Boolean>() {
					@Override
					public void onSuccess(Boolean result) {}
					@Override
					public void onFailure(Throwable caught) {}
				});
			}
		});
		btnDelete.addSelectHandler(new SelectHandler() {
			@Override
			public void onSelect(SelectEvent event) {
				rpc.deleteAuthor(999, new AsyncCallback<Void>() {
					@Override
					public void onSuccess(Void result) {}
					@Override
					public void onFailure(Throwable caught) {}
				});
			}
		});

		show(vlc);
	}

	@Override
	protected String version() {
		return "0.0.4";
	}

	@Override
	protected String defaultLocale() {
		return "zh_TW";
	}

	private void show(Widget view) {
		vp.add(view);
		RootPanel.get().add(vp);
	}
}
