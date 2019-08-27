package fairy.easy.loginfo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import fairy.easy.logcanary.LogCanary;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //内存泄漏检测
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        LogCanary.install(this,5);


    }
}