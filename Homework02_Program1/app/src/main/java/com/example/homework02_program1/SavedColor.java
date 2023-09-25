package com.example.homework02_program1;

public class SavedColor
{
    //red, green, blue, hex, background, text color
    private int red;
    private int green;
    private int blue;
    private String hex;

    public SavedColor()
    {

    }

    //overloaded constructor
    public SavedColor(int r, int g, int b, String h)
    {
        red = r;
        green = g;
        blue = b;
        hex = h;
    }

    //getters and setters
    public int getRed()
    {
        return red;
    }

    public void setRed(int r)
    {
        red = r;
    }

    public int getGreen()
    {
        return green;
    }

    public void setGreen(int g)
    {
        green = g;
    }

    public int getBlue()
    {
        return blue;
    }

    public void setBlue(int b)
    {
        blue = b;
    }

    public String getHex()
    {
        return hex;
    }

    public void setHex(String h)
    {
        hex = h;
    }
}
