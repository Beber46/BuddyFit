package fr.guimsbeber.buddyfit;

import java.util.List;

import fr.guimsbeber.buddyfit.bdd.CategoryRepo;
import fr.guimsbeber.buddyfit.bdd.ExerciceRepo;
import fr.guimsbeber.buddyfit.objet.Category;
import fr.guimsbeber.buddyfit.objet.Exercice;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class HomeActivity extends Activity {
	Handler mhandler = null;
	
	public static final String TAG = "guimsbeber";
	public static final boolean DEBUG = true;
	
	private CategoryRepo mCategoryRepo;
	private ExerciceRepo mExerciceRepo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		//Sauve Cat�gories
		this.createCategoryIfNotExist();
		//Sauve Exercices
		this.createExerciceIfNotExist();
		
		mhandler = new Handler();
		mhandler.postDelayed(new Runnable() {            
	        @Override
	        public void run() {
	            Intent intent = new Intent(HomeActivity.this, MenuActivity.class);
	            startActivity(intent);  
	            finish();
	        }
	    }, 3000);
	    
	}
	/**
	 * Permet de cr�er si n�cessaire des exercices
	 */
	private void createExerciceIfNotExist(){
		mExerciceRepo = new ExerciceRepo(HomeActivity.this);
		
		mExerciceRepo.Open();
		if(mExerciceRepo.GetAll().size()==0)//si la liste est vide alors on cr�e les cat�gories
		{
			Exercice exercice = new Exercice(1, "Crunch", "Allong� sur le sol le dos bien � plat, les jambes repos�es " +
					"sur un banc, cuisses et mollets en angle droit. Les mains sont plac�es derri�re la t�te mais ne " +
					"doivent pas tirer sur la nuque. Ramenez vos �paules en direction de vos jambes. Soufflez lors de " +
					"la contractio, expirez en revenant � la position initiale."
					, 8);
			mExerciceRepo.Save(exercice);
		}
		mExerciceRepo.Close();
	}
	
	/**
	 * Permet de cr�er si n�cessaire des cat�gories
	 */
	private void createCategoryIfNotExist(){
		
		mCategoryRepo = new CategoryRepo(HomeActivity.this);
		
		mCategoryRepo.Open();
		if(mCategoryRepo.GetAll().size()==0)//si la liste est vide alors on cr�e les cat�gories
		{
			Category saveCat = new Category(1,"Triceps","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(2,"Chest","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(3,"Biceps","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(4,"Back","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(5,"Glutes","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(6,"Lower Leg","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(7,"Upper Leg","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(8,"Abs","description");
			mCategoryRepo.Save(saveCat);
			
			saveCat = new Category(9,"Cardio","description");
			mCategoryRepo.Save(saveCat);

			saveCat = new Category(10,"Forearm","description");
			mCategoryRepo.Save(saveCat);

			saveCat = new Category(11,"Shoulder","description");
			mCategoryRepo.Save(saveCat);
			
			if(HomeActivity.DEBUG)
				Log.d(HomeActivity.TAG, "Nombre de category sauvergarder : "+mCategoryRepo.GetAll().size());
		}
		mCategoryRepo.Close();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
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
