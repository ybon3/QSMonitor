package com.dtc.test.qsm.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.container.Viewport;
import com.sencha.gxt.widget.core.client.toolbar.LabelToolItem;

public class QSMEP implements EntryPoint {
	private static final SimpleEventBus eventBus = new SimpleEventBus();
	public static void fireEvent(GwtEvent<?> event) {
		eventBus.fireEvent(event);
	}
	private static final VerticalLayoutData ld = new VerticalLayoutData(1, 32);

	private final VerticalLayoutContainer vlc = new VerticalLayoutContainer();
	private final Viewport viewport = new Viewport();

	@Override
	public void onModuleLoad() {
		GWT.log("== getAllAuthor() ===========================");
		WSClient wsClient = new WSClient();
		wsClient.open();

		eventBus.addHandler(RecordEvent.TYPE, new RecordHandler() {
			@Override
			public void onRecord(RecordEvent event) {
				addRecord(event.record);
			}
		});

		vlc.setScrollMode(ScrollMode.AUTO);
		viewport.add(vlc);
		RootPanel.get().add(viewport);
	}

	private void addRecord(Record r) {
		vlc.add(new RecordItem(r), ld);

		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				vlc.forceLayout();
				vlc.getScrollSupport().setVerticalScrollPosition(vlc.getScrollSupport().getMaximumVerticalScrollPosition());
			}
		});
	}
}

class RecordItem extends HorizontalLayoutContainer {
	private static final DateTimeFormat format = DateTimeFormat.getFormat("yyyy/MM/dd HH:mm:ss");
	private static final HorizontalLayoutData dateLD = new HorizontalLayoutData(150, 1);
	private static final HorizontalLayoutData pageLD = new HorizontalLayoutData(100, 1);
	private static final HorizontalLayoutData allOther = new HorizontalLayoutData(1, 1);

	private static final String IMAGE_URL = "api/image.jsp";
	private static final String REPORT_URL = "api/report.jsp";
	private static final String PATIENT = "00101000";
	private static final String ACCESSION = "00080050";

	public RecordItem(Record r) {
		LabelToolItem date = new LabelToolItem(format.format(new Date()));
		this.add(date, dateLD);

		String url = r.getPage().substring(GWT.getHostPageBaseURL().length());

		if (url.equals(IMAGE_URL)) {
			doImage(r);
		} else if (url.equals(REPORT_URL)) {
			doReport(r);
		} else {
			doGeneral(r);
		}
	}

	private void doReport(Record r) {
		String content = "<span style='color:red;margin-right:10px'>報告完成</span>"
				+ "<span style='margin-right:10px'>Patient(" + PATIENT + ")：" + r.getValue(PATIENT) + "</span>"
				+ " Accession(" + ACCESSION +")：" + r.getValue(ACCESSION);
		HTML html = new HTML(content);
		this.add(html, allOther);
	}

	private void doImage(Record r) {
		String content = "<span style='color:green;margin-right:10px'>影像完成</span>"
				+ "<span style='margin-right:10px'>Patient(" + PATIENT + ")：" + r.getValue(PATIENT) + "</span>"
				+ " Accession(" + ACCESSION +")：" + r.getValue(ACCESSION);
		HTML html = new HTML(content);
		this.add(html, allOther);
	}

	private void doGeneral(Record r) {
		LabelToolItem page = new LabelToolItem(r.getPage().substring(GWT.getHostPageBaseURL().length()));
		this.add(page, pageLD);

		StringBuffer paramString = new StringBuffer();

		for (String key : r.getParamList()) {
			paramString.append(key + " = (" + r.getValue(key) + ")  ");
		}

		LabelToolItem param = new LabelToolItem(paramString.toString());
		this.add(param, allOther);
	}
}