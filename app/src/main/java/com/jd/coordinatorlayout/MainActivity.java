package com.jd.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<String> titles;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        initData();
        initTabs(titles);
        initFragmens();
        bindViewpager();
    }

    private void initData() {
        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热点");
        titles.add("阳光宽屏");
        titles.add("北京");
        titles.add("社会");
        titles.add("娱乐");
        titles.add("问答");
        titles.add("图片");
        titles.add("科技");
        titles.add("汽车");
        titles.add("体育");
        titles.add("财经");
        titles.add("军事");
        titles.add("国际");
        titles.add("段子");
        titles.add("趣图");
        titles.add("美女");
        titles.add("健康");
        titles.add("正能量");
        titles.add("特卖");
        titles.add("房产");
        titles.add("中国新唱将");
    }

    private void bindViewpager() {
        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }

    private void initFragmens() {
        fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(new ListFragment());
        }
    }

    private void initTabs(List<String> titles) {
        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
    }

    public void checkin(View view) {
        Snackbar.make(view, "点击成功", Snackbar.LENGTH_SHORT).show();
    }

}


