package lyl.mymvp.utils;

import lyl.mymvp.ui.base.beans.HttpResults;
import rx.functions.Func1;

/**
 * Created by lyl on 2018-6-15.
 */

public class HttpResultFunc<T> implements Func1<HttpResults<T>, T> {
    public HttpResultFunc() {
    }

    public T call(HttpResults<T> var1) {
        if (var1.errorCode < 0) {
            throw new ApiException(var1.errorMsg);
        } else {
            return var1.data;//代表请求成功
        }
    }
}