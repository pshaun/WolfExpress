package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Protein extends AppCompatActivity implements View.OnClickListener {

    double price = 0.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.EggSalad);
        button1.setText("Egg Salad - $5.89  (140 Cal.)");
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.ChickenSalad);
        button2.setText("Chicken Salad - $5.89  (110 Cal.)");

        Button button3 = (Button) findViewById(R.id.TunaSalad);
        button3.setText("Tuna Salad - $5.89  (110 Cal.)");

        Button button4 = (Button) findViewById(R.id.CripsyChicken);
        button4.setText("Crispy Chicken - $6.19  (240 Cal.)");

        Button button5 = (Button) findViewById(R.id.RoastedChicken);
        button5.setText("Roasted Chicken - $6.19  (80 Cal.)");

        Button button6 = (Button) findViewById(R.id.GrillVeggies);
        button6.setText("Grilled Veggies - $5.89  (35 Cal.)");

        Button button7 = (Button) findViewById(R.id.Ham);
        button7.setText("Ham - $6.99  (70 Cal.)");

        Button button8 = (Button) findViewById(R.id.RoastBeef);
        button8.setText("Roast Beef - $6.99  (100 Cal.)");

        Button button9 = (Button) findViewById(R.id.Salami);
        button9.setText("Salami - $6.99  (140 Cal.)");


        button2.setOnClickListener(this);

        button3.setOnClickListener(this);

        button4.setOnClickListener(this);

        button5.setOnClickListener(this);

        button6.setOnClickListener(this);

        button7.setOnClickListener(this);

        button8.setOnClickListener(this);

        button9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Protein.this, ChoiceWrap.class);
        intent.putExtra("protein", ((Button)v).getText());
        intent.putExtra("type", getIntent().getStringExtra("type"));


        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}


