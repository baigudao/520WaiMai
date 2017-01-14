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
 * Created by Administrator on 2016/11/13.
 */
public class RestaurantActivity extends Activity {

    private TextView tv_take;
    private TextView tv_has;
    private LayoutInflater layoutInflater;
    private List<View> views = new ArrayList<>();
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_restaurant);

        tv_take = (TextView) findViewById(R.id.take);
        tv_has = (TextView) findViewById(R.id.has);

        layoutInflater = LayoutInflater.from(this);
        View view1 = layoutInflater.inflate(R.layout.restaurant_item, null);
        View view2 = layoutInflater.inflate(R.layout.restaurant_item2, null);
        views.add(view1);
        views.add(view2);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        tv_take.setTextColor(getResources().getColor(R.color.red));
                        tv_has.setTextColor(getResources().getColor(R.color.black));
                        break;
                    case 1:
                        tv_take.setTextColor(getResources().getColor(R.color.black));
                        tv_has.setTextColor(getResources().getColor(R.color.red));
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return views.size();
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
        };
        viewPager.setAdapter(pagerAdapter);

        tv_take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        tv_has.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

    }


    public void backUp(View view) {
        RestaurantActivity.this.finish();
    }

    public void loginAndRegister (View view){
        startActivity(new Intent(RestaurantActivity.this,LoginAndRegister.class));
    }
}
