package fr.guimsbeber.buddyfit;

import java.util.ArrayList;
import java.util.HashMap;

import fr.guimsbeber.buddyfit.adapter.AlternateListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ProfilActivity extends Activity {
	
	private ListView mListViewTest;
	private Button _btnHome;
	private Button _btnActivities;
	private Button _btnExercices;
	private Button _btnRoutine;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil);
		
		//get buttons
		_btnHome 		= (Button) findViewById(R.id.btnHome);
		_btnRoutine 	= (Button) findViewById(R.id.btnRoutine);
		_btnExercices 	= (Button) findViewById(R.id.btnExercices);
		_btnActivities 		= (Button) findViewById(R.id.btnActivities);
		
		//listener
		_btnHome.setOnClickListener(buttonListener);
		_btnRoutine.setOnClickListener(buttonListener);
		_btnActivities.setOnClickListener(buttonListener);
		_btnExercices.setOnClickListener(buttonListener);
		
		//Récup list view
		mListViewTest = (ListView)findViewById(R.id.lvInfoUser);
		
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;
		
		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Weight");
        map.put("txtNowInfo", "78kg");
        map.put("txtIdealInfo", "75kg");
        listItem.add(map);

		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Waist");
        map.put("txtNowInfo", "80cm");
        map.put("txtIdealInfo", "76cm");
        listItem.add(map);
        
		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Chest");
        map.put("txtNowInfo", "114cm");
        map.put("txtIdealInfo", "120cm");
        listItem.add(map);

		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Arms");
        map.put("txtNowInfo", "45cm");
        map.put("txtIdealInfo", "50cm");
        listItem.add(map);

		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Forearms");
        map.put("txtNowInfo", "45cm");
        map.put("txtIdealInfo", "50cm");
        listItem.add(map);

		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Shoulders");
        map.put("txtNowInfo", "45cm");
        map.put("txtIdealInfo", "50cm");
        listItem.add(map);

		map = new HashMap<String, String>();
        map.put("txtNameInfo", "Hips");
        map.put("txtNowInfo", "45cm");
        map.put("txtIdealInfo", "50cm");
        listItem.add(map);
        
        AlternateListAdapter mSimpleAdapter = new AlternateListAdapter(this.getBaseContext(), listItem, R.layout.liste_profil, 
        		new String[] {"txtNameInfo", "txtNowInfo", "txtIdealInfo"}, 
        		new int[]{R.id.txtNameInfo,R.id.txtNowInfo,R.id.txtIdealInfo});
        
        mListViewTest.setAdapter(mSimpleAdapter);
	}
    
	OnClickListener buttonListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = null;
				//button home
				if(v == _btnHome){
					i = new Intent(ProfilActivity.this, MenuActivity.class);
				}
				//button activities
				if(v == _btnActivities){
					//i = new Intent(ProfilActivity.this, MenuActivity.class);
				}
				//button routines
				if(v == _btnRoutine){
					i = new Intent(ProfilActivity.this, RoutineListActivity.class);
				}
				//button exercices
				if(v == _btnExercices){
					i = new Intent(ProfilActivity.this, ExercicesActivity.class);
				}
				
				//intent not null, start activity
				if(i != null){				
					startActivity(i);
					finish();
				}
				
			}
		};
    
}