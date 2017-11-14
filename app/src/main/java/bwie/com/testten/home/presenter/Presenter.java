package bwie.com.testten.home.presenter;

import android.content.Context;

import bwie.com.testten.Bean.Shouye_Bean;
import bwie.com.testten.home.mode.GetBean;
import bwie.com.testten.home.mode.ModelInfo;
import bwie.com.testten.home.view.Iview;
import bwie.com.testten.utils.Api;

/**
 * Created by Maibenben on 2017/11/9.
 */

public class Presenter {
    private Iview iview;
    private ModelInfo modelInfo;
    private Context context;

    public Presenter(Iview iview, Context context) {
        this.iview = iview;
        this.context = context;
        modelInfo=new ModelInfo();
    }

    public void getdata(){
        modelInfo.getdata(Api.HOME_URL, new GetBean() {
            @Override
            public void getData(Shouye_Bean bean) {
                iview.getdata(bean);
            }
        });
    }
}
