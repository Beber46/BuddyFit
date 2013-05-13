package fr.guimsbeber.buddyfit;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class HomeActivity extends Activity {
	
	private HorizontalScrollView _horizontalScrollView;
	private ImageView _ivBarrePoints;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
