package fr.guimsbeber.buddyfit;

import fr.guimsbeber.buddyfit.adapter.ExerciceListAdapter;
import fr.guimsbeber.buddyfit.bdd.ExerciceRepo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListExerciceActivity extends Activity {
	private ListView mListViewForOneCategory;
	private ExerciceListAdapter mAdapter;
	private int mValueSession = 0;
	private Context _ctx;

	private ExerciceRepo mExerciceRepo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_exercice);
		_ctx=this;
		mExerciceRepo = new ExerciceRepo(this);
		TextView txtVListForCategory = (TextView)findViewById(R.id.txtVListForCategory);
		mListViewForOneCategory = (ListView)findViewById(R.id.lvListForCategory);
		Bundle extras = getIntent().getExtras();
		Button btnAddExercice = (Button)findViewById(R.id.btnAddExercice);
		Button btnPrevious = (Button)findViewById(R.id.btnPrevious);
		
		btnPrevious.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {finish();}
		});
		
		//Récupération du sessionID
		if (extras != null) {
			mValueSession = extras.getInt("mValueSession");
		}
		
		//Affichage de la liste en fonction du choix précédent
		mExerciceRepo.Open();
		if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG,"mValueSession = "+mValueSession);
		if(mValueSession != 0){
			this.onChangeTitleOfPage(txtVListForCategory);
			mAdapter = new ExerciceListAdapter(this, mExerciceRepo.GetByCategory(mValueSession));
		}
		else {
			txtVListForCategory.setText(R.string.tltshowall);
			mAdapter = new ExerciceListAdapter(this, mExerciceRepo.GetAll());
		}
		mExerciceRepo.Close();
		mListViewForOneCategory.setAdapter(mAdapter);
		registerForContextMenu(mListViewForOneCategory);
		
		btnAddExercice.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(v.getContext(), OPExerciceActivity.class);
				mIntent.putExtra("mValueSession",mValueSession);
				startActivity(mIntent);
				finish();
			}
		});
	}

	/**
	 * Permet d'attribuer un titre à la page en fonction de la valeur de retour
	 * présent dans le bundle
	 * @param txtVListForCategory
	 */
	private void onChangeTitleOfPage(TextView txtVListForCategory){
		if(mValueSession==1){
			txtVListForCategory.setText(R.string.tlttriceps);
		}
		else if(mValueSession==2){
			txtVListForCategory.setText(R.string.tltchest);
		}
		else if(mValueSession==3){
			txtVListForCategory.setText(R.string.tltbiceps);
		}
		else if(mValueSession==4){
			txtVListForCategory.setText(R.string.tltback);
		}
		else if(mValueSession==5){
			txtVListForCategory.setText(R.string.tltglutes);
		}
		else if(mValueSession==6){
			txtVListForCategory.setText(R.string.tltlowerleg);
		}
		else if(mValueSession==7){
			txtVListForCategory.setText(R.string.tltupperleg);
		}
		else if(mValueSession==8){
			txtVListForCategory.setText(R.string.tltAbs);
		}
		else if(mValueSession==9){
			txtVListForCategory.setText(R.string.tltcardio);
		}
		else if(mValueSession==10){
			txtVListForCategory.setText(R.string.tltforearm);
		}
		else if(mValueSession==11){
			txtVListForCategory.setText(R.string.tltshoulder);
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
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
    @Override
    public void onBackPressed() {
    	Intent mIntent = new Intent(_ctx, ExercicesActivity.class);
		startActivity(mIntent);
		finish();
    }
}
