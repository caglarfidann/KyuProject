package com.gwt.kyu.client.presenters;

import java.util.HashMap;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.server.ExamOperation;
import com.gwt.kyu.shared.User;

public class ResultPresenter implements Presenter {
	HashMap<String, String> resultHash;
	Display view;
	User user;
	ExamOperation examOperation;
	public ResultPresenter(User user,HashMap<String, String> hashResult,Display view) {
		// TODO Auto-generated constructor stub
		this.user=user;
		this.resultHash=hashResult;
		this.view=view;
		examOperation=new ExamOperation();
		bind();
	}
	
	public interface Display{
		
		public void clear();
		
		public Widget asWidget();
		
		public void setPresenter(ResultPresenter resultPresenter);
		
		public void onInitialize(HasWidgets container);
		
		public Label getName();
		
		public Label getSurName();

		public Label getMail();
		
		public Label getCountry();
		
		public Label getCity();
		
		public Label getTeam();
		
	}
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.setPresenter(this);
		view.clear();	
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
		view.onInitialize(container);
		view.getName().setText(user.getUserName());
		view.getSurName().setText(user.getUserSurname());
		view.getMail().setText(user.getEmail());
		view.getCountry().setText(user.getCountry());
		view.getCity().setText(user.getCity());
		view.getTeam().setText(user.getTeam());
	}

}
