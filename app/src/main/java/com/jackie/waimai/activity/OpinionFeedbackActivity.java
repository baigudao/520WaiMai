package com.jackie.waimai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/13.
 */
public class OpinionFeedbackActivity extends Activity {

    private EditText editText_email;
    private EditText editText_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_opinionfeedback);

        editText_email = (EditText) findViewById(R.id.et_email);
        editText_content = (EditText) findViewById(R.id.et_opinion);
    }

    public void backUp(View view) {
        OpinionFeedbackActivity.this.finish();
    }

    public void sendFeedback(View view) {
        boolean email = editText_email.getText().length() > 0;
        boolean content = editText_content.getText().length() > 0;
        if (email & content) {
            Toast.makeText(OpinionFeedbackActivity.this, "你反馈的意见已经发送！", Toast.LENGTH_SHORT).show();
            OpinionFeedbackActivity.this.finish();
        } else if (!email & content) {
            Toast.makeText(OpinionFeedbackActivity.this, "联系方式不能为空！", Toast.LENGTH_SHORT).show();
        } else if (email & !content) {
            Toast.makeText(OpinionFeedbackActivity.this, "反馈意见不能为空！", Toast.LENGTH_SHORT).show();
        } else if (!email & !content) {
            Toast.makeText(OpinionFeedbackActivity.this, "请输入内容！", Toast.LENGTH_SHORT).show();
        }

    }
}
