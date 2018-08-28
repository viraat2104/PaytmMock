package com.example.sharmav2.paytmmock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class PaytmPaymentScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm_payment_screen);
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<Object> object = (ArrayList<Object>) args.getSerializable("ARRAYLIST");
//        TextView tx = (TextView) findViewById(R.id.trialview);
//        tx.setText(object.get(0).toString());

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd MMM yyyy");
        String strDate = formatter.format(date);

        Random rnd = new Random();
        int n = 10000 + rnd.nextInt(90000);
        int m = 10000 + rnd.nextInt(90000);
        String rndno = "2"+n+m;

        TextView set_date = (TextView)findViewById(R.id.date_time);
        TextView set_name = (TextView)findViewById(R.id.display_name);
        TextView set_number = (TextView)findViewById(R.id.display_number);
        TextView set_amount = (TextView)findViewById(R.id.amount);
        TextView set_tranc = (TextView)findViewById(R.id.transaction_number);

        set_amount.setText(""+object.get(2).toString());
        set_date.setText(""+strDate);
        set_name.setText(""+object.get(0).toString()+"'s Wallet linked to");
        set_number.setText(""+object.get(1).toString());
        set_tranc.setText("Transaction ID: "+rndno);






    }
}
