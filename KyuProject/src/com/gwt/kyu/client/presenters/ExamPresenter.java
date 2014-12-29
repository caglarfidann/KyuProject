package com.gwt.kyu.client.presenters;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.shared.User;

public class ExamPresenter implements Presenter {
	Display view;
	User user;
	public interface Display{
		public void clear();
		
		public Widget asWidget();
		
		public void setPresenter(ExamPresenter examPresenter);
		
		public void onInitialize(HasWidgets container);
		
	}
	
	public ExamPresenter(User user,Display view) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.user=user;
		bind();
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
	}

}
