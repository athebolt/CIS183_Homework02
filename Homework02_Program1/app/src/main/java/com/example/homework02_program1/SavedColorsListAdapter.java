package com.example.homework02_program1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SavedColorsListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<SavedColor> listOfSavedColors;
    public SavedColorsListAdapter(Context c, ArrayList<SavedColor> ls)
    {
        //passed to class of Saved Color List Adapter from Main Activity
        context = c;
        listOfSavedColors = ls;
    }
    @Override
    public int getCount()
    {
        return listOfSavedColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfSavedColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        //connection of variables between custom xml and java files
        TextView tv_j_customCell_red = view.findViewById(R.id.tv_v_customCell_red);
        TextView tv_j_customCell_green = view.findViewById(R.id.tv_v_customCell_green);
        TextView tv_j_customCell_blue = view.findViewById(R.id.tv_v_customCell_blue);
        TextView tv_j_customCell_hex = view.findViewById(R.id.tv_v_customCell_hex);

        //saved color at pos i
        SavedColor savedColor = listOfSavedColors.get(i);

        //setting custom cell info
        tv_j_customCell_red.setText("Red: " + savedColor.getRed());
        tv_j_customCell_green.setText("Green: " + savedColor.getGreen());
        tv_j_customCell_blue.setText("Blue: " + savedColor.getBlue());
        tv_j_customCell_hex.setText("Hex: " + savedColor.getHex());
        view.setBackgroundColor(Color.parseColor("#" + savedColor.getHex()));

        //if the background is dark, set the text to white
        if(savedColor.getRed() < 128 && savedColor.getGreen() < 128 && savedColor.getBlue() < 128)
        {
            tv_j_customCell_red.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_customCell_green.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_customCell_blue.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_customCell_hex.setTextColor(Color.parseColor("#FFFFFF"));
        }

        //return the view created
        return view;
    }
}
