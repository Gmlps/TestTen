package bwie.com.testten.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import bwie.com.testten.Bean.Shouye_Bean;
import bwie.com.testten.R;
import bwie.com.testten.utils.Tupian;

/**
 * Created by Maibenben on 2017/11/13.
 */

public class Item3_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Shouye_Bean.MiaoshaBean miaosha;
    private Context context;
    private LayoutInflater inflater;

    public Item3_Adapter(Shouye_Bean.MiaoshaBean miaosha, Context context) {
        this.miaosha = miaosha;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item3_item, parent, false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        String str =   miaosha.list.get(position).images;

        String[] split = str.split("\\|");

        Tupian.jiazi(((Viewholder) holder).sim,context,split[0]);
        ((Viewholder)holder).tv.setText(miaosha.list.get(position).title);

    }

    @Override
    public int getItemCount() {
        return miaosha.list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {

        SimpleDraweeView sim;
        TextView tv;

        public Viewholder(View itemView) {
            super(itemView);
            sim = itemView.findViewById(R.id.sim);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
