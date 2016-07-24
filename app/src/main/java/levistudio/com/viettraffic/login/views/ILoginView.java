package levistudio.com.viettraffic.login.views;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Levi on 7/24/2016.
 */

public interface ILoginView {
    void showLoading(boolean isShow);

    void showEmailError(String error);

    void showPasswordError(String error);

    void showLoginError(String error);

    void onLoginSuccess(FirebaseUser user);
}
