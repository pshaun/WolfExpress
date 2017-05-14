package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceWrap extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_wrap);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.Spinach);
        button1.setText("Spinach (310 Cal.)");

        Button button2 = (Button) findViewById(R.id.Tomato);
        button2.setText("Tomato (310 Cal.)");

        Button button3 = (Button) findViewById(R.id.Wheat);
        button3.setText("Wheat (310 Cal.)");

        Button button4 = (Button) findViewById(R.id.Plain);
        button4.setText("Plain (320 Cal.)");

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(ChoiceWrap.this, Cheese.class);
        intent.putExtra("choiceWrap", ((Button)v).getText());
        intent.putExtra("protein", getIntent().getStringExtra("protein"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
