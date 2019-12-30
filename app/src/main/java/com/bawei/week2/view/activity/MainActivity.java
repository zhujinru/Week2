package com.bawei.week2.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week2.R;
import com.bawei.week2.base.BaseActivity;
import com.bawei.week2.contract.HomeContract;
import com.bawei.week2.model.bean.GsonBean;
import com.bawei.week2.presenter.HomePresenter;
import com.bawei.week2.view.adapter.MyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<HomePresenter> implements HomeContract.IView {


    @BindView(R.id.arecycler)
    RecyclerView arecycler;

    @Override
    protected HomePresenter providerPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getHomeData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onHomeSuccess(GsonBean gsonBean) {
        List<GsonBean.ResultBean> result = gsonBean.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        arecycler.setLayoutManager(linearLayoutManager);
        MyAdapter myAdapter = new MyAdapter(result);
        arecycler.setAdapter(myAdapter);
        myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClickL(int i) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void onHomeFailure(Throwable throwable) {
        Log.e("xxx","失败");
    }


}
