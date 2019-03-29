package com.oy.wrapperrecyclerview.contract;


import com.oy.wrapperrecyclerview.bean.NewsBean;

import java.util.List;



public interface GankContract {
    interface View {

        void setListData(List<NewsBean.DataDictBean.DataListBean> listData);
        void onInitLoadFailed();
        void stopRefresh();
        void stopLoadMore();
        void done();
    }
    interface Presenter {
        void onViewCreate();
        void startRefresh();
        void startLoadMore();
    }
}
