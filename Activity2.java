package com.acadgild.android.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity2);
		Intent intentObject = getIntent();
		String userName = intentObject.getStringExtra("UserName");
		boolean isRegistered = intentObject.getBooleanExtra("isRegistered", true);

		String userNameBundle=intentObject.getExtras().getString("BundleUserName");

		Toast.makeText(getApplicationContext(),userName+" Registration Status :"+isRegistered, Toast.LENGTH_LONG).show();
		Toast.makeText(getApplicationContext(),userNameBundle+" Registration Status :"+isRegistered, Toast.LENGTH_LONG).show();
	}



}
