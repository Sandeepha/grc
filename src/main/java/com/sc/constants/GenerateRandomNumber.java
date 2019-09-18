package com.sc.constants;

import java.util.*;

import org.apache.commons.lang.RandomStringUtils;

public class GenerateRandomNumber 

{
	static Random rnum = new Random();
    public static String getRandomNumber(){
    	
    	String number = RandomStringUtils.randomNumeric(5);
    	//int number = rnum.nextInt(9999);        
		return number;
    }
	public static void main(String[] args) {      
     
      
   }
}
