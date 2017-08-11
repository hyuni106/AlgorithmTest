package com.example.user.algorithmtest;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.algorithmtest.adapter.ChatAdapter;
import com.example.user.algorithmtest.datas.ChatData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Test05Activity extends BaseActivity {

    private android.widget.ListView listChat;
    private android.widget.EditText edtInput;
    private android.widget.Button btnSend;
    List<ChatData> chatDatas = new ArrayList<>();
    ChatAdapter chatAdapter;

    int questionNum = 471;

    int strikeCount = 0;
    int ballCount = 0;
    int inputCount = 0;
    int[] questionNumArray = new int[3];
    int[] inputNumArray = new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test05);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setValues() {
        makeQuestion();

        chatDatas.clear();
        chatAdapter = new ChatAdapter(mContext, chatDatas);
        listChat.setAdapter(chatAdapter);
    }

    @Override
    public void setupEvents() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtInput.getText().toString().length() == 3) {
                    checkAnswer();
                } else {
                    Toast.makeText(mContext, "세자리 숫자를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkAnswer() {
        String inputStr = edtInput.getText().toString();
        int inputNum = Integer.parseInt(inputStr);
        chatDatas.add(new ChatData(true, inputStr));
        chatAdapter.notifyDataSetChanged();
        listChat.smoothScrollToPosition(chatAdapter.getCount() - 1);
        edtInput.setText("");

        for (int i = 0; i < 3; i++) {
            inputNumArray[i] = inputNum % 10;
            inputNum /= 10;
        }

        strikeCount = 0;
        ballCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputNumArray[i] == questionNumArray[j]) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                inputCount++;
                if (strikeCount == 3) {
                    String autoReply = String.format(Locale.KOREA, "확인했습니다. %d번 시도했습니다.", inputCount);
                    chatDatas.add(new ChatData(false, autoReply));
                    chatDatas.add(new ChatData(false, "축하합니다. 클리어하셨습니다."));
                    btnSend.setEnabled(false);
                    edtInput.setEnabled(false);
                } else {
                    String autoReply = String.format(Locale.KOREA, "확인했습니다. %d번 시도했습니다.", inputCount);
                    chatDatas.add(new ChatData(false, autoReply));

                    String resultStr = String.format(Locale.KOREA, "%d 스트라이크, %d 볼 입니다.", strikeCount, ballCount);
                    chatDatas.add(new ChatData(false, resultStr));
                }
                chatAdapter.notifyDataSetChanged();
                listChat.smoothScrollToPosition(chatAdapter.getCount() - 1);
            }
        }, 500);
    }

    public void makeQuestion() {
        while (true) {
            questionNum = (int) (Math.random() * 900) + 100;
            for (int i = 0; i < 3; i++) {
                questionNumArray[i] = questionNum % 10;
                questionNum /= 10;
            }

            boolean checkZero = !(questionNumArray[0] == 0 || questionNumArray[1] == 0 || questionNumArray[2] == 0);
            boolean checkDupl = questionNumArray[0] != questionNumArray[1] &&
                    questionNumArray[1] != questionNumArray[2] &&
                    questionNumArray[2] != questionNumArray[0];

            if (checkZero && checkDupl) {
                break;
            }

        }
    }

    @Override
    public void bindViews() {
        this.btnSend = (Button) findViewById(R.id.btnSend);
        this.edtInput = (EditText) findViewById(R.id.edtInput);
        this.listChat = (ListView) findViewById(R.id.listChat);
    }
}
