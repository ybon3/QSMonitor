package com.dtc.test.qsm.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

import us.dontcareabout.gwt.client.GFEP;

public class MyEP extends GFEP {
	static final RpcServiceAsync rpc = GWT.create(RpcService.class);
	private static Viewport vp = new Viewport();

	@Override
	protected void start() {
		VerticalLayoutContainer vlc = new VerticalLayoutContainer();
		vlc.add(new Label("HELLO"));
		/*
		rpc.getAllAuthor(new AsyncCallback<List<AuthorRecord>>() {
			@Override
			public void onSuccess(List<AuthorRecord> result) {

				for (AuthorRecord r : result) {
					vlc.add(new Label(r.getFirstName()));
				}

				show(vlc);
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
*/

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
