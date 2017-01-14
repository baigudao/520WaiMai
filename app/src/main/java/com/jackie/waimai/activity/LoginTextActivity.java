package com.jackie.waimai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/11.
 */
public class LoginTextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_logintext);
    }

    public void loginAndRegister(View view) {
        Intent intent = new Intent(LoginTextActivity.this, LoginAndRegister.class);
        startActivity(intent);
    }
}
