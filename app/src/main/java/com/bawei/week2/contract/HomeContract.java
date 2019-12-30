package com.bawei.week2.contract;

import com.bawei.week2.model.bean.GsonBean;

public interface HomeContract {
    interface IView{
        void onHomeSuccess(GsonBean gsonBean);
        void onHomeFailure(Throwable throwable);
    }
    interface IPresenter{
        void getHomeData();
    }
    interface IModel{
        void getHomeData(IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onHomeSuccess(GsonBean gsonBean);
            void onHomeFailure(Throwable throwable);
        }
    }
}
