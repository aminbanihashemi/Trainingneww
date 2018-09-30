package app.sematech.training.Fragments;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import app.sematech.training.R;

public class MyPagerActivity extends AppCompatActivity {
    SmartTabLayout indicator;
    ViewPager pager;
    MyPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pager);
        bind();
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
    }

    private void bind() {
        indicator = (SmartTabLayout) findViewById(R.id.indicator);
        pager = (ViewPager) findViewById(R.id.pager);
    }
}
