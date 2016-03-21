package fr.univ_lille1.iuta.place.palette;

import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by bulteela on 21/03/16.
 */
public class Primary {

    SeekBar bar;
    TextView text;
    public Primary(final SeekBar bar, final TextView text){
        this.bar = bar;
        this.text=text;
        text.setText("128");
        bar.setMax(255);
        bar.setProgress(128);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                text.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public int getValue(){
        return bar.getProgress();
    }

}
