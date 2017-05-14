package com.example.kusha.finalproject;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class ProgressActivity extends AppCompatActivity implements View.OnClickListener {


    //private long timeCountInMilliSeconds = 1 * 15000;


    private long timeCountInMilliSeconds = 1*1000;

    private enum TimerStatus {
        STARTED,
        STOPPED
    }

    private TimerStatus timerStatus = TimerStatus.STOPPED;

    private ProgressBar progressBarCircle;
    /*//
    private EditText editTextMinute;
    //
    private TextView textViewTime;*/

    private ImageView imageViewReset;
    private ImageView imageViewStartStop;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent wherefrom=getIntent();
        Bundle extras = wherefrom.getExtras();
        TextView orderListProgress = (TextView)findViewById(R.id.textView8);
        orderListProgress.setText((String) extras.get("text2Qr"));

        // method call to initialize the views
        initViews();
        // method call to initialize the listeners
        initListeners();

        timerStatus = TimerStatus.STOPPED;
        startStop();

    }


    /**
     * method to initialize the views
     */
    private void initViews() {
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);
        /*//
        editTextMinute = (EditText) findViewById(R.id.editTextMinute);
        //
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        //*/
//        imageViewReset = (ImageView) findViewById(R.id.imageViewReset);
        imageViewStartStop = (ImageView) findViewById(R.id.imageViewStartStop);
    }

    /**
     * method to initialize the click listeners
     */
    private void initListeners() {
        //
//        imageViewReset.setOnClickListener(this);

        imageViewStartStop.setOnClickListener(this);
    }

    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
/*
            case R.id.imageViewReset:
                reset();
                break;
*/
            case R.id.imageViewStartStop:
                //start needed
                startStop();
                break;
        }
    }

    /**
     * method to reset count down timer
     */
    //not required
    private void reset() {
        stopCountDownTimer();
        startCountDownTimer();

        //startCountDownTimer3();
    }


    /**
     * method to start and stop count down timer
     */
    private void startStop() {
        if (timerStatus == TimerStatus.STOPPED) {
            TextView orderPlaced = (TextView) findViewById(R.id.textView3);
            //TextView orderPreparing = (TextView) findViewById(R.id.textView4);
           //TextView orderComplete = (TextView) findViewById(R.id.textView5);

            orderPlaced.setTypeface(null, Typeface.BOLD); //only text style(only bold)
            // call to initialize the timer values
            //no need
            setTimerValues();
            // call to initialize the progress bar values
            setProgressBarValues();
            // showing the reset icon
//            imageViewReset.setVisibility(View.VISIBLE);
            // changing play icon to stop icon
            // making edit text not editable
            //
//            editTextMinute.setEnabled(false);
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED;
            // call to start the count down timer
            startCountDownTimer();

        }

    }

    /**
     * method to initialize the values for count down timer
     */
    private void setTimerValues() {
        //int time = 1;
        int time = 1;
       /* if (!editTextMinute.getText().toString().isEmpty()) {
            // fetching value from edit text and type cast to integer
            time = Integer.parseInt(editTextMinute.getText().toString().trim());
        } else {
            // toast message to fill edit text
            Toast.makeText(getApplicationContext(), getString(R.string.message_minutes), Toast.LENGTH_LONG).show();
        }*/
        // assigning values after converting to milliseconds
        //TextView orderPreparing = (TextView) findViewById(R.id.textView4);
        //TextView orderComplete = (TextView) findViewById(R.id.textView5);


        timeCountInMilliSeconds = time * 60 * 1000;
    }

    /**
     * method to start count down timer
     */
    private void startCountDownTimer() {

        countDownTimer = new CountDownTimer(timeCountInMilliSeconds, 10000) {
            int counter = 0;
            @Override
            public void onTick(long millisUntilFinished) {

//                textViewTime.setText(hmsTimeFormatter(millisUntilFinished));

                progressBarCircle.setProgress((int) ((millisUntilFinished / 1000)/1.3));
                counter++;
                if(counter == 3){
                    TextView orderPreparing = (TextView) findViewById(R.id.textView4);
                    Toast.makeText(getApplicationContext(),"Your food is being prepared!",Toast.LENGTH_LONG).show();

                    orderPreparing.setTypeface(null, Typeface.BOLD); //only text style(only bold)
                }


            }

            @Override
            public void onFinish() {

//                textViewTime.setText(hmsTimeFormatter(timeCountInMilliSeconds));
                // call to initialize the progress bar values
                setProgressBarValues();
                // hiding the reset icon
//                imageViewReset.setVisibility(View.GONE);
                // changing stop icon to start icon
                // making edit text editable
//                editTextMinute.setEnabled(true);
                // changing the timer status to stopped
                progressBarCircle.setProgress((int) 0);
                TextView orderComplete = (TextView) findViewById(R.id.textView5);
                orderComplete.setTypeface(null, Typeface.BOLD); //only text style(only bold)
                timerStatus = TimerStatus.STOPPED;
                Toast.makeText(getApplicationContext(),"Your order is ready!",Toast.LENGTH_LONG).show();
            }

        }.start();
        countDownTimer.start();
    }



    /**
     * method to stop count down timer
     */
    private void stopCountDownTimer() {
        countDownTimer.cancel();
    }

    /**
     * method to set circular progress bar values
     */
    private void setProgressBarValues() {

        progressBarCircle.setMax((int) timeCountInMilliSeconds / 1000);
        progressBarCircle.setProgress((int) timeCountInMilliSeconds / 1000);

    }


    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private String hmsTimeFormatter(long milliSeconds) {

        String hms = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hms;


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.id_order_history) {
            Intent myIntent = null;
            myIntent = new Intent(ProgressActivity.this, OrderHistoryActivity.class);
            startActivity(myIntent);
            return true;
        }

        if(id==R.id.id_set) {
            Intent myIntent = null;
            myIntent = new Intent(ProgressActivity.this, PaymentOptionsActivity.class);
            startActivity(myIntent);
            return true;
        }
        if(id==R.id.id_logout) {
            Intent myIntent = null;
            myIntent = new Intent(ProgressActivity.this, LoginActivity.class);
            startActivity(myIntent);
            Toast.makeText(getApplicationContext(), "Logged out successfully!", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
    }


}
