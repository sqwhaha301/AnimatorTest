package com.ceo.animatortest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EvenActivity extends AppCompatActivity {

    @Bind(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button2)
    public void onClick() {

        ObjectAnimator animator = new ObjectAnimator().ofFloat(button2,"alpha",0F,1F);
        animator.setDuration(1000);

//        //系统提供了属性动画的监听事件的适配器，可提供选择需要的事件
//        animator.addListener(new AnimatorListenerAdapter() {
//            //只重写了动画结束的监听事件
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//                Intent intent = new Intent(EvenActivity.this,MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });



        //这监听需要重写所有的事件方法
        animator.addListener(new Animator.AnimatorListener() {
            /**
             * 动画开始
             * @param animation
             */
            @Override
            public void onAnimationStart(Animator animation) {

            }
            /**
             * 动画结束
             * @param animation
             */
            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(EvenActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
            /**
             * 动画取消
             * @param animation
             */
            @Override
            public void onAnimationCancel(Animator animation) {

            }
            /**
             * 动画重复
             * @param animation
             */
            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();

    }
}
