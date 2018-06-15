package lyl.mymvp.model;

import android.text.TextUtils;

import lyl.mymvp.https.UserApi;
import lyl.mymvp.ui.base.beans.LoginResultBean;
import lyl.mymvp.utils.ApiException;
import lyl.mymvp.utils.HttpResultFunc;
import lyl.mymvp.utils.RetrofitClient;
import lyl.mymvp.utils.SchedulersCompat;
import rx.Observable;

/**
 * Created by lyl on 2018-6-15.
 */

public class UserModel {
    public static UserModel getInstance() {
        return UserModel.UserModelHolder.instance;
    }


    private static class UserModelHolder {
        private static UserModel instance = new UserModel();

        private UserModelHolder() {
        }
    }


    public Observable<LoginResultBean> login(String var1, final String var2, String var3) {
        return TextUtils.isEmpty(var1) ?
                Observable.error(new ApiException("请输入账号"))
                : (TextUtils.isEmpty(var2)
                ? Observable.error(new ApiException("请输入密码"))
                : ((UserApi) RetrofitClient.getInstance().createService(UserApi.class))
                .login(var1, var2)
                .map(new HttpResultFunc()).compose(SchedulersCompat.applyIoSchedulers()));
    }


}
