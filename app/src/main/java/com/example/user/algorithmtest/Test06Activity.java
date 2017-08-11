package com.example.user.algorithmtest;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Test06Activity extends BaseActivity {

    private android.widget.TextView remainMoneyTxt;
    private android.widget.TextView myNum01;
    private android.widget.TextView myNum02;
    private android.widget.TextView myNum03;
    private android.widget.TextView myNum04;
    private android.widget.TextView myNum05;
    private android.widget.TextView myNum06;
    private android.widget.TextView okNum01;
    private android.widget.TextView okNum02;
    private android.widget.TextView okNum03;
    private android.widget.TextView okNum04;
    private android.widget.TextView okNum05;
    private android.widget.TextView okNum06;
    private android.widget.Button startBtn;
    private TextView earnMoneyTxt;
    private TextView bonusNumTxt;
    Handler mHandler = new Handler();
    // Handler > 어떤 업무를 수행해주는 프로세스 > 가상의 CPU
    // 일반적인 프로그래밍에서는 Thread
    int remainMoney = 10000000;
    long earnMoney = 0;
    int[] correctLottoNum = new int[6];
//int[] correctLottoNum = {3, 9, 12, 29, 31, 42};
    int bonusNum = 0;
    int[] myNum = {6, 9, 19, 29, 34, 43};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test06);
        bindViews();
        setupEvents();
        setValues();
    }

    // Runnable > Handler가 수행하게 될 작업 내역
    // Runnable 내부의 run 메소드가 실제로 수행할 작업을 적으면 된다
    // OnClickListener 내부의 conClick메소드에 실제로 눌리면 할 일을 적는것과
    // 코드의 구조가 거의 유사하고 이해하는 방식도 비슷
    Runnable doLottoRun = new Runnable() {
        @Override
        public void run() {
            // 남은 금액이 있을 경우를 검사
            if (remainMoney > 0) {
                // 일단 1000원 소모
                remainMoney -= 1000;
                // 남은 금액을 , 붙이며 String 만들어줌
                String moneyStr = String.format(Locale.KOREA, "%,d원", remainMoney);
                // 남은 금액을 화면에 표시
                remainMoneyTxt.setText(moneyStr);

                for (int i = 0; i < 6; i++) {
                    // 1~45 숫자 여섯개를 랜덤으로 생성
                    // Math.random 활용
                    while (true) {
                        correctLottoNum[i] = (int) (Math.random() * 45) + 1;
                        boolean isDupl = false;
                        for (int j = 0; j < i; j++) {
                            if (correctLottoNum[i] == correctLottoNum[j]) {
                                isDupl = true;
                            }
                        }
                        if (!isDupl) {
                            break;
                        }
                    }
                }

                for (int i = correctLottoNum.length; i > 0; i--) {
                    for (int j = 0; j < i - 1; j++) {
                        if (correctLottoNum[j] > correctLottoNum[j + 1]) {
                            int tmp = correctLottoNum[j];
                            correctLottoNum[j] = correctLottoNum[j + 1];
                            correctLottoNum[j + 1] = tmp;
                        }
                    }
                }

                // 보너스 번호 생성
                while (true) {
                    bonusNum = (int) (Math.random() * 45) + 1;
                    boolean isDupl = false;
                    for (int i = 0; i < 6; i++) {
                        if (bonusNum == correctLottoNum[i]) {
                            isDupl = true;
                        }
                    }
                    if (!isDupl) {
                        break;
                    }
                }

                okNum01.setText(correctLottoNum[0] + "");
                okNum02.setText(correctLottoNum[1] + "");
                okNum03.setText(correctLottoNum[2] + "");
                okNum04.setText(correctLottoNum[3] + "");
                okNum05.setText(correctLottoNum[4] + "");
                okNum06.setText(correctLottoNum[5] + "");
                bonusNumTxt.setText(bonusNum + "");

                int okNumCount = 0;

                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (myNum[i] == correctLottoNum[j]) {
                            okNumCount++;
                        }
                    }
                }

                if (okNumCount == 6) {
                    earnMoney += 2900000000L;
                } else if (okNumCount == 5) {
                    boolean bonusOk = false;
                    for (int i=0; i<6; i++) {
                        if (bonusNum == myNum[i]) {
                            bonusOk = true;
                        }
                    }
                    if (bonusOk) {
                        earnMoney += 65000000;
                    } else {
                        earnMoney += 1650000;
                    }
                } else if (okNumCount == 4) {
                    earnMoney += 50000;
                } else if (okNumCount == 3) {
                    remainMoney += 5000;
                }

                String earnMoneyStr = String.format(Locale.KOREA, "%,d원 획득!", earnMoney);
                earnMoneyTxt.setText(earnMoneyStr);

                // mHandler에게 doLottoRun 다시 실행
                if (okNumCount < 6) {
                    mHandler.post(doLottoRun);
                }
            }
        }
    };

    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(doLottoRun);
    }

    @Override
    public void setValues() {
        String startMoney = String.format(Locale.KOREA, "%,d원", remainMoney);
        remainMoneyTxt.setText(startMoney);
    }

    @Override
    public void setupEvents() {
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.post(doLottoRun);
            }
        });
    }

    @Override
    public void bindViews() {
        this.startBtn = (Button) findViewById(R.id.startBtn);
        this.earnMoneyTxt = (TextView) findViewById(R.id.earnMoneyTxt);
        this.bonusNumTxt = (TextView) findViewById(R.id.bonusNumTxt);
        this.okNum06 = (TextView) findViewById(R.id.okNum06);
        this.okNum05 = (TextView) findViewById(R.id.okNum05);
        this.okNum04 = (TextView) findViewById(R.id.okNum04);
        this.okNum03 = (TextView) findViewById(R.id.okNum03);
        this.okNum02 = (TextView) findViewById(R.id.okNum02);
        this.okNum01 = (TextView) findViewById(R.id.okNum01);
        this.myNum06 = (TextView) findViewById(R.id.myNum06);
        this.myNum05 = (TextView) findViewById(R.id.myNum05);
        this.myNum04 = (TextView) findViewById(R.id.myNum04);
        this.myNum03 = (TextView) findViewById(R.id.myNum03);
        this.myNum02 = (TextView) findViewById(R.id.myNum02);
        this.myNum01 = (TextView) findViewById(R.id.myNum01);
        this.remainMoneyTxt = (TextView) findViewById(R.id.remainMoneyTxt);
    }

}
