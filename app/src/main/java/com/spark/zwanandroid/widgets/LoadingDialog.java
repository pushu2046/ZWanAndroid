package com.spark.zwanandroid.widgets;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ContentLoadingProgressBar;

import com.spark.zwanandroid.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * desc:
 加载等待框---
 */
public class LoadingDialog extends AppCompatDialogFragment {

    @BindView(R.id.pb_dialog_loading)
    ContentLoadingProgressBar mProgressbar;
    Unbinder unbinder;

    public static LoadingDialog newInstance() {

        Bundle args = new Bundle();

        LoadingDialog fragment = new LoadingDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Window window = dialog.getWindow();
        //去掉dialog默认的padding
        WindowManager.LayoutParams lp = Objects.requireNonNull(window).getAttributes();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.CENTER;
        //lp.windowAnimations = R.style.Middle_Anim;
        lp.dimAmount = 0.0f;
        lp.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(false);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        int width = (int) (CommonUtils.getScreenWidth(Objects.requireNonNull(getContext())) * 0.75);
//        window.setLayout(width, window.getAttributes().height);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_loading, container, false);
        unbinder = ButterKnife.bind(this, view);
        mProgressbar.getIndeterminateDrawable()
                .setColorFilter(ContextCompat.getColor(Objects.requireNonNull(getContext()),R.color.gold_dark)
                        , PorterDuff.Mode.MULTIPLY);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
