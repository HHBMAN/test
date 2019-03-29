package com.oy.wrapperrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.oy.wrapperrecyclerview.adapter.GankNewsAdapter;
import com.oy.wrapperrecyclerview.bean.NewsBean;
import com.oy.wrapperrecyclerview.contract.GankContract;
import com.oy.wrapperrecyclerview.contract.GankPresenter;
import com.oy.wrapperrecyclerview.widget.xRecyclerView;

import java.util.List;

import butterknife.BindView;

public class NewsActivity extends AppCompatActivity implements GankContract.View {

    private GankNewsAdapter mAdapter;
    private GankPresenter mPresenter;

    xRecyclerView mRecyclerView;

    @BindView(R.id.gank_load_failed_tv)
    TextView mTvLoadFailed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //一定要注意绑定ID
        mRecyclerView=(xRecyclerView)findViewById(R.id.gank_recycler_view);

        mPresenter = new GankPresenter(this);
        mRecyclerView.setListener(new xRecyclerView.xAdapterListener() {
            @Override
            public void startRefresh() {
                Log.e("fragment", "start refresh");
                mPresenter.startRefresh();
            }

            @Override
            public void startLoadMore() {
                Log.e("fragment", "start load more");
                mPresenter.startLoadMore();
            }
        });
        mRecyclerView.startRefreshing();
        mPresenter.onViewCreate();
    }

    @Override
    public void setListData(List<NewsBean.DataDictBean.DataListBean> listData) {
        if (mAdapter == null) {
            mAdapter = new GankNewsAdapter(listData, this);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onInitLoadFailed() {
        mRecyclerView.setVisibility(View.GONE);
        mTvLoadFailed.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopRefresh() {
        mRecyclerView.stopRefreshing();

    }

    @Override
    public void stopLoadMore() {
        mRecyclerView.stopLoadingMore();
        Toast.makeText(this,"加载完毕",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void done() {
        mRecyclerView.stopLoadingMore();
        Toast.makeText(this,"已经到底",Toast.LENGTH_SHORT).show();
    }

//    public void done(){
//        mRecyclerView.stopLoadingMore();
//        Toast.makeText(this,"已经到底",Toast.LENGTH_SHORT);
//
//    }

}
