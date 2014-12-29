package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.ExamPresenter;

public class ExamPage extends Composite implements ExamPresenter.Display{

	private static ExamPageUiBinder uiBinder = GWT
			.create(ExamPageUiBinder.class);

	interface ExamPageUiBinder extends UiBinder<Widget, ExamPage> {
	}

	public ExamPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(ExamPresenter examPresenter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInitialize(HasWidgets container) {
		// TODO Auto-generated method stub
		
	}

}
