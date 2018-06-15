package lyl.mymvp.https;

import lyl.mymvp.ui.base.beans.HttpResults;
import lyl.mymvp.ui.base.beans.LoginResultBean;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 *
 */

public interface UserApi {
    @FormUrlEncoded
    @POST(Consts.URL.LOGIN)
    Observable<HttpResults<LoginResultBean>> login(@Field("username") String var1, @Field("password") String var2);


}
