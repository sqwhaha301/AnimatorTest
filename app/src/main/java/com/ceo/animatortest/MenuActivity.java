package com.ceo.animatortest;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MenuActivity extends AppCompatActivity {
    @Bind(R.id.imageView_b)
    ImageView imageViewB;
    @Bind(R.id.imageView_c)
    ImageView imageViewC;
    @Bind(R.id.imageView_d)
    ImageView imageViewD;
    @Bind(R.id.imageView_e)
    ImageView imageViewE;
    @Bind(R.id.imageView_f)
    ImageView imageViewF;
    @Bind(R.id.imageView_g)
    ImageView imageViewG;
    @Bind(R.id.imageView_h)
    ImageView imageViewH;
    @Bind(R.id.imageView_a)
    ImageView imageViewA;


    //初始化菜单按钮集合
    private List<ImageView> imageViewList= new ArrayList<ImageView>();
    //菜单的开和关闭的状态标记
    private boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        //将ImageView添加进行集合
        imageViewList.add(imageViewA);
        imageViewList.add(imageViewB);
        imageViewList.add(imageViewC);
        imageViewList.add(imageViewD);
        imageViewList.add(imageViewE);
        imageViewList.add(imageViewF);
        imageViewList.add(imageViewG);
        imageViewList.add(imageViewH);

    }


    @OnClick({R.id.imageView_b, R.id.imageView_c, R.id.imageView_d, R.id.imageView_e, R.id.imageView_f, R.id.imageView_g, R.id.imageView_h, R.id.imageView_a})
    public void onClick(View view) {
        switch (view.getId()) {
            //点击主菜单按钮，显示展示子菜单动画
            case R.id.imageView_a:
                if(flag)
                {
                    startAnim();

                }
                else
                {
                    closeAnim();

                }
                break;

            //点击其他子菜单
            default:
                Toast.makeText(this,"点击",Toast.LENGTH_SHORT).show();
                break;
        }
    }


    //回收子菜单的方法
    private void closeAnim() {
        for (int i = 1; i < imageViewList.size() ; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",i*100,0F);
            animator.setDuration(500);
            animator.setStartDelay(i*300);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
            flag=true;
        }

    }

    //依次展开子菜单方法
    private void startAnim() {
        //遍历除了第一个主菜单按钮，其他的子菜单按钮，所以i从1开始
        //垂直展示子菜单,并且使用setStartDelay()方法实现依次弹出子菜单的效果
        //然后使用插值器setInterpolator(new BounceInterpolator())实现一个自由落体的效果
        //
        for (int i = 1; i < imageViewList.size() ; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),"translationY",0F,i*100);
            animator.setDuration(500);
            animator.setStartDelay(i*300);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
            flag=false;
        }
    }
}
