package com.example.chaitanya.chaitanyart;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class ChaitanyaSeek extends AppCompatActivity {

    SeekBar seekRed, seekGreen, seekBlue;
    private int seekR, seekG, seekB;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);

        textView = (TextView) findViewById(R.id.text_fragment);
        seekRed = (SeekBar) findViewById(R.id.SeekBarR);
        seekGreen = (SeekBar) findViewById(R.id.SeekBarG);
        seekBlue = (SeekBar) findViewById(R.id.SeekBarB);

        seekRed.setOnSeekBarChangeListener(seekBarChangeListener);
        seekGreen.setOnSeekBarChangeListener(seekBarChangeListener);
        seekBlue.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            switch (seekBar.getId()) {
                case R.id.SeekBarR:
                    seekR = progress;
                    break;
                case R.id.SeekBarG:
                    seekG = progress;
                    break;
                case R.id.SeekBarB:
                    seekB = progress;
                    break;
            }
            doSomethingWithColor();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void doSomethingWithColor() {
        int color = Color.rgb(seekR, seekG, seekB);
        textView.setTextColor(color);

    }
}
