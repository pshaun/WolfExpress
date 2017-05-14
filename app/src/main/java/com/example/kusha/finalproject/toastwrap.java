package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class toastwrap extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toastwrap);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.Yes);
        button1.setText("Yes");

        Button button2 = (Button) findViewById(R.id.No);
        button2.setText("No");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(toastwrap.this, Orderlist.class);
        intent.putExtra("toastWrap", ((Button) v).getText());
        intent.putExtra("Dressings", getIntent().getStringExtra("Dressings"));
        intent.putExtra("Toppings", getIntent().getStringExtra("Toppings"));
        intent.putExtra("Cheese", getIntent().getStringExtra("Cheese"));
        intent.putExtra("choiceWrap", getIntent().getStringExtra("choiceWrap"));
        intent.putExtra("protein", getIntent().getStringExtra("protein"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
