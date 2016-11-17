package com.feicui.edu.easyshop.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.feicui.edu.easyshop.R;
import com.feicui.edu.easyshop.common.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginActivity extends AppCompatActivity {

    private Unbinder unbinder;
    private ActivityUtils activityUtils;

    @BindView(R.id.login_btn)
    Button btn_login;

    @BindView(R.id.login_name)
    TextView tv_name;

    @BindView(R.id.login_password)
    TextView tv_password;

    @BindView(R.id.login_register)
    TextView tv_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder = ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
