package levistudio.com.viettraffic.login.views;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import levistudio.com.viettraffic.App;
import levistudio.com.viettraffic.R;
import levistudio.com.viettraffic.login.presenters.ILoginPresenter;
import levistudio.com.viettraffic.login.presenters.RegisterPresenter;
import levistudio.com.viettraffic.views.activities.MainActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    // UI references.
    @BindView(R.id.text_email)
    EditText textEmail;
    @BindView(R.id.text_password)
    EditText textPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private ProgressDialog mProgressDialog;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(App.getInstance().getPreferenceManager().getUserUid() != null){
            /**
             * User has logged in
             */
            startMainActivity();
        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mLoginPresenter = new RegisterPresenter(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait ...");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString().trim();
                String password = textPassword.getText().toString().trim();
                mLoginPresenter.doLogin(email, password);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString().trim();
                String password = textPassword.getText().toString().trim();
                mLoginPresenter.doRegister(email, password);
            }
        });
    }


    @Override
    public void showLoading(boolean isShow) {
        if(isShow){
            mProgressDialog.show();
        }else{
            if(mProgressDialog.isShowing()){
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public void showEmailError(String error) {

    }

    @Override
    public void showPasswordError(String error) {

    }

    @Override
    public void showLoginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess(FirebaseUser user) {
        Toast.makeText(this, "Login successfully " + user.getEmail(), Toast.LENGTH_LONG).show();
        App.getInstance().getPreferenceManager().saveLoginInfo(user.getUid());
        startMainActivity();
    }

    private void startMainActivity(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

