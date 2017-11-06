package com.csw.gagger2test.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.csw.gagger2test.di.component.RepoListComponent;
import com.csw.gagger2test.function.repo_list.RepoListFragment;

import java.util.List;

/**
 * Created by caisw on 2017/11/6.
 */

public class RepoListFragmentAdapter extends FragmentPagerAdapter {

    private List<String> strings;
    private RepoListComponent.Builder repoListComponentBuilder;

    public RepoListFragmentAdapter(FragmentManager fm, List<String> strings, RepoListComponent.Builder repoListComponentBuilder) {
        super(fm);
        this.strings = strings;
        this.repoListComponentBuilder = repoListComponentBuilder;
    }

    @Override
    public Fragment getItem(int position) {
        RepoListFragment fragment = RepoListFragment.newInstance(strings.get(position));
        fragment.beginInject(repoListComponentBuilder);
        return fragment;
    }

    @Override
    public int getCount() {
        return strings == null ? 0 : strings.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    public void setNewData(List<String> strings) {
        if (this.strings == null) {
            this.strings = strings;
        } else {
            this.strings.clear();
            if (strings != null) {
                this.strings.addAll(strings);
            }
        }
        notifyDataSetChanged();
    }
}
