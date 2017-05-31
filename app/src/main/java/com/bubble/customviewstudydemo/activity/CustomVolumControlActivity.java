package com.bubble.customviewstudydemo.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bubble.customviewstudydemo.R;
import com.bubble.customviewstudydemo.utils.StringUtils;
import com.bubble.customviewstudydemo.view.CustomVolumControlBar;

/**
 * @description 音量控制，上下滑动调节音量
 * @date 17/5/18
 */

public class CustomVolumControlActivity extends BaseActivity {
    private EditText et_length, et_centralAngle;
    private CustomVolumControlBar customVolumControlBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init(R.layout.custom_volumbar);
    }

    @Override
    public void initView() {
        super.initView();

        et_length = (EditText) findViewById(R.id.et_length);
        et_centralAngle = (EditText) findViewById(R.id.et_centralAngle);
        btn_save = (Button) findViewById(R.id.btn_save);
        customVolumControlBar = (CustomVolumControlBar) findViewById(R.id.customVolumControlBar);
    }

    @Override
    public void initData() {
        super.initData();

        setTitle("CustomVolumControlActivity");

        setBlogInfo("Android 自定义View (四) 视频音量调控",
                "http://blog.csdn.net/lmj623565791/article/details/24529807");
    }

    @Override
    public void save() {
        customLayoutParams = customVolumControlBar.getLayoutParams();

        //设置边长
        String length = et_length.getText().toString();
        if (!StringUtils.isNullOrEmpty(length) && customLayoutParams != null) {
            setSquareViewLength(length);
            customVolumControlBar.setLayoutParams(customLayoutParams);
        }

        //设置圆心角大小
        String centralAngle = et_centralAngle.getText().toString();
        if (!StringUtils.isNullOrEmpty(centralAngle) && StringUtils.canParseDouble(centralAngle)) {
            customVolumControlBar.setCentralAangle(Integer.parseInt(centralAngle));
        }
    }
}