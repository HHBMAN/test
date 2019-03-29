package com.oy.wrapperrecyclerview.contract;

import android.util.Log;
import android.widget.Toast;


import com.oy.wrapperrecyclerview.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**

 */

public class GankPresenter implements GankContract.Presenter {

    private final GankURLService mUrlService;
    private final GankContract.View mView;

    private  List<NewsBean.DataDictBean.DataListBean> news_data=new ArrayList<>();
    private int mCurrentPage;
    private int pageSize=3;

    public GankPresenter(GankContract.View view) {
        // retrofit 创建API Service实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GankURLService.BASE_URL1)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUrlService = retrofit.create(GankURLService.class);
        news_data.clear();
        mView = view;
    }

    @Override
    public void onViewCreate() {
        mCurrentPage = 1;
        loadData();
    }

    @Override
    public void startRefresh() {
        mCurrentPage = 1;
        loadData();
    }

    @Override
    public void startLoadMore() {
        mCurrentPage++;
        loadData();
    }

    private void loadData() {
        mUrlService.gerNews(pageSize,mCurrentPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        // 首次或刷新
                        if (mCurrentPage == 1)
                            news_data.clear();

                        //判断是否还有数据
                        if(newsBean.getDataDict().getDataList()==null){

                            System.out.println("没有数据");

                           // Toast.makeText(this,"已经到底了",Toast.LENGTH_LONG).show();
                            mView.done();

                        }else {

                            // 刷新数据
                            news_data.addAll(newsBean.getDataDict().getDataList());
                            mView.setListData(news_data);
                        }


                        Log.e("adapter", "page:" + mCurrentPage + ", size:" + news_data.size());
                        // 更新视图
                        if (mCurrentPage == 1) {
                            mView.stopRefresh();
                        } else if(mCurrentPage<4){
                            mView.stopLoadMore();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.onInitLoadFailed();
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
