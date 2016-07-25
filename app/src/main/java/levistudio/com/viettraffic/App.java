package levistudio.com.viettraffic;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import levistudio.com.viettraffic.managers.PreferenceManager;

/**
 * Created by Levi on 7/14/2016.
 */

public class App extends Application {
    private static App mInstance;
    private PreferenceManager mPreferenceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static App getInstance(){
        return mInstance;
    }

    public PreferenceManager getPreferenceManager(){
        if(mPreferenceManager == null){
            mPreferenceManager = new PreferenceManager(getBaseContext());
        }
        return mPreferenceManager;
    }

}
