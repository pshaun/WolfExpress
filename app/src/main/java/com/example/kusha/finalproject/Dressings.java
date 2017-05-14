package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Dressings extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dressings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button button1 = (Button) findViewById(R.id.ChipotleMayo);
        button1.setText("Chipotle Mayo (110 Cal.)");

        Button button2 = (Button) findViewById(R.id.Mayonnaise);
        button2.setText("Mayonnaise (100 Cal.)");

        Button button3 = (Button) findViewById(R.id.DeliMustard);
        button3.setText("Deli Mustard (70 Cal.)");

        Button button4 = (Button) findViewById(R.id.DijonMustard);
        button4.setText("Dijon Mustard (90 Cal.)");

        Button button5 = (Button) findViewById(R.id.OildAndVinegar);
        button5.setText("Oil and Vinegar (80 Cal.)");

        Button button6 = (Button) findViewById(R.id.PestoMayo);
        button6.setText("Pesto Mayo (100 Cal.)");

        Button button7 = (Button) findViewById(R.id.RussianDressing);
        button7.setText("Russian Dressing (100 Cal.)");

        Button button8 = (Button) findViewById(R.id.HoneyMustard);
        button8.setText("Honey Mustard (150 Cal.)");


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Dressings.this, toastwrap.class);
        intent.putExtra("Dressings", ((Button) v).getText());
        intent.putExtra("Toppings", getIntent().getStringExtra("Toppings"));
        intent.putExtra("Cheese", getIntent().getStringExtra("Cheese"));
        intent.putExtra("choiceWrap", getIntent().getStringExtra("choiceWrap"));
        intent.putExtra("protein", getIntent().getStringExtra("protein"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
