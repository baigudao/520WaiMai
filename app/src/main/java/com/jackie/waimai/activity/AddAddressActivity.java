package com.jackie.waimai.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jackie.waimai.R;

/**
 * Created by Administrator on 2016/11/13.
 */
public class AddAddressActivity extends Activity {

    private Button button_save;
    private EditText editText_phone;
    private EditText editText_name;
    private EditText editText_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_addaddress);

        button_save = (Button) findViewById(R.id.btn_save);
        editText_address = (EditText) findViewById(R.id.et_address);
        editText_name = (EditText) findViewById(R.id.et_name);
        editText_phone = (EditText) findViewById(R.id.et_phone);

        editText_address.addTextChangedListener(new TextChange());
        editText_name.addTextChangedListener(new TextChange());
        editText_phone.addTextChangedListener(new TextChange());
    }

    public void backUp(View view) {
        AddAddressActivity.this.finish();
    }

    public void save(View view) {
        Toast.makeText(AddAddressActivity.this, "新地址已保存！", Toast.LENGTH_SHORT).show();
        AddAddressActivity.this.finish();
    }

    class TextChange implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            boolean name = editText_name.getText().length() > 0;
            boolean phone = editText_phone.getText().length() > 0;
            boolean address = editText_address.getText().length() > 0;

            if (name & phone & address) {
                button_save.setEnabled(true);
            } else {
                button_save.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
