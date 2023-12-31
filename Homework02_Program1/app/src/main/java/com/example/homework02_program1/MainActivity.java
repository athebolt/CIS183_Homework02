package com.example.homework02_program1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //GUI id variables
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    TextView tv_j_hex;
    Button btn_j_saveColor;
    ListView lv_j_colors;

    //Variables
    int red;
    int green;
    int blue;
    String redHex;
    String greenHex;
    String blueHex;
    boolean isDarkRed;
    boolean isDarkGreen;
    boolean isDarkBlue;
    ArrayList<SavedColor> listOfSavedColors;
    SavedColorsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establishing connections
        tv_j_red        = findViewById(R.id.tv_v_red);
        tv_j_green      = findViewById(R.id.tv_v_green);
        tv_j_blue       = findViewById(R.id.tv_v_blue);
        sb_j_red        = findViewById(R.id.sb_v_red);
        sb_j_green      = findViewById(R.id.sb_v_green);
        sb_j_blue       = findViewById(R.id.sb_v_blue);
        tv_j_hex        = findViewById(R.id.tv_v_hex);
        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_colors     = findViewById(R.id.lv_v_colors);

        //allows list to be clicked
        lv_j_colors.setClickable(true);

        //set default to white
        red = 255;
        green = 255;
        blue = 255;
        redHex = "FF";
        greenHex = "FF";
        blueHex = "FF";

        isDarkRed = false;
        isDarkGreen = false;
        isDarkBlue = false;

        //create list
        listOfSavedColors = new ArrayList<SavedColor>();

        //Event Handlers
        saveColorButtonEventHandler();
        redSeekbarEventHandler();
        greenSeekbarEventHandler();
        blueSeekbarEventHandler();
        listClickEventHandler();

        //display list
        fillListView();
    }

    public void saveColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Log.d("Button Pressed","yes");

                //create new saved color
                SavedColor savedColor = new SavedColor(red, green, blue, redHex+greenHex+blueHex);

                //add saved color to list
                listOfSavedColors.add(savedColor);

                //reset seekbars to default and background to white
                resetView();

                //update list
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void redSeekbarEventHandler()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_red.setText("Red:    " + i);

                red = i;

                if(i < 128)
                {
                    isDarkRed = true;
                }
                else
                {
                    isDarkRed = false;
                }

                redHex = Integer.toHexString(i).toUpperCase();

                hexRepresentation();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void greenSeekbarEventHandler()
    {
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_green.setText("Green: " + i);

                green = i;

                if(i < 128)
                {
                    isDarkGreen = true;
                }
                else
                {
                    isDarkGreen = false;
                }

                greenHex = Integer.toHexString(i).toUpperCase();

                hexRepresentation();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void blueSeekbarEventHandler()
    {
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_blue.setText("Blue:   " + i);

                blue = i;

                if(i < 128)
                {
                    isDarkBlue = true;
                }
                else
                {
                    isDarkBlue = false;
                }

                blueHex = Integer.toHexString(i).toUpperCase();

                hexRepresentation();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void hexRepresentation()
    {
        if(redHex.length() == 1)
        {
            redHex = "0" + redHex;
        }

        if(greenHex.length() == 1)
        {
            greenHex = "0" + greenHex;
        }

        if(blueHex.length() == 1)
        {
            blueHex = "0" + blueHex;
        }

        //if the display is dark, set the text to white
        if(isDarkRed && isDarkGreen && isDarkBlue)
        {
            tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_hex.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            tv_j_red.setTextColor(Color.parseColor("#000000"));
            tv_j_green.setTextColor(Color.parseColor("#000000"));
            tv_j_blue.setTextColor(Color.parseColor("#000000"));
            tv_j_hex.setTextColor(Color.parseColor("#000000"));
        }

        tv_j_hex.setText("Hex Representation:   " + redHex + greenHex + blueHex);

        //update background color
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor("#"+redHex+greenHex+blueHex));
    }

    public void resetView()
    {
        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);

        tv_j_red.setText("Red:    255");
        tv_j_green.setText("Green: 255");
        tv_j_blue.setText("Blue:   255");
        tv_j_hex.setText("Hex Representation:   FFFFFF");

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor((Color.parseColor("#FFFFFF")));
    }

    public void fillListView()
    {
        adapter = new SavedColorsListAdapter(this, listOfSavedColors);

        //list view now has adapter "adapter"
        lv_j_colors.setAdapter(adapter);
    }

    public void listClickEventHandler()
    {
        lv_j_colors.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //Log.d("List clicked", "test");

                //if the user clicks on an object in the list
                //then change the seekbars to the list contents
                sb_j_red.setProgress(listOfSavedColors.get(i).getRed());
                sb_j_green.setProgress(listOfSavedColors.get(i).getGreen());
                sb_j_blue.setProgress(listOfSavedColors.get(i).getBlue());
            }
        });
    }
}