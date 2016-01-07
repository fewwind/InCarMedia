package com.example.fewwind.myfirst.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.fewwind.myfirst.R;

/**
 * Created by fewwind on 2015/12/31.
 */
public class ModeIncarVIew extends FrameLayout {

    View space;

    public ModeIncarVIew(Context context) {
        this(context, null);
    }

    public ModeIncarVIew(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public ModeIncarVIew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.modle_incar,this);
        space = findViewById(R.id.id_view);

    }


}
