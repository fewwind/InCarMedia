package com.example.fewwind.myfirst;

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.internal.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.fewwind.myfirst.Util.HttpUtils;
import com.example.fewwind.myfirst.serializable.Book;
import com.example.fewwind.myfirst.serializable.PerActivity;
import com.example.fewwind.myfirst.serializable.Person;
import com.example.fewwind.myfirst.serializable.SeriActivity;
import com.example.fewwind.myfirst.view.BaseActivity;

import java.lang.reflect.Field;

import me.drakeet.materialdialog.MaterialDialog;

public class MainActivity extends BaseActivity {


    private FloatingActionButton fabBtn;
    private boolean open = true;
ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);

        fabBtn = (FloatingActionButton) findViewById(R.id.id_fab);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addView(MainActivity.this, true);
    }



    public void remove()
    {

    }


    public void show() {
        MaterialDialog mMaterialDialog = new MaterialDialog(this);

        mMaterialDialog.show();
    }



    public void Serializable(View view) {

        Intent intent = new Intent(this, SeriActivity.class);
        intent.putExtra("ser",new Person("gulong","88"));
        startActivity(intent);

    }
    public void Parcelable(View view) {
        Intent intent = new Intent(this, PerActivity.class);
        intent.putExtra("pac",new Book("欢乐英雄","古龙",2015));
        startActivity(intent);
/*        PopupMenu menu = new PopupMenu(MainActivity.this,view);

        menu.getMenuInflater().inflate(R.menu.pop_menu, menu.getMenu());

        makePopForceShowIcon(menu);
        menu.show();*/

        Log.e("tag", "Parcelable: " + mAnchor);
//    super.addView(MainActivity.this, true);

        Matrix matrix=new Matrix();
        iv.setScaleType(ImageView.ScaleType.MATRIX); //required
        matrix.postRotate((float) 30, iv.getWidth() / 2, iv.getHeight() / 2);
        iv.setImageMatrix(matrix);
         String NetUrlBase = "http://dev.in-carmedia.com/";
         final String doLoginUrl = NetUrlBase + "/system/dologin";

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpUtils.postReq(doLoginUrl,"deviceid=1231310");
            }
        }).start();

    }



    /**
     *设置悬浮按钮显示和隐藏的方法
     */
    private void fabToggle() {
        if (open) {
            TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                    0.5f, Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                    -1.0f);
            mHiddenAction.setDuration(1500);
            fabBtn.startAnimation(mHiddenAction);
            final ScaleAnimation animation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(200);//设置动画持续时间
            fabBtn.setAnimation(animation);


            fabBtn.setVisibility(View.GONE);
            open = false;
        } else {
            TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                    -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
            mShowAction.setDuration(1500);
            // fabBtn.startAnimation(mShowAction);

            final ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(200);//设置动画持续时间
            fabBtn.setAnimation(animation);
            fabBtn.setVisibility(View.VISIBLE);
            open = true;
        }
    }


    //使用反射让popupMenu 显示菜单icon
    private void makePopForceShowIcon(PopupMenu popupMenu) {
        //d,a[f
        try {
            Field mFieldPopup = popupMenu.getClass().getDeclaredField("mPopup");
            mFieldPopup.setAccessible(true);
            MenuPopupHelper mPopup = (MenuPopupHelper) mFieldPopup.get(popupMenu);
            mPopup.setForceShowIcon(true);
        } catch (Exception e) {

        }
    }

    /**
     *material dialog
     */
    public void show0() {

        final MaterialDialog mMaterialDialog = new MaterialDialog(this);
        mMaterialDialog.setTitle("MaterialDialog");
        mMaterialDialog.setMessage("Hello world!");
        mMaterialDialog.setPositiveButton("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
            }
        });
        mMaterialDialog.setNegativeButton("CANCEL", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
            }
        });

        mMaterialDialog.show();
    }

}
