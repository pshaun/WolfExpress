package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaladProtein extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_protein);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.CS);
        button1.setText("Chicken Salad (80 Cal.)");

        Button button2 = (Button) findViewById(R.id.Turkey);
        button2.setText("Turkey (60 Cal.)");

        Button button3 = (Button) findViewById(R.id.RC);
        button3.setText("Roasted Chicken (85 Cal.)");

        Button button4 = (Button) findViewById(R.id.BuffaloChicken);
        button4.setText("Buffalo Chicken (155 Cal.)");

        Button button5 = (Button) findViewById(R.id.H);
        button5.setText("Ham (60 Cal.)");

        Button button6 = (Button) findViewById(R.id.S);
        button6.setText("Salami (110 Cal.)");

        Button button7 = (Button) findViewById(R.id.ES);
        button7.setText("Egg Salad (90 Cal.)");

        Button button8 = (Button) findViewById(R.id.TS);
        button8.setText("Tuna Salad (60 Cal.)");

        Button button9 = (Button) findViewById(R.id.CC);
        button9.setText("Crispy Chicken 150 Cal.)");


        button1.setOnClickListener(this);

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
        Intent intent = new Intent(SaladProtein.this, SaladTopping.class);
        intent.putExtra("Protein", ((Button) v).getText());
        intent.putExtra("Greens", getIntent().getStringExtra("Greens"));
        intent.putExtra("Salad size", getIntent().getStringExtra("Salad size"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}

