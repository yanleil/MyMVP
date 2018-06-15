package lyl.mymvp.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;


public class BaseActivity <P extends Presenter> extends NucleusAppCompatActivity<P> {

    private ProgressDialog progressDialog;

    protected void openActivity(Class<? extends Activity> pClass, Bundle pBundle) {
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
    }

    public void openActivityForResult(Class<? extends Activity> pClass, Bundle pBundle, int requestCode){
        Intent intent = new Intent(this, pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivityForResult(intent,requestCode);
    }


    public void showProgressDialog(String...text) {
        if (text!=null&& text.length>0) {
            progressDialog = ProgressDialog.show(this,"",text[0],true,false);

        }else {
            progressDialog = ProgressDialog.show(this,"","loading...",true,false);

        }
    }

    public void dismissProgressDialog(){
        if (progressDialog!=null) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }




    public void hideKey(EditText edit){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit.getWindowToken(),0);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}
