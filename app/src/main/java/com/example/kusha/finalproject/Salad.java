package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Salad extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.SmallSalad);
        button1.setText("Small Salad - $4.09");

        Button button2 = (Button) findViewById(R.id.LargeSalad);
        button2.setText("Large Salad - $5.79");

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Salad.this, Greens.class);
        intent.putExtra("Salad size", ((Button)v).getText());
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
