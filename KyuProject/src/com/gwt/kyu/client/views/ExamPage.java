package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.ExamPresenter;

public class ExamPage extends Composite implements ExamPresenter.Display{
	ExamPresenter examPresenter;
	private AbsolutePanel absolutePanel;
	private static ExamPageUiBinder uiBinder = GWT
			.create(ExamPageUiBinder.class);

	interface ExamPageUiBinder extends UiBinder<Widget, ExamPage> {
	}

	public ExamPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	private Label exam=new Label("--EXAM--");
	private Label user=new Label();
	private Button submit=new Button("Submit");
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(ExamPresenter examPresenter) {
		// TODO Auto-generated method stub
		this.examPresenter=examPresenter;
	}

	@Override
	public void onInitialize(HasWidgets container) {
		// TODO Auto-generated method stub
		int height=1920;
		int width=1080;
		absolutePanel = new AbsolutePanel();
		absolutePanel.setSize(String.valueOf(height)+"px",String.valueOf(width)+"px");
		absolutePanel.add(exam,880,10);
		absolutePanel.add(user,870,40);
		absolutePanel.add(submit,890,650);	
		container.add(absolutePanel);
	}

	@Override
	public Label userNameLabel() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public AbsolutePanel getPanel() {
		// TODO Auto-generated method stub
		return absolutePanel;
	}

	@Override
	public Button getSubmitButton() {
		// TODO Auto-generated method stub
		return submit;
	}
}
