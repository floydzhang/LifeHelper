package com.ns.yc.lifehelper.ui.home.view.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ns.yc.lifehelper.R;
import com.ns.yc.lifehelper.model.bean.HomeBlogEntity;
import com.ns.yc.lifehelper.utils.image.ImageUtils;

import org.yczbj.ycrefreshviewlib.adapter.RecyclerArrayAdapter;
import org.yczbj.ycrefreshviewlib.viewHolder.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * <pre>
 *     @author yangchong
 *     blog  : https://github.com/yangchong211
 *     time  : 2016/03/22
 *     desc  : Home主页面适配器
 *     revise:
 * </pre>
 */
public class HomeBlogAdapter extends RecyclerArrayAdapter<HomeBlogEntity> {


    public HomeBlogAdapter(Activity activity) {
        super(activity);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(parent);
    }


    public class MyViewHolder extends BaseViewHolder<HomeBlogEntity> {

        @Bind(R.id.ll_news_head)
        LinearLayout llNewsHead;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_author)
        TextView tvAuthor;
        @Bind(R.id.tv_time)
        TextView tvTime;
        @Bind(R.id.tv_type)
        TextView tvType;
        @Bind(R.id.iv_img)
        ImageView ivImg;
        @Bind(R.id.ll_new_content)
        LinearLayout llNewContent;

        MyViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_home_list);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setData(HomeBlogEntity data) {
            super.setData(data);
            if (getAdapterPosition() == 0) {
                llNewContent.setVisibility(View.GONE);
                llNewsHead.setVisibility(View.VISIBLE);
            } else {
                llNewContent.setVisibility(View.VISIBLE);
                llNewsHead.setVisibility(View.GONE);
                tvTitle.setText(data.getTitle());
                ImageUtils.loadImgByPicasso(getContext(), data.getImageUrl(), R.drawable.image_default, ivImg);
                tvAuthor.setText(data.getAuthor());
                tvTime.setText(data.getTime());
            }
        }
    }
}
