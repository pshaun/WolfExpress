package com.example.kusha.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class OrderPlaced extends AppCompatActivity implements View.OnClickListener{
    private String text2Qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderplaced);
        ((TextView)findViewById(R.id.left)).setText(String.format( "$%.2f", MainActivity.amountBalance ));


        Button button1 = (Button) findViewById(R.id.GenerateBtn);
        button1.setText("Generate QR Code");
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("Check Progress");
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("Back To Main Menu");
        button3.setOnClickListener(this);

        TextView text = (TextView) findViewById(R.id.orderNum);
        text.setText("Order #"+MainActivity.o);

    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        Intent wherefrom=getIntent();

        Intent myIntent = null;
        switch (v.getId()) {
            case R.id.GenerateBtn:
                Bundle extras = wherefrom.getExtras();
                if (extras != null) {
                    text2Qr = (String) extras.get("text2Qr");
                    Log.v("text2ddQR", text2Qr);
                    i = new Intent(this, GeneratorActivity.class);
                    i.putExtra("text2Qr", text2Qr);
                }
                break;
            case R.id.button2:
                extras = wherefrom.getExtras();
                if(extras !=null) {
                    text2Qr = (String) extras.get("text2Qr");
                    i = new Intent(this, ProgressActivity.class);
                    i.putExtra("text2Qr" ,text2Qr);
                }
                break;
            case R.id.button3:
                extras = wherefrom.getExtras();
                if(extras !=null) {
                    text2Qr = (String) extras.get("text2Qr");
                    i = new Intent(this, ProgressActivity.class);
                    i.putExtra("text2Qr" ,text2Qr);
                    i = new Intent(this, MainActivity.class);
                    MainActivity.o++;
                }

                break;
        }


        startActivity(i);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        Intent wherefrom=getIntent();
        Bundle extras = wherefrom.getExtras();
        int id=item.getItemId();
        if(id==R.id.id_order_history) {
            Intent myIntent = null;
            extras = wherefrom.getExtras();
            if(extras !=null) {
                text2Qr = (String) extras.get("text2Qr");
            }
            else {
                text2Qr = "-";
            }
            myIntent = new Intent(OrderPlaced.this, OrderHistoryActivity.class);
            myIntent.putExtra("text2Qr" ,text2Qr);
            startActivity(myIntent);
            return true;
        }

        if(id==R.id.id_set) {
            Intent myIntent = null;
            myIntent = new Intent(OrderPlaced.this, PaymentOptionsActivity.class);
            startActivity(myIntent);
            return true;
        }
        if(id==R.id.id_logout) {
            Intent myIntent = null;
            myIntent = new Intent(OrderPlaced.this, LoginActivity.class);
            startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
    }








}
