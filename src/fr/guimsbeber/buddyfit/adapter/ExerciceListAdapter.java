package fr.guimsbeber.buddyfit.adapter;

import java.util.List;

import fr.guimsbeber.buddyfit.ButtonEffect;
import fr.guimsbeber.buddyfit.OPExerciceActivity;
import fr.guimsbeber.buddyfit.R;
import fr.guimsbeber.buddyfit.objet.Exercice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ExerciceListAdapter extends BaseAdapter{

	private List<Exercice> mListeExercice;
	private LayoutInflater mInflater;
	private Context mCtx;
	private Exercice mExercice;
	
	public ExerciceListAdapter(Context context, List<Exercice> exercices){
		this.mListeExercice = exercices;
		this.mCtx = context;
		this.mInflater = LayoutInflater.from(this.mCtx);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.mListeExercice.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return this.mListeExercice.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return this.mListeExercice.get(pos).getId();
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		RelativeLayout layoutItem;
		
		if (convertView == null) {
			layoutItem = (RelativeLayout) this.mInflater.inflate(R.layout.liste_exercicebycategory, parent, false);
		} else {
			layoutItem = (RelativeLayout) convertView;
		}
		mExercice = this.mListeExercice.get(pos);
		((TextView)layoutItem.findViewById(R.id.txtVExerciceName)).setText(mExercice.getName());
		Button btnEditExe = (Button)layoutItem.findViewById(R.id.btnEditExercice);
		ButtonEffect.assignGrey(btnEditExe);
		btnEditExe.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mIntent = new Intent(v.getContext(), OPExerciceActivity.class);
				mIntent.putExtra("mExerciceID",mExercice.getId());
				mCtx.startActivity(mIntent);
			}
		});
		
		return layoutItem;
	}

}
