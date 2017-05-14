package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PickSandwich extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_sandwich);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.CCS);
        button1.setText("Chipotle Chicken Sandwich - $6.19 (320 Cal.)");

        Button button2 = (Button) findViewById(R.id.CCS2);
        button2.setText("Crispy Chicken Sandwich $5.79 (590 Cal.)");

        Button button3 = (Button) findViewById(R.id.GCS);
        button3.setText("Grilled Chicken Sandwich $6.19 (320 Cal.)");

        Button button4 = (Button) findViewById(R.id.CCT);
        button4.setText("Crispy Chicken Tenders $6.19 (320 Cal.)");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(PickSandwich.this, Buns.class);
        intent.putExtra("Sandwich", ((Button) v).getText());
        intent.putExtra("Grill", getIntent().getStringExtra("Grill"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
