package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Greens extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greens);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.Romaine);
        button1.setText("Romaine");

        Button button2 = (Button) findViewById(R.id.kale);
        button2.setText("Kale");

        Button button3 = (Button) findViewById(R.id.MVPB);
        button3.setText("Mann Veggie Power Blend");

        Button button4 = (Button) findViewById(R.id.Spinach);
        button4.setText("Spinach");

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Greens.this, SaladProtein.class);
        intent.putExtra("Greens", ((Button)v).getText());
        intent.putExtra("Salad size", getIntent().getStringExtra("Salad size"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
