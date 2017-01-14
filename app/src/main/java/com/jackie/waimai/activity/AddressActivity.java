package com.jackie.waimai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/13.
 */
public class AddressActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_address);
    }

    public void backUp(View view) {
        AddressActivity.this.finish();
    }

    public void addAddress(View view) {
        startActivity(new Intent(AddressActivity.this, AddAddressActivity.class));
    }
}
