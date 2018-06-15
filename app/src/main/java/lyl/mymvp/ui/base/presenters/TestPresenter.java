package lyl.mymvp.ui.base.presenters;

import android.os.Bundle;

import lyl.mymvp.model.UserModel;
import lyl.mymvp.ui.base.beans.LoginResultBean;
import lyl.mymvp.ui.base.views.TestView;
import lyl.mymvp.utils.ErrorHanding;
import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Created by lyl on 2018-6-14.
 */

public class TestPresenter extends RxPresenter<TestView> {
    private static final int LOGIN_ID = 110;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableFirst(LOGIN_ID, new Func0<Observable<LoginResultBean>>() {
            @Override
            public Observable<LoginResultBean> call() {
                return UserModel.getInstance().login(name, pwd, "");
            }
        }, new Action2<TestView, LoginResultBean>() {
            @Override
            public void call(TestView testView, LoginResultBean loginResultBean) {
                testView.getResult();
                testView.dismissProgress();
            }
        }, new Action2<TestView, Throwable>() {
            @Override
            public void call(TestView testView, Throwable throwable) {
                testView.dismissProgress();
                testView.showError(ErrorHanding.handleError(throwable));


            }
        });
    }

    public void getLoginResults(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
        start(LOGIN_ID);
    }
}
