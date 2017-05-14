package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Toppings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button button1 = (Button) findViewById(R.id.Lettuce);
        button1.setText("Lettuce (0 Cal.)");

        Button button2 = (Button) findViewById(R.id.Tomatoes);
        button2.setText("Tomatoes (5 Cal.)");

        Button button3 = (Button) findViewById(R.id.Pickels);
        button3.setText("Pickles (7 Cal.)");

        Button button4 = (Button) findViewById(R.id.Onion);
        button4.setText("Onion (11 Cal.)");

        Button button5 = (Button) findViewById(R.id.GreenPepper);
        button5.setText("Green Pepper (6 Cal.)");


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Toppings.this, Dressings.class);
        intent.putExtra("Toppings", ((Button) v).getText());
        intent.putExtra("Cheese", getIntent().getStringExtra("Cheese"));
        intent.putExtra("choiceWrap", getIntent().getStringExtra("choiceWrap"));
        intent.putExtra("protein", getIntent().getStringExtra("protein"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
