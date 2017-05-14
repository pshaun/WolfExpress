package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaladTopping extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_topping);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button button1 = (Button) findViewById(R.id.Becon);
        button1.setText("Bacon (43 Cal.)");

        Button button2 = (Button) findViewById(R.id.BlackBeans);
        button2.setText("Black Beans (35 Cal.)");

        Button button3 = (Button) findViewById(R.id.Broccoli);
        button3.setText("Broccoli (10 Cal.)");

        Button button4 = (Button) findViewById(R.id.Cauliflower);
        button4.setText("Cauliflower (7 Cal.)");

        Button button5 = (Button) findViewById(R.id.Celery);
        button5.setText("Celery (4 Cal.)");

        Button button6 = (Button) findViewById(R.id.Craisins);
        button6.setText("Craisins (86 Cal.)");

        Button button7 = (Button) findViewById(R.id.Cucumbers);
        button7.setText("Cucumbers (3 Cal.)");

        Button button8 = (Button) findViewById(R.id.Tomatoes2);
        button8.setText("Tomatoes (5 Cal.)");

        Button button9 = (Button) findViewById(R.id.FetaCheese);
        button9.setText("Feta Cheese (75 Cal.)");

        Button button10 = (Button) findViewById(R.id.GarbanzoBeans);
        button10.setText("Garbanzo Beans (45 Cal.)");

        Button button11 = (Button) findViewById(R.id.GRPM);
        button11.setText("Green and Red Pepper Medley (100 Cal.)");

        Button button12 = (Button) findViewById(R.id.Mushrooms);
        button12.setText("Mushrooms (6 Cal.)");

        Button button13 = (Button) findViewById(R.id.ParmesanCheese);
        button13.setText("Parmesan Cheese (110 Cal.)");

        Button button14 = (Button) findViewById(R.id.Provolone2);
        button14.setText("Provolone (98 Cal.)");

        Button button15 = (Button) findViewById(R.id.SwissCheese);
        button15.setText("Swiss Cheese (106 Cal.)");

        Button button16 = (Button) findViewById(R.id.RedOnions);
        button16.setText("Red Onions (11 Cal.)");

        Button button17 = (Button) findViewById(R.id.ShreddedCarrots);
        button17.setText("Shredded Carrots (11 Cal.)");

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button4.setOnClickListener(this);

        button5.setOnClickListener(this);

        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);

        button12.setOnClickListener(this);
        button13.setOnClickListener(this);

        button14.setOnClickListener(this);

        button15.setOnClickListener(this);

        button16.setOnClickListener(this);
        button17.setOnClickListener(this);

        button11.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SaladTopping.this, SaladDressing.class);
        intent.putExtra("Topping", ((Button) v).getText());
        intent.putExtra("Protein", getIntent().getStringExtra("Protein"));
        intent.putExtra("Greens", getIntent().getStringExtra("Greens"));
        intent.putExtra("Salad size", getIntent().getStringExtra("Salad size"));
        intent.putExtra("type", getIntent().getStringExtra("type"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}
