package bwie.com.testten.utils;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Maibenben on 2017/11/9.
 */

public class Tupian {
     public static void jiazi(SimpleDraweeView sim, Context context, String path){
             GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(context.getResources());
             /**
              * 设置淡入淡出效果的显示时间j
              * */
             //    compile 'com.facebook.fresco:fresco:0.14.0'   依赖
             GenericDraweeHierarchy hierarchy = builder.setFadeDuration(1000).build();
             DraweeController placeHolderDraweeController = Fresco.newDraweeControllerBuilder()
                     .setUri(path) //为图片设置url
                     .setTapToRetryEnabled(true)   //设置在加载失败后,能否重试
                     .setOldController(sim.getController())
                     .build();
             sim.setController(placeHolderDraweeController);
             sim.setHierarchy(hierarchy);
         }
}
