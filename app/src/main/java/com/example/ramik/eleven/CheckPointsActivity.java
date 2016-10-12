package com.example.ramik.eleven;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RamiK on 7/31/2016.
 */
public class CheckPointsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkpoints);

        Integer[] levels = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        List<Integer> checkPointLevels = new ArrayList<>(Arrays.asList(levels));

        GridView gridView = (GridView)findViewById(R.id.gridview);
        CheckPointsAdapter checkPointsAdapter = new CheckPointsAdapter(this, checkPointLevels);
        gridView.setAdapter(checkPointsAdapter);
    }
}
