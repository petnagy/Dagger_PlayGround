# Dagger_PlayGround

It is a playground to exercise Dagger with Android.
Dagger2 is the most popular Dependency Injection framework in Android. In this project you can find some example how can you use it in your android project.

##Install Dagger

It is easy with gradle, just update your build.gradle file's dependencies:

```
dependencies {
    compile "com.google.dagger:dagger:2.9"
    annotationProcessor "com.google.dagger:dagger-compiler:2.9"
    provided 'javax.annotation:jsr250-api:1.0'
}
```

##Working of Dagger

First of all we need to declare the object graphs. It is easy we need to create modules and components. A module will contain the real object how we would like to create any object. In component we should enumerate the using modules and where we will inject the component. When we run our code Dagger (with annotation processor) will generate the code which will be used in our application. Your are able to check and debug it.

##Module

When we start to use a Module we need to annotate it with ```@Module``` annotation.
We can use local and global wariables in our modules.

```
@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }
```
When we create the activity module it will have an instance of activtiy. We can use it later like an activity context.

If we want to provide any object, we need to annotate the method with ```@Provides```. If we forget it than we will get any error message after all. 

example:
```
@Provides
    Context provideContext() {
        return activity;
    }
```

##Component

we can enumerate the modules what we want to use in the components.

```
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, IngredientModule.class,
        CoffeeModule.class, ExtraModule.class})
```

And we are able to add some dependencies between the object graph with use of dependencies. However dependencies is an optional field.
```
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
```

Component will be used in the injection. So we need it use it where we will inject the object graph. And here can we enumerate that methods which will be exposed from any module which is used by component.

##Level of Injection

In most cases we need to declare one Application level injection. It will be injected when our Application will be instantiated. Manny times we can use an application context, like at the case of intantiating SharedPreference or SQLite database, etc..
If we want to use Application or Application context in any object we must put those instatiation of those objects into the ApplicationModule.

##@Singleton annotation

If we annotate a provide method with ```@Singleton``` than it will be a Singleton object. It will be instantiated only once during the running of our application.
