package com.example.mynewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String flatPriceText;
    EditText flatPrice;
    EditText arendaCost;
    int monthsToPlatit;
    EditText srok;
    EditText stavka;
    TextView text;
    double daysToRasplata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    public void calculate(){
        try {
            arendaCost = findViewById(R.id.editTextNumber2);
            flatPrice = findViewById(R.id.editTextNumber);
            srok = findViewById(R.id.editTextNumber4);
            stavka = findViewById(R.id.editTextNumber3);
            int stavkaText = Integer.parseInt(stavka.getText().toString());
            double flatPriceText = Integer.parseInt(flatPrice.getText().toString());
            int arendaCostText = Integer.parseInt(arendaCost.getText().toString());
            int srokText = Integer.parseInt(srok.getText().toString());
            double delStavkaText = stavkaText * 0.01;



            for(int i = 1; i<=srokText; i++){
                double dobavka = flatPriceText * delStavkaText;
                flatPriceText += dobavka;
            }
            text = findViewById(R.id.textView11);
            daysToRasplata = flatPriceText / arendaCostText;
            System.out.println("flat " + daysToRasplata);
            System.out.println(monthsToPlatit);
            text.setText(String.valueOf(daysToRasplata));
        }
        catch (Exception e){
            System.out.println("Ты дебил");
        }

    }


}
