package levistudio.com.viettraffic.login.presenters;

import android.text.TextUtils;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import levistudio.com.viettraffic.App;
import levistudio.com.viettraffic.base.BaseListener;
import levistudio.com.viettraffic.login.interactor.LoginInteractor;
import levistudio.com.viettraffic.login.views.ILoginView;

/**
 * Created by Levi on 7/24/2016.
 */

public class RegisterPresenter implements ILoginPresenter {
    private static final String TAG = "RegisterPresenter";

    private ILoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public RegisterPresenter(ILoginView loginView) {
        mLoginView = loginView;
        mLoginInteractor = new LoginInteractor(mRegisterListener, mLoginListener);
    }


    @Override
    public void doLogin(String email, String password) {
        boolean isValid = doValidate(email, password);
        if (isValid) {
            mLoginInteractor.doLogin(email, password);
        }
    }

    @Override
    public void doRegister(String email, String password) {
        mLoginInteractor.doRegister(email, password);
    }

    private boolean doValidate(String email, String password) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        return true;
    }

    private BaseListener<FirebaseUser> mRegisterListener = new BaseListener<FirebaseUser>() {
        @Override
        public void onSuccess(FirebaseUser user) {
            Toast.makeText(App.getInstance().getBaseContext(), "Register successfully", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(String error) {
            Toast.makeText(App.getInstance().getBaseContext(), error, Toast.LENGTH_LONG).show();
        }
    };

    private BaseListener<FirebaseUser> mLoginListener = new BaseListener<FirebaseUser>() {
        @Override
        public void onSuccess(FirebaseUser user) {
            mLoginView.onLoginSuccess(user);
        }

        @Override
        public void onError(String error) {
            mLoginView.showLoginError(error);
        }
    };
}
