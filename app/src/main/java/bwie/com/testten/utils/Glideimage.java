package bwie.com.testten.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Maibenben on 2017/11/9.
 */

public class Glideimage extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //使用glide加载图片
        Glide.with(context).load(path).into(imageView);
    }

}
