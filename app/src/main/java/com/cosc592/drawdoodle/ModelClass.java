package com.cosc592.drawdoodle;

public class ModelClass {
    String[] colors;
    int i;

    public ModelClass(){
        this.i =0;
        this.colors = new String[]{"#000000", "#ffffff", "#808080", "#ff0000", "#0000ff", "#ffff00", "#994C00"};
    }

    //Return Initial Black Color
    public String getInitialColor(){
        return colors[i];
    }

    //Return New Color
    public String getNewColor(){
        if (i < 6) i = i + 1;
        else i = 0;
        return colors[i];
    }
}
