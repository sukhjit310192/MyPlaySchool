package com.myplayschool;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Fullversion extends Activity implements OnClickListener{
	public ImageView imgUpdate,imgback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fullversion);
//		 AdView adView = (AdView)this.findViewById(R.id.adView);
//		    adView.loadAd(new AdRequest());

		imgUpdate=(ImageView) findViewById(R.id.update);
		imgUpdate.setOnClickListener(this);
		imgback=(ImageView) findViewById(R.id.back);
		imgback.setOnClickListener(this);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.update:

			Intent intentbrowser = new Intent( Intent.ACTION_VIEW , Uri.parse( "  " ) );
			startActivity( intentbrowser );
			
			break;
		case R.id.back:

			Intent intent = new Intent(getApplicationContext(),HomePage.class);
			startActivity(intent);
			finish();
			break;
		default:
			break;
		}


	}

}
