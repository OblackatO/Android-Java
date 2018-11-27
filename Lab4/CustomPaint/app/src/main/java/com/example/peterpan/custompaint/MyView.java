package com.example.peterpan.custompaint;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyView extends View {

    Activity activity;

    public MyView(Activity activity){
        super(activity);
        this.activity = activity;
        this.setBackgroundColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Paint paint = new Paint();

        paint.setColor(Color.RED);
        canvas.drawRect(new Rect(10,10,getWidth()/2, getHeight()/2),paint);

        paint.setColor(Color.GREEN);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2,paint);

        paint.setColor(Color.YELLOW);
        for(int i=0; i<20; i++){
            canvas.drawLine(i*getWidth()/20, getHeight(), getWidth(), i*getHeight()/20, paint);
        }
    }
}
