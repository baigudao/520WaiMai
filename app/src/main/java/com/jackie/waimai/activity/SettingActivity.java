package com.jackie.waimai.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/13.
 */
public class SettingActivity extends Activity {

    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_setting);
        toggleButton = (ToggleButton) findViewById(R.id.tb);
    }

    public void backUpToCanTing1(View view) {
        SettingActivity.this.finish();
    }


    public void banben(View view) {
        Toast.makeText(SettingActivity.this, "此版本已经是最新的啦！", Toast.LENGTH_SHORT).show();
    }

    public void telephone(View view) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:15927470687"));
        startActivity(intent);
    }

    public void loginAndRegister(View view) {
        startActivity(new Intent(SettingActivity.this, LoginAndRegister.class));
    }
}
