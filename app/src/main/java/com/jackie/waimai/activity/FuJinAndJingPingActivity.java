package com.jackie.waimai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.jackie.waimai.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/4.
 */
public class FuJinAndJingPingActivity extends Activity {

    private ViewPager viewPager;
    private TextView textView_fuJin;
    private TextView textView_jingPing;
    private LayoutInflater layoutInflater;
    private List<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_fuandjing);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        textView_fuJin = (TextView) findViewById(R.id.fuJin);
        textView_jingPing = (TextView) findViewById(R.id.jingPing);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        textView_fuJin.setTextColor(getResources().getColor(R.color.red));
                        textView_jingPing.setTextColor(getResources().getColor(R.color.black));
                        break;
                    case 1:
                        textView_fuJin.setTextColor(getResources().getColor(R.color.black));
                        textView_jingPing.setTextColor(getResources().getColor(R.color.red));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        layoutInflater = LayoutInflater.from(this);
        final View view1 = layoutInflater.inflate(getResources().getLayout(R.layout.activity_same1), null);
        View view2 = layoutInflater.inflate(getResources().getLayout(R.layout.activity_same1), null);
        views.add(view1);
        views.add(view2);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return views == null ? 0 : views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(views.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(views.get(position));
                return views.get(position);
            }
        });

    }

    public void fuJin(View view) {
        viewPager.setCurrentItem(0);
    }

    public void jingPing(View view) {
        viewPager.setCurrentItem(1);
    }


    public void wantWaiMai(View view) {
        startActivity(new Intent(FuJinAndJingPingActivity.this, TellActivity.class));
    }

    public void backUpToCanTing1(View view) {
        FuJinAndJingPingActivity.this.finish();
    }

}
