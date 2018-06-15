package lyl.mymvp.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import lyl.mymvp.https.Consts;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by lyl on 2018-6-15.
 */

public class RetrofitClient {
    private Retrofit retrofit;

    private RetrofitClient() {
        HttpLoggingInterceptor var1 = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("=====>>>", "" + message);
            }
        });
        var1.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient var2 = (new OkHttpClient.Builder())
                .connectTimeout(20L, TimeUnit.SECONDS)
                .readTimeout(20L, TimeUnit.SECONDS)
                .writeTimeout(20L, TimeUnit.SECONDS)
                .addInterceptor(var1)
//                .cookieJar(new CookiesManager())
                .build();

        this.retrofit = (new retrofit2.Retrofit.Builder())
                .client(var2).addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Consts.URL.BASE_URL).build();
    }

    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }


    public <S> S createService(Class<S> var1) {
        return this.retrofit.create(var1);
    }

    private static class SingletonHolder {
        private static final RetrofitClient INSTANCE = new RetrofitClient();

        private SingletonHolder() {
        }
    }
}
