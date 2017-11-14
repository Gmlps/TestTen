package bwie.com.testten.home.mode;

import android.util.Log;

import bwie.com.testten.Bean.Shouye_Bean;
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
 * Created by Maibenben on 2017/11/9.
 */

public class ModelInfo implements Imodel {
    @Override
    public void getdata(String url, final GetBean getbean) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiServer retrofitll = retrofit.create(ApiServer.class);
        Observable<Shouye_Bean> observable = retrofitll.getHomes();
        Subscription sss = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shouye_Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("sss", e.toString());

                    }

                    @Override
                    public void onNext(Shouye_Bean bean) {

                        getbean.getData(bean);

                    }
                });
    }
}
