package com.feicui.edu.easyshop.activity.me;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.feicui.edu.easyshop.R;
import com.feicui.edu.easyshop.activity.LoginActivity;
import com.feicui.edu.easyshop.common.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {

    private ActivityUtils activityUtils;
    private View view;

    @BindView(R.id.logo_iv)
    ImageView logo_iv;

    public MeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_me, container, false);
            ButterKnife.bind(this, view);
        }
        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activityUtils = new ActivityUtils(getActivity());

    }

    @OnClick({R.id.me_login_tv, R.id.me_iv, R.id.me_person_good, R.id.me_person_info, R.id.me_person_upload})
    public void onClick(){
//        需要添加判断，是否已经登录，未登录则跳转登录界面
        activityUtils.startActivity(LoginActivity.class);
    }


}
