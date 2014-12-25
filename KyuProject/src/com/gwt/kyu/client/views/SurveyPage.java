package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.SurveyPresenter;
public class SurveyPage extends Composite implements SurveyPresenter.Display {

	private static SurveyPageUiBinder uiBinder = GWT
			.create(SurveyPageUiBinder.class);

	interface SurveyPageUiBinder extends UiBinder<Widget, SurveyPage> {
	}
	final String[] Items = { "FB", "GS", "BJK", "TS"};
	final String[] Favorite={"Soccer","Tennis","Basketball","Volleyball","Swimming","Other"};
	private SurveyPresenter surveyPresenter;
	public static String selectedRadioButton;
	public static String selectedCheckBox;
	
	private Label survey=new Label("Survey");
	private Label name=new Label("Name :");
	private Label surname=new Label("Surname :");
	private Label country=new Label("Country :");
	private Label city=new Label("City :");
	private Label favorite=new Label("Favorite Sport : ");
	private Label team=new Label("Favorite Team :"); 
	private TextBox nameText=new TextBox();
	private Image ImgName=new Image();//http://www.clker.com/cliparts/G/F/D/c/j/r/correct-md.png
	private Image ImgSurname=new Image();//http://images.clipartpanda.com/wrong-clipart-7iaLbGKiA.png
	private TextBox surnameText=new TextBox();
	private ListBox countryList=new ListBox(false);
	private ListBox cityList=new ListBox(false);
	private Button show=new Button("Show");
	private Button chn = new Button("Cihan Burda!!!!!");
	//private CheckboxGroup Checkgroup=new CheckboxGroup();
	private AbsolutePanel absolutePanel;
	public SurveyPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(SurveyPresenter surveyPresenter) {
		// TODO Auto-generated method stub
		this.surveyPresenter=surveyPresenter;
	}

	@Override
	public void onInitialize(HasWidgets container) {
		// TODO Auto-generated method stub 
		absolutePanel = new AbsolutePanel();
		absolutePanel.setSize("1920px", "1080px");
		absolutePanel.add(survey,850,10);
		absolutePanel.add(name,750,40);
		absolutePanel.add(nameText,900,40);
		ImgName.setSize("20px","20px");
		absolutePanel.add(ImgName,1100,40);
		absolutePanel.add(surname,750,70);
		absolutePanel.add(surnameText,900,70);
		ImgSurname.setSize("20px","20px");
		absolutePanel.add(ImgSurname,1100,70);
		absolutePanel.add(country,750,100);
		absolutePanel.add(countryList,900,100);
		absolutePanel.add(city,750,130);
		absolutePanel.add(cityList,900,130);
		absolutePanel.add(favorite,750,160);
		onCheckBox(absolutePanel);
		absolutePanel.add(team,750,190);
		onRadioBUtton(absolutePanel);
		absolutePanel.add(show,850,250);
		container.add(absolutePanel);
		absolutePanel.add(chn,900,400);
	}
	
	public void onRadioBUtton(AbsolutePanel absolutePanel){
		for (int i = 0; i < Items.length; i++) {
			final RadioButton radioButton = new RadioButton("Teams", Items[i]);
			radioButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					selectedRadioButton=radioButton.getText();
				}
			});
			absolutePanel.add(radioButton,900+(50*i),190);
		}
	}
	
	public void onCheckBox(AbsolutePanel absolutePanel){	
		for (int i = 0; i < Favorite.length; i++) {
		    final CheckBox checkBox=new CheckBox(Favorite[i]);
			//Group yapýlacak??????????????
		    checkBox.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					selectedCheckBox=checkBox.getText();
					for (int j = 0; j < Favorite.length; j++) {
						if(!Favorite[j].equals(selectedCheckBox)){
							
						}
					}
				}
			});
			absolutePanel.add(checkBox,900+(90*i),160);		
		}
	}
	@Override
	public Button getShowlButton() {
		// TODO Auto-generated method stub
		return show;
	}

	@Override
	public String getSelectedRadio() {
		// TODO Auto-generated method stub
		return selectedRadioButton;
	}

	@Override
	public void fillListCountry(String[] Country) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Country.length; i++) {
			countryList.addItem(Country[i]);
		}
	}

	@Override
	public ListBox getCountryList() {
		// TODO Auto-generated method stub
		return countryList;
	}

	@Override
	public ListBox getCityList() {
		// TODO Auto-generated method stub
		return cityList;
	}

	@Override
	public TextBox getNameText() {
		// TODO Auto-generated method stub
		return nameText;
	}

	@Override
	public TextBox getSurnameText() {
		// TODO Auto-generated method stub
		return surnameText;
	}

	@Override
	public Image getImgName() {
		// TODO Auto-generated method stub
		return ImgName;
	}

	@Override
	public Image getImgSurname() {
		// TODO Auto-generated method stub
		return ImgSurname;
	}

	@Override
	public Button getDetail() {
		// TODO Auto-generated method stub
		return chn;
	}
}
