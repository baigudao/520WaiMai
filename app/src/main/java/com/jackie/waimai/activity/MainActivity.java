package com.jackie.waimai.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.waimai.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by baigu on 2016/4/15.
 */
public class MainActivity extends Activity {

    private ViewPager viewPager;
    private ImageView imageView_home;
    private ImageView imageView_order;
    private ImageView imageView_mine;
    private TextView textView_home;
    private TextView textView_order;
    private TextView textView_mine;
    private LayoutInflater layoutInflater;
    private List<View> views = new ArrayList<>();
    private PagerAdapter pagerAdapter;
    private LinearLayout ll1;
    private LinearLayout ll2;
    private LinearLayout ll3;
    private SwipeRefreshLayout refreshLayout;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 123) {
                refreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "刷新成功！", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        imageView_home = (ImageView) findViewById(R.id.home_n);
        imageView_order = (ImageView) findViewById(R.id.order_n);
        imageView_mine = (ImageView) findViewById(R.id.mine_n);

        textView_home = (TextView) findViewById(R.id.text_home);
        textView_order = (TextView) findViewById(R.id.text_order);
        textView_mine = (TextView) findViewById(R.id.text_mine);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        imageView_home.setImageResource(R.drawable.ic_tab_home_p);
                        imageView_order.setImageResource(R.drawable.ic_tab_order_n);
                        textView_home.setTextColor(Color.RED);
                        textView_order.setTextColor(Color.BLACK);
                        break;
                    case 1:
                        imageView_order.setImageResource(R.drawable.ic_tab_order_p);
                        imageView_home.setImageResource(R.drawable.ic_tab_home_n);
                        imageView_mine.setImageResource(R.drawable.ic_tab_mine_n);
                        textView_order.setTextColor(Color.RED);
                        textView_home.setTextColor(Color.BLACK);
                        textView_mine.setTextColor(Color.BLACK);
                        break;
                    case 2:
                        imageView_mine.setImageResource(R.drawable.ic_tab_mine_p);
                        imageView_home.setImageResource(R.drawable.ic_tab_home_n);
                        imageView_order.setImageResource(R.drawable.ic_tab_order_n);
                        textView_home.setTextColor(Color.BLACK);
                        textView_mine.setTextColor(Color.RED);
                        textView_order.setTextColor(Color.BLACK);
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

        View view1 = layoutInflater.inflate(R.layout.activity_home, null);
        View view2 = layoutInflater.inflate(R.layout.activity_order, null);
        View view3 = layoutInflater.inflate(R.layout.activity_mine, null);

        views.add(view1);
        views.add(view2);
        views.add(view3);

        pagerAdapter = new PagerAdapter() {
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
        };

        viewPager.setAdapter(pagerAdapter);


        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });


        refreshLayout = (SwipeRefreshLayout) view1.findViewById(R.id.swipe);
        refreshLayout.setColorSchemeResources(android.R.color.black);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = 123;
                        handler.sendMessage(message);
                    }
                }, 5000);
            }
        });
    }


    public void setting (View view){
        startActivity(new Intent(MainActivity.this,SettingActivity.class));
    }

    public void loginAndRegister(View view) {
        Intent intent = new Intent(MainActivity.this, LoginAndRegister.class);
        startActivity(intent);
    }


    public void sameClick(View view) {
        startActivity(new Intent(MainActivity.this, SameActivity.class));
    }

    public void sameClickFull(View view) {
        startActivity(new Intent(MainActivity.this, FuJinAndJingPingActivity.class));
    }

    public void goToLogin(View view) {
        startActivity(new Intent(MainActivity.this, LoginAndRegister.class));
    }

    public void logintext(View view) {
        startActivity(new Intent(MainActivity.this, LoginTextActivity.class));
    }

    public void toast(View view) {
        Toast.makeText(MainActivity.this, "没有推送消息", Toast.LENGTH_SHORT).show();
    }

    public void goTorestaurant(View view) {
        startActivity(new Intent(MainActivity.this, RestaurantActivity.class));
    }

    public void address (View view){
        startActivity(new Intent(MainActivity.this,AddressActivity.class));
    }

    public void feedback (View view){
        startActivity(new Intent(MainActivity.this,OpinionFeedbackActivity.class));
    }

    public void goToErWeiMa (View view){
    startActivity(new Intent(MainActivity.this,ErWeiMaActivity.class));
    }


    private long startTime = 0;

    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - startTime) > 3000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            startTime = currentTime;
        } else {
            finish();
        }
    }
}

