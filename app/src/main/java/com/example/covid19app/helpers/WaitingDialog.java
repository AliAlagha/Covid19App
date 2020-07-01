package com.example.covid19app.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.covid19app.R;

public class WaitingDialog {

    private AlertDialog alertDialog;

    public WaitingDialog(Activity activity) {

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.waiting_dialog_layout, null);
        builder.setView(view);
        builder.setCancelable(false);
        alertDialog = builder.create();

    }

    public void showWaitingDialog() {
        alertDialog.show();
    }

    public void hideWaitingDialog() {
        alertDialog.dismiss();
    }

}
