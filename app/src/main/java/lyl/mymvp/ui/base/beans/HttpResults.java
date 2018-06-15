package lyl.mymvp.ui.base.beans;

/**
 * Created by lyl on 2018-6-15.
 * 请求结果统一处理
 */

public class HttpResults<T> {
    public int errorCode;//请求结果状态码
    public String errorMsg;
    public T data;//具体数据

    public HttpResults() {
    }
}
