package com.example.ramik.eleven;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;

/**
 * Created by RamiK on 7/31/2016.
 */
public class CheckPointsAdapter extends ArrayAdapter<Integer> {

    List<Integer> items;

    public CheckPointsAdapter(Context context, List<Integer> items){
        super(context, 0, items);
        this.items = items;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_checkpoint, parent, false);
        }
        Button checkPointButton = (Button)convertView.findViewById(R.id.checkpoint);
        checkPointButton.setText(String.valueOf(items.get(position)));
        checkPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), StartingLevelsActivity.class);
                i.putExtra("checkpoint", (int)(items.get(position)-1));
                ((Activity)getContext()).startActivity(i);
            }
        });


        return convertView;
    }
}
