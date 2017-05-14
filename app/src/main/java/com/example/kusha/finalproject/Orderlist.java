package com.example.kusha.finalproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Orderlist extends AppCompatActivity implements View.OnClickListener {

    int randomNum;
    double tax = 0.51;
    double orderPrice = 0;
    double proteinCost = 6.40;
    double smallsaladCost = 4.44;
    double sandwichCost = 6.70;
    Intent i;

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_orderlist);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        findViewById(R.id.checkout).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);


        randomNum = 10 + (int) (Math.random() * ((200 - 10) + 1));

        Bundle extras = new Bundle();
        Button button1 = (Button) findViewById(R.id.checkout);
        button1.setText("Complete Order");
        Button button2 = (Button) findViewById(R.id.cancel);
        button2.setText("Cancel");
        String wa;

        switch (getIntent().getStringExtra("type")) {
            case "Wraps":
                mDatabase = FirebaseDatabase.getInstance().getReference().child("Cyclone_Wraps(OrderNo"+MainActivity.o+")");
                createHeader(ll, "Cyclone Wraps:");
                createRelativeView(ll, "Protein:", getIntent().getStringExtra("protein"), 2);
                mDatabase.child("1)Protein").setValue(getIntent().getStringExtra("protein"));
                i = new Intent(this, OrderPlaced.class);
                i.putExtra("text2Qr", getIntent().getStringExtra("protein"));
                createRelativeView(ll, "ChoiceWrap:", getIntent().getStringExtra("choiceWrap"), 3);
                mDatabase.child("2)Wrap_Choice").setValue(getIntent().getStringExtra("choiceWrap"));
                //i = new Intent(this, OrderPlaced.class);
                String wh = "Cyclone Wraps:";
                wa = "Protein: " + getIntent().getStringExtra("protein");
                String wb = "Choice Wrap: " + getIntent().getStringExtra("choiceWrap");
                String wc = "Cheese: " + getIntent().getStringExtra("Cheese");

                String wd = "Toppings: " + getIntent().getStringExtra("Toppings");
                String we = "Dressings: " + getIntent().getStringExtra("Dressings");
                String wf = "Toast Wrap: " + getIntent().getStringExtra("toastWrap");
                String x = String.format( "Total: $%.2f", proteinCost );
                String wg = "Payment Method: Meal Plan";
                wa = wh + "\n" + wa + "\n" + wb + "\n" + wc + "\n" + wd + "\n" + we + "\n" + wf + "\n" + x + "\n" + wg;
                i.putExtra("text2Qr", wa);

                createRelativeView(ll, "Cheese:", getIntent().getStringExtra("Cheese"), 4);
                mDatabase.child("3)Cheese").setValue(getIntent().getStringExtra("Cheese"));
                createRelativeView(ll, "Toppings:", getIntent().getStringExtra("Toppings"), 5);
                mDatabase.child("4)Toppings").setValue(getIntent().getStringExtra("Toppings"));
                createRelativeView(ll, "Dressings:", getIntent().getStringExtra("Dressings"), 6);
                mDatabase.child("5)Dressings").setValue(getIntent().getStringExtra("Dressings"));
                createRelativeView(ll, "ToastWrap:", getIntent().getStringExtra("toastWrap"), 7);
                mDatabase.child("6)ToastWrap").setValue(getIntent().getStringExtra("toastWrap"));
                createRelativeView(ll, "Tax:", "$" + tax, 8);
                createRelativeView(ll, "Sum Total:", String.format( "$%.2f", proteinCost ), 9);

                orderPrice = proteinCost;

                break;
            case "Grill":
                mDatabase = FirebaseDatabase.getInstance().getReference().child("The_Grill(OrderNo"+MainActivity.o+")");
                createHeader(ll, "The Grill:");
                i = new Intent(this, OrderPlaced.class);
                i.putExtra("text2Qr", getIntent().getStringExtra("protein"));
                String ga = "The Grill: ";
                String gb;

                if (getIntent().hasExtra("Sandwich")) {
                    createRelativeView(ll, "Sandwich:", getIntent().getStringExtra("Sandwich"), 2);
                    mDatabase.child("1)Choice").setValue(getIntent().getStringExtra("Sandwich"));
                    gb = "Sandwich or Burger: " + getIntent().getStringExtra("Sandwich");
                } else {
                    createRelativeView(ll, "Burger:", getIntent().getStringExtra("Burger"), 2);
                    mDatabase.child("1)Choice").setValue(getIntent().getStringExtra("Burger"));
                    gb = "Sandwich or Burger: " + getIntent().getStringExtra("Burger");
                }

                createRelativeView(ll, "Buns:", getIntent().getStringExtra("Buns"), 3);
                mDatabase.child("2)Bun").setValue(getIntent().getStringExtra("Buns"));
                String gc = "Bun: " + getIntent().getStringExtra("Buns");
                createRelativeView(ll, "Cheese:", getIntent().getStringExtra("Grill Cheese"), 4);
                mDatabase.child("3)Cheese").setValue(getIntent().getStringExtra("Grill Cheese"));
                String gd = "Cheese: " + getIntent().getStringExtra("Grill Cheese");
                createRelativeView(ll, "Toppings:", getIntent().getStringExtra("Grill Toppings"), 5);
                mDatabase.child("4)Toppings").setValue(getIntent().getStringExtra("Grill Toppings"));
                String ge = "Toppings: " + getIntent().getStringExtra("Grill Toppings");
                createRelativeView(ll, "Tax:", "$" + tax, 6);
                createRelativeView(ll, "Sum Total:", String.format( "$%.2f", sandwichCost ), 7);
                orderPrice = sandwichCost;
                String y = String.format( "Total: $%.2f", sandwichCost );
                String gf = "Payment Method: Meal Plan";
                ga = ga + "\n" + gb + "\n" + gc + "\n" + gd + "\n" + ge + "\n" + y + "\n" + gf;
                i.putExtra("text2Qr", ga);

                break;
            default:
                i = new Intent(this, OrderPlaced.class);

                mDatabase = FirebaseDatabase.getInstance().getReference().child("Cyclone_Salads(OrderNo"+MainActivity.o+")");
                createHeader(ll, "Cyclone Salads:");
                String sa = "Cyclone Salads: ";
                createRelativeView(ll, "Size:", getIntent().getStringExtra("Salad size"), 2);
                mDatabase.child("1)Size").setValue(getIntent().getStringExtra("Salad size"));
                String sb = "Salad Size: " + getIntent().getStringExtra("Salad size");
                createRelativeView(ll, "Greens:", getIntent().getStringExtra("Greens"), 3);
                mDatabase.child("2)Greens").setValue(getIntent().getStringExtra("Greens"));
                String sc = "Greens: " + getIntent().getStringExtra("Greens");
                createRelativeView(ll, "Protein:", getIntent().getStringExtra("Protein"), 4);
                mDatabase.child("3)Protein").setValue(getIntent().getStringExtra("Protein"));
                String sd = "Protein: " + getIntent().getStringExtra("Protein");
                createRelativeView(ll, "Toppings:", getIntent().getStringExtra("Topping"), 5);
                mDatabase.child("4)Topping").setValue(getIntent().getStringExtra("Topping"));
                String se = "Topping: " + getIntent().getStringExtra("Topping");
                createRelativeView(ll, "Dressings:", getIntent().getStringExtra("Dressing"), 6);
                mDatabase.child("5)Dressing").setValue(getIntent().getStringExtra("Dressing"));
                String sf = "Dressing: " + getIntent().getStringExtra("Dressing");
                tax = 0.35;
                createRelativeView(ll, "Tax:", "$" + tax, 7);
                createRelativeView(ll, "Sum Total:", String.format( "$%.2f", smallsaladCost ), 8);
                orderPrice = smallsaladCost;
                String z = String.format( "Total: $%.2f", smallsaladCost );
                String sg = "Payment Method: Meal Plan";
                sa = sa + "\n" + sb + "\n" + sc + "\n" + sd + "\n" + se + "\n" + z + "\n" + sf;
                i.putExtra("text2Qr", sa);

                break;
        }

        //startActivity(i);

    }


    public void createRelativeView(LinearLayout ll, String textKey, String textValue, int position) {
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.HORIZONTAL);
        l.setGravity(Gravity.CENTER_VERTICAL);
        TextView textView = new TextView(this);
        textView.setText(textKey);
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView.setTextSize(20);
        textView.setPadding(4, 4, 4, 4);
        TextView textView1 = new TextView(this);
        textView1.setText(textValue);
        textView1.setTextSize(18);

        textView1.setPadding(4, 4, 4, 4);
        l.addView(textView);
        l.addView(textView1);

        ll.addView(l, position);
    }

    public void createHeader(LinearLayout ll, String textValue) {
        TextView textView = new TextView(this);
        textView.setText(textValue);
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        textView.setPadding(4, 4, 4, 4);
        textView.setTextSize(22);
        ll.addView(textView, 1);
    }


    @Override
    public void onClick(View v) {
        Intent myIntent = null;
        switch (v.getId()) {
            case R.id.checkout:
                if (MainActivity.amountBalance - orderPrice < 0) {
                    Toast.makeText(Orderlist.this, "Insufficient balance!", Toast.LENGTH_SHORT).show();
                } else {
                    MainActivity.amountBalance = MainActivity.amountBalance - orderPrice;
                    myIntent = new Intent(Orderlist.this, OrderPlaced.class);
                    Toast.makeText(getApplicationContext(),"Your order was placed!",Toast.LENGTH_LONG).show();

                    startActivity(i);
                }
                break;
            case R.id.cancel:
                i = new Intent(Orderlist.this, MainActivity.class);
                Toast.makeText(Orderlist.this, "All items have been removed from cart.", Toast.LENGTH_LONG).show();
                startActivity(i);
                break;

        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_order_history) {
            Intent myIntent = null;
            myIntent = new Intent(Orderlist.this, OrderHistoryActivity.class);
            startActivity(myIntent);
            return true;
        }

        if(id==R.id.id_set) {
            Intent myIntent = null;
            myIntent = new Intent(Orderlist.this, PaymentOptionsActivity.class);
            startActivity(myIntent);
            return true;
        }
        if(id==R.id.id_logout) {
            Intent myIntent = null;
            myIntent = new Intent(Orderlist.this, LoginActivity.class);
            startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
    }

}

