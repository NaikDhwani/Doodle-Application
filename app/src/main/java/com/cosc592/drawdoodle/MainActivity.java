package com.cosc592.drawdoodle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ModelClass model;
    ViewClass viewClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ModelClass();
        String initialColor = model.getInitialColor();

        int DP = (int)(getResources().getDisplayMetrics().density);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels/DP;
        int height = displayMetrics.heightPixels/DP;

        TouchHandler handler = new TouchHandler();
        viewClass = new ViewClass(this,width,height,handler, initialColor);

        setContentView(viewClass);
    }

    //Color box Touch handler
    private class TouchHandler implements View.OnTouchListener
    {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                String currentColor = model.getNewColor();
                viewClass.changeColor(currentColor);
            }
            return true;
        }
    }
}
