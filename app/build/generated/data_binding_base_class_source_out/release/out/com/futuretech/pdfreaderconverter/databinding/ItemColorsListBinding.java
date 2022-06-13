// Generated by data binding compiler. Do not edit!
package com.futuretech.pdfreaderconverter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.futuretech.pdfreaderconverter.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemColorsListBinding extends ViewDataBinding {
  @NonNull
  public final ImageView iVColorInner;

  @NonNull
  public final ImageView iVColorOuter;

  protected ItemColorsListBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView iVColorInner, ImageView iVColorOuter) {
    super(_bindingComponent, _root, _localFieldCount);
    this.iVColorInner = iVColorInner;
    this.iVColorOuter = iVColorOuter;
  }

  @NonNull
  public static ItemColorsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_colors_list, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemColorsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemColorsListBinding>inflateInternal(inflater, R.layout.item_colors_list, root, attachToRoot, component);
  }

  @NonNull
  public static ItemColorsListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_colors_list, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemColorsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemColorsListBinding>inflateInternal(inflater, R.layout.item_colors_list, null, false, component);
  }

  public static ItemColorsListBinding bind(@NonNull View view) {
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
  public static ItemColorsListBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemColorsListBinding)bind(component, view, R.layout.item_colors_list);
  }
}