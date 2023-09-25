package com.example.homework02_program1;

public class SavedColor
{
    //red, green, blue, hex, background, text color
    private String red;
    private String green;
    private String blue;
    private String hex;

    public SavedColor()
    {

    }

    public SavedColor(String r, String g, String b, String h)
    {
        red = r;
        green = g;
        blue = b;
        hex = h;
    }

    //getters and setters
    public String getRed()
    {
        return red;
    }

    public void setRed(String r)
    {
        red = r;
    }

    public String getGreen()
    {
        return green;
    }

    public void setGreen(String g)
    {
        green = g;
    }

    public String getBlue()
    {
        return blue;
    }

    public void setBlue(String b)
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
