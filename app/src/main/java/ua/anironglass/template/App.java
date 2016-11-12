package ua.anironglass.template;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import timber.log.Timber;
import ua.anironglass.template.injection.components.ApplicationComponent;
import ua.anironglass.template.injection.components.DaggerApplicationComponent;
import ua.anironglass.template.injection.modules.ApplicationModule;

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initializeTimber();
    }

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (null == mApplicationComponent) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}