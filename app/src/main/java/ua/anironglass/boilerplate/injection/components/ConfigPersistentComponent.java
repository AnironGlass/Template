package ua.anironglass.boilerplate.injection.components;

import dagger.Component;
import ua.anironglass.boilerplate.injection.modules.ActivityModule;
import ua.anironglass.boilerplate.injection.scopes.ConfigPersistent;
import ua.anironglass.boilerplate.ui.base.BaseActivity;


/**
 * A dagger component that will live during the lifecycle of an Activity but it won't
 * be destroy during configuration changes. Check {@link BaseActivity} to see how this components
 * survives configuration changes.
 * Use the {@link ConfigPersistent} scope to annotate dependencies that need to survive
 * configuration changes (for example Presenters).
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

}