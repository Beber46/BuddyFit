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
	private Button _btnRoutine;
	private Button _btnActivities;
	private Button _btnTime;
	private Button _btnProfil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_routine_list);
		
		//get buttons
		_btnHome 		= (Button) findViewById(R.id.btnHome);
		_btnRoutine 	= (Button) findViewById(R.id.btnRoutine);
		_btnActivities 	= (Button) findViewById(R.id.btnActivities);
		_btnTime 		= (Button) findViewById(R.id.btnTime);
		_btnProfil 		= (Button) findViewById(R.id.btnProfil);
		
		//listener
		_btnHome.setOnClickListener(buttonListener);
		_btnRoutine.setOnClickListener(buttonListener);
		_btnActivities.setOnClickListener(buttonListener);
		_btnTime.setOnClickListener(buttonListener);
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
			//button routines
			if(v == _btnRoutine){
				i = new Intent(RoutineListActivity.this, RoutineListActivity.class);
			}
			//button activities
			if(v == _btnActivities){
				//i = new Intent(RoutineListActivity.this, MenuActivity.class);
			}
			//button time
			if(v == _btnTime){
				//i = new Intent(RoutineListActivity.this, MenuActivity.class);
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
