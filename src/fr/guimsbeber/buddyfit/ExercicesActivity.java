package fr.guimsbeber.buddyfit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ExercicesActivity extends Activity {
	
	private Button _btnRoutine;
	private Button _btnActivities;
	private Button _btnHome;
	private Button _btnProfil;
	
	//boutons des muscles
	private Button _btnTriceps;
	private Button _btnBiceps;
	private Button _btnBack;
	private Button _btnGlutes;
	private Button _btnLowerLegs;
	private Button _btnUpperLegs;
	private Button _btnAbs;
	private Button _btnCardio;
	private Button _btnChest;
	private Button _btnForearm;
	private Button _btnShoulder;
	private Button _btnShowAll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercices);

		//get buttons
		_btnRoutine 	= (Button) findViewById(R.id.btnRoutine);
		_btnHome 		= (Button) findViewById(R.id.btnHome);
		_btnActivities 	= (Button) findViewById(R.id.btnActivities);
		_btnProfil 		= (Button) findViewById(R.id.btnProfil);

		_btnTriceps     = (Button)findViewById(R.id.btnTriceps);
		_btnBiceps     = (Button)findViewById(R.id.btnBiceps);
		_btnBack     = (Button)findViewById(R.id.btnBack);
		_btnGlutes     = (Button)findViewById(R.id.btnGlutes);
		_btnLowerLegs     = (Button)findViewById(R.id.btnLowerLegs);
		_btnUpperLegs     = (Button)findViewById(R.id.btnUpperLegs);
		_btnAbs     = (Button)findViewById(R.id.btnAbs);
		_btnCardio     = (Button)findViewById(R.id.btnCardio);
		_btnChest     = (Button)findViewById(R.id.btnChest);
		_btnForearm     = (Button)findViewById(R.id.btnForearm);
		_btnShoulder     = (Button)findViewById(R.id.btnShoulder);
		_btnShowAll     = (Button)findViewById(R.id.btnShowAll);

		//Effect
		ButtonEffect.assignGrey(_btnHome);
		ButtonEffect.assignGrey(_btnProfil);
		ButtonEffect.assignGrey(_btnRoutine);
		ButtonEffect.assignGrey(_btnActivities);

		ButtonEffect.assignRed(_btnTriceps);
		ButtonEffect.assignRed(_btnBiceps);
		ButtonEffect.assignRed(_btnBack);
		ButtonEffect.assignRed(_btnGlutes);
		ButtonEffect.assignRed(_btnLowerLegs);
		ButtonEffect.assignRed(_btnUpperLegs);
		ButtonEffect.assignRed(_btnAbs);
		ButtonEffect.assignRed(_btnCardio);
		ButtonEffect.assignRed(_btnChest);
		ButtonEffect.assignRed(_btnShowAll);
		ButtonEffect.assignRed(_btnForearm);
		ButtonEffect.assignRed(_btnShoulder);
		
		//listener
		_btnRoutine.setOnClickListener(buttonListener);
		_btnActivities.setOnClickListener(buttonListener);
		_btnHome.setOnClickListener(buttonListener);
		_btnProfil.setOnClickListener(buttonListener);
		
		//operation sur les catégories de muscle
		_btnTriceps.setOnClickListener(buttonCatListener);
		_btnBiceps.setOnClickListener(buttonCatListener);
		_btnBack.setOnClickListener(buttonCatListener);
		_btnGlutes.setOnClickListener(buttonCatListener);
		_btnLowerLegs.setOnClickListener(buttonCatListener);
		_btnUpperLegs.setOnClickListener(buttonCatListener);
		_btnAbs.setOnClickListener(buttonCatListener);
		_btnCardio.setOnClickListener(buttonCatListener);
		_btnChest.setOnClickListener(buttonCatListener);
		_btnShowAll.setOnClickListener(buttonCatListener);
		_btnForearm.setOnClickListener(buttonCatListener);
		_btnShoulder.setOnClickListener(buttonCatListener);
	}


	//Catégory
	OnClickListener buttonCatListener = new OnClickListener() {

		@Override
		public void onClick(View btn) {
			// TODO Auto-generated method stub
			
			int sessionID = 0;
			if(btn == _btnTriceps){
				sessionID=1;
			}
			else if(btn == _btnChest){
				sessionID=2;
			}
			else if(btn == _btnBiceps){
				sessionID=3;
			}
			else if(btn == _btnBack){
				sessionID=4;
			}
			else if(btn == _btnGlutes){
				sessionID=5;
			}
			else if(btn == _btnLowerLegs){
				sessionID=6;
			}
			else if(btn == _btnUpperLegs){
				sessionID=7;
			}
			else if(btn == _btnAbs){
				sessionID=8;
			}
			else if(btn == _btnCardio){
				sessionID=9;
			}
			else if(btn == _btnForearm){
				sessionID=10;
			}
			else if(btn == _btnShoulder){
				sessionID=11;
			}
			
			if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG, "Value = "+String.valueOf(sessionID));
			
			Intent mIntent = new Intent(getApplicationContext(), ListExerciceActivity.class);
			mIntent.putExtra("mValueSession",sessionID);
			startActivity(mIntent);
		}
		
	};
	
	OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent i = null;
			//button routines
			if(v == _btnRoutine){
				i = new Intent(ExercicesActivity.this, RoutineListActivity.class);
			}
			//button activities
			else if(v == _btnActivities){
				//i = new Intent(MenuActivity.this, MenuActivity.class);
			}
			//button execices
			else if(v == _btnHome){
				i = new Intent(ExercicesActivity.this, MenuActivity.class);
			}
			//button profil
			else if(v == _btnProfil){
				i = new Intent(ExercicesActivity.this, ProfilActivity.class);
			}
			
			
			//intent not null, start activity
			if(i != null){				
				startActivity(i);
				finish();
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
