package com.example.ramik.eleven;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StartingLevelsActivity extends AppCompatActivity {

    private int level = 0;
    String[] messages = { "test", "test", "test", "test", "test"};
    private TextView mTitle;
    private TextView mMessage;
    private  List<NumberChooser> engines;
    private Button mElevenButton;
    private int lossCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startinglevels);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            level = extras.getInt("checkpoint");
        }

        mElevenButton = (Button) findViewById(R.id.textView);

        final TinyDB tinyDB = new TinyDB(this);
        lossCount = tinyDB.getInt("lossCount");

        TextView lossCounter = (TextView)findViewById(R.id.losscount);
        System.out.println(lossCount);
        lossCounter.setTextColor(Color.RED);
        lossCounter.setText(String.valueOf(lossCount));

        EngineDatabase engineDatabase = new EngineDatabase(mElevenButton);

        setActionBarTitle();

        engines = engineDatabase.getEngines();
        for (int i = 0; i < engines.size(); i++){
            System.out.println(engines.get(i).getDelay());
        }

        engines.get(level).start();

  //      mTitle = (TextView) findViewById(R.id.title);
        //mMessage = (TextView) findViewById(R.id.message);
//        mTitle.setText(titles[level]);
        //mMessage.setText(messages[level]);

        mElevenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                engines.get(level).stop();
                if (mElevenButton.getText().toString().equals("11")) {
                    mElevenButton.setTextColor(Color.GREEN);
                    startNewLevel();
                    //startActivity(new Intent(StartingLevelsActivity.this, MultipleActivity.class));
                } else {
                    mElevenButton.setTextColor(Color.RED);
                    tinyDB.putInt("lossCount", tinyDB.getInt("lossCount")+1);
                    new LoserDisplay(StartingLevelsActivity.this, StartingLevelsActivity.class);
                }
            }
        });

        mElevenButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                engines.get(level).stop();
                startNewLevel();
                return true;
            }
        });
    }

    private void setActionBarTitle(){
        getSupportActionBar().setTitle("Level " + (level + 1));
        getSupportActionBar().setSubtitle("Eleven");
    }

    private void startNewLevel(){
        if (level != engines.size()-1) {
            level++;
        }
        else{
            level = 0;
        }
        setActionBarTitle();
        mElevenButton.setTextColor(Color.WHITE);
        mElevenButton.setText("0");
        engines.get(level).start();

    }

    @Override
    public void onBackPressed(){
        engines.get(level).stop();
        finish();
    }
}
