package com.jackie.waimai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/13.
 */
public class ErWeiMaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_erweima);
    }

    public void backUp(View view) {
        ErWeiMaActivity.this.finish();
    }
}
