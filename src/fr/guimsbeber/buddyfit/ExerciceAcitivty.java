package fr.guimsbeber.buddyfit;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ExerciceAcitivty extends Activity {
	private ListView mListViewTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercice);
		
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
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	@Override
    protected void onStart() {
        super.onStart();
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
