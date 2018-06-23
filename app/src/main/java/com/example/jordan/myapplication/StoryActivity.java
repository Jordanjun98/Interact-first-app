package com.example.jordan.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {


    private Mars mars;

    private String name;

    private ImageView headerimageview;

    private TextView storytextview;

    private Button btn1;

    private Button btn2;

    private Stack<Integer> pageStack = new Stack<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        headerimageview = findViewById(R.id. headerimageview);
        storytextview = findViewById(R.id.storytextview );
        btn1 = findViewById(R.id.choice2btn);
        btn2 = findViewById(R.id.choice1btn);


        Intent i = getIntent();
        name = i.getStringExtra(getResources().getString(R.string.key));


        if(name == null || name.isEmpty()){
            name = "friend";
        }

        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();

         mars = new Mars();
        loadPage(0);

    }
    private void loadPage(int pageNumber){

        pageStack.push(pageNumber);

        final Page page = mars.getPage(pageNumber);

        Drawable drawable = getResources().getDrawable(page.getImageId());
        headerimageview.setImageDrawable(drawable);

        storytextview.setText(String.format(getString(page.getTextId()),name));

        if(page.isFInalPage()){
            btn2.setText("PLay again");
            btn2.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View v){
                     loadPage(0);
                     
                }
            });
            btn1.setVisibility(View.INVISIBLE);
        }else{
            btn1.setVisibility(View.VISIBLE);
            btn1.setText(page.getChoice1().getButtonId());
            btn2.setText(page.getChoice2().getButtonId());


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(page.getChoice1().getPageNumber());

                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(page.getChoice2().getPageNumber());
                }
            });
        }

    }
    @Override
    public void onBackPressed(){
        pageStack.pop();

        if (pageStack.isEmpty()){
            super.onBackPressed();
        }else{
            loadPage(pageStack.pop());
        }
    }
}
