package levistudio.com.viettraffic.login.interactor;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Levi on 7/24/2016.
 */

public interface OnRegisterCompleteListener {
    void onSuccess(FirebaseUser user);

    void onError(String error);
}
