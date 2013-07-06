package fr.guimsbeber.buddyfit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListExerciceActivity extends Activity {
	private ListView mListViewForOneCategory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_exercice);

		int value = 0;
		TextView txtVListForCategory = (TextView)findViewById(R.id.txtVListForCategory);
		Bundle extras = getIntent().getExtras();
		
		//Récupération du sessionID
		if (extras != null) {
		    value = extras.getInt("key_mysession");
		}
		
		if(value != 0){
			if(value==1){
				txtVListForCategory.setText(R.string.tlttriceps);
			}
			else if(value==2){
				txtVListForCategory.setText(R.string.tltchest);
			}
			else if(value==3){
				txtVListForCategory.setText(R.string.tltbiceps);
			}
			else if(value==4){
				txtVListForCategory.setText(R.string.tltback);
			}
			else if(value==5){
				txtVListForCategory.setText(R.string.tltglutes);
			}
			else if(value==6){
				txtVListForCategory.setText(R.string.tltlowerleg);
			}
			else if(value==7){
				txtVListForCategory.setText(R.string.tltupperleg);
			}
			else if(value==8){
				txtVListForCategory.setText(R.string.tltAbs);
			}
			else if(value==9){
				txtVListForCategory.setText(R.string.tltcardio);
			}
			else if(value==10){
				txtVListForCategory.setText(R.string.tltforearm);
			}
			else if(value==11){
				txtVListForCategory.setText(R.string.tltshoulder);
			}
			else if(value==12){
				txtVListForCategory.setText(R.string.tltshowall);
			}
		}
		
		Button btnAddExercice = (Button)findViewById(R.id.btnAddExercice);
		
		btnAddExercice.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent mIntent = new Intent(v.getContext(), AddExerciceActivity.class);
				startActivity(mIntent);
			}
		});
		
		//Récup list view
		mListViewForOneCategory = (ListView) findViewById(R.id.lvListForCategory);
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
