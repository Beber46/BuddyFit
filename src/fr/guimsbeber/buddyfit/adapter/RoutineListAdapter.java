package fr.guimsbeber.buddyfit.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr.guimsbeber.buddyfit.R;
import fr.guimsbeber.buddyfit.objet.Routine;

public class RoutineListAdapter extends BaseAdapter  {
	
	private ArrayList<Routine> _routines;
	private LayoutInflater _inflater;
	
	
	public RoutineListAdapter(Context context, ArrayList<Routine> routines) {
		super();
		_routines = routines;
		_inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return _routines.size();
	}

	@Override
	public Object getItem(int position) {
		return _routines.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		RelativeLayout layoutItem;

		if (convertView == null) {
			layoutItem = (RelativeLayout) _inflater.inflate(R.layout.liste_routine, parent, false);
		} else {
			layoutItem = (RelativeLayout) convertView;
		}
	  
		TextView tvName = (TextView)layoutItem.findViewById(R.id.tvRoutineNameList);
		TextView tvDescrip = (TextView)layoutItem.findViewById(R.id.tvRoutineDescription);
	           
		tvName.setText(_routines.get(position).getName());
		tvDescrip.setText(_routines.get(position).getDescription());

	  return layoutItem;
	}


}
