package fr.guimsbeber.buddyfit.adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import fr.guimsbeber.buddyfit.GetStartedActivity;
import fr.guimsbeber.buddyfit.R;

public class ExerciceDetailsListAdapter extends BaseAdapter{

	private List<HashMap<String, String>> mListe;
	private LayoutInflater mInflater;
	private Context mCtx;
	private HashMap<String, String> mHashMap;
	
	public ExerciceDetailsListAdapter(Context ctx,List<HashMap<String, String>> liste){
		this.mCtx=ctx;
		this.mListe = liste;
		this.mInflater = LayoutInflater.from(this.mCtx);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.mListe.size();
	}

	@Override
	public HashMap<String, String> getItem(int pos) {
		// TODO Auto-generated method stub
		return this.mListe.get(pos);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		RelativeLayout layoutItem;
		
		if (convertView == null) {
			layoutItem = (RelativeLayout) this.mInflater.inflate(R.layout.list_exercice, parent, false);
		} else {
			layoutItem = (RelativeLayout) convertView;
		}
		
		this.mHashMap = this.mListe.get(pos);
		
		ImageButton changeValue = (ImageButton)layoutItem.findViewById(R.id.ImgBtnChange);
		
		changeValue.setOnClickListener(this.changeValueDialog);
		
		
		return null;
	}
	
	/**
	 * Permet de définir un evenement sur le clique du bouton de la liste
	 */
	private OnClickListener changeValueDialog = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(mHashMap.get("info").equals(mCtx.getString(R.string.infReps))){
				//je suis dans le cas d'une répétition
			}
			else if(mHashMap.get("info").equals(mCtx.getString(R.string.infWeight))){
				//je suis dans le cas d'un poids
			} 
			else if(mHashMap.get("info").equals(mCtx.getString(R.string.infRestTime))){
				//je suis dans le cas d'une pause
			} 
		}
	};

}
