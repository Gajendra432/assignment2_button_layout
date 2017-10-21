package com.acadgild.android.intents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Activity1 extends Activity {

	private static final int CAMERA_REQUEST = 100;
	ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity1);
		image = (ImageView) findViewById(R.id.image);
	}


	public void openActivity(View v) {

		//Create Intent object
		Intent openNewActivity = new Intent(getApplicationContext(), Activity2.class);

		//Directly set data in intent object
		openNewActivity.putExtra("UserName", "Gajendra");
		openNewActivity.putExtra("isRegistered", true);
		openNewActivity.putExtra("age", 12);
		//Set data in bundle and then set bundle in intent object
		Bundle dataBundle = new Bundle();
		dataBundle.putString("BundleUserName", "ACADGILD-B");
		dataBundle.putInt("age", 20);
		openNewActivity.putExtras(dataBundle);
		//openNewActivity.putExtra("data", dataBundle);

		startActivity(openNewActivity);
	}

	public void openWebPage(View v) {
		Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.veltechuniv.edu.in"));
		startActivity(webIntent);
	}
    public void shareData(View v) {
		Intent sendIntent = new Intent();
		sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello From VELTECH");
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
	}
    public void StartResultActivity(View v) {
		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, CAMERA_REQUEST);
	}


	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
			Bitmap photo = (Bitmap) data.getExtras().get("data");
			image.setImageBitmap(photo);

		}
	}
}