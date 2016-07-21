package levistudio.com.viettraffic;

import android.app.Application;

/**
 * Created by Levi on 7/14/2016.
 */

public class App extends Application {
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static App getInstance(){
        return mInstance;
    }
}
