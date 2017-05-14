package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GrillToppings extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grill_toppings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.LettuceG);
        button1.setText("Lettuce (0 Cal.)");

        Button button2 = (Button) findViewById(R.id.Tomatoes3);
        button2.setText("Tomatoes (5 Cal.)");

        Button button3 = (Button) findViewById(R.id.Pickles2);
        button3.setText("Pickles (7 Cal.)");

        Button button4 = (Button) findViewById(R.id.Onions2);
        button4.setText("Onions (11 Cal.)");

        Button button5 = (Button) findViewById(R.id.CM2);
        button5.setText("Chipotle Mayo (110 Cal.)");


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(GrillToppings.this, Orderlist.class);
        intent.putExtra("Grill Toppings", ((Button) v).getText());
        intent.putExtra("Grill Cheese", getIntent().getStringExtra("Grill Cheese"));
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
