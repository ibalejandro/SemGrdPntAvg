package com.example.sgpacalculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Choice extends Activity {

	public static Activity cho;
	String shownUserName;
	String data[] = new String [2]; 
	TextView choice;
	Button semgpa;
	Button cumgpa;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		cho = this; //for closing the Activity later
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		Bundle b = getIntent().getExtras();
		shownUserName = b.getString("shownUserName");
		choice = (TextView) findViewById(R.id.choice);
		semgpa = (Button) findViewById(R.id.semgpa);
		cumgpa = (Button) findViewById(R.id.cumgpa);
	}

	public void selectSGPA(View view){
		data[1] = "s"; // "s" for semester
		openXCalculator();
	}
	
	public void selectCGPA(View view){
		data[1] = "c";  // "c" for cumulative
		openXCalculator();
	} 
	
    public void openXCalculator(){ //the same method for both calculators
    	Intent openCalculator = new Intent(Choice.this, Calculator.class);
		Bundle b = new Bundle();
		data[0] = shownUserName;    
		b.putStringArray("data", data);
		openCalculator.putExtras(b);
        startActivity(openCalculator); 
    }
    
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_choice, menu);
		return true;
	}

}
