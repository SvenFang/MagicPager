# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.


-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontskipnonpubliclibraryclassmembers


-dontpreverify
-verbose
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-dontwarn android.support.v4.**
-dontwarn javax.microedition.khronos.**
-dontwarn All
#-keepattributes InnerClasses
-keepattributes JavascriptInterface
-keepattributes Signature
-keepattributes *Annotation*
-ignorewarnings

-dontoptimize

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.preference.Preference
-keep class * extends android.support.v4.app.Fragment
-keep class android.support.v4.app.Fragment{*;}
-keep class android.support.v4.app.FragmentManager{*;}
-keep class android.support.v4.app.FragmentPagerAdapter{*;}
-keep class android.support.v4.app.FragmentActivity {*;}
-keep class android.support.v4.view.ViewPager{*;}
-keep class android.support.v4.view.ViewPager$* {*;}
-keep class android.support.v4.view.PagerAdapter{*;}
-keep class * extends android.view.View

-keepclasseswithmembers class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
    public static ** valueOf(int);
}

-keepclassmembers class * implements android.os.Parcelable {
    static ** CREATOR;
    <fields>;
    <methods>;
}

-keep class * implements java.io.Serializable {
    *;
}

-keep public class **.R$*{
   public static final int *;
}

-keepattributes SourceFile,LineNumberTable



-keep class com.yy.magerpage.** {*;}

-keep class org.mozilla.javascript.** { *; }
