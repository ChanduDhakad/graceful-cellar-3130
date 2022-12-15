package com.RoamBus3.service;

import java.util.Random;

public class RandomString {

	public String make(int length) {
	
	String str="abcdefghijklmnopqrstuvwxyz";
	
	String RandomString="";
	
	
	Random random=new Random();
	
	char[] txt=new char[length];
	
	for(int i=0; i<6; i++) {
		txt[i]=str.charAt(random.nextInt(24));
	}
	
	for(int i=0; i<txt.length; i++) {
		RandomString+=txt[i];
	}
	return RandomString;
	
	}
}
