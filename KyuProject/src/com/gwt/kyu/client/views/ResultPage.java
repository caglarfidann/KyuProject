package com.gwt.kyu.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.kyu.client.presenters.ResultPresenter;

public class ResultPage extends Composite implements ResultPresenter.Display{
	private ResultPresenter resultPresenter;
	private AbsolutePanel absolutePanel;
	private static ResultPageUiBinder uiBinder = GWT
			.create(ResultPageUiBinder.class);

	interface ResultPageUiBinder extends UiBinder<Widget, ResultPage> {
	}

	public ResultPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	private Label resultLabel=new Label("--RESULT--");
	private Label name=new Label("Name :");
	private Label surname=new Label("Surname :");
	private Label mail=new Label("E-Mail :");
	private Label country=new Label("Country :");
	private Label city=new Label("City :");
	private Label team=new Label("Team :");
	private Label nameLabel=new Label();
	private Label surnameLabel=new Label();
	private Label mailLabel=new Label();
	private Label countryLabel=new Label();
	private Label cityLabel=new Label();
	private Label teamLabel=new Label();
	private CellTable<String> resultTable=new CellTable<String>();
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(ResultPresenter resultPresenter) {
		// TODO Auto-generated method stub
		this.resultPresenter=resultPresenter;
	}

	@Override
	public void onInitialize(HasWidgets container) {
		// TODO Auto-generated method stub
		int width=Window.getClientWidth();
		int height=Window.getClientHeight();
		absolutePanel = new AbsolutePanel();
		absolutePanel.setSize(String.valueOf(width)+"px",String.valueOf(height)+"px");
		absolutePanel.add(resultLabel,880,10);
		absolutePanel.add(name,750,40);
		nameLabel.addStyleName(".gwt-Label-Style");
		absolutePanel.add(nameLabel,850,40);
		absolutePanel.add(surname,750,70);
		surname.addStyleName(".gwt-Label-Style");
		absolutePanel.add(surnameLabel,850,70);
		absolutePanel.add(mail,750,100);
		mailLabel.addStyleName(".gwt-Label-Style");
		absolutePanel.add(mailLabel,850,100);
		absolutePanel.add(country,750,130);
		countryLabel.addStyleName(".gwt-Label-Style");
		absolutePanel.add(countryLabel,850,130);
		absolutePanel.add(city,750,160);
		cityLabel.addStyleName(".gwt-Label-Style");
		absolutePanel.add(cityLabel,850,160);
		absolutePanel.add(team,750,160);
		teamLabel.addStyleName(".gwt-Label-Style");
		absolutePanel.add(teamLabel,850,160);
		
		absolutePanel.add(resultTable,700,190);
		container.add(absolutePanel);
	}

	@Override
	public Label getName() {
		// TODO Auto-generated method stub
		return nameLabel;
	}

	@Override
	public Label getSurName() {
		// TODO Auto-generated method stub
		return surnameLabel;
	}

	@Override
	public Label getMail() {
		// TODO Auto-generated method stub
		return mailLabel;
	}

	@Override
	public Label getCountry() {
		// TODO Auto-generated method stub
		return countryLabel;
	}

	@Override
	public Label getCity() {
		// TODO Auto-generated method stub
		return cityLabel;
	}

	@Override
	public Label getTeam() {
		// TODO Auto-generated method stub
		return teamLabel;
	}

}
