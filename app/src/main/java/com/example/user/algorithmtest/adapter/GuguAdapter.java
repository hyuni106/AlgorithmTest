package com.example.user.algorithmtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.user.algorithmtest.R;
import com.example.user.algorithmtest.datas.GuguData;

import java.util.List;
import java.util.Locale;

/**
 * Created by user on 2017-08-10.
 */

public class GuguAdapter extends ArrayAdapter<GuguData> {
    Context mContext;
    List<GuguData> mList;
    LayoutInflater inf;

    public GuguAdapter(Context context, List<GuguData> list) {
        super(context, R.layout.gugudan_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.gugudan_list_item, null);
        }

        GuguData data = mList.get(position);
        TextView resultTxt = (TextView) row.findViewById(R.id.resultTxt);

        String result = String.format(Locale.KOREA, "%d X %d = %d", data.getDan(), data.getNum(), data.getNum()*data.getDan());
        resultTxt.setText(result);

        return row;
    }
}
