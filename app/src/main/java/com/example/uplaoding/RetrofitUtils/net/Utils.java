package com.example.uplaoding.RetrofitUtils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class Utils implements ImpNetWorkInerface{

    private static Utils utils;
    private final Apiservice apiservice;

    private Utils(){

        Retrofit build = new Retrofit.Builder()
                .baseUrl(Urlconstant.URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiservice = build.create(Apiservice.class);
    }

    public static Utils getUtils() {
        if (utils==null){
            synchronized (Utils.class){
                if (utils==null){
                    utils=new Utils();
                }
            }
        }
        return utils;
    }


    @Override
    public <T> void get(String url, ImpCallBack<T> callBack) {
        apiservice.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] interfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
                            Type argument = arguments[0];
                            T t = new Gson().fromJson(string, argument);
                            callBack.onSuccess(t);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callBack.onFail("网络异常"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
