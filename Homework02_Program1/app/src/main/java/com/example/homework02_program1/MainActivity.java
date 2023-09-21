package com.example.homework02_program1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //Variables
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    TextView tv_j_hex;
    Button btn_j_saveColor;
    ListView lv_j_colors;
    String redHex;
    String greenHex;
    String blueHex;
    boolean isDarkRed;
    boolean isDarkGreen;
    boolean isDarkBlue;

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

        //set default to white
        redHex = "FF";
        greenHex = "FF";
        blueHex = "FF";

        isDarkRed = false;
        isDarkGreen = false;
        isDarkBlue = false;

        //function calls
        saveColorButtonEventHandler();
        redSeekbarEventHandler();
        greenSeekbarEventHandler();
        blueSeekbarEventHandler();
    }

    public void saveColorButtonEventHandler()
    {
        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Button Pressed","yes");
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

        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(Color.parseColor("#"+redHex+greenHex+blueHex));
    }

}