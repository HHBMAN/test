package com.oy.wrapperrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.oy.wrapperrecyclerview.bean.NewsBean;
import com.oy.wrapperrecyclerview.contract.GankURLService;
import com.oy.wrapperrecyclerview.contract.NullOnEmptyConverterFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {

    TextView title, year, desc;
    ImageView img;
    private GankURLService mUrlService;
    ProgressBar progressBar;
    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GankURLService.BASE_URL1)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUrlService = retrofit.create(GankURLService.class);
        loadFirstPage();

    }

    public void initView(){
        progressBar = (ProgressBar) findViewById(R.id.main_progress);
        title =(TextView) findViewById(R.id.titleTxt);
        year =(TextView) findViewById(R.id.yearTxt);
        desc =(TextView) findViewById(R.id.descTxt);
        img =(ImageView) findViewById(R.id.imgPoster);

    }

    private void loadFirstPage() {


    }

}
