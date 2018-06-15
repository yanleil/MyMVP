package lyl.mymvp;

import android.app.Application;

/**
 * Created by lyl on 2018-6-15.
 */

public class MyAppcation extends Application {
    private static MyAppcation a;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static MyAppcation a() {
        return a;
    }
}
