package lyl.mymvp.ui.base;

import nucleus.presenter.Presenter;
import nucleus.view.NucleusSupportFragment;



public class BaseFragment  <P extends Presenter> extends NucleusSupportFragment<P> {

    @Override
    public void onResume() {
        super.onResume();

    }
}
