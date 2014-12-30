package com.gwt.kyu.client.presenters;

import java.util.HashMap;
import java.util.Set;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.views.ResultPage;
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
		
		public Button getSubmitButton();
	}
	
	public ExamPresenter(User user,Display view) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.user=user;
		examOperation=new ExamOperation();
		hm = new HashMap<String, String>();	
		hm.clear();
		bind();
	}
	
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.setPresenter(this);
		view.clear();	
		view.getSubmitButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				try {
					int count=0;
					Set<String> keys = hm.keySet();
					for (String key : keys) {
						String correct=examOperation.CorrectAnswer(key);
						if(hm.get(key).equals(correct)){
							count++;
						}
					}		
					Window.alert("Sinav Sonucunuz 5 uzerinden "+String.valueOf(count)+" !!!");
					
					Presenter prsntr=new ResultPresenter(user,hm,new ResultPage());
					prsntr.go(RootPanel.get());
					
				} catch (Exception e) {
					Window.alert("SORUN VAR!!!");
				}

			}
		});
		
		
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		container.clear();
		container.add(view.asWidget());
		view.onInitialize(container);
		view.userNameLabel().setText("--"+user.getUserName()+"  "+user.getUserSurname()+"--");	
		fillQuestion();
	}
	
	public void fillQuestion(){	
		
		AbsolutePanel panel=view.getPanel();
		Set<String> quest=examOperation.getAllQuestion();
		int count=0;
		for (final String soru : quest) {
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
						hm.put(soru, radioButton.getText().toString());
					}
				});	
				panel.add(radioButton,750+(50*i),110+(120*count));
			}
			count++;
		}
	}
}
