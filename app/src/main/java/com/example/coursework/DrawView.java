package com.example.coursework;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawView extends View {
    private int operand1;
    private int operand2;
    private Paint paint;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
    }

    public void setOperands(int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        invalidate(); // Redraw the view
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Calculate the side of the square
        int side = operand1 * operand2;

        // Set up the paint
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        // Draw the square in the center of the canvas
        int x = getWidth() / 2 - side / 2;
        int y = getHeight() / 2 - side / 2;

        canvas.drawRect(x, y, x + side, y + side, paint);
    }
}

