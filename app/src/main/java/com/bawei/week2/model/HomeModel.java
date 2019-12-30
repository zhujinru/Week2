package com.bawei.week2.model;

import com.bawei.week2.contract.HomeContract;
import com.bawei.week2.model.bean.GsonBean;
import com.bawei.week2.util.NetUtil;
import com.google.gson.Gson;

public class HomeModel implements HomeContract.IModel {
    @Override
    public void getHomeData(IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getJsonGet("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?page=1&count=5&keyword=手机", new NetUtil.MyCallBack() {
            @Override
            public void onGetJson(String json) {
                GsonBean gsonBean = new Gson().fromJson(json, GsonBean.class);
                iModelCallBack.onHomeSuccess(gsonBean);
            }

            @Override
            public void onError(Throwable throwable) {
                iModelCallBack.onHomeFailure(throwable);
            }
        });
    }
}
