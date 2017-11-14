package bwie.com.testten.Adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import bwie.com.testten.Bean.Shouye_Bean;
import bwie.com.testten.R;
import bwie.com.testten.utils.Glideimage;

/**
 * Created by Maibenben on 2017/11/9.
 */

public class Shouye_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private Shouye_Bean bean;
    private LayoutInflater inflater;

    public Shouye_Adapter(Context context, Shouye_Bean bean) {
        this.context = context;
        this.bean = bean;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return 0;
        } else if (position % 3 == 1) {
            return 1;
        } else {
            return 2;
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = inflater.inflate(R.layout.item1, parent, false);
            Viewholder viewholder = new Viewholder(view);
            return viewholder;
        } else if (viewType == 1) {
            View view = inflater.inflate(R.layout.item2, parent, false);
            Viewholder2 viewholder = new Viewholder2(view);
            return viewholder;
        } else {
            View view = inflater.inflate(R.layout.item3, parent, false);
            Viewholder3 viewholder = new Viewholder3(view);
            return viewholder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position % 3 == 0) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < bean.data.size(); i++) {
                list.add(bean.data.get(i).icon);
            }
            ((Viewholder) holder).banner.setImageLoader(new Glideimage());
            ((Viewholder) holder).banner.setImages(list);
            ((Viewholder) holder).banner.start();
        } else if (position % 3 == 1) {
            Shouye_Bean.TuijianBean tuijian = bean.tuijian;
            //使用线性布局管理器
            RecyclerView.LayoutManager layout = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            ((Viewholder2) holder).recyc.setLayoutManager(layout);
            ((Viewholder2) holder).recyc.setAdapter(new Item_Adapter(context, tuijian));
        } else {

            Shouye_Bean.MiaoshaBean miaosha = bean.miaosha;
            //使用线性布局管理器
            RecyclerView.LayoutManager layout = new LinearLayoutManager(context);
            ((Viewholder3) holder).recyc.setLayoutManager(layout);
            ((Viewholder3) holder).recyc.setAdapter(new Item3_Adapter(miaosha, context));
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class Viewholder extends RecyclerView.ViewHolder {

        Banner banner;

        public Viewholder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class Viewholder2 extends RecyclerView.ViewHolder {
        RecyclerView recyc;

        public Viewholder2(View itemView) {
            super(itemView);
            recyc = itemView.findViewById(R.id.recyc);
        }
    }

    class Viewholder3 extends RecyclerView.ViewHolder {
        RecyclerView recyc;

        public Viewholder3(View itemView) {
            super(itemView);
            recyc = itemView.findViewById(R.id.recyc);
        }
    }
}
