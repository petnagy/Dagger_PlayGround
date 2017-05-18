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
