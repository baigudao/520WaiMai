package com.jackie.waimai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/3.
 */
public class SameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_same);


    }


    public void wantWaiMai(View view) {
        startActivity(new Intent(SameActivity.this, TellActivity.class));
    }

    public void backUpToCanTing1(View view) {
        SameActivity.this.finish();
    }

}
