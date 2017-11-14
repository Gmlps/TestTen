package bwie.com.testten.utils;

import java.util.Map;

import bwie.com.testten.Bean.Login_Bean;
import bwie.com.testten.Bean.Shouye_Bean;
import bwie.com.testten.Bean.Zhece_Bean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

    //
//    @GET("v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
//    Observable<HomeBean> getHome();
//
    @GET("ad/getAd")
    Observable<Shouye_Bean> getHomes();

    @POST
    Observable<Login_Bean> Login(@Url String name, @QueryMap Map<String,String> map);


    @GET
    Observable<Zhece_Bean> Zhuce(@Url String name, @QueryMap Map<String,String> map);


}
