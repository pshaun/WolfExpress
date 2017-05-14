package com.example.kusha.finalproject;

import android.content.Intent;
        import android.graphics.Bitmap;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.Toast;
        import com.google.zxing.BarcodeFormat;
        import com.google.zxing.MultiFormatWriter;
        import com.google.zxing.WriterException;
        import com.google.zxing.common.BitMatrix;
        import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {
    private EditText text;
    private String test;
    private Button gen_btn;
    private ImageView image;
    private String text2Qr;
    private String text2Qr1;
    private BitMatrix bitMatrix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text = (EditText) findViewById(R.id.text);
        //gen_btn = (Button) findViewById(R.id.gen_btn);
        image = (ImageView) findViewById(R.id.image);
        Intent wherefrom=getIntent();
        if(wherefrom==null){
            Log.v("shithappend","sdfasf");
        }

        Bundle extras = wherefrom.getExtras();
        Log.v("asfdasdf","ASdfasdf");
        if (extras != null) {
            text2Qr =(String) extras.get("text2Qr");
            text2Qr1=(String) extras.get("text2Qr1");
            Log.v("text2ddQR",text2Qr);
        }
        bitMatrix=new BitMatrix(100,100);




                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try{

                    Log.v("text2yoQR",text2Qr);
                    bitMatrix = multiFormatWriter.encode(text2Qr, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                }
                catch (WriterException e){
                    e.printStackTrace();
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
            myIntent = new Intent(GeneratorActivity.this, OrderHistoryActivity.class);
            startActivity(myIntent);
            return true;
        }

        if(id==R.id.id_set) {
            Intent myIntent = null;
            myIntent = new Intent(GeneratorActivity.this, PaymentOptionsActivity.class);
            startActivity(myIntent);
            return true;
        }
        if(id==R.id.id_logout) {
            Intent myIntent = null;
            myIntent = new Intent(GeneratorActivity.this, LoginActivity.class);
            startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
    }


    }

