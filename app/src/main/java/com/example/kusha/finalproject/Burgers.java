package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Burgers extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burgers);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.FreshBeefBurger);
        button1.setText("Fresh Beef Burger - $3.69 (230 Cal.)");

        Button button2 = (Button) findViewById(R.id.DoubleBurger);
        button2.setText("Double Burger - $6.19 (730 Cal.)");

        Button button3 = (Button) findViewById(R.id.TurkeyBurger);
        button3.setText("Turkey Burger - $3.79 (310 Cal.)");

        Button button4 = (Button) findViewById(R.id.GVBurger);
        button4.setText("Garden Vegetable Burger - $3.79 (310 Cal.)");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Burgers.this, Buns.class);
        intent.putExtra("Burger", ((Button) v).getText());
        intent.putExtra("Grill", getIntent().getStringExtra("Grill"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
