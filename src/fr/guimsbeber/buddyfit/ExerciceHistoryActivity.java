package fr.guimsbeber.buddyfit;

import java.util.ArrayList;
import java.util.HashMap;

import fr.guimsbeber.buddyfit.adapter.AlternateListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class ExerciceHistoryActivity extends Activity {
	private ListView mListViewTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercice_history);
		
		//Récup list view
		mListViewTest = (ListView) findViewById(R.id.lvToday);

		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map;

		map = new HashMap<String, String>();
		map.put("inf", "Sets01");
		map.put("value", "10x12kg");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("inf", "Sets02");
		map.put("value", "10x12kg");
		listItem.add(map);

		map = new HashMap<String, String>();
		map.put("inf", "Sets02");
		map.put("value", "10x12kg");
		listItem.add(map);
		
		AlternateListAdapter mSimpleAdapter = new AlternateListAdapter(this.getBaseContext(), listItem, R.layout.liste_exercice_history, 
        		new String[] {"inf", "value"}, 
        		new int[]{R.id.txtTitleInfo,R.id.txtResumeInfo});

        mListViewTest.setAdapter(mSimpleAdapter);
        
      //Récup list view
  		mListViewTest = (ListView) findViewById(R.id.lvLastSession);

  		listItem = new ArrayList<HashMap<String, String>>();

  		map = new HashMap<String, String>();
  		map.put("inf", "Sets01");
  		map.put("value", "10x12kg");
  		listItem.add(map);

  		map = new HashMap<String, String>();
  		map.put("inf", "Sets02");
  		map.put("value", "10x12kg");
  		listItem.add(map);

  		map = new HashMap<String, String>();
  		map.put("inf", "Sets02");
  		map.put("value", "10x12kg");
  		listItem.add(map);
  		
  		mSimpleAdapter = new AlternateListAdapter(this.getBaseContext(), listItem, R.layout.liste_exercice_history, 
          		new String[] {"inf", "value"}, 
          		new int[]{R.id.txtTitleInfo,R.id.txtResumeInfo});

          mListViewTest.setAdapter(mSimpleAdapter);

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
}
