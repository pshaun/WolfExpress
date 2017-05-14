package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderHistoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_order_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent wherefrom=getIntent();
        Bundle extras = wherefrom.getExtras();
        TextView text = (TextView)findViewById(R.id.textView6);
        if(text == null){
            text.setText("No previous orders found.");
        }
        else {
            text.setText((String) extras.get("text2Qr") + "\n\n");
        }
        Button orderAgain = (Button) findViewById(R.id.button4);
        orderAgain.setOnClickListener(this);
        if(MainActivity.amountBalance == 20.00){
            orderAgain.setVisibility(View.INVISIBLE);
        }
        else{
            orderAgain.setVisibility(View.VISIBLE);
        }
    }

    public void onClick(View v) {

    }
}
