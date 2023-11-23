package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import android.view.ViewGroup;




public class MainActivity extends AppCompatActivity {
    EditText height;
    EditText weight;
    Button calculate;
    TextView indexResult;
    TextView textResult;

    ImageView pointer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.edit_height);
        weight = findViewById(R.id.edit_weight);

        calculate = findViewById(R.id.btn_calculate);

        indexResult = findViewById(R.id.index_results);
        textResult = findViewById(R.id.text_results);

        pointer = findViewById(R.id.pointer);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float h = Float.parseFloat(String.valueOf(height.getText())) / 100;
                float w = Float.parseFloat(String.valueOf(weight.getText()));
                float bmi = w / (h*h);

                setResult(bmi);


            }
        });


    }
    private void setResult(float bmi){
        height.setText("");
        weight.setText("");

        String roundedValue = String.format("%.2f", bmi);
        indexResult.setText(roundedValue);

        if (bmi <= 18.5) {
            textResult.setText("You are Underweight");
            textResult.setTextColor(R.color.blue);
            setPointerDimens(25,0,0,30,270);
        } else if (bmi>18.5 && bmi<25) {
            textResult.setText("You are healthy");
            textResult.setTextColor(getColor(R.color.green));
            setPointerDimens(10,0,0,20,310);
        } else if (bmi>=25 && bmi<30) {
            textResult.setText("You are overweight");

            textResult.setTextColor(R.color.yellow);
            setPointerDimens(0,0,0,0,0);
        } else if (bmi>=30 && bmi<35) {
            textResult.setText("You are obese");
            setPointerDimens(10,0,20,0,50);
            textResult.setTextColor(R.color.oragne);
        } else if (bmi>35) {
            textResult.setText("You are extremly Obese");
            setPointerDimens(25,0,30,0,90);
            textResult.setTextColor(R.color.red);
        }

    }

    private void setPointerDimens(int t, int b, int l, int r, float rotation) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pointer.getLayoutParams();
        layoutParams.setMargins(l, t, r, b);
        pointer.setLayoutParams(layoutParams);
        pointer.setRotation(rotation);
    }
}