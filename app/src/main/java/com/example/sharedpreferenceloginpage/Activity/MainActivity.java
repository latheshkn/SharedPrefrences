package com.example.sharedpreferenceloginpage.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sharedpreferenceloginpage.R;

public class MainActivity extends AppCompatActivity {
    EditText editTextname, editTextpassd;
    Button save, retrieve, clear;

    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextname = findViewById(R.id.editname);
        editTextpassd = findViewById(R.id.editpass);
        show = findViewById(R.id.txtshow);

        save = findViewById(R.id.save);
        clear = findViewById(R.id.clear);
        retrieve = findViewById(R.id.Retrieve);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = editTextname.getText().toString();
                String password = editTextpassd.getText().toString();


                //now create SharedPrefrence
                SharedPreferences preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("NAME", name);
                editor.putString("PASSWORD", password);
                editor.commit();


                if (preferences.getString("NAME", "abc").length() > 0 && preferences.getString("PASSWORD", "xyz").length() > 0) {

                    Toast.makeText(MainActivity.this, "Registration Sucessful", Toast.LENGTH_SHORT).show();
                }
//
////                else if(preferences.getString("PASSWORD", "xyz").length() > 0){
////
////                    Toast.makeText(MainActivity.this, "Registration Sucessful", Toast.LENGTH_SHORT).show();
////                }
//
                else {
                    Toast.makeText(MainActivity.this, "enter the data", Toast.LENGTH_SHORT).show();
                }
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editTextname.setText("");
                editTextpassd.setText("");

                Toast.makeText(MainActivity.this, "data cleared", Toast.LENGTH_SHORT).show();

            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);

                // adding below prefrence inside show.setText
//              //  preferences.getString("NAME","abc");
//               //preferences.getString("PASSWORD","xyz");

//
                show.setText(preferences.getString("NAME", "abc") + " " + preferences.getString("PASSWORD", "xyz"));


            }
        });

    }

}