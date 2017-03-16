package com.example.osamakhalid.ihs;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Signals extends AppCompatActivity {
    ImageView redlight,greenlight,yellowlight;
    TextView redtimer,greentimer,yellowtimer;
    int valuez,valuex,valuey;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signals);
        Bundle bundle = getIntent().getExtras();
        greentimer=(TextView) findViewById(R.id.green_timer);
        redtimer=(TextView) findViewById(R.id.red_timer);
        yellowtimer=(TextView) findViewById(R.id.yellow_timer);

         valuex =Integer.parseInt( bundle.getString("x"));
         valuey =Integer.parseInt( bundle.getString("y"));
         valuez =Integer.parseInt( bundle.getString("z"));
         redCount(valuez);


    }
    public void greenCount(int v){
        new CountDownTimer(v+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                greentimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                ++count;
               greentimer.setText("0");
               yellowCount(valuey);
            }
        }.start();

    }
    public void redCount(int v){
        new CountDownTimer(v+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                redtimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                redtimer.setText("0");
               yellowCount(valuey);
            }
        }.start();

    }
    public void yellowCount(int v){
        new CountDownTimer(v+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                yellowtimer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                if(count==1){
                    count=0;
                    yellowtimer.setText("0");
                    redCount(valuez);
                }
                else{
                yellowtimer.setText("0");
                greenCount(valuex); }
            }
        }.start();

    }

}
