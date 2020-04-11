package com.crazy.simplemvp.model;


import androidx.annotation.NonNull;

import com.crazy.simplemvp.BuildConfig;
import com.crazy.simplemvp.Constants;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiWrapper {
    private static final int CONNECT_TIMEOUT = 60;// 延时设置得大一点，防止连接时间过长没得到结果
    private static String BASE_URL = Constants.BASE_URL;

    private static ApiWrapper instance;
    private Retrofit retrofit;

    private ApiWrapper() {
        this(CONNECT_TIMEOUT);
    }

    private ApiWrapper(int timeout) {
        this(BASE_URL, timeout);
    }

    private ApiWrapper(String baseUrl, int timeout) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.SECONDS)
                .readTimeout(timeout, TimeUnit.SECONDS);
        // 只有 debug 版本添加 log 信息打印
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(interceptor);
        }
        retrofit = getRetrofit(okHttpClient, getUrl(baseUrl));
    }

    /**
     * 添加默认地址
     *
     * @param url 请求地址
     * @return  返回请求地址
     */
    public String getUrl(String url) {
        if (!url.contains("http")) {
            url = "http://" + url;
        }
        return url;
    }

    @NonNull
    private Retrofit getRetrofit(OkHttpClient.Builder okHttpClient, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();
    }


    public static ApiWrapper getInstance() {
        if (instance == null) {
            synchronized (ApiWrapper.class) {
                if (instance == null) {
                    instance = new ApiWrapper();
                }
            }
        }
        return instance;
    }


    public static ApiWrapper getInstance(String url) {
        synchronized (ApiWrapper.class) {
            instance = new ApiWrapper(url, CONNECT_TIMEOUT);
        }
        return instance;
    }

    public static ApiWrapper getInstance(String url, int timeout) {
        if (instance == null) {
            synchronized (ApiWrapper.class) {
                if (instance == null) {
                    instance = new ApiWrapper(url, timeout);
                }
            }
        }
        return instance;
    }

    public static ApiWrapper getInstance(int timeout) {
        if (instance == null) {
            synchronized (ApiWrapper.class) {
                if (instance == null) {
                    instance = new ApiWrapper(timeout);
                }
            }
        }
        return instance;
    }

    public <T> T create(Class<T> services) {
        return retrofit.create(services);
    }

}