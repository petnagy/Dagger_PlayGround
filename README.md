# Dagger_PlayGround

It is a playground to exercise Dagger with Android.
Dagger2 is the most popular Dependency Injection framework in Android. In this project you can find some example how can you use it in your android project.

## Install Dagger

It is easy with gradle, just update your build.gradle file's dependencies:

```
dependencies {
    compile "com.google.dagger:dagger:2.9"
    annotationProcessor "com.google.dagger:dagger-compiler:2.9"
    provided 'javax.annotation:jsr250-api:1.0'
}
```

## About this projecct

The purpose of this project to create a sandbox where other developers could play with Dagger and study some usecases.
If you are not familiar with Dagger you can find lot of good bogs and sites where you can study how to use Dagger2 library.

[Codepath](https://github.com/codepath/android_guides/wiki/Dependency-Injection-with-Dagger-2),
[Official Dagger documentation](https://google.github.io/dagger/users-guide.html)

## Dependency Injection

There are 3 major kind of dependency injection:
- Contructor Injection
- Field Injection
- Method Injection

## Constructor Injection

It is the most powerfull way of dependency injection. If you have a Foo class and you want to use another object Boo in it than you can use dependency injection to create the field object. You can set the Boo object in the constructor. It is really clear and you can find easily the dependency.

```
public class Foo {
    
    private Boo boo;
    
    public Foo(Boo boo) {
        this.boo = boo;
    }
    
}
```

In this case after the constructor you can use the boo object. If you do not use Dagger than you have to create a Boo object when you create the Foo like here:
```
Foo foo = new Foo(new Boo());
```

It is more easy with Dagger. You have to add the instantiation in a Module.

```
@Provides
Foo providesFoo(Boo boo) {
    return new Foo(boo);
}

@Provides
Boo providesBoo() {
    return new Boo();
}
```

And where you use Dagger injection (e.g. your Acttivity) you can use ```@Inject``` annotation.

```
public class OneActivtiy extends Activity {

    @Inject
    Foo foo;

}
```

Be careful because Dagger cannot instantiate any private field (because it will not use reflection).

## Field injection

Filed injection is a solution to inject an object into the injectable class with annotating the field with ```@Inject```.
It seems easy however there are more problems.

1. The dependency is hidden. (with Constructor injection you can see the dependency)
2. We will not know when will be injected the field. After the class was constructed but we will not know exactly when.

You can see an example if you have a look how we use the dependency injection in an Activity.

If you want to use in other class you must do the next:

Use ```@Inject``` annotation to the injected class.
```
public class Foo {
    
    @Inject
    public Foo() {...}

}
```
And do not use any ```@Provides``` method in your module.
For example look ShowCaseModel class.

## Method injection

We can annotate with ```@Inject``` any setter method. And it will be called after the constructor was called.

Example:
```
public class Watcher {

    @Inject
    public Watcher() {...}

    public void watch(Foo foo) {
        Log.d("Method Injection", "It is a method Injection");
    }
}
```

```
public class Foo {

    @Inject
    public Foo() {...}
    
    @Inject
    public void addWatcher(Watcher watcher) {
        watcher.watch(this);
    }

}
```

We must annotate both constructor with @Inject. And there is no any @Provides method in any module for Watcher object.
Have a look Watcher.class in the project.
