package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaladDressing extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_dressing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button1 = (Button) findViewById(R.id.BalsamicVinaigrette);
        button1.setText("Balsamic Vinaigrette (120 Cal.)");

        Button button2 = (Button) findViewById(R.id.Caesar);
        button2.setText("Caesar (160 Cal.)");

        Button button3 = (Button) findViewById(R.id.BleuCheese);
        button3.setText("Bleu Cheese (120 Cal.)");

        Button button4 = (Button) findViewById(R.id.HM);
        button4.setText("Honey Mustard (150 Cal.)");

        Button button5 = (Button) findViewById(R.id.LoCalItalian);
        button5.setText("Lo-Cal Italian (90 Cal.)");

        Button button6 = (Button) findViewById(R.id.CM);
        button6.setText("Chipotle Mayo (110 Cal.)");

        Button button7 = (Button) findViewById(R.id.Ranch);
        button7.setText("Ranch (110 Cal.)");

        Button button8 = (Button) findViewById(R.id.ThousandIsland);
        button8.setText("Thosand Island (110 Cal.)");

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button4.setOnClickListener(this);

        button5.setOnClickListener(this);

        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

        button8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SaladDressing.this, Orderlist.class);
        intent.putExtra("Dressing", ((Button) v).getText());
        intent.putExtra("Topping", getIntent().getStringExtra("Topping"));
        intent.putExtra("Protein", getIntent().getStringExtra("Protein"));
        intent.putExtra("Greens", getIntent().getStringExtra("Greens"));
        intent.putExtra("Salad size", getIntent().getStringExtra("Salad size"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

    }
}
