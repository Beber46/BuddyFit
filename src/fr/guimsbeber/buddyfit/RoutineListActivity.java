package fr.guimsbeber.buddyfit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RoutineListActivity extends Activity {
	
	private Button _btnHome;
	private Button _btnActivities;
	private Button _btnExercices;
	private Button _btnProfil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		//get buttons
		_btnHome 		= (Button) findViewById(R.id.btnHome);
		_btnExercices 	= (Button) findViewById(R.id.btnExercices);
		_btnActivities 		= (Button) findViewById(R.id.btnActivities);
		_btnProfil 		= (Button) findViewById(R.id.btnProfil);
		
		//listener
		_btnHome.setOnClickListener(buttonListener);
		_btnActivities.setOnClickListener(buttonListener);
		_btnExercices.setOnClickListener(buttonListener);
		_btnProfil.setOnClickListener(buttonListener);
	}
	
	OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = null;
			//button home
			if(v == _btnHome){
				i = new Intent(RoutineListActivity.this, MenuActivity.class);
			}
			//button activities
			if(v == _btnActivities){
				//i = new Intent(MenuActivity.this, MenuActivity.class);
			}
			//button time
			if(v == _btnExercices){
				//i = new Intent(MenuActivity.this, MenuActivity.class);
			}
			//button profil
			if(v == _btnProfil){
				i = new Intent(RoutineListActivity.this, ProfilActivity.class);
			}			
			
			//intent not null, start activity
			if(i != null){				
				startActivity(i);
				finish();
			}
			
		}
	};


}
