package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Cheese extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheese);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.American);
        button1.setText("American Cheese (105 Cal.)");

        Button button2 = (Button) findViewById(R.id.Provolone);
        button2.setText("Provolone Cheese (98 Cal.)");

        Button button3 = (Button) findViewById(R.id.PepperJack);
        button3.setText("Pepper Jack Cheese (80 Cal.)");

        Button button4 = (Button) findViewById(R.id.Swiss);
        button4.setText("Swiss Cheese (106 Cal.)");

        Button button5 = (Button) findViewById(R.id.Cheddar);
        button5.setText("Cheddar Cheese (113 Cal.)");


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Cheese.this, Toppings.class);
        intent.putExtra("Cheese", ((Button)v).getText());
        intent.putExtra("choiceWrap", getIntent().getStringExtra("choiceWrap"));
        intent.putExtra("protein", getIntent().getStringExtra("protein"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
