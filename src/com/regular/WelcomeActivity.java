package com.regular;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomeActivity extends Activity 
{
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        
        applicationInit();
        
        /**Step to the main activity*/
        Button startButton = (Button) findViewById(R.id.welcomeActivity_startButton);
        startButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) 
			{
				Intent appRealStart = new Intent(WelcomeActivity.this, MainActivity.class);
		        startActivity(appRealStart);
		        WelcomeActivity.this.finish();
			}
		});
    }
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		
	}
	
	/** 
	 * Init the whole app, prepare for the app Start
	 * @author Scott.zhu
	 * */
	private void applicationInit() 
	{
		

	}

}
