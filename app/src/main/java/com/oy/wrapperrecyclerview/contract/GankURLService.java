package com.oy.wrapperrecyclerview.contract;



import com.oy.wrapperrecyclerview.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface GankURLService {



    String BASE_URL1="http://qz.ljjzsj.com";



    @GET("appapi/getnews")
    Observable<NewsBean> gerNews(
            @Query("pagesize") int size,
            @Query("pagenumber") int number
    );

    @GET("appapi/getnews")
    Call<NewsBean> getDetailsNews(@Query("pagesize") int size,
                                  @Query("pagenumber") int number
    );
}
