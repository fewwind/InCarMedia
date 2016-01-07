package com.example.fewwind.myfirst.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public  View mAnchor;
    public void addView (Context context,boolean show){
        mAnchor = ((Activity) context).findViewById(android.R.id.content);


        final ModeIncarVIew ll = new ModeIncarVIew(context);
//        final LinearLayout ll = new LinearLayout(context);
        Log.d("tag", "getSimpleName(): "+mAnchor.getClass().getSimpleName());

        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ((ViewGroup) mAnchor).addView(ll, ((ViewGroup) mAnchor).getChildCount(), lp);

//        if (mAnchor.getClass().getSimpleName().equals("FrameLayout"))
//        {
//            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
//                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            ((ViewGroup) mAnchor).addView(ll, ((ViewGroup) mAnchor).getChildCount(), lp);
//
//        } else
//        {
//            FrameLayout frameLayout = new FrameLayout(context);
//            ViewGroup parent = (ViewGroup) mAnchor.getParent();
//            parent.removeView(mAnchor);
//            parent.addView(frameLayout, mAnchor.getLayoutParams());
//            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
//                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            frameLayout.addView(mAnchor, lp);
//
//            frameLayout.addView(ll);
//        }

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ll == null) return;
                ViewGroup parent = (ViewGroup) ll.getParent();
                if (parent instanceof RelativeLayout || parent instanceof FrameLayout)
                {
                    parent.removeView(ll);
                } else
                {
                    parent.removeView(ll);
                    View origin = parent.getChildAt(0);
                    ViewGroup graParent = (ViewGroup) parent.getParent();
                    graParent.removeView(parent);
                    graParent.addView(origin, parent.getLayoutParams());
                }

            }
        });
    }

  /*  public void addView (Context context,boolean show){
         mAnchor = ((Activity) context).findViewById(android.R.id.content);


        LinearLayout ll = new LinearLayout(context);
        ll.setBackgroundColor(Color.RED);
        if (mAnchor.getClass().getSimpleName().equals("FrameLayout"))
        {
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ((ViewGroup) mAnchor).addView(ll, ((ViewGroup) mAnchor).getChildCount(), lp);

        } else
        {
            FrameLayout frameLayout = new FrameLayout(context);
            ViewGroup parent = (ViewGroup) mAnchor.getParent();
            parent.removeView(mAnchor);
            parent.addView(frameLayout, mAnchor.getLayoutParams());
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            frameLayout.addView(mAnchor, lp);

            frameLayout.addView(ll);
        }

    }*/

}
