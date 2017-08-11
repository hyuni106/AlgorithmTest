package com.example.user.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.user.algorithmtest.adapter.GuguAdapter;
import com.example.user.algorithmtest.datas.GuguData;

import java.util.ArrayList;
import java.util.List;

public class Test03Activity extends AppCompatActivity {

    private android.widget.Button gugu2Btn;
    private android.widget.Button gugu3Btn;
    private android.widget.Button gugu4Btn;
    private android.widget.Button gugu5Btn;
    private android.widget.Button gugu6Btn;
    private android.widget.Button gugu7Btn;
    private android.widget.Button gugu8Btn;
    private android.widget.Button gugu9Btn;
    private android.widget.Button guguTotalBtn;
    private android.widget.ListView guguList;
    GuguAdapter guguAdapter;
    List<GuguData> guguDataList = new ArrayList<>();
    private android.widget.LinearLayout guguBtnLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test03);
        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {
        guguAdapter = new GuguAdapter(Test03Activity.this, guguDataList);
        guguList.setAdapter(guguAdapter);
    }

    private void printGugudan(int tag) {
        guguDataList.clear();
        if (tag == 0) {
            for (int i=2; i<10; i++) {
                for (int j=1; j<10; j++) {
                    guguDataList.add(new GuguData(i, j));
                }
            }
        } else {
            for (int i=1; i<10; i++) {
                guguDataList.add(new GuguData(tag, i));
            }
        }
        guguAdapter.notifyDataSetChanged();
    }

    private void setupEvents() {
        View.OnClickListener guguListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = Integer.parseInt(v.getTag().toString());
                // integer 클래스 : Wrapper 클래스
                // int를 감싼다 > int : 기본형 변수
                // 그외의 대문자로 시작하는 클래스 : 참조형 변수
                // Ex. 참조형 변수 : String > 클래스(변수, 메소드)
                // int > 클래스화 : Integer
                // double > 클래스화 : Double
                // parse > 분쇄하다 > 개발 : 분석하다
                // 날아온 자료를 분석해서 다르게 활용하고자 할 때 parse

                printGugudan(tag);
                // 클릭된 버튼에 달려있는 Tag를 기반으로
                // 몇단을 출력해야 하는지 판단하여 실행
            }
        };

        gugu2Btn.setOnClickListener(guguListener);
        gugu3Btn.setOnClickListener(guguListener);
        gugu4Btn.setOnClickListener(guguListener);
        gugu5Btn.setOnClickListener(guguListener);
        gugu6Btn.setOnClickListener(guguListener);
        gugu7Btn.setOnClickListener(guguListener);
        gugu8Btn.setOnClickListener(guguListener);
        gugu9Btn.setOnClickListener(guguListener);
        guguTotalBtn.setOnClickListener(guguListener);
    }

    private void bindViews() {
        this.gugu9Btn = (Button) findViewById(R.id.gugu9Btn);
        this.gugu8Btn = (Button) findViewById(R.id.gugu8Btn);
        this.gugu7Btn = (Button) findViewById(R.id.gugu7Btn);
        this.guguBtnLayout = (LinearLayout) findViewById(R.id.guguBtnLayout);
        this.gugu6Btn = (Button) findViewById(R.id.gugu6Btn);
        this.gugu5Btn = (Button) findViewById(R.id.gugu5Btn);
        this.gugu4Btn = (Button) findViewById(R.id.gugu4Btn);
        this.gugu3Btn = (Button) findViewById(R.id.gugu3Btn);
        this.gugu2Btn = (Button) findViewById(R.id.gugu2Btn);
        this.guguList = (ListView) findViewById(R.id.guguList);
        this.guguTotalBtn = (Button) findViewById(R.id.guguTotalBtn);
    }
}
