package lyl.mymvp.utils;

/**
 * Created by yanghui on 2018-1-15.
 */


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

public class NetWorkUtil {
    public static final int NETTYPE_WIFI = 1;
    public static final int NETTYPE_CMWAP = 2;
    public static final int NETTYPE_CMNET = 3;

    public NetWorkUtil() {
    }

    public static boolean isNetConnected(Context var0) {
        if(var0 != null) {
            ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
            NetworkInfo var2 = var1.getActiveNetworkInfo();
            if(var2 != null) {
                return var2.isAvailable();
            }
        }

        return false;
    }

    public static int getNetworkType(Context var0) {
        byte var1 = 0;
        ConnectivityManager var2 = (ConnectivityManager)var0.getApplicationContext().getSystemService("connectivity");
        NetworkInfo var3 = var2.getActiveNetworkInfo();
        if(var3 == null) {
            return var1;
        } else {
            int var4 = var3.getType();
            if(var4 == 0) {
                String var5 = var3.getExtraInfo();
                if(!TextUtils.isEmpty(var5)) {
                    if(var5.toLowerCase().equals("cmnet")) {
                        var1 = 3;
                    } else {
                        var1 = 2;
                    }
                }
            } else if(var4 == 1) {
                var1 = 1;
            }

            return var1;
        }
    }
}

