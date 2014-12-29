package com.gwt.kyu.client.presenters;

import java.util.HashMap;
import java.util.Set;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.server.ExamOperation;
import com.gwt.kyu.shared.User;

public class ExamPresenter implements Presenter {
	Display view;
	User user;
	public static HashMap<String, String> hm;
	ExamOperation examOperation;
	public interface Display{
		public void clear();
		
		public Widget asWidget();
		
		public void setPresenter(ExamPresenter examPresenter);
		
		public void onInitialize(HasWidgets container);
		
		public Label userNameLabel();
		
		public AbsolutePanel getPanel();
	}
	
	public ExamPresenter(User user,Display view) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.user=user;
		examOperation=new ExamOperation();
		hm=new HashMap<String, String>();
		hm.clear();
		bind();
	}
	
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.setPresenter(this);
		view.clear();
		fillQuestion();
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
		view.onInitialize(container);
		view.userNameLabel().setText("--"+user.getUserName()+"  "+user.getUserSurname()+"--");	
	}
	
	public void fillQuestion(){	
		AbsolutePanel panel=view.getPanel();
		Set<String> quest=examOperation.getAllQuestion();
		int count=0;
		for (String soru : quest) {
			final Label question=new Label("Question--"+(count+1));
			panel.add(question,750,70+(120*count));
			final Label question1=new Label(soru); 
			panel.add(question1,750,90+(120*count));
			String[] questionAnswer=examOperation.getAnswer(soru);
			for (int i = 0; i < questionAnswer.length; i++) {
				final RadioButton radioButton = new RadioButton("Question"+(count+1), questionAnswer[i]);
				radioButton.addClickHandler(new ClickHandler() {			
					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						hm.put(String.valueOf(soru), radioButton.getText());
					}
				});
				panel.add(radioButton,750+(50*count),110+(120*count));
			}
			count++;
		}
	}
}
