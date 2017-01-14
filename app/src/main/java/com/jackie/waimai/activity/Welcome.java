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
import android.widget.ImageView;

import com.jackie.waimai.R;
import com.jackie.waimai.application.JackieApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baigu on 2016/4/14.
 */
public class Welcome extends Activity {

    private ViewPager viewPager;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private PagerAdapter pagerAdapter;
    private List<View> lists = new ArrayList<>();
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (JackieApplication.SKIP_WELCOME) {
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);


        viewPager = (ViewPager) findViewById(R.id.viewpager);

        imageView1 = (ImageView) findViewById(R.id.page1);
        imageView2 = (ImageView) findViewById(R.id.page2);
        imageView3 = (ImageView) findViewById(R.id.page3);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        imageView1.setImageResource(R.drawable.page_now);
                        imageView2.setImageResource(R.drawable.page);
                        break;
                    case 1:
                        imageView1.setImageResource(R.drawable.page);
                        imageView2.setImageResource(R.drawable.page_now);
                        imageView3.setImageResource(R.drawable.page);
                        break;
                    case 2:
                        imageView3.setImageResource(R.drawable.page_now);
                        imageView2.setImageResource(R.drawable.page);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        layoutInflater = LayoutInflater.from(this);
        View view1 = layoutInflater.inflate(R.layout.welcome1, null);
        View view2 = layoutInflater.inflate(R.layout.welcome2, null);
        View view3 = layoutInflater.inflate(R.layout.welcome3, null);
        lists.add(view1);
        lists.add(view2);
        lists.add(view3);
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return lists.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(lists.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(lists.get(position));
                return lists.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);
    }

    public void startButton(View view) {

        JackieApplication.SKIP_WELCOME = true;

        Intent intent = new Intent(Welcome.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
