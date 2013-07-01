package fr.guimsbeber.buddyfit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {
	
	private Button _btnRoutine;
	private Button _btnActivities;
	private Button _btnExercices;
	private Button _btnProfil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		ButtonEffect.assignRed((Button)findViewById(R.id.btnStart));
		
		//get buttons
		_btnRoutine 	= (Button) findViewById(R.id.btnRoutine);
		_btnExercices 	= (Button) findViewById(R.id.btnExercices);
		_btnActivities 	= (Button) findViewById(R.id.btnActivities);
		_btnProfil 		= (Button) findViewById(R.id.btnProfil);

		ButtonEffect.assignGrey(_btnRoutine);
		ButtonEffect.assignGrey(_btnExercices);
		ButtonEffect.assignGrey(_btnActivities);
		ButtonEffect.assignGrey(_btnProfil);
		
		//listener
		_btnRoutine.setOnClickListener(buttonListener);
		_btnActivities.setOnClickListener(buttonListener);
		_btnExercices.setOnClickListener(buttonListener);
		_btnProfil.setOnClickListener(buttonListener);
	}
	
	OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = null;
			//button routines
			if(v == _btnRoutine){
				i = new Intent(MenuActivity.this, RoutineListActivity.class);
			}
			//button activities
			else if(v == _btnActivities){
				//i = new Intent(MenuActivity.this, MenuActivity.class);
			}
			//button execices
			else if(v == _btnExercices){
				i = new Intent(MenuActivity.this, ExercicesActivity.class);
			}
			//button profil
			else if(v == _btnProfil){
				i = new Intent(MenuActivity.this, ProfilActivity.class);
			}
			
			
			//intent not null, start activity
			if(i != null){				
				startActivity(i);
			}
			
		}
	};
	

	@Override
    protected void onStart() {
        super.onStart();
		overridePendingTransition(R.anim.fade, R.anim.hold);
        // The activity is about to become visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }
}
