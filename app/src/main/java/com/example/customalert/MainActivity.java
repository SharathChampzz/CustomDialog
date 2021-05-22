package com.example.customalert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    ImageView refreshButton;
    TextView name;
    ImageView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.result);
        refreshButton = findViewById(R.id.refresh);
        profile = findViewById(R.id.profile);

        String data = loadData();
        if(loadData().equals("")){  // Fresh User
            //alert = findViewById(R.id.openWindow);
            Toast.makeText(this, "No Previous Login session Found!", Toast.LENGTH_SHORT).show();
            ViewDialog alert = new ViewDialog();
            alert.showDialog(getActivity(), "If You want to pass message to dialog");
        }
        else{  // Old User
            refreshButton.setVisibility(View.GONE);
            String[] res = data.split("[,]", 0);
            name.setText(res[0]);
            String num = res[1];

            //Toast.makeText(this, "Previous Data : " + res[0] + ":" + num, Toast.LENGTH_SHORT).show();
            switch (num) {
                case "1":
                    profile.setImageResource(R.drawable.p1);
                    break;
                case "2":
                    profile.setImageResource(R.drawable.p2);
                    break;
                case "3":
                    profile.setImageResource(R.drawable.p3);
                    break;
                case "4":
                    profile.setImageResource(R.drawable.p4);
                    break;
                case "5":
                    profile.setImageResource(R.drawable.p5);
                    break;
                case "6":
                    profile.setImageResource(R.drawable.p6);
                    break;
                default:
                    Toast.makeText(this, "Uncaught Exception!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
        
        refreshButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });


    }

    private Activity getActivity() {
        return this;
    }

    public String loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        return sharedPreferences.getString(TEXT, "");
    }
}