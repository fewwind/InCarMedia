package com.example.fewwind.myfirst.serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.fewwind.myfirst.R;
import com.example.fewwind.myfirst.view.BaseActivity;
import com.example.fewwind.myfirst.view.DragView;

public class SeriActivity extends BaseActivity {


    private static final String TAG ="tag" ;
    DragView view;
    CoordinatorLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seri);


        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("ser");

        cl = (CoordinatorLayout) findViewById(R.id.cl);
        view= (DragView) findViewById(R.id.id_tv_ser);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


//        Log.e(TAG, "onCreate: width--"+view.getMeasuredWidth()+"__Height--"+view.getMeasuredHeight() );
//        Log.e(TAG, "onCreate: width--"+view.getWidth()+"__Height--"+view.getHeight() );

        view.post(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, "onCreate: Measuredwidth--" + view.getMeasuredWidth() + "__MeasuredHeight--" + view.getMeasuredHeight());
                Log.e(TAG, "onCreate: width--"+view.getWidth()+"__Height--"+view.getHeight() );
            }
        });
        
        

    }

    @Override
    protected void onStart() {
        super.onStart();
        addView(SeriActivity.this, true);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        Log.e(TAG, "onCreate: Measuredwidth--" + view.getMeasuredWidth() + "__MeasuredHeight--" + view.getMeasuredHeight());
//        Log.e(TAG, "onCreate: width--"+view.getWidth()+"__Height--"+view.getHeight() );

    }
}
