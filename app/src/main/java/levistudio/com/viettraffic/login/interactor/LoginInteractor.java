package levistudio.com.viettraffic.login.interactor;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import levistudio.com.viettraffic.App;
import levistudio.com.viettraffic.R;
import levistudio.com.viettraffic.base.BaseListener;
import levistudio.com.viettraffic.common.TableConstant;
import levistudio.com.viettraffic.entities.User;

/**
 * Created by Levi on 7/24/2016.
 */

public class LoginInteractor {
    private static final String TAG = "LoginInteractor";

    private FirebaseAuth mFirebaseAuth;
    private FirebaseDatabase mFirebaseDatabase;
    private BaseListener<FirebaseUser> mRegisterListener;
    private BaseListener<FirebaseUser> mLoginListener;

    public LoginInteractor(BaseListener<FirebaseUser> registerListener, BaseListener<FirebaseUser> loginListener) {
        mRegisterListener = registerListener;
        mLoginListener = loginListener;
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void doLogin(String email, String password) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = task.getResult().getUser();
                            if (user != null) {
                                mLoginListener.onSuccess(user);
                            } else {
                                Log.d(TAG, "[onComplete] current user is null");
                                mLoginListener.onError(App.getInstance().getString(R.string.login_error_login_failed));
                            }
                        } else {
                            Log.d(TAG, "signInWithEmailAndPassword is failed");
                            mLoginListener.onError(App.getInstance().getString(R.string.login_error_login_failed));
                        }
                    }
                });
    }

    public void doRegister(String email, String password) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final FirebaseUser user = task.getResult().getUser();
                            if (user != null) {
                                String uid = user.getUid();
                                DatabaseReference ref = mFirebaseDatabase
                                        .getReference(TableConstant.USER_TABLE)
                                        .child(uid);
                                User newUser = new User();
                                newUser.setName("Khac Vy");
                                newUser.setAge(23);
                                newUser.setSex(true);
                                ref.setValue(newUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            mRegisterListener.onSuccess(user);
                                        } else {
                                            Log.d(TAG, "Add extra info failed");
                                            mRegisterListener.onError(App.getInstance().getString(R.string.common_query_firebase_error));
                                        }
                                    }
                                });
                            }
                        } else {
                            Log.d(TAG, "createUserWithEmailAndPassword is failed");
                            mRegisterListener.onError(App.getInstance().getString(R.string.common_query_firebase_error));
                        }
                    }
                });
    }
}
