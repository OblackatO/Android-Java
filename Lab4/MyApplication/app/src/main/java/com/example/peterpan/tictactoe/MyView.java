package com.example.peterpan.tictactoe;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {


    char[] A = new char[]{' ', 'x', 'o', ' ', 'x', 'o', 'o', 'x', ' '};

    public MyView(Activity activity) {
        super(activity);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        //Vertical lines
        canvas.drawLine(getWidth()/3,10,getWidth()/3,getHeight()-10,paint);
        canvas.drawLine(getWidth()/3*2,10,getWidth()/3*2,getHeight()-10,paint);

        //Horizontal lines
        canvas.drawLine(10,getHeight()/3,getWidth()-10,getHeight()/3,paint);
        canvas.drawLine(10,getHeight()/3*2,getWidth()-10,getHeight()/3*2,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // ADD CODE HERE

        return super.onTouchEvent(event);
    }
}