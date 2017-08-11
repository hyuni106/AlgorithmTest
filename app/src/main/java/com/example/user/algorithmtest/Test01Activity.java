package com.example.user.algorithmtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test01Activity extends AppCompatActivity {

    private android.widget.EditText inputEdt;
    private android.widget.Button resultBtn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);
        bindViews();
        setupEvents();
    }

    private void setupEvents() {
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                int inputNum = Integer.parseInt(inputEdt.getText().toString());
                for (int i=1; i<=inputNum; i++) {
                    if (i%3 == 0 || i%5 == 0) {
                        sum += i;
                    }
                }
                resultTxt.setText(sum + "");
                inputEdt.setText("");
                hideKeyboard();
            }
        });
    }

    private void bindViews() {
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.resultBtn = (Button) findViewById(R.id.resultBtn);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
