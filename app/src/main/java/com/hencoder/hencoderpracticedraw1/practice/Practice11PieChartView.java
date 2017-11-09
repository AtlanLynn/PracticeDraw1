package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    final float arrPer[] = new float[]{10f,20f,5f,10f,40f,8f,7f};
    final int color[] = new int[]{Color.BLACK,Color.BLUE,Color.GREEN,Color.CYAN,
            Color.GRAY,Color.RED,Color.YELLOW};
    RectF arcRF = new RectF(100 ,50, 300, 250);
    RectF arcRF1 = new RectF(90 ,40, 290, 240);
    Paint paint = new Paint();
    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        paint.setAntiAlias(true);
        float CurrPer = 0f; //偏移角度
        float Percentage ; //当前所占比例
        for(int i=0; i<7; i++) {
            //将百分比转换为饼图显示角度
            Percentage = 360 * (arrPer[i]/ 100);
            Percentage = (float)(Math.round(Percentage *100))/100-2;
            paint.setColor(color[i]);
            //在饼图中显示所占比例
            canvas.drawArc(i==4?arcRF1:arcRF, CurrPer, Percentage, true, paint);

            //下次的起始角度
            CurrPer += Percentage+2;
        }
        paint.setColor(Color.WHITE);
        canvas.drawCircle(200,150,70,paint);
    }
}
