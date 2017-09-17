package com.lmnlym.schaefflerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.text.Html;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.ImageButton;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Button;
import android.view.Gravity;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView productNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // user input stuff
        final EditText descriptionText = (EditText) findViewById(R.id.description);
        final EditText productNumberText = (EditText) findViewById(R.id.productNumber);
        final TextView numberDisplay = (TextView) findViewById(R.id.numberDisplay);
        final TextView descriptionDisplay = (TextView) findViewById(R.id.descriptionDisplay);


        // functions for UPDATE button
        Button updateButton = (Button) findViewById(R.id.updateButton);

        // update product number and description
        // set font size in textView
        // set description textView to all caps
        // center everything
        updateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String productNumber = productNumberText.getText().toString();
                String description = descriptionText.getText().toString();

                numberDisplay.setText(productNumber.toUpperCase());
                int numberLength = numberDisplay.getText().length();

                if(numberLength <= 8){
                    numberDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 190);
                }else if(numberLength <= 11){
                    numberDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 140);
                }else if(numberLength <= 13){
                    numberDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 120);
                }else{
                    numberDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 95);
                }


                descriptionDisplay.setText(description.toUpperCase());
                descriptionDisplay.setGravity(Gravity.CENTER_HORIZONTAL);
                numberDisplay.setGravity(Gravity.CENTER);

            }
        });



        /*// CLEAR button, clears out everythang, commented out because
            //Jordan said it's unneccessary
        Button clearButton = (Button) findViewById(R.id.clearProductNumber);


        clearButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                productNumberText.setText("");
                numberDisplay.setText("");
                descriptionText.setText("");
                descriptionDisplay.setText("");
            }
        });*/



        // spinner dropdown stuff
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.machine_status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {

            RelativeLayout rl = (RelativeLayout) findViewById(R.id.relLayout);



            @Override
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
             /*   if (position > 0) {
                    Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "!", Toast.LENGTH_SHORT).show();
                }*/

                if (position == 0) {
                    // DEFAULT = GRAY
                    rl.setBackgroundColor(Color.GRAY);
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);
                } else if (position == 1) {
                    // SETUP = YELLOW
                    rl.setBackgroundColor(Color.rgb(255,247,111));
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);

                } else if (position == 2) {
                    // INSPECTION = RED
                    rl.setBackgroundColor(Color.rgb(255,0,0));
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);
                } else if (position == 3) {
                    // RUNNING = GREEN
                    rl.setBackgroundColor(Color.rgb	(0,255,55));
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);
                } else if (position == 4) {
                    // FINISHED = WHITE
                    rl.setBackgroundColor(Color.WHITE);
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);

                } else if (position == 5) {
                    // TOOLING = BLUE
                    rl.setBackgroundColor(Color.rgb(0,0,255));
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);

                } else if (position == 6) {
                    // PINK TICKET = PINK
                    rl.setBackgroundColor(Color.rgb(255,105,180));
                    descriptionText.setTextColor(Color.BLACK);
                    productNumberText.setTextColor(Color.BLACK);
                    numberDisplay.setTextColor(Color.BLACK);
                    descriptionDisplay.setTextColor(Color.BLACK);
                } else {
                    // MACHINE DOWN = BLACK
                    rl.setBackgroundColor(Color.rgb(100,100,100));
                    descriptionText.setTextColor(Color.WHITE);
                    productNumberText.setTextColor(Color.WHITE);
                    numberDisplay.setTextColor(Color.RED);
                    descriptionDisplay.setTextColor(Color.RED);
                }

            }

            @Override
            public void onNothingSelected (AdapterView < ? > parent){

            }

        }

        );



    }

}


