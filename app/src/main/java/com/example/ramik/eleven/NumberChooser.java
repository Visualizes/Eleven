package com.example.ramik.eleven;

import android.os.Handler;
import android.widget.Button;

/**
 * Created by Rami on 2/28/2016.
 */
public class NumberChooser {

    private boolean userHasStopped = false;
    private DelayProvider delayProvider;
    private Handler handler;
    private Runnable runnable;

    public NumberChooser(DelayProvider delayProvider, final NumberProvider numberProvider, final Button mElevenButton){
        this.delayProvider = delayProvider;

        System.out.println(delayProvider.getNextDelay());

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (!userHasStopped) {
                    mElevenButton.setText(String.valueOf(numberProvider.getNextNumber()));
                    start();
                }
            }
        };
    }

    public void start(){
        handler.postDelayed(runnable, delayProvider.getNextDelay());
    }

    public void stop(){
        userHasStopped = true;
        handler.removeCallbacks(runnable);
    }

    public int getDelay(){
        return delayProvider.getNextDelay();
    }
}
