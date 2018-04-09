package com.myplayschool;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Splashscreen extends Activity implements OnClickListener{
	ImageView imgstart,info;
	private PopupWindow mpopup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

	
		imgstart=(ImageView) findViewById(R.id.splashimg);
		imgstart.setOnClickListener(this);
		info = (ImageView)findViewById(R.id.infor);

		info.setOnClickListener(new OnClickListener() 
		{            
			public void onClick(View arg0) 
			{
				View popUpView = getLayoutInflater().inflate(R.layout.popup_info, (ViewGroup) findViewById(R.layout.splash)); // inflating popup layout
				mpopup = new PopupWindow(popUpView, LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, true); //Creation of popup
				mpopup.setAnimationStyle(android.R.style.Animation_Dialog);   
				mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);    // Displaying popup
				//  final Animation animfade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


				ImageView btnOk = (ImageView)popUpView.findViewById(R.id.closebutton);
				btnOk.setOnClickListener(new OnClickListener() 
				{                    
					public void onClick(View v) 
					{
						mpopup.dismiss();  //dismissing the popup
					}
				});




			}
		});  
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub

	
		Intent inter=new Intent(getApplicationContext(),IndexList.class);
		startActivity(inter);
		finish();
	}

}
