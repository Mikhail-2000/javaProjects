package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView resultField;
    private EditText number_field_1;
    private EditText number_field_2;
    private Button plus, minus, multiply, division;
    private Switch switchMode;
    boolean random = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = findViewById(R.id.textView);
        number_field_1 = findViewById(R.id.number_field_1);
        number_field_2 = findViewById(R.id.number_field_2);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        switchMode = findViewById(R.id.switchMode);
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random = !random;
            }
        });

        plus.setOnClickListener(new OperationListener(OperationType.plus));
        minus.setOnClickListener(new OperationListener(OperationType.minus));
        division.setOnClickListener(new OperationListener(OperationType.division));
        multiply.setOnClickListener(new OperationListener(OperationType.multiply));

    }
    public class OperationListener implements View.OnClickListener {
        float n1, n2;
        private OperationType type;
        OperationListener(OperationType op)
        {
            this.type = op;

        }
        @Override
        public void onClick(View view) {
            try{
                n1 = Float.parseFloat(number_field_1.getText().toString());
                n2 = Float.parseFloat(number_field_2.getText().toString());
            }
            finally{
                resultField.setText(String.valueOf("ВведитеЧисло!"));
            }
            float res = getResult(n1, n2);
            resultField.setText(String.valueOf(res));
        }
        private float getResult(float num1, float num2){
            if(random){
                Random rn = new Random();
                int delta = rn.nextInt() % 3;
                num1 += delta;
                delta = rn.nextInt() % 3;
                num2 += delta;
            }
            switch(type){
                case plus:
                    return num1 + num2;
                case minus:
                    return num1 - num2;
                case division:
                    return num1 / num2;
                case multiply:
                    return num1 * num2;
            }
            return 0;
        }
    }

}