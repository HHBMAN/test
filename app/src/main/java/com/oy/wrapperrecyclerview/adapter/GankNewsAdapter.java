package com.oy.wrapperrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.oy.wrapperrecyclerview.DetailsActivity;
import com.oy.wrapperrecyclerview.R;

import com.oy.wrapperrecyclerview.bean.NewsBean;
import com.oy.wrapperrecyclerview.widget.xRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class GankNewsAdapter extends xRecyclerView.xAdapter<GankNewsAdapter.MyViewHolder> {

    private final List<NewsBean.DataDictBean.DataListBean> news_data;

    private Context context;

    public GankNewsAdapter(List<NewsBean.DataDictBean.DataListBean> data, Context context) {
        news_data = data;

        this.context=context;
    }

    @Override
    protected int getxItemCount() {
        return news_data.size();
    }

    @Override
    protected MyViewHolder onCreatexViewHolder(ViewGroup parent, int itemType) {
        Context context = parent.getContext().getApplicationContext();
        return new MyViewHolder(View.inflate(context, R.layout.item_gank_news, null));
    }

    @Override
    protected void onBindxViewHolder(MyViewHolder holder, int position) {
        final NewsBean.DataDictBean.DataListBean item = news_data.get(position);

        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getNewsContent());

        Glide
                .with(holder.itemView)
                .load(item.getTitleImageUrl())

                .into(holder.image);

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Nullable@BindView(R.id.gank_item_title)
        TextView title;

        @Nullable@BindView(R.id.gank_item_subtitle)
        TextView subtitle;

        @Nullable@BindView(R.id.gank_item_image)
        ImageView image;


        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(context, DetailsActivity.class);
                   // i.putExtra("movieId",movieId.getText());

                    context.startActivity(i);

                }
            });
        }
    }
}
