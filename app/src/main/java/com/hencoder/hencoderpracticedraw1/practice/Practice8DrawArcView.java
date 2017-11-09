package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    Paint paint = new Paint();
    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL); // 填充模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(100, 100, 300, 300, -110, 100, true, paint); // 绘制扇形
            canvas.drawArc(100, 100, 300, 300, 20, 140, false, paint); // 绘制弧形
            paint.setStyle(Paint.Style.STROKE); // 画线模式
            canvas.drawArc(100, 100, 300, 300, 180, 90, false, paint); // 绘制不封口的弧形
        }
    }
}
