package com.gwt.kyu.server;

import java.util.HashMap;
import java.util.Set;

public class ExamOperation {
	public HashMap<String, String[]> getQuestionAnswer() {
		HashMap<String, String[]> hm = new HashMap<String, String[]>();
		hm.clear();
		String[] q1 = { "9", "10", "11", "12"};
		String[] q2 = { "10", "11", "19", "20" };
		String[] q3 = { "8", "7", "6","5"};
		String[] q4 = { "198", "999", "9999", "39996"};
		String[] q5 = { "9", "10", "11", "12"};
		hm.put("1'den 100'e kadar yazd���m�zda ka� defa '0' rakam�n� kullan�r�z?", q1);
		hm.put("1'den 100'e kadar yazd���m�zda ka� defa '6' rakam�n� kullan�r�z?", q2);
		hm.put("12 ile 49 aras�nda 5 ile b�l�nebilen ka� tane do�al say� vard�r?", q3);
		hm.put("41258 say�s�n�n, binler basama��ndaki rakam�n ba��l de�eri ile mutlak de�eri aras�ndaki fark ka�t�r?", q4);
		hm.put("2 ile 56 aras�nda 5'e b�l�nebilen ka� tane do�al say� vard�r?", q5);
		return hm;
	}
	
	public HashMap<String, String> getCorrectAnswer() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.clear();
		hm.put("1'den 100'e kadar yazd���m�zda ka� defa '0' rakam�n� kullan�r�z?", "10");
		hm.put("1'den 100'e kadar yazd���m�zda ka� defa '6' rakam�n� kullan�r�z?", "10");
		hm.put("12 ile 49 aras�nda 5 ile b�l�nebilen ka� tane do�al say� vard�r?", "7");
		hm.put("41258 say�s�n�n, binler basama��ndaki rakam�n ba��l de�eri ile mutlak de�eri aras�ndaki fark ka�t�r?", "9999");
		hm.put("2 ile 56 aras�nda 5'e b�l�nebilen ka� tane do�al say� vard�r?", "11");
		return hm;
	}
	
	public Set<String> getAllQuestion(){
		HashMap<String, String[]> hm = getQuestionAnswer();
		Set<String> keys = hm.keySet();
		return keys;
	}
	
	public String[] getAnswer(String question) {
		String[] answerArray = null;
		HashMap<String, String[]> hm = getQuestionAnswer();
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			if (key.equals(question)) {
				answerArray = hm.get(key);
				break;
			}
		}
		return answerArray;
	}
	
	public String CorrectAnswer(String question){
		String correctAnswer=null;
		HashMap<String, String> hm = getCorrectAnswer();
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			if (key.equals(question)) {
				correctAnswer = hm.get(key);
				break;
			}
		}
		return correctAnswer;
	}
}
