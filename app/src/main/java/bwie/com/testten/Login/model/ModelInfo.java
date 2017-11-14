package bwie.com.testten.Login.model;

import android.util.Log;

import java.util.Map;

import bwie.com.testten.Bean.Login_Bean;
import bwie.com.testten.utils.ApiServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Maibenben on 2017/11/13.
 */

public class ModelInfo implements Imodel {
    //private DatagramPacket getbean;

    @Override
    public void getdata(final GetBean getBean, Map<String, String> map) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://120.27.23.105")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer retrofitll = retrofit.create(ApiServer.class);
        Observable<Login_Bean> observable = retrofitll.Login("/user/login", map);
        Subscription sss = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("sss", e.toString());

                    }

                    @Override
                    public void onNext(Login_Bean bean) {

                        Log.e("sss", bean.msg);
                        getBean.getData(bean);

                    }
                });
    }
}
