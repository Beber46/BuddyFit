package fr.guimsbeber.buddyfit.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import fr.guimsbeber.buddyfit.R;
import fr.guimsbeber.buddyfit.RoutineActivity;
import fr.guimsbeber.buddyfit.objet.Routine;

public class RoutineListAdapter extends BaseAdapter  {
	
	private ArrayList<Routine> _routines;
	private LayoutInflater _inflater;
	private Context _context;
	
	
	public RoutineListAdapter(Context context, ArrayList<Routine> routines) {
		super();
		_routines 	= routines;
		_context 	= context;
		_inflater 	= LayoutInflater.from(context);
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
		Button btnFlech = (Button) layoutItem.findViewById(R.id.btnRoutineView);
	           
		tvName.setText(_routines.get(position).getName());
		tvDescrip.setText(_routines.get(position).getDescription());
		btnFlech.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(_context, RoutineActivity.class);
				_context.startActivity(i);				
			}
		});

	  return layoutItem;
	}


}
