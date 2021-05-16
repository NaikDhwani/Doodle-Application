package com.cosc592.drawdoodle;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewClass extends RelativeLayout {

    final int DP;
    int width, height;
    CanvasView canvasView;
    TextView square;

    public ViewClass(Context context, int width, int height, View.OnTouchListener handler, String initialColor) {
        super(context);
        DP = (int)(getResources().getDisplayMetrics().density);

        this.width = width;
        this.height = height;

        canvasView = new CanvasView(context, initialColor);
        canvasView.setBackgroundColor(Color.parseColor("#ffffff"));
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        canvasView.setLayoutParams(params);
        canvasView.getColor(initialColor);
        addView(canvasView);

        square = new TextView(context);
        square.setBackgroundColor(Color.parseColor(initialColor));
        params = new RelativeLayout.LayoutParams(150*DP, 150*DP);
        params.setMargins(width + 110*DP, height + 180*DP,0*DP,0*DP);
        square.setLayoutParams(params);
        square.setOnTouchListener(handler);
        addView(square);
    }

    //Change Square Background and pass new color to the canvas paint
    public void changeColor(String newColor){
        square.setBackgroundColor(Color.parseColor(newColor));
        canvasView.getColor(newColor);
    }
}
