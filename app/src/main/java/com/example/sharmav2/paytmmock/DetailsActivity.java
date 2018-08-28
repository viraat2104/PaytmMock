package com.example.sharmav2.paytmmock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class DetailsActivity extends DetailValidator implements OnClickListener, Validator.ValidationListener{


    @NotEmpty(message = "Please enter Name")
    EditText merc_name = null;
    @NotEmpty
    @Length(max=10, min=6, message = "Mobile No must have at-least 10 characters")
    EditText merc_number = null;
    @Min(value=1, message = "amount must be greater than 0")
    EditText amount = null;

    TextView txt_errors = null;
    protected Validator validator;
    protected boolean validated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        merc_name = (EditText) findViewById(R.id.merchant_name);
        merc_number = (EditText) findViewById(R.id.merchant_number);
        amount = (EditText) findViewById(R.id.amount);
        txt_errors = (TextView) findViewById(R.id.Error);

        Button button = (Button) findViewById(R.id.submit_details);
        button.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){
                forwardDetails(v);
            }
        });

    }



    public void forwardDetails(View v){
        ArrayList ar = new ArrayList<>();
        if (validated) {
            // Our form is successfully validated, so, do your stuffs here...
            //Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_LONG).show();
            String merchant_name = merc_name.getText().toString().trim();
            String merchant_number = merc_number.getText().toString().trim();
            int pay_amount = Integer.parseInt(amount.getText().toString().trim());



            ar.add(merchant_name);
            ar.add(merchant_number);
            ar.add(pay_amount);
            Intent intent = new Intent(this, PaytmPaymentScreen.class);
            //intent.putExtra("data", ar);

            Bundle args = new Bundle();
            args.putSerializable("ARRAYLIST",(Serializable)ar);
            intent.putExtra("BUNDLE",args);

            startActivity(intent);
        }



    }

    @Override
    public void onClick(View v) {
        super.onClick(v);


    }






}
