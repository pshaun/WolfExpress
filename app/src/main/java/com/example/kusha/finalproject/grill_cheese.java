package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Prashant on 4/21/17.
 */

public class grill_cheese extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grill_cheese);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.GAmerican);
        button1.setText("American Cheese (105 Cal.)");

        Button button2 = (Button) findViewById(R.id.GProvolone);
        button2.setText("Provolone Cheese (106 Cal.)");

        Button button3 = (Button) findViewById(R.id.GPepperJack);
        button3.setText("Pepper Jack Cheese (80 Cal.)");

        Button button4 = (Button) findViewById(R.id.GSwiss);
        button4.setText("Swiss Cheese (106 Cal.)");

        Button button5 = (Button) findViewById(R.id.GCheddar);
        button5.setText("Cheddar Cheese (113 Cal.)");


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(grill_cheese.this, GrillToppings.class);
        intent.putExtra("Grill Cheese", ((Button) v).getText());
        intent.putExtra("Buns", getIntent().getStringExtra("Buns"));
        if (getIntent().hasExtra("Sandwich"))
            intent.putExtra("Sandwich", getIntent().getStringExtra("Sandwich"));
        else
            intent.putExtra("Burger", getIntent().getStringExtra("Burger"));

        intent.putExtra("Grill", getIntent().getStringExtra("Grill"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}


