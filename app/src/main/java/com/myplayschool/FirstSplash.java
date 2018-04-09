package com.myplayschool;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class FirstSplash extends Activity{protected boolean _active = true;
protected int _splashTime = 20; // time to display the splash screen in ms
private static int progress;
private ProgressDialog progressDialog;
static ProgressBar progressBar;
private int progressStatus = 0;
private Handler handler = new Handler();
TextView loading;
Typeface stype;



private boolean checkInternetConnection() {
	ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	if (conMgr.getActiveNetworkInfo() != null
			&& conMgr.getActiveNetworkInfo().isAvailable()
			&& conMgr.getActiveNetworkInfo().isConnected()) {
		Log.i("netttt", "connection");
		return true;
	} else {
		while (conMgr.getActiveNetworkInfo() == null) {
			Toast.makeText(getApplicationContext(),
					"No Internet Connection Found !!! Please Connect To Internet First",
					Toast.LENGTH_SHORT).show();


			//toast.setGravity(Gravity.CENTER, 0, 0);

			progMethod();
		}

		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					finish();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		return false;
	}}


public void progMethod() {

	progress = 0;	
	progressBar = (ProgressBar) findViewById(R.id.progressBar1);
	progressBar.setMax(200);
	//---do some work in background thread---
	new Thread(new Runnable()
	{

		public void run()
		{
			//---do some work here---
			while (progressStatus < 200)
			{
				progressStatus = doSomeWork();

				//---Update the progress bar---
				handler.post(new Runnable()
				{
					public void run() {
						progressBar.setProgress(progressStatus);

					}
				});

			}

			//---hides the progress bar---
			handler.post(new Runnable()
			{
				public void run()

				{
					//---0 - VISIBLE; 4 - INVISIBLE; 8 - GONE---
					//progressBar.setVisibility(8);
				}
			});
		}
		//---do some long lasting work here---
		private int doSomeWork()
		{
			try {
				//---simulate doing some work---
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return ++progress;
		}
	}).start();

}


@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.firstsplash);




	
	checkInternetConnection();


	progMethod();

	//        if(isInternetAvailable()==false)
	//        { 
	//   		 startActivity(new Intent(Splesh.this,Activity_DealsCircleApplicationActivity.class));
	//            finish();
	//        	 Toast.makeText(getApplicationContext(), "Interneti connected", 2000).show();	
	//        }
	//        else if (isInternetAvailable()==true)
	//        {
	//        	 Toast.makeText(getApplicationContext(), "Internetis is Not connected plese connect", 100000).show();	
	//        }
	Thread splashTread = new Thread() {
		@Override
		public void run() {
			try {

				int waited = 0;
				while (_active && (waited < _splashTime)) {
					sleep(2000);
					if (_active) {
						waited += 2000;
					}
				}
			} catch (Exception e) {

			} finally 
			{
				Intent in=new Intent(FirstSplash.this,HomePage.class);
				startActivity(in);
				finish();

			}
		};
	};
	splashTread.start();
	Toast t = Toast.makeText(this,"You are online!!!!",Toast.LENGTH_LONG);


}







}