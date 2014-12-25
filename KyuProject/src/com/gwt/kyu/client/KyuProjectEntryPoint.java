package com.gwt.kyu.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.kyu.client.presenters.Presenter;
import com.gwt.kyu.client.presenters.SurveyPresenter;
import com.gwt.kyu.client.views.SurveyPage;

public class KyuProjectEntryPoint implements EntryPoint {
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		Presenter prsntr=new SurveyPresenter(new SurveyPage());
		prsntr.go(RootPanel.get());
	}
}
