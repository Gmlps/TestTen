package bwie.com.testten.Login.presenter;

import android.content.Context;

import java.util.Map;

import bwie.com.testten.Bean.Login_Bean;
import bwie.com.testten.Login.model.GetBean;
import bwie.com.testten.Login.model.ModelInfo;
import bwie.com.testten.Login.view.Iview;


/**
 * Created by Maibenben on 2017/11/13.
 */

public class Presenter {
    private Iview iview;
    private ModelInfo modelInfo;
    private Context context;

    public Presenter(Iview iview, Context context) {
        this.iview = iview;
        this.context = context;
        modelInfo = new ModelInfo();
    }

    public void getdata(Map<String, String> map) {
        modelInfo.getdata(new GetBean() {
            @Override
            public void getData(Login_Bean bean) {
                iview.getdata(bean);
            }
        }, map);
    }
}
