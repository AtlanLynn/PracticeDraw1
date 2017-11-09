package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    //坐标原点位置
    private final int originX = 50;
    private final int originY = 280;
    //视图宽度
    private int width;
    //视图高度
    private int height;
    Paint paint = new Paint();
    Paint tPaint = new Paint();
    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        drawAxis(canvas, paint);
        drawColumn(canvas, paint);
    }


    private void drawAxis(Canvas canvas, Paint paint) {
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        canvas.drawLine(originX,originY,originX+width,originY,paint);//X轴
        canvas.drawLine(originX,originY,originX,0,paint);//Y轴
    }


    private void drawColumn(Canvas canvas, Paint paint) {
        paint.setColor(Color.GREEN);
        tPaint.setColor(Color.WHITE);
        tPaint.setTextSize(15);
        float cellWidth = width / 9;
        float leftX = originX+10;
        for(int i=0;i<7;i++){
            float leftTopY = originY - height * (i+1)* 10/100;
            canvas.drawRect(leftX, leftTopY, leftX + cellWidth, originY, paint);
            canvas.drawText("Text",leftX+5, originY+15,tPaint);
            leftX = leftX+cellWidth+10;
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec) - 100;
        height = MeasureSpec.getSize(heightMeasureSpec);
    }
}
