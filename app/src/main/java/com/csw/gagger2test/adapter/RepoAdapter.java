package com.csw.gagger2test.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.csw.gagger2test.R;
import com.csw.gagger2test.entities.Repo;

import java.util.List;

/**
 * Created by caisw on 2017/10/31.
 */

public class RepoAdapter extends BaseQuickAdapter<Repo, BaseViewHolder> {


    public RepoAdapter(@Nullable List<Repo> data) {
        super(R.layout.item_repo, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Repo item) {
        helper.setText(R.id.tv_repo_name, item.getName());
        helper.setText(R.id.tv_repo_desc, item.getDescription());
        helper.setText(R.id.tv_repo_language, item.getLanguage());
    }
}
