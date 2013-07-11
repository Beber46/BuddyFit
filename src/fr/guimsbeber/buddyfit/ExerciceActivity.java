package fr.guimsbeber.buddyfit;

import java.util.ArrayList;
import java.util.HashMap;

import fr.guimsbeber.buddyfit.bdd.ExerciceRepo;
import fr.guimsbeber.buddyfit.objet.Exercice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ExerciceActivity extends Activity {
	private ListView mListViewTest;
	private Dialog mDialog=null;
	private Context _ctx;
	private int mExerciceID=0;
	private Exercice mExercice=null;
	private ExerciceRepo mExerciceRepo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercice);
		
		_ctx=this;
		mExerciceRepo = new ExerciceRepo(this);
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			mExerciceID = extras.getInt("mExerciceID");
			mExerciceRepo.Open();
			mExercice = mExerciceRepo.GetById(mExerciceID);
			mExerciceRepo.Close();
		}
		else  //rien à foutre la 
			finish();
		
		if(mExercice==null)
			finish();
		
		TextView txtExerciceName = (TextView)findViewById(R.id.txtExerciceName);
		txtExerciceName.setText(mExercice.getName());
		
		TextView txtViewDescription = (TextView)findViewById(R.id.txtViewDescription);
		txtViewDescription.setText(mExercice.getDescription());
		
		ButtonEffect.assignRed((Button)findViewById(R.id.btnSaveAndRest));
		ButtonEffect.assignGrey((Button)findViewById(R.id.btnViewHistory));
		
		//Récup list view
		mListViewTest = (ListView) findViewById(R.id.lvExercice);

		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;

		map = new HashMap<String, String>();
		map.put("inf", "Reps");
		map.put("value", "8");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("inf", "Weight");
		map.put("value", "25");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("inf", "Reset Time");
		map.put("value", "90 sec");
		listItem.add(map);
		
		SimpleAdapter mSimpleAdapter = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.list_exercice, 
        		new String[] {"inf", "value"}, 
        		new int[]{R.id.txtTitle,R.id.txtValue});

        mListViewTest.setAdapter(mSimpleAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.op_exercice, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_edit:
	        	Intent mIntent = new Intent(_ctx, OPExerciceActivity.class);
				mIntent.putExtra("mExerciceID",mExercice.getId());
				mIntent.putExtra("exerciceAct",1);
				startActivity(mIntent);
	            return true;
	        case R.id.action_delete:
	        	//Création de l'AlertDialog
		        AlertDialog.Builder alBuilder = new AlertDialog.Builder(_ctx);
		        alBuilder.setTitle(R.string.alertdialog_title_delete)
		        	.setMessage(R.string.alertdialog_texte_sure)
		        	.setIcon(R.drawable.alertswarning)
		        	.setPositiveButton(R.string.alertdialog_yes,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								mExerciceRepo.Open();
								mExerciceRepo.Delete(mExerciceID);
								mExerciceRepo.Close();

								BackPressEvent();
							}
						})
					.setNegativeButton(R.string.alertdialog_no,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {

							}
						});
		        
		        mDialog = alBuilder.create();				
				//On l'affiche
				alBuilder.show();
	            return true;
	        default:
	            return true;
	    }
	}
	
	/**
	 * Modifie l'evenement lors du back (bouton ou back telephone)
	 */
	private void BackPressEvent(){
		Intent mIntent = new Intent(_ctx, ListExerciceActivity.class);
		mIntent.putExtra("mValueSession",mExercice.getIdCategory());
		startActivity(mIntent);
		finish();
	}
	
	private void clearAll(){
		mExerciceRepo.Open();
		mExercice = mExerciceRepo.GetById(mExerciceID);
		mExerciceRepo.Close();
		
		TextView txtExerciceName = (TextView)findViewById(R.id.txtExerciceName);
		txtExerciceName.setText(mExercice.getName());
		
		TextView txtViewDescription = (TextView)findViewById(R.id.txtViewDescription);
		txtViewDescription.setText(mExercice.getDescription());
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
        clearAll();
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
    	if(mDialog!=null)
    		if(mDialog.isShowing())
    			mDialog.dismiss();
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
    	if(mDialog!=null)
    		if(mDialog.isShowing())
    			mDialog.dismiss();
        super.onDestroy();
        // The activity is about to be destroyed.
    }
    
    @Override
    public void onBackPressed() {
    	Intent mIntent = new Intent(_ctx, ListExerciceActivity.class);
		mIntent.putExtra("mValueSession",mExercice.getIdCategory());
		startActivity(mIntent);
		finish();
    }
}
