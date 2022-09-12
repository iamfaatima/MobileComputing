package com.example.quranapplistview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter31 extends ArrayAdapter<String> {

    public ListAdapter31(Context context, ArrayList<String> sal)
    {
        super(context, R.layout.list_item, sal);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent)
    {
        String sm = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item31,parent,false);

        }

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        TextView asi = convertView.findViewById(R.id.SuratIndextv);
        TextView asn = convertView.findViewById(R.id.UrSurattv);

        position = position + 1;

        try {
            Log.d("in", sm);
            asi.setText(String.valueOf(position));
            asn.setText(sm);
        }
        catch (Exception e)
        {
            Log.d("in", "Error");
        }

        return convertView;

    }
}
