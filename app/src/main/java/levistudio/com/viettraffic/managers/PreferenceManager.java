package levistudio.com.viettraffic.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Levi on 7/24/2016.
 */

public class PreferenceManager {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private static final String APP_PREFERENCE = "pref_viettraffic";
    private static final String KEY_USER_UID = "user_uid";
    //private static final String KEY_U = "pref_viettraffic";
    //private static final String APP_PREFERENCE = "pref_viettraffic";

    public PreferenceManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(APP_PREFERENCE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
    }

    public void saveLoginInfo(String uid){
        mEditor.putString(KEY_USER_UID, uid).commit();
    }

    public String getUserUid(){
        return mSharedPreferences.getString(KEY_USER_UID, null);
    }

    public void clear(){
        mEditor.clear().commit();
    }
}
