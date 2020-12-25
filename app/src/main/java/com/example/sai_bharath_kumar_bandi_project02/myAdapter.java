package com.example.sai_bharath_kumar_bandi_project02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends BaseAdapter {
    private ArrayList<Integer> carList;
    private Context context;
    private LayoutInflater layoutInflater;

    public myAdapter(ArrayList<Integer> carList, Context context) {
        this.carList = carList;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int i) {
        return carList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            view = layoutInflater.inflate(R.layout.items,viewGroup,false);
        }

        TextView image_name = view.findViewById(R.id.item_name);
        ImageView imageView = view.findViewById(R.id.item_view);
        image_name.setText(MainActivity.image_names[i]);
        imageView.setImageResource(carList.get(i));

        return view;
    }
}
