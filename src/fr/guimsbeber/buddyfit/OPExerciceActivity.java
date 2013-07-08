package fr.guimsbeber.buddyfit;

import fr.guimsbeber.buddyfit.bdd.ExerciceRepo;
import fr.guimsbeber.buddyfit.objet.Exercice;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class OPExerciceActivity extends Activity {
	
	private ExerciceRepo mExerciceRepo;
	private int mExerciceID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_op_exercice);
		
		mExerciceRepo = new ExerciceRepo(this);
		Button btnPrevious = (Button)findViewById(R.id.btnPrevious);

		Bundle extras = getIntent().getExtras();
		if (extras != null && extras.getInt("mExerciceID")!=0) {
			mExerciceRepo.Open();
			mExerciceID = extras.getInt("mExerciceID");
			
			if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG,"mExerciceID : "+mExerciceID);
			Exercice exercice = mExerciceRepo.GetById(1);

			if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG,"exercice name : "+exercice.getName());
			
			EditText eTxtExerciceName = (EditText)findViewById(R.id.eTxtExerciceName);
			eTxtExerciceName.setText(exercice.getName());
			EditText eTxtDescriptorExercice = (EditText)findViewById(R.id.eTxtDescriptorExercice);
			eTxtDescriptorExercice.setText(exercice.getDescription());
			mExerciceRepo.Close();
		}
		
		btnPrevious.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {finish();}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_exercice, menu);
		return true;
	}
	

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
