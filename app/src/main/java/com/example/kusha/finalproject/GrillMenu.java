package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GrillMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grill_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.ChickenSandwich);
        button1.setText("Sandwich or Chicken");

        Button button2 = (Button) findViewById(R.id.Burger);
        button2.setText("Burger or Hot Dog");

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = null;
        switch (v.getId()) {
            case R.id.ChickenSandwich:
                intent = new Intent(GrillMenu.this, PickSandwich.class);
                break;
            case R.id.Burger:
                intent = new Intent(GrillMenu.this, Burgers.class);
                break;
        }
        intent.putExtra("Grill", ((Button) v).getText());
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
