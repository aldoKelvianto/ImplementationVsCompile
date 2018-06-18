## Implementation vs Compile

This project has two branches:

- implementation
- compile

Both test has similar use case, click FAB to show the component from `myandroidlibrary`. The difference is the configuration I have used on `myandroidlibrary` build.gradle. You can refer to the unit test to see difference.

I will repost my answer about implementation and compile here:

----



This answer will demonstrate the difference between `implementation`, `api`, and `compile` on a project. Let's say I have a project with three Gradle modules:

 - app (an Android application)
 - myandroidlibrary (an Android library)
 - myjavalibrary (a Java library)

`app` has `myandroidlibrary` as dependencies. `myandroidlibrary` has `myjavalibrary`  as dependencies.

> app -> myandroidlibrary -> myjavalibrary

`myjavalibrary` has a `MySecret` class


    public class MySecret {
    
        public static String getSecret() {
            return "Money";
        }
    }

`myandroidlibrary` has `MyAndroidComponent` class that manipulate value from `MySecret` class.

    public class MyAndroidComponent {
    
        private static String component = MySecret.getSecret();
    
        public static String getComponent() {
            return "My component: " + component;
        }    
    }

Lastly, `app` is only interested in the value from `myandroidlibrary`

    TextView tvHelloWorld = findViewById(R.id.tv_hello_world);
    tvHelloWorld.setText(MyAndroidComponent.getComponent());

Now, let's talk about dependencies on `app` build.gradle. It's very simple and intuitive.
    dependencies {
        implementation project(':myandroidlibrary')      
    }

What do you think `myandroidlibrary` build.gradle should look like? We have three options:
    dependencies {
        // Option #1
        implementation project(':myjavalibrary') 
        // Option #2
        compile project(':myjavalibrary')      
        // Option #3
        api project(':myjavalibrary')           
    }

> What's the difference between them and what should I be using?

**Compile and Api**

If you're using `compile` and `api`. Our Android Application now able to access `myandroidcomponent` dependency, which is a `MySecret` class.


    TextView textView = findViewById(R.id.text_view);
    textView.setText(MyAndroidComponent.getComponent());
    // You can access MySecret
    textView.setText(MySecret.getSecret());

**Implementation**

If you're using `implementation` configuration, `MySecret` is not exposed.


    TextView textView = findViewById(R.id.text_view);
    textView.setText(MyAndroidComponent.getComponent());
    // You can NOT access MySecret
    textView.setText(MySecret.getSecret()); // Won't even compile

So, which configuration you should choose? That really depends on your requirement. 

If you want to expose dependencies use `api` or `compile`, if you don't want to expose dependencies (hiding your internal module) then use `implementation`.

This is just a gist of Gradle configurations, refer to [Table 49.1. Java Library plugin - configurations used to declare dependencies][1] for more detailed explanation.


[1]: https://docs.gradle.org/current/userguide/java_library_plugin.html