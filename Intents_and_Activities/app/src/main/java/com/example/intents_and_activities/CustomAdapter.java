package com.example.intents_and_activities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
public class CustomAdapter extends BaseAdapter {
    Context context;
    int flags[];
    String list[];
    LayoutInflater inflater;

    public CustomAdapter(Application context, String[] list, int[] flags) {

        this.context=context;
        this.list=list;
        this.flags=flags;
        inflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_listview, null);
        TextView text=(TextView) view.findViewById(R.id.txt_view);
        ImageView icon=(ImageView) view.findViewById(R.id.img_view);
        text.setText(list[position]);
        icon.setImageResource(flags[position]);
        return view;
    }
}
