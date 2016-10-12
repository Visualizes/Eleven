package com.example.ramik.eleven;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * Created by Rami on 2/23/2016.
 */
public class LoserDisplay {
    public LoserDisplay(final Context context, final Class currentClass){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("You suck.");

        alertDialogBuilder.setMessage("Please get good. Try again?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                context.startActivity(new Intent(context, currentClass));
                ((Activity)context).finish();
            }
        });
        alertDialogBuilder.setNeutralButton("Checkpoint", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                context.startActivity(new Intent(context, HomeActivity.class));
                ((Activity)context).finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
