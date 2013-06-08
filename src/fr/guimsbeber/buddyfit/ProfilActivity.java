package fr.guimsbeber.buddyfit;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class ProfilActivity extends Activity {
	private ListView mListViewTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil);
		
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
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