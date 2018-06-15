package lyl.mymvp.ui.base;


public interface BaseView {

    void showProgress();

    void dismissProgress();

    void showError(String error);
}
