package rcpl.com.brightnesschange;

import android.content.ContentResolver;
import android.content.Context;
import android.media.audiofx.BassBoost;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar sb;
    int brightness;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=(SeekBar)findViewById(R.id.seekBar);
        c=getApplicationContext();
        sb.setMax(255);
        //Getting Current screen brightness.
        brightness = Settings.System.getInt(c.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,0);
        //Setting up current screen brightness to seekbar;
        sb.setProgress(brightness);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Changing Brightness on seekbar movement
                Settings.System.putInt(c.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
