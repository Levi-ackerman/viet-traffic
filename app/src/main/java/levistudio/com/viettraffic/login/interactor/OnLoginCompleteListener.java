package levistudio.com.viettraffic.login.interactor;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Levi on 7/24/2016.
 */

public interface OnLoginCompleteListener {
    void onLoginSuccess(FirebaseUser user);

    void onLoginFailed(String error);
}
