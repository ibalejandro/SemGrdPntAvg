package com.example.sgpacalculator;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends Activity {
    
	String shownUserName;
	EditText userName;
	Button signIn;
	TextView calcysgpa;
	TextView name;
	TextView owner;
	TextView year;
	TextView exception_name;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		userName = (EditText) findViewById(R.id.userName);
		signIn = (Button) findViewById(R.id.signIn);
		calcysgpa = (TextView) findViewById(R.id.calcysgpa);
		name = (TextView) findViewById(R.id.name);
		owner = (TextView) findViewById(R.id.owner);
		year = (TextView) findViewById(R.id.year);
		exception_name = (TextView) findViewById(R.id.exception_name);
	}

	public void signIn(View view){
		 shownUserName = userName.getText().toString();
		 if(shownUserName.trim().length() != 0){
			 if(isAlpha(shownUserName)){ //everything is ok for calculating
				 Intent openChoice = new Intent(SignIn.this, Choice.class);
				 Bundle b = new Bundle();
				 b.putString("shownUserName", shownUserName);  //passing parameters
				 openChoice.putExtras(b);
			     startActivity(openChoice);
			     finish(); 
			 }
			 else{
				 exception_name.setText(getString(R.string.inv_name)); //invalid characters in 
				 exception_name.setTextColor(Color.RED);                //the EditText
			 }
		 }
		 else{
			 exception_name.setText(getString(R.string.exception_name));//no characters in 
			 exception_name.setTextColor(Color.RED);                    //the EditText
		 }
	}
	
	
	
    public boolean isAlpha(String name) { //taken from stackoverflow and modified
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }

        return true;
    }

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sign_in, menu);
		return true;
	}

}
