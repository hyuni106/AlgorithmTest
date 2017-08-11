package com.example.user.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Locale;

public class Test04Activity extends AppCompatActivity {

    private android.widget.Button btnReset;
    private android.widget.CheckBox chkBox01;
    private android.widget.CheckBox chkBox02;
    private android.widget.CheckBox chkBox03;
    private android.widget.CheckBox chkBox04;
    private android.widget.CheckBox chkBox05;
    private android.widget.CheckBox chkBox06;
    private android.widget.CheckBox chkBox07;
    private android.widget.CheckBox chkBox08;
    private android.widget.CheckBox chkBox09;
    private android.widget.CheckBox chkBox10;
    private android.widget.CheckBox chkBox11;
    private android.widget.CheckBox chkBox12;
    private android.widget.CheckBox chkBox13;
    private android.widget.CheckBox chkBox14;
    private android.widget.CheckBox chkBox15;
    private android.widget.CheckBox chkBox16;
    private android.widget.CheckBox chkBox17;
    private android.widget.CheckBox chkBox18;
    private android.widget.CheckBox chkBox19;
    private android.widget.CheckBox chkBox20;
    private android.widget.CheckBox chkBox21;
    private android.widget.CheckBox chkBox22;
    private android.widget.CheckBox chkBox23;
    private android.widget.CheckBox chkBox24;
    private android.widget.CheckBox chkBox25;
    private Button btnAll;
    private Button btnCross;
    private Button btnEdge;
    private TextView txtBingo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04);
        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {

    }

    private void setupEvents() {
        final CheckBox[][] checkBoxes = {
                {chkBox01, chkBox02, chkBox03, chkBox04, chkBox05},
                {chkBox06, chkBox07, chkBox08, chkBox09, chkBox10},
                {chkBox11, chkBox12, chkBox13, chkBox14, chkBox15},
                {chkBox16, chkBox17, chkBox18, chkBox19, chkBox20},
                {chkBox21, chkBox22, chkBox23, chkBox24, chkBox25}
        };

        btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        checkBoxes[i][j].setChecked(true);
                    }
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        checkBoxes[i][j].setChecked(false);
                    }
                }
            }
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == j) {
                            checkBoxes[i][j].setChecked(true);
                        } else if (i + j == 4) {
                            checkBoxes[i][j].setChecked(true);
                        } else {
                            checkBoxes[i][j].setChecked(false);
                        }
                    }
                }
            }
        });

        btnEdge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i == 0 || i == 4 || j == 0 || j == 4) {
                            checkBoxes[i][j].setChecked(true);
                        } else {
                            checkBoxes[i][j].setChecked(false);
                        }
                    }
                }
            }
        });

        CompoundButton.OnCheckedChangeListener changeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                int bingo = 0;
                for (int i = 0; i < 5; i++) {
                    int countX = 0;
                    for (int j = 0; j < 5; j++) {
                        if (checkBoxes[i][j].isChecked()) {
                            countX++;
                            if (countX == 5) {
                                bingo++;
                            }
                        }
                    }
                }
                for (int i = 0; i < 5; i++) {
                    int countY = 0;
                    for (int j = 0; j < 5; j++) {
                        if (checkBoxes[j][i].isChecked()) {
                            countY++;
                            if (countY == 5) {
                                bingo++;
                            }
                        }
                    }
                }

                int cross = 0;
                for (int i = 0; i < 5; i++) {
                    if (checkBoxes[i][i].isChecked()) {
                        cross++;
                        if (cross == 5) {
                            bingo++;
                        }
                    }
                }

                int reverseCross = 0;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (i + j == 4 && checkBoxes[i][j].isChecked()) {
                            reverseCross++;
                            if (reverseCross == 5) {
                                bingo++;
                            }
                        }
                    }
                }
                String resultStr = String.format(Locale.KOREA, "%d 빙고", bingo);
                txtBingo.setText(resultStr);
            }
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                checkBoxes[i][j].setOnCheckedChangeListener(changeListener);
            }
        }
    }

    private void bindViews() {
        txtBingo = (TextView) findViewById(R.id.txtBingo);
        this.chkBox25 = (CheckBox) findViewById(R.id.chkBox25);
        this.chkBox24 = (CheckBox) findViewById(R.id.chkBox24);
        this.chkBox23 = (CheckBox) findViewById(R.id.chkBox23);
        this.chkBox22 = (CheckBox) findViewById(R.id.chkBox22);
        this.chkBox21 = (CheckBox) findViewById(R.id.chkBox21);
        this.chkBox20 = (CheckBox) findViewById(R.id.chkBox20);
        this.chkBox19 = (CheckBox) findViewById(R.id.chkBox19);
        this.chkBox18 = (CheckBox) findViewById(R.id.chkBox18);
        this.chkBox17 = (CheckBox) findViewById(R.id.chkBox17);
        this.chkBox16 = (CheckBox) findViewById(R.id.chkBox16);
        this.chkBox15 = (CheckBox) findViewById(R.id.chkBox15);
        this.chkBox14 = (CheckBox) findViewById(R.id.chkBox14);
        this.chkBox13 = (CheckBox) findViewById(R.id.chkBox13);
        this.chkBox12 = (CheckBox) findViewById(R.id.chkBox12);
        this.chkBox11 = (CheckBox) findViewById(R.id.chkBox11);
        this.chkBox10 = (CheckBox) findViewById(R.id.chkBox10);
        this.chkBox09 = (CheckBox) findViewById(R.id.chkBox09);
        this.chkBox08 = (CheckBox) findViewById(R.id.chkBox08);
        this.chkBox07 = (CheckBox) findViewById(R.id.chkBox07);
        this.chkBox06 = (CheckBox) findViewById(R.id.chkBox06);
        this.chkBox05 = (CheckBox) findViewById(R.id.chkBox05);
        this.chkBox04 = (CheckBox) findViewById(R.id.chkBox04);
        this.chkBox03 = (CheckBox) findViewById(R.id.chkBox03);
        this.chkBox02 = (CheckBox) findViewById(R.id.chkBox02);
        this.chkBox01 = (CheckBox) findViewById(R.id.chkBox01);
        this.btnReset = (Button) findViewById(R.id.btnReset);
        this.btnEdge = (Button) findViewById(R.id.btnEdge);
        this.btnCross = (Button) findViewById(R.id.btnCross);
        this.btnAll = (Button) findViewById(R.id.btnAll);
    }
}
