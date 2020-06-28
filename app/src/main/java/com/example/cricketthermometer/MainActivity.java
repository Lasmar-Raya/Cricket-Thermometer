package com.example.cricketthermometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static android.app.ProgressDialog.show;

public class MainActivity extends AppCompatActivity {
    EditText etChirps; // first i define the variables (using their id)
    Button btnChirps;
    TextView tvResults;
    DecimalFormat formatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // second i make the link between the code and the front-end
        formatter=new DecimalFormat("#0.00");
        etChirps=findViewById(R.id.etChirps);
        btnChirps=findViewById(R.id.btnChirps);
        tvResults=findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE); // when the app starts , the text "Text View" 'll be invisible
        //When i click the button
        btnChirps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etChirps.getText().toString().isEmpty())
                {
                    Toast.makeText( getApplicationContext(), "Please enter a number" ,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps=Integer.parseInt(etChirps.toString().trim()); // i read the input as a string , i convert it to integer
                    double temp= (chirps/3.0)+4;
                    String results="The approximate temperature outside is "+formatter.format(temp)+" degrees Celsius ." ;
                    tvResults.setText(results);
                }

            }
        });

    }
}