package com.example.ontap_ketthucmon01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {


    private int layout;
    private Context context;
    private ArrayList<Person> arrayList;

    public ListAdapter(int layout, Context context, ArrayList<Person> arrayList) {
        this.layout = layout;
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return 0;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.list_item, null);

        TextView tvID = convertView.findViewById(R.id.tvEmpID);
        TextView tvName = convertView.findViewById(R.id.tvEmpName);
        TextView tvAge = convertView.findViewById(R.id.tvEmpAge);
        TextView tvGender = convertView.findViewById(R.id.tvEmpGender);

        Person person = arrayList.get(position);

        tvID.setText(String.valueOf(person.getId()));
        tvName.setText(person.getName());
        tvAge.setText(String.valueOf(person.getAge()));
        tvGender.setText(person.getGender());
        return convertView;
    }
}
