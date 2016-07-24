package levistudio.com.viettraffic.base;

/**
 * Created by Levi on 7/24/2016.
 */

public interface BaseListener<T> {
    void onSuccess(T t);

    void onError(String error);
}
