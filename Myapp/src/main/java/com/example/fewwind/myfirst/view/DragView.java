package com.example.fewwind.myfirst.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by fewwind on 2015/11/27.
 */
public class DragView extends View {

    private Scroller mScroller;
    private static final String TAG ="tag" ;
    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initScroll(context);


        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: ");
            }
        });


        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.e(TAG, "onLongClick: " );
                return false;
            }
        });
    }

    private void initScroll(Context context) {
        this.setBackgroundColor(Color.RED);
        mScroller = new Scroller(context);
    }



    int lastX, lastY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = rawX;
                lastY = rawY;

                break;

            case MotionEvent.ACTION_MOVE:
                int offsetX = rawX - lastX;
                int offsetY = rawY - lastY;


                layout(getLeft() + offsetX,
                getTop() + offsetY,
                getRight() + offsetX,
                getBottom() + offsetY);

                lastX = rawX;
                lastY = rawY;
                break;

            case MotionEvent.ACTION_UP:


                break;


        }


        return true;
    }
}
