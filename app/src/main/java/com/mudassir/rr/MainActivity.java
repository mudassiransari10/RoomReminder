package com.mudassir.rr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView welcome;
    EditText user;
    ImageView imageView;
    Button button;
    private static String users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText user = (EditText)findViewById(R.id.username);
        TextView welcome = (TextView) findViewById(R.id.welcomeText);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Button button = (Button)findViewById(R.id.btnConfirm);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("com.mudassir.rr", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref.edit();
                ed.putString("users", user.getText().toString());
                ed.apply();

                Intent intent = new Intent(MainActivity.this, howToUse.class);
                startActivity(intent);
//                if(pref.getBoolean("activity_executed", false)){
//                    Intent intent = new Intent(this, howToUse.class);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    SharedPreferences.Editor ed = pref.edit();
//                    ed.putBoolean("activity_executed", true);
//                    ed.commit();
//                }
            }
        });

    }
}