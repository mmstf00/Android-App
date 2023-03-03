package com.example.coursework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class SquareView extends View {

    private int side;
    private int color;

    public SquareView(Context context, int side, int color) {
        super(context);
        this.side = side;
        this.color = color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        int halfSide = side / 2;

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        canvas.drawRect(centerX - halfSide, centerY - halfSide, centerX + halfSide, centerY + halfSide, paint);
    }
}
