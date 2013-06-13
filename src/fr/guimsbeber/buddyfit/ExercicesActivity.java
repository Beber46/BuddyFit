package fr.guimsbeber.buddyfit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ExercicesActivity extends Activity {
	
	private Button _btnRoutine;
	private Button _btnActivities;
	private Button _btnHome;
	private Button _btnProfil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercices);
		
		//get buttons
				_btnRoutine 	= (Button) findViewById(R.id.btnRoutine);
				_btnHome 		= (Button) findViewById(R.id.btnHome);
				_btnActivities 	= (Button) findViewById(R.id.btnActivities);
				_btnProfil 		= (Button) findViewById(R.id.btnProfil);
				
				//listener
				_btnRoutine.setOnClickListener(buttonListener);
				_btnActivities.setOnClickListener(buttonListener);
				_btnHome.setOnClickListener(buttonListener);
				_btnProfil.setOnClickListener(buttonListener);
	}


	OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = null;
			//button routines
			if(v == _btnRoutine){
				i = new Intent(ExercicesActivity.this, RoutineListActivity.class);
			}
			//button activities
			if(v == _btnActivities){
				//i = new Intent(MenuActivity.this, MenuActivity.class);
			}
			//button execices
			if(v == _btnHome){
				i = new Intent(ExercicesActivity.this, MenuActivity.class);
			}
			//button profil
			if(v == _btnProfil){
				i = new Intent(ExercicesActivity.this, ProfilActivity.class);
			}
			
			
			//intent not null, start activity
			if(i != null){				
				startActivity(i);
				finish();
			}
			
		}
	};

}