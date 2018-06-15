package lyl.mymvp.ui.base.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import lyl.mymvp.R;
import lyl.mymvp.ui.base.BaseActivity;
import lyl.mymvp.ui.base.presenters.TestPresenter;
import lyl.mymvp.ui.base.views.TestView;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(TestPresenter.class)
public class TestActivityActivity extends BaseActivity<TestPresenter> implements TestView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity);

    }

    @Override
    public void showProgress() {
        showProgressDialog("正在加载");
    }

    @Override
    public void dismissProgress() {
        dismissProgressDialog();
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void getResult() {
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }

    public void click(View view) {
        showProgress();
        getPresenter().getLoginResults("lyl_test", "123456");
    }
}
