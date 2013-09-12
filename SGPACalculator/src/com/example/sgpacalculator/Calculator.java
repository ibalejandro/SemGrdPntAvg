package com.example.sgpacalculator;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends Activity {

	private Choice choFromCal = new Choice(); //it helps by closing that Activity
	String data [] = new String [2];
	EditText point1;
	EditText point2;
	EditText point3;
	EditText point4;
	EditText point5;
	EditText point6;
	EditText point7;
	EditText point8;
	EditText point9;
	EditText credit1;
	EditText credit2;
	EditText credit3;
	EditText credit4;
	EditText credit5;
	EditText credit6;
	EditText credit7;
	EditText credit8;
	EditText credit9;
	EditText cumpoint1;
	EditText cumpoint2;
	EditText cumpoint3;
	EditText cumpoint4;
	EditText cumpoint5;
	EditText cumpoint6;
	EditText cumpoint7;
	EditText cumpoint8;
	EditText cumpoint9;
	EditText cumpoint10;
	Button clear;
	Button calculate;
	Button cumclear;
	Button cumcalculate;
	Button ok;
	Button cAgain;
	TextView points;
	TextView credits;
	TextView cumpoints;
	TextView dataInError;
	TextView cumdataInError;
	TextView sUserN;
	TextView res;
	TextView grade;
	float po;
	int cr;
	float pointsTCredits;
	int credSum;
	float sgpa;
	String sgpaToShow;
	ArrayList <String> ponAndCre = new ArrayList<String>();
	ArrayList <String> cumulativePoints = new ArrayList<String>();
	boolean dataOk;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
        data = b.getStringArray("data");
		if(data[1].equals("s")){
			setContentView(R.layout.activity_calculator);
			point1 = (EditText) findViewById(R.id.point1);
			point2 = (EditText) findViewById(R.id.point2);
			point3 = (EditText) findViewById(R.id.point3);
			point4 = (EditText) findViewById(R.id.point4);
			point5 = (EditText) findViewById(R.id.point5);
			point6 = (EditText) findViewById(R.id.point6);
			point7 = (EditText) findViewById(R.id.point7);
			point8 = (EditText) findViewById(R.id.point8);
			point9 = (EditText) findViewById(R.id.point9);
			credit1 = (EditText) findViewById(R.id.credit1);
			credit2 = (EditText) findViewById(R.id.credit2);
			credit3 = (EditText) findViewById(R.id.credit3);
			credit4 = (EditText) findViewById(R.id.credit4);
			credit5 = (EditText) findViewById(R.id.credit5);
			credit6 = (EditText) findViewById(R.id.credit6);
			credit7 = (EditText) findViewById(R.id.credit7);
			credit8 = (EditText) findViewById(R.id.credit8);
			credit9 = (EditText) findViewById(R.id.credit9);
			clear = (Button) findViewById(R.id.clear);
			calculate = (Button) findViewById(R.id.calculate);
			ok = (Button) findViewById(R.id.ok);
			cAgain = (Button) findViewById(R.id.cAgain);
			points = (TextView) findViewById(R.id.points);
			credits = (TextView) findViewById(R.id.credits);
			dataInError = (TextView) findViewById(R.id.dIError);
		}else{
			setContentView(R.layout.activity_cumulative);
			cumpoint1 = (EditText) findViewById(R.id.cumpoint1);
			cumpoint2 = (EditText) findViewById(R.id.cumpoint2);
			cumpoint3 = (EditText) findViewById(R.id.cumpoint3);
			cumpoint4 = (EditText) findViewById(R.id.cumpoint4);
			cumpoint5 = (EditText) findViewById(R.id.cumpoint5);
			cumpoint6 = (EditText) findViewById(R.id.cumpoint6);
			cumpoint7 = (EditText) findViewById(R.id.cumpoint7);
			cumpoint8 = (EditText) findViewById(R.id.cumpoint8);
			cumpoint9 = (EditText) findViewById(R.id.cumpoint9);
			cumpoint10 = (EditText) findViewById(R.id.cumpoint10);
			cumclear = (Button) findViewById(R.id.cumclear);
			cumcalculate = (Button) findViewById(R.id.cumcalculate);
			cumpoints = (TextView) findViewById(R.id.cumpoints);
			cumdataInError = (TextView) findViewById(R.id.cumdataInError);
		}
	}

	
	public void calculate(View view){
		
		 ponAndCre.clear();
		 po = 0;
		 cr = 0;
		 pointsTCredits = 0;
	     credSum = 0;
		 sgpa = 0;
		 dataOk = true;
		 ponAndCre.add(point1.getText().toString());
		 ponAndCre.add(point2.getText().toString());
		 ponAndCre.add(point3.getText().toString());
		 ponAndCre.add(point4.getText().toString());
		 ponAndCre.add(point5.getText().toString());
		 ponAndCre.add(point6.getText().toString());
		 ponAndCre.add(point7.getText().toString());
		 ponAndCre.add(point8.getText().toString());
		 ponAndCre.add(point9.getText().toString());
		 ponAndCre.add(credit1.getText().toString());
		 ponAndCre.add(credit2.getText().toString());
		 ponAndCre.add(credit3.getText().toString());
		 ponAndCre.add(credit4.getText().toString());
		 ponAndCre.add(credit5.getText().toString());
		 ponAndCre.add(credit6.getText().toString());
		 ponAndCre.add(credit7.getText().toString());
		 ponAndCre.add(credit8.getText().toString());
		 ponAndCre.add(credit9.getText().toString());
		 
		 for (int i=0; i<ponAndCre.size()/2 && dataOk; i++){
			if (!validate(ponAndCre.get(i), ponAndCre.get(i+9))){
				dataOk = false;
			}
		 }
		 if(dataOk && credSum > 0){
             callResult();
			 res.setText(getString(R.string.result)); //to show the SGPA
		 }
		 else{
			 dataInError.setTextColor(Color.RED); // calculating isn't possible
		 }
		
	}

	
	public void cumCalculate(View view){
		
		 cumulativePoints.clear();
		 po = 0;
		 pointsTCredits = 0;
		 credSum = 0;
		 sgpa = 0;
		 dataOk = true;
		 cumulativePoints.add(cumpoint1.getText().toString());
		 cumulativePoints.add(cumpoint2.getText().toString());
		 cumulativePoints.add(cumpoint3.getText().toString());
		 cumulativePoints.add(cumpoint4.getText().toString());
		 cumulativePoints.add(cumpoint5.getText().toString());
		 cumulativePoints.add(cumpoint6.getText().toString());
		 cumulativePoints.add(cumpoint7.getText().toString());
		 cumulativePoints.add(cumpoint8.getText().toString());
		 cumulativePoints.add(cumpoint9.getText().toString());
		 cumulativePoints.add(cumpoint10.getText().toString());

		 for (int i=0; i<cumulativePoints.size() && dataOk; i++){
			 if (!validateCum(cumulativePoints.get(i))){
					dataOk = false;
			 }
		 }
		 if(dataOk && credSum > 0){
			 callResult();
			 res.setText(getString(R.string.cumresult)); //to show the CGPA
		 }
		 else{
			 cumdataInError.setTextColor(Color.RED); // calculating isn't possible
		 }
		
	}
	
	
  public void callResult(){
	     sgpa = pointsTCredits / credSum;
		 sgpaToShow = String.valueOf(sgpa);
		 if(sgpaToShow.length() >  5){
			 sgpaToShow = sgpaToShow.substring(0,5);
		 }
		 setContentView(R.layout.activity_sgpa);  //calling the result layout
		 sUserN = (TextView) findViewById(R.id.sUserN);
		 res = (TextView) findViewById(R.id.res);
		 grade = (TextView) findViewById(R.id.grade);
		 sUserN.setText(data[0]); //to show the user name
		 grade.setText(sgpaToShow);  //sgpaToShow is the calculated XGPA
  }
  
  
  public boolean isValidPoint(float p){
		if(p >= 0.00 && p <= 5.00){ //points must be in this range
			return true;
		}
		return false;
  }
	
   public boolean isValidCredit(int c){
	   if(c >= 0 && c <= 21){  //credits must be in this range
			return true;
	   }
	   return false;
	}
   
   public boolean validate(String px, String cy){
	   if(px.trim().length() != 0 && cy.trim().length() != 0){
			 if(px.charAt(px.length()-1) != '.'){
				 po = Float.valueOf(px);  //with this method does it work
				  if(isValidPoint(po)){
					 cr = Integer.valueOf(cy); //with this method does it work
					 if(isValidCredit(cr)){  //everything is ok for calculating
						 pointsTCredits = pointsTCredits + (po*cr);
						 credSum = credSum + cr;
						 return true;
				
					 }
					 else{
						 return false;
					 }
				}
				else{
					return false;
				}
			 }
			 else{
				 return false;
			 }
		 }
		 else{
			 if(px.trim().length() == 0 && cy.trim().length() == 0){ //no info is ok too
				 return true;
			 }
			 else{
				 return false;
			 }
		 }
   }
   
   
   public boolean validateCum(String cp){
		 if(cp.trim().length() != 0){
			 if(cp.charAt(cp.length()-1) != '.'){
				 po = Float.valueOf(cp);
				 if(isValidPoint(po)){
					 pointsTCredits = pointsTCredits + po;
		 			 credSum++;
		 			 return true;
				 }
				 else{
					 return false;
				 }
			 }
			 else{
				 return false;
			 }
		 }
		 else{
			 return true;
		 }
   }
   
   
   public void clearAll(View view){
	     point1.setText("");
		 point2.setText("");
		 point3.setText("");
		 point4.setText("");
		 point5.setText("");
		 point6.setText("");
		 point7.setText("");
		 point8.setText("");
		 point9.setText("");
		 credit1.setText("");
		 credit2.setText("");
		 credit3.setText("");
		 credit4.setText("");
		 credit5.setText("");
		 credit6.setText("");
		 credit7.setText("");
		 credit8.setText("");
		 credit9.setText("");
		 dataInError.setTextColor(Color.BLACK);
   }
   
   
   public void cumClearAll(View view){
	     cumpoint1.setText("");
		 cumpoint2.setText("");
		 cumpoint3.setText("");
		 cumpoint4.setText("");
		 cumpoint5.setText("");
		 cumpoint6.setText("");
		 cumpoint7.setText("");
		 cumpoint8.setText("");
		 cumpoint9.setText("");
		 cumpoint10.setText("");
		 cumdataInError.setTextColor(Color.BLACK);
 }
   
   @SuppressWarnings("static-access")
public void exitHere(View view){
	   choFromCal.cho.finish();  //it helps by closing that Activity
	   System.exit(0);
   }
   
   
   @SuppressWarnings("static-access")
public void calculateAgain(View view){
	  choFromCal.cho.finish();
	  Intent openSignIn = new Intent(Calculator.this, SignIn.class);
      startActivity(openSignIn);
      finish();
   }
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculator, menu);
		return true;
	}

}
