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

public class Item_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private Shouye_Bean.TuijianBean tuijian;
    private LayoutInflater inflater;

    public Item_Adapter(Context context, Shouye_Bean.TuijianBean tuijian) {
        this.context = context;
        this.tuijian = tuijian;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item2_item, parent, false);
        Viewholder viewholder = new Viewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String str =   tuijian.list.get(position).images;

        String[] split = str.split("\\|");



        Tupian.jiazi(((Viewholder) holder).sim, context, split[0]);
        ((Viewholder) holder).tv.setText(tuijian.list.get(position).title);
    }

    @Override
    public int getItemCount() {
        return tuijian.list.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        SimpleDraweeView sim;
        TextView tv;

        public Viewholder(View itemView) {
            super(itemView);
            sim = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
