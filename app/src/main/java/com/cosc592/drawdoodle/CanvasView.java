package com.cosc592.drawdoodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;

public class CanvasView extends View {

    private Path path;
    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<String> paints = new ArrayList<>();
    private Paint paint, squarePaint;
    float x, y;
    String color;

    public CanvasView(Context context, String initColor) {
        super(context);
        path = new Path();
        paint = new Paint();
        squarePaint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(25f);
        paint.setColor(Color.parseColor(initColor));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < paths.size(); i++) {
            paint.setColor(Color.parseColor(paints.get(i)));
            canvas.drawPath(paths.get(i), paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                path.lineTo(x+10,y+10);
                paths.add(path);
                paints.add(color);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                paths.add(path);
                paints.add(color);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return true;
    }

    //get New Color
    public void getColor(String color){
        this.color = color;
        path = new Path();
    }
}
