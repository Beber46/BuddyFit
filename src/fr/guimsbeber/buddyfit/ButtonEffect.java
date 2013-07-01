package fr.guimsbeber.buddyfit;

import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Cette class permet de définir un effet lorsque le bouton est préssé
 * @author Bertrand
 *
 */
public class ButtonEffect {
	private static final int _RED = 0xe0CE2C29;
	private static final int _GREY =0xe0E7E7E7;
	
	
	public static void assignRed(Button monBouton){
		monBouton.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    v.getBackground().setColorFilter(_RED, PorterDuff.Mode.SRC_IN);
                    v.invalidate();
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.getBackground().clearColorFilter();
                    v.invalidate();
                    break;
                }
            }
			return false;
		}});
	}
	
	public static void assignGrey(Button monBouton){
		monBouton.setOnTouchListener(new OnTouchListener(){
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    v.getBackground().setColorFilter(_GREY, PorterDuff.Mode.SRC_IN);
                    v.invalidate();
                    break;
                }
                case MotionEvent.ACTION_UP: {
                    v.getBackground().clearColorFilter();
                    v.invalidate();
                    break;
                }
            }
			return false;
		}});
	}
	
}
