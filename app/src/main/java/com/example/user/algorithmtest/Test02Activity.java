package com.example.user.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test02Activity extends AppCompatActivity {

    private android.widget.EditText inputEdt;
    private android.widget.Button resultBtn;
    private android.widget.TextView resultTxt;
    private Button result2Btn;
    private Button result3Btn;
    private Button result4Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);
        bindViews();
        setupEvents();
    }

    private void setupEvents() {
        inputEdt.setText("5");
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTxt.setGravity(Gravity.LEFT);
                resultTxt.setText(printStar());
            }
        });

        result2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTxt.setGravity(Gravity.RIGHT);
                resultTxt.setText(printStar());
            }
        });

        result3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTxt.setGravity(Gravity.LEFT);
                resultTxt.setText(reverseStar());
            }
        });

        result4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTxt.setGravity(Gravity.RIGHT);
                resultTxt.setText(reverseStar());
            }
        });
    }

    private String printStar() {
        int inputNum = Integer.parseInt(inputEdt.getText().toString());
        String result = "";
        for (int i = 0; i < inputNum; i++) {
            for (int j = 0; j <= i; j++) {
                result += "*";
            }
            result += "\n";
        }
        return result;
    }

    private String reverseStar() {
        int inputNum = Integer.parseInt(inputEdt.getText().toString());
        String result = "";
        for (int i = 0; i < inputNum; i++) {
            for (int j = 0; j < inputNum-i; j++) {
                result += "*";
            }
            result += "\n";
        }
        return result;
    }

    private void bindViews() {
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.result4Btn = (Button) findViewById(R.id.result4Btn);
        this.result3Btn = (Button) findViewById(R.id.result3Btn);
        this.result2Btn = (Button) findViewById(R.id.result2Btn);
        this.resultBtn = (Button) findViewById(R.id.resultBtn);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);
    }
}
