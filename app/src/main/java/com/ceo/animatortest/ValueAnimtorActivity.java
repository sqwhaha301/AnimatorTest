package com.ceo.animatortest;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValueAnimtorActivity extends AppCompatActivity {

    @Bind(R.id.button5)
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animtor);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.button5)
    public void onClick() {

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,60);
        valueAnimator.setDuration(1000);
        //设置改变监听
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取改变的值
                Integer value = (Integer) animation.getAnimatedValue();
                button5.setText(""+value);
            }
        });
        valueAnimator.start();
    }
}
