package com.appzvalley.firstandroiddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    TextView txt;
    EditText editText1, editText2;
    Button button1, button2, button3, button4, button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nestedlayouts);

        txt = (TextView) findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        button1 = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String val1 = editText1.getText().toString();
                    String val2 = editText2.getText().toString();
                    int a = Integer.parseInt(val1);
                    int b = Integer.parseInt(val2);
                    int result = a + b;
                    txt.setText("Result of Addition is : "+String.valueOf(result));
                    txt.setTextColor(getResources().getColor(R.color.textSuccessColor));
                 }
                catch (NumberFormatException e){
                    txt.setText("Enter Valid Input :" + e.getMessage());
                    txt.setTextColor(getResources().getColor(R.color.textErrorColor));
                    Toast.makeText(getApplicationContext(),"Enter Valid Input :" + e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setTextColor(getResources().getColor(R.color.textSuccessColor));
            }
        });

        Thread mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(myIntent);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        mThread.start();


        /*try {
            Thread.sleep(15000);
        } catch (InterruptedException e)
        {
            Toast.makeText(getApplicationContext(),"Exception Occured While calling new activity",Toast.LENGTH_SHORT).show();
        }
        Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(myIntent);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(myIntent);
            }
        });*/

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,txt.getTextSize()+1);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setTextSize(TypedValue.COMPLEX_UNIT_SP,txt.getTextSize()-1);
            }
        });
    }
}
