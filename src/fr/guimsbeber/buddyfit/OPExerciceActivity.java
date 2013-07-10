package fr.guimsbeber.buddyfit;

import java.util.ArrayList;
import java.util.List;

import fr.guimsbeber.buddyfit.bdd.CategoryRepo;
import fr.guimsbeber.buddyfit.bdd.ExerciceRepo;
import fr.guimsbeber.buddyfit.objet.Exercice;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class OPExerciceActivity extends Activity implements OnItemSelectedListener{
	
	private Context _ctx;
	
	//BDD
	private ExerciceRepo mExerciceRepo;
	private CategoryRepo mCategoryRepo;
	
	//Atributs
	private int mExerciceID;
	private Exercice mExercice;
	private Button mBtnSaveRest;
	private EditText mETxtExerciceName;
	private EditText mETxtDescriptorExercice;
	private Spinner mSpinCategoryExercice;
	private int mPositionSpinner;
	private int mValueSession;
	private Button mBtnDeleteExercice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_op_exercice);
		
		_ctx=this;
		
		mExerciceRepo = new ExerciceRepo(this);
		mCategoryRepo = new CategoryRepo(this);
		Button btnPrevious = (Button)findViewById(R.id.btnPrevious);
		mBtnSaveRest = (Button)findViewById(R.id.btnSaveExercice);
		mETxtExerciceName = (EditText)findViewById(R.id.eTxtExerciceName);
		mETxtDescriptorExercice = (EditText)findViewById(R.id.eTxtDescriptorExercice);
		mSpinCategoryExercice = (Spinner)findViewById(R.id.spinCategoryExercice);
		mBtnDeleteExercice = (Button)findViewById(R.id.btnDeleteExercice);
		mExercice=null;

		//Chargement
		this.loadMySpinner();
		mSpinCategoryExercice.setOnItemSelectedListener(this);
		mPositionSpinner=0;
		mExerciceID=0;
		
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			mValueSession = extras.getInt("mValueSession");
			if(extras.getInt("mExerciceID")!=0) {//s'il s'agit d'une modification
				
				//Je rend visible le bouton delete 
				mBtnDeleteExercice.setVisibility(View.VISIBLE);
				
				mExerciceRepo.Open();
				mExerciceID = extras.getInt("mExerciceID");
				
				if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG,"mExerciceID : "+mExerciceID);
				mExercice = mExerciceRepo.GetById(mExerciceID);
				
				mValueSession=mExercice.getIdCategory();
				
				if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG,"exercice name : "+mExercice.getName());
				
				mETxtExerciceName.setText(mExercice.getName());
				mETxtDescriptorExercice.setText(mExercice.getDescription());
				mExerciceRepo.Close();
			}

			if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG,"mValueSession : "+mValueSession);
			//Init Spinner position
			if(mValueSession>0)
				mSpinCategoryExercice.setSelection(mValueSession-1);//-1 car la position commence à 0
			
		}
		
		mBtnSaveRest.setOnClickListener(mButtonListener);
		mBtnDeleteExercice.setOnClickListener(mButtonListener);
		btnPrevious.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				BackPressEvent();
			}
		});
	}

	/**
	 * Modifie l'evenement lors du back (bouton ou back telephone)
	 */
	private void BackPressEvent(){
		Intent mIntent = new Intent(_ctx, ListExerciceActivity.class);
		mIntent.putExtra("mValueSession",mValueSession);
		startActivity(mIntent);
		finish();
	}
	
	/**
	 * Permet de charger le contenu des catégories dans le spinner
	 */
	private void loadMySpinner(){
		mCategoryRepo.Open();
		
		List<String> listCategories = new ArrayList<String>();
		
		//je récup toutes les catégories
		listCategories = mCategoryRepo.GetAllStrings();
		
		if(listCategories.size()>0){
			ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listCategories);
			dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			
			mSpinCategoryExercice.setAdapter(dataAdapter);
		}
		
		mCategoryRepo.Close();
	}
	
	private OnClickListener mButtonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v==mBtnSaveRest){
				mExerciceRepo.Open();
				mExercice = new Exercice(mETxtExerciceName.getText().toString(), mETxtDescriptorExercice.getText().toString(), mPositionSpinner);
				mExerciceRepo.Save(mExercice);
				mExerciceRepo.Close();
				
				BackPressEvent();
			}
			else if(v==mBtnDeleteExercice && mBtnDeleteExercice.getVisibility()==View.VISIBLE && mExerciceID!=0){
				
				//Création de l'AlertDialog
		        AlertDialog.Builder alBuilder = new AlertDialog.Builder(_ctx);
		        alBuilder.setTitle(R.string.alertdialog_title_delete)
		        	.setMessage(R.string.alertdialog_texte_sure)
		        	.setIcon(android.R.drawable.ic_delete)
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
				
				//On l'affiche
				alBuilder.show();
				
			}
		}
	};
	
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

    @Override
    public void onBackPressed() {
    	BackPressEvent();
    }
    
	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
		long id) {
		if(HomeActivity.DEBUG)Log.d(HomeActivity.TAG, "Ma position dans le spinner "+pos);
		mPositionSpinner=pos+1;//+1 car par de 0
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
	}

}
