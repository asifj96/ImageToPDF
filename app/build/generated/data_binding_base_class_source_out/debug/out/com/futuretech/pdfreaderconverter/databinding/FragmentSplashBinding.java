// Generated by data binding compiler. Do not edit!
package com.futuretech.pdfreaderconverter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.futuretech.pdfreaderconverter.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSplashBinding extends ViewDataBinding {
  @NonNull
  public final LottieAnimationView lottieAnim;

  @NonNull
  public final TextView tvSplashTitle;

  protected FragmentSplashBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LottieAnimationView lottieAnim, TextView tvSplashTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.lottieAnim = lottieAnim;
    this.tvSplashTitle = tvSplashTitle;
  }

  @NonNull
  public static FragmentSplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_splash, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSplashBinding>inflateInternal(inflater, R.layout.fragment_splash, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSplashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_splash, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSplashBinding>inflateInternal(inflater, R.layout.fragment_splash, null, false, component);
  }

  public static FragmentSplashBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentSplashBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSplashBinding)bind(component, view, R.layout.fragment_splash);
  }
}