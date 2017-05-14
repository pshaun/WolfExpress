package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Buns extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buns);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.WhiteBun);
        button1.setText("White Bun");

        Button button2 = (Button) findViewById(R.id.WholeWheat);
        button2.setText("WholeWheat Bun");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Buns.this, grill_cheese.class);
        intent.putExtra("Buns", ((Button) v).getText());
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
