package fr.guimsbeber.buddyfit;

import java.util.ArrayList;

import fr.guimsbeber.buddyfit.adapter.RoutineListAdapter;
import fr.guimsbeber.buddyfit.objet.Routine;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class RoutineListActivity extends Activity {
	
	private Button _btnHome;
	private Button _btnActivities;
	private Button _btnExercices;
	private Button _btnProfil;
	private Button _btnRoutineAdd;
	private Button _btnRoutineRm;
	private Button _btnRoutineModif;
	private Button _btnRefresh;
	private ListView _listView;	
	
	private ArrayList<Routine> _routines;
	private RoutineListAdapter _adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_routine_list);
		
		//views
		_btnHome 		= (Button) findViewById(R.id.btnHome);
		_btnExercices 	= (Button) findViewById(R.id.btnExercices);
		_btnActivities 	= (Button) findViewById(R.id.btnActivities);
		_btnProfil 		= (Button) findViewById(R.id.btnProfil);
		_btnRoutineAdd 	= (Button) findViewById(R.id.btnRoutineAdd);
		_btnRoutineRm	= (Button) findViewById(R.id.btnRoutineRm);
		_btnRoutineModif= (Button) findViewById(R.id.btnRoutineModif);
		_btnRefresh		= (Button) findViewById(R.id.btnRoutineRefresh);
		_listView		= (ListView) findViewById(R.id.lvRoutines);	

		ButtonEffect.assignGrey(_btnHome);
		ButtonEffect.assignGrey(_btnProfil);
		ButtonEffect.assignGrey(_btnExercices);
		ButtonEffect.assignGrey(_btnActivities);
		
		//listener
		_btnHome.setOnClickListener(buttonListener);
		_btnActivities.setOnClickListener(buttonListener);
		_btnExercices.setOnClickListener(buttonListener);
		_btnProfil.setOnClickListener(buttonListener);
		_btnRoutineAdd.setOnClickListener(buttonListener);
		_btnRoutineRm.setOnClickListener(buttonListener);
		_btnRoutineModif.setOnClickListener(buttonListener);
		_btnRefresh.setOnClickListener(buttonListener);
		
		_routines = new ArrayList<Routine>();
		_routines.add(new Routine(0, "Routine 1", 5, "Example routine", 2));
		_routines.add(new Routine(1, "Routine 2", 5, "Example routine 2", 2));
		
		_adapter = new RoutineListAdapter(this, _routines);
		_listView.setAdapter(_adapter);
		
	}
	
	OnClickListener buttonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intentActivity = null;
			Intent intentRoutine = null;
			//button home
			if(v == _btnHome){
				intentActivity = new Intent(RoutineListActivity.this, MenuActivity.class);
			}
			//button activities
			else if(v == _btnActivities){
				//intentActivity = new Intent(RoutineListActivity.this, MenuActivity.class);
			}
			//button exercices
			else if(v == _btnExercices){
				intentActivity = new Intent(RoutineListActivity.this, ExercicesActivity.class);
			}
			//button profil
			else if(v == _btnProfil){
				intentActivity = new Intent(RoutineListActivity.this, ProfilActivity.class);
			}		
			//button routine add
			else if(v == _btnRoutineAdd){
				intentRoutine = new Intent(RoutineListActivity.this, RoutineCreateActivity.class);
			}
			
			//intent not null, start activity
			if(intentActivity != null){				
				startActivity(intentActivity);
				finish();
			}
			
			//intent not null, start activity
			if(intentRoutine != null){				
				startActivity(intentRoutine);
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
