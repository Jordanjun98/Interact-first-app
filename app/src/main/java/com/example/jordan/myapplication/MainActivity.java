package com.example.jordan.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;

    private Button startAdvButton;

    private ImageView mainTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        startAdvButton = findViewById(R.id.startAdvButton);

        mainTitle = findViewById(R.id.mainTitle);


        startAdvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Execution
                String name = nameEditText.getText().toString();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, StoryActivity.class);
                i.putExtra(getResources().getString(R.string.key),name);
                startActivity(i);


            }
        });

        mainTitle = findViewById(R.id.mainTitle);
        mainTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard(v);

            }
        });

    }

    private void hideKeyboard(View v){
        v = getCurrentFocus();
        if (v != null){
            InputMethodManager imn = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imn.hideSoftInputFromWindow(v.getWindowToken(),0);
        }

    }
}
