package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener {


    public static double amountBalance = 20.00;
    private TextView greetingTextView;
    private TextView greetingTextView2;
    static int o = 5237;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        String user = getIntent().getStringExtra("username");
        if(user == null){
            user = "Guest";
        }
        greetingTextView = (TextView) findViewById(R.id.greeting_text_view);
        greetingTextView2 = (TextView) findViewById(R.id.greeting_text_view2);
        greetingTextView.setText("\nWelcome, "+ user);
        greetingTextView2.setText(String.format( "\nYou currently have $%.2f", MainActivity.amountBalance) + " in dining dollars.");
        findViewById(R.id.Wraps).setOnClickListener(this);
        findViewById(R.id.Grill).setOnClickListener(this);
        findViewById(R.id.Salads).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent myIntent = null;
        switch (v.getId()) {
            case R.id.Wraps:
                myIntent = new Intent(MainActivity.this, Protein.class);
                myIntent.putExtra("type", "Wraps");
                break;
            case R.id.Grill:
                myIntent = new Intent(MainActivity.this, GrillMenu.class);
                myIntent.putExtra("type", "Grill");
                break;
            case R.id.Salads:
                myIntent = new Intent(MainActivity.this, Salad.class);
                myIntent.putExtra("type", "Salads");
                break;
        }
        startActivity(myIntent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        Intent wherefrom=getIntent();
        Bundle extras = wherefrom.getExtras();
        String text2Qr;
        if(id==R.id.id_order_history) {
            Intent myIntent = null;
            extras = wherefrom.getExtras();
            if(extras !=null) {
                text2Qr = (String) extras.get("text2Qr");
            }
            else {
                text2Qr = "No previous orders found.";
            }
            myIntent = new Intent(MainActivity.this, OrderHistoryActivity.class);
            myIntent.putExtra("text2Qr" ,text2Qr);
            startActivity(myIntent);
            return true;
        }

        if(id==R.id.id_set) {
            Intent myIntent = null;
            myIntent = new Intent(MainActivity.this, PaymentOptionsActivity.class);
            startActivity(myIntent);
            return true;
        }
        if(id==R.id.id_logout) {
            Intent myIntent = null;
            myIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
        }

    }

