package com.example.kusha.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentOptionsActivity extends AppCompatActivity {
    private String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.arraySpinner = new String[] {
                "Meal Plan - Dining Dollars", "Credit Card/Debit Card", "Pay With Cash"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
        TextView textView = (TextView) findViewById(R.id.textView12);
        textView.setText(String.format( "$%.2f", MainActivity.amountBalance));
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_order_history) {
            Intent myIntent = null;
            myIntent = new Intent(PaymentOptionsActivity.this, OrderHistoryActivity.class);
            startActivity(myIntent);
            return true;
        }

        if(id==R.id.id_set) {
            Intent myIntent = null;
            myIntent = new Intent(PaymentOptionsActivity.this, PaymentOptionsActivity.class);
            startActivity(myIntent);
            return true;
        }
        if(id==R.id.id_logout) {
            Intent myIntent = null;
            myIntent = new Intent(PaymentOptionsActivity.this, LoginActivity.class);
            startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
    }
}
