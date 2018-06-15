package lyl.mymvp.utils;

import com.alibaba.fastjson.JSONException;

import java.net.SocketTimeoutException;

import lyl.mymvp.MyAppcation;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by lyl on 2018-6-15.
 */

public class ErrorHanding {
    public ErrorHanding() {
    }

    public static String handleError(Throwable var0) {
        String var1;
        if (!NetWorkUtil.isNetConnected(MyAppcation.a())) {
            var1 = "无网络连接";
        } else if (var0 instanceof ApiException) {
            var1 = var0.getMessage();
        } else if (var0 instanceof JSONException) {
            var1 = "数据异常";
        } else if (var0 instanceof SocketTimeoutException) {
            var1 = "连接超时";
        } else if (var0 instanceof HttpException) {
            var1 = ((HttpException) var0).message();
        } else if (var0 instanceof NullPointerException) {
            var1 = "程序异常";
        } else {
            var1 = "连接服务器失败";
        }

        return var1;
    }
}
