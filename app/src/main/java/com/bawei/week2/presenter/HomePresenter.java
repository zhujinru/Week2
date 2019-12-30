package com.bawei.week2.presenter;

import com.bawei.week2.base.BasePresenter;
import com.bawei.week2.contract.HomeContract;
import com.bawei.week2.model.HomeModel;
import com.bawei.week2.model.bean.GsonBean;

public class HomePresenter extends BasePresenter<HomeContract.IView> implements HomeContract.IPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getHomeData() {
       homeModel.getHomeData(new HomeContract.IModel.IModelCallBack() {
           @Override
           public void onHomeSuccess(GsonBean gsonBean) {
               view.onHomeSuccess(gsonBean);
           }

           @Override
           public void onHomeFailure(Throwable throwable) {
                view.onHomeFailure(throwable);
           }
       });
    }
}
