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


    boolean check_validated = false;
    TextView txt_errors = null;
    protected Validator validator;
    protected boolean validated;

    String merchant_name = null;
    String merchant_number = null;
    int pay_amount;

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

        validate_fields();

    }

    private void validate_fields() {
        ArrayList <String> errors = new ArrayList<String>();
         merchant_name = merc_name.getText().toString().trim();
         merchant_number = merc_number.getText().toString().trim();
         pay_amount = Integer.parseInt(amount.getText().toString().trim());

        if(merchant_name.isEmpty() || merchant_name==null){
            errors.add("Enter merchant name");
            check_validated = false;
        }
        else if(merchant_number.length()<10){
            errors.add("Enter valid mobile number");
            check_validated = false;
        }
        else if(pay_amount<1){
            errors.add("Minimum amount must be 1");
            check_validated=false;
        }
        else {
            check_validated = true;
        }

    }


    public void forwardDetails(View v){
        ArrayList ar = new ArrayList<>();

        if (check_validated) {
            // Our form is successfully validated, so, do your stuffs here...
            //Toast.makeText(this, "Form Successfully Validated", Toast.LENGTH_LONG).show();



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
        else {

            //txt_errors.setText();
        }



    }

    @Override
    public void onClick(View v) {
        super.onClick(v);


    }






}
