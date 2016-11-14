package com.ceo.animatortest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.button4)
    Button button4;
    @Bind(R.id.button6)
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.imageView, R.id.button3, R.id.button4,R.id.button6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:

//                setAnimation();
               setAnimator();
                break;
            case R.id.imageView:
                Toast.makeText(this, "iv click", Toast.LENGTH_SHORT).show();
                break;

            case R.id.button3://到菜单
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);

                break;
            case R.id.button4://到事件
                Intent intent1 = new Intent(MainActivity.this, EvenActivity.class);
                startActivity(intent1);

                break;
            case R.id.button6://到事件
                Intent intent2 = new Intent(MainActivity.this, ValueAnimtorActivity.class);
                startActivity(intent2);

                break;


        }
    }

    /**
     * 传统的Animation
     */
    public void setAnimation() {
        TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    /**
     * Animator中的ObjectAnimator
     */
    public void setAnimator() {
        /**
         * 第一个参数：设置动画的控件
         * 第二个参数：操作控件属性的名称
         * translationX:获取的是偏移量
         * translationY:
         * X:获取的移动到的绝对值
         * Y:
         *
         * rotation：旋转
         *
         *
         * 第三和第四：X和Y的移动距离
         *
         * setDuration（）设置动画持续时间
         * start()开启动画
         *
         * 如果是多种动画，那么动画将会同时执行，那么这就说明了start（）方法是一个异步的过程
         *
         */
//        ObjectAnimator.ofFloat(imageView,"translationX",0F,200F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationY",0F,200F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"rotation",0F,360F).setDuration(1000).start();


        /**
         * 对于多种动画的优化
         * 采用PropertyValuesHolder对动画属性和变化的值进行收集
         *
         * 然后再通过 ObjectAnimator.ofPropertyValuesHolder()方法，将
         * 要操作的控件以及为控件设置的多种动画属性作为参数进行传递，
         * 并开启实现动画效果。
         */
//        PropertyValuesHolder p1=PropertyValuesHolder.ofFloat("rotation",0F,360F);
//        PropertyValuesHolder p2=PropertyValuesHolder.ofFloat("translationX",0F,200F);
//        PropertyValuesHolder p3=PropertyValuesHolder.ofFloat("translationY",0F,200F);
//
//        ObjectAnimator.ofPropertyValuesHolder(imageView,p1,p2,p3).setDuration(1000).start();

        /**
         * 类似于AnimationSet的动画集合
         * AnimatorSet
         *
         * animatorSet.playTogether（）:进行同时动画效果
         *
         * animatorSet.playSequentially():按照设置的参数的顺序进行显示动画效果
         */

//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F).setDuration(1000);
//        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView,"translationY",0F,200F).setDuration(1000);
//        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView,"rotation",0F,360F).setDuration(1000);
//
//        AnimatorSet animatorSet = new AnimatorSet();
//
//        animatorSet.playTogether(animator1,animator2,animator3);
//        animatorSet.playSequentially(animator1,animator2,animator3);
//        animatorSet.setDuration(1000);
//        animatorSet.start();

        /**
         * 如何做到对属性动画进行详细的控制呢？
         *
         * 比如:  想让动画 先进行X,Y轴的同时移动，移动终止后，再进行旋转
         *animatorSet.play(animator1).with(animator2);//执行X,动画，同时让Y动画随着X动画一起执行
         *
         animatorSet.play(animator3).after(animator1);//在X或Y动画执行完之后，在进行旋转
         animatorSet.play(animator3).before(animator1);//或者在X动画之前执行
         */
//
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F).setDuration(1000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F).setDuration(1000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000);

        AnimatorSet animatorSet = new AnimatorSet();

        animatorSet.play(animator1).with(animator2);
        animatorSet.play(animator3).after(animator1);
//        animatorSet.play(animator3).before(animator1);
        animatorSet.setDuration(1000);
        animatorSet.start();
    }


}
