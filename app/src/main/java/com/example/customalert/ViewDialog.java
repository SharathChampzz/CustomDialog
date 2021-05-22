package com.example.customalert;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class ViewDialog {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    EditText type;

    public void showDialog(Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.welcome);

        ImageView pp1,pp2,pp3,pp4,pp5,pp6;

        pp1 = (ImageView) dialog.findViewById(R.id.p1);
        pp2 = (ImageView) dialog.findViewById(R.id.p2);
        pp3 = (ImageView) dialog.findViewById(R.id.p3);
        pp4 = (ImageView) dialog.findViewById(R.id.p4);
        pp5 = (ImageView) dialog.findViewById(R.id.p5);
        pp6 = (ImageView) dialog.findViewById(R.id.p6);

        type = dialog.findViewById(R.id.entername);

        pp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().toString().equals("")){
                    Toast.makeText(activity, "Please Enter User name", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(activity, type, "1");
                    dialog.dismiss();
                }
            }
        });
        pp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().toString().equals("")){
                    Toast.makeText(activity, "Please Enter User name", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(activity, type, "2");
                    dialog.dismiss();
                }
            }
        });
        pp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().toString().equals("")){
                    Toast.makeText(activity, "Please Enter User name", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(activity, type, "3");
                    dialog.dismiss();
                }
            }
        });
        pp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().toString().equals("")){
                    Toast.makeText(activity, "Please Enter User name", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(activity, type, "4");
                    dialog.dismiss();
                }
            }
        });
        pp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().toString().equals("")){
                    Toast.makeText(activity, "Please Enter User name", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(activity, type, "5");
                    dialog.dismiss();
                }
            }
        });
        pp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.getText().toString().equals("")){
                    Toast.makeText(activity, "Please Enter User name", Toast.LENGTH_SHORT).show();
                }
                else{
                    saveData(activity, type, "6");
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    public static void saveData(Context context, EditText type, String pplno) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, type.getText().toString() + "," + pplno);
        editor.apply();
        Toast.makeText(context, "Data saved!  Please Refresh to see updated result!!", Toast.LENGTH_SHORT).show();
    }


}
