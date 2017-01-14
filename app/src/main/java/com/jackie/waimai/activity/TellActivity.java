package com.jackie.waimai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/4.
 */
public class TellActivity extends Activity {

    private EditText editText_tell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tell);

        editText_tell = (EditText) findViewById(R.id.et_tell);
    }


    public void backUpToCanTing(View view) {
        TellActivity.this.finish();
    }

    public void send(View view) {
        if (editText_tell.getText().length()> 0 ){
            Toast.makeText(TellActivity.this, "你的信息已发送！", Toast.LENGTH_SHORT).show();
            TellActivity.this.finish();
        }else {
            Toast.makeText(TellActivity.this, "输入的内容不能为空！", Toast.LENGTH_SHORT).show();
        }
    }
}
