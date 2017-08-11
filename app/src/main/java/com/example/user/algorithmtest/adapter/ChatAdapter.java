package com.example.user.algorithmtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.algorithmtest.R;
import com.example.user.algorithmtest.datas.ChatData;

import java.util.List;

/**
 * Created by user on 2017-08-11.
 */

// Adapter 만드는 이유 > Data클래스를 layout에 입혀서 ListView에 한줄한줄 뿌려주기 위함
public class ChatAdapter extends ArrayAdapter<ChatData> {
    Context mContext;
    List<ChatData> mList;
    LayoutInflater inf;

    public ChatAdapter(Context context, List<ChatData> list) {
        super(context, R.layout.chating_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.chating_list_item, null);
        }

        // setAdapter를 통해 연결까지 되는걸 확인하고 나면
        // getCount 메소드는 지워버리고 실제 내용이 출력될 수 있도록 getView 내부를 수정

        ChatData data = mList.get(position);
        // 위치에 맞는 클래스 가져욤

        LinearLayout myMessageLayout = (LinearLayout) row.findViewById(R.id.myMessageLayout);
        LinearLayout cpuMessageLayout = (LinearLayout) row.findViewById(R.id.cpuMessageLayout);
        TextView myMessageTxt = (TextView) row.findViewById(R.id.myMessageTxt);
        TextView cpuMessageTxt = (TextView) row.findViewById(R.id.cpuMessageTxt);
        // 필요한 뷰들을 row로부터 찾아서 바인딩

        if (data.isSentByMe()) {
            myMessageLayout.setVisibility(View.VISIBLE);
            cpuMessageLayout.setVisibility(View.GONE);
            myMessageTxt.setText(data.getMessageText());
        } else {
            myMessageLayout.setVisibility(View.GONE);
            cpuMessageLayout.setVisibility(View.VISIBLE);
            cpuMessageTxt.setText(data.getMessageText());
        }

        return row;
    }

}
