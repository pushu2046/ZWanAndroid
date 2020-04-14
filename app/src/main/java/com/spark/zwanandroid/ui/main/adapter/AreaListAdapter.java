package com.spark.zwanandroid.ui.main.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.spark.zwanandroid.model.beans.AreaEntity;


import java.util.List;

/**
 * desc:支行适配器
 *
 * @author Bian
 * create at 2018/12/20
 */
public class AreaListAdapter extends BaseQuickAdapter<AreaEntity, BaseViewHolder> {

    public AreaListAdapter(int layoutResId, @Nullable List<AreaEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AreaEntity item) {
       // helper.setText(R.id.tv_item_list_way, item.getName());
    }
}
