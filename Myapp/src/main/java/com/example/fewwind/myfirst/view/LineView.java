package com.example.fewwind.myfirst.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by fewwind on 2015/12/31.
 */
public class LineView extends View {

    Paint paint1 ;
    Paint paint2 ;
    Paint paint3 ;
    Paint paint4 ;
    Paint paint5 ;

    int mWidth;
    int mHeight;


    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint5 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        paint2.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        paint3.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        paint4.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        paint5.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint5.setStyle(Paint.Style.STROKE);
        mWidth = getWidth();
        mHeight = getHeight();

        Log.i("tag", "onMeasure: width--" + mWidth + "height++++" + mHeight);
        canvas.drawRect(mWidth / 3f, mHeight / 3f, mWidth * 2 / 3f, mHeight * 2 / 3, paint1);

        canvas.drawLine(0, 0, mWidth / 3, mHeight / 3, paint1);
        canvas.drawLine(mWidth * 2 / 3, mHeight / 3, mWidth, 0, paint1);
        canvas.drawLine(0, mHeight, mWidth / 3, mHeight*2 / 3, paint1);
        canvas.drawLine(mWidth * 2 / 3,mHeight*2 / 3,mWidth,mHeight,paint1);

    }
}
