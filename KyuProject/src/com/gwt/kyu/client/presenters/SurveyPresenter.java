package com.gwt.kyu.client.presenters;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.views.ExamPage;
import com.gwt.kyu.server.ListBoxOperation;
import com.gwt.kyu.server.ValidateOperation;
import com.gwt.kyu.shared.User;
//29.12.2014(14:10)
public class SurveyPresenter implements Presenter {
	Display view;
	final String[] Country = { "France", "Italy", "Netherlands", "Spain",
			"Turkey", "United Kingdom", "U.S.A." };
	String[] cityList;
	ListBoxOperation listOperation;
	ValidateOperation validate;
	
	public interface Display {
		public void clear();

		public Widget asWidget();

		public void setPresenter(SurveyPresenter surveyPresenter);

		public void onInitialize(HasWidgets container);

		public Button getShowlButton();

		public String getSelectedRadio();

		public TextBox getNameText();

		public TextBox getSurnameText();
		
		public TextBox getMailText();

		public Image getImgName();

		public Image getImgSurname();
		
		public Image getMailImage();

		public void fillListCountry(String[] Country);

		public ListBox getCountryList();

		public ListBox getCityList();
	}

	public SurveyPresenter(Display view) {
		// TODO Auto-generated constructor stub
		this.view = view;
		listOperation = new ListBoxOperation();
		validate=new ValidateOperation();
		bind();
	}

	@Override
	public void bind() {
		// TODO Auto-generated method stub
		view.setPresenter(this);
		view.clear();
		view.getNameText().setText("caglar");
		view.getSurnameText().setText("fidan");
		view.getMailText().setText("caglar@hotmail.com");
		view.fillListCountry(Country);
		getSelectedCountry("France");
		view.getImgName().setUrl("http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png");
		view.getImgSurname().setUrl("http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png");
		view.getMailImage().setUrl("http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png");
		view.getShowlButton().setEnabled(false);
		view.getShowlButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				User user=new User();
				user.setUserName(view.getNameText().getText());
				user.setUserSurname(view.getSurnameText().getText());
				user.setEmail(view.getMailText().getText());				
				user.setCountry(Country[view.getCountryList().getSelectedIndex()]);
				user.setCity(view.getCityList().getItemText(view.getCityList().getSelectedIndex()));
				user.setTeam(view.getSelectedRadio());
				
				Presenter prsntr=new ExamPresenter(user,new ExamPage());
				prsntr.go(RootPanel.get());
			}
		});
		view.getCountryList().addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
				view.getCityList().clear();
				getSelectedCountry(view.getCountryList().getItemText(
						view.getCountryList().getSelectedIndex()));
			}
		});
		view.getNameText().addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				// TODO Auto-generated method stub
				if (validate.validateFirstName(view.getNameText()
						.getText()) == true) {
					view.getImgName().setUrl("http://www.clker.com/cliparts/G/F/D/c/j/r/correct-md.png");
					view.getShowlButton().setEnabled(true);
					
				} else {
					view.getImgName().setUrl("http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png");
					view.getShowlButton().setEnabled(false);
				}
			}
		});
		
		view.getSurnameText().addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				// TODO Auto-generated method stub
				if (validate.validateLastName(view.getSurnameText()
						.getText()) == true) {
					view.getImgSurname().setUrl("http://www.clker.com/cliparts/G/F/D/c/j/r/correct-md.png");
					view.getShowlButton().setEnabled(true);
				} else {
					view.getImgSurname().setUrl("http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png");
					view.getShowlButton().setEnabled(false);
				}
			}
		});
		view.getMailText().addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				// TODO Auto-generated method stub
				if (validate.validateMail(view.getMailText().getText())==true) {
					view.getMailImage().setUrl("http://www.clker.com/cliparts/G/F/D/c/j/r/correct-md.png");
					view.getShowlButton().setEnabled(true);
				}
				else{
					view.getMailImage().setUrl("http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png");
					view.getShowlButton().setEnabled(false);
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
	}

	public void getSelectedCountry(String Selected) {
		cityList = listOperation.getCities(Selected);
		for (int i = 0; i < cityList.length; i++) {
			view.getCityList().addItem(cityList[i]);
		}
	}
}
