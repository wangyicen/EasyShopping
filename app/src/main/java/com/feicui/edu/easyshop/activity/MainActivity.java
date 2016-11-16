package com.feicui.edu.easyshop.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.feicui.edu.easyshop.R;
import com.feicui.edu.easyshop.common.ActivityUtils;
import com.feicui.edu.easyshop.activity.me.MeFragment;
import com.feicui.edu.easyshop.activity.shop.ShopFragment;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @BindViews({R.id.main_shpping, R.id.main_message, R.id.main_tel_list, R.id.main_me})
    TextView[] textViews;

    @BindView(R.id.main_tool_bar)
    Toolbar toolbar;

    @BindView(R.id.main_title)
    TextView title;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

//    连续点击两次退出系统
    private boolean isExit = false;
    private ActivityUtils activityUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
//        设置actionbar
        setSupportActionBar(toolbar);
//        设置actionbar标题为空
        getSupportActionBar().setTitle("");

        initView();

    }

//    初始化界面，默认显示市场界面
    private void initView() {
        textViews[0].setSelected(true);

        viewPager.setAdapter(unLoginAdapter);
        viewPager.setCurrentItem(0);

//        设置ViewPager滑动监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (TextView textView : textViews){
                    textView.setSelected(false);
                }
//                设置toolbar标题，改变选中页面图标颜色
                title.setText(textViews[position].getText());
                textViews[position].setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

//    设置适配器
    private FragmentStatePagerAdapter unLoginAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
    @Override
    public Fragment getItem(int position) {
        switch (position){
//            市场
            case 0:
                return new ShopFragment();
//            消息
            case 1:
                return new UnLoginFragment();
//            通讯录
            case 2:
                return new UnLoginFragment();
//            我的
            case 3:
                return new MeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
};

    //    点击两次退出系统
    @Override
    public void onBackPressed() {

        if (!isExit){
            isExit = true;
            activityUtils.showToast("再摁一次退出系统~");
            viewPager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        }else {
            finish();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @OnClick({R.id.main_shpping, R.id.main_message, R.id.main_tel_list, R.id.main_me})
    public void onClick(TextView view){

        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setSelected(false);
            textViews[i].setTag(i);
        }
//        设置选择效果
        view.setSelected(true);
//      false表示瞬间切换，而不是平移切换
        viewPager.setCurrentItem((Integer) view.getTag(), false);
//      设置title
        title.setText(textViews[(int) view.getTag()].getText());
    }

}
