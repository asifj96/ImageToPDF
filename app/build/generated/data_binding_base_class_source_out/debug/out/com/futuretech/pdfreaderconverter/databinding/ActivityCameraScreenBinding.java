// Generated by data binding compiler. Do not edit!
package com.futuretech.pdfreaderconverter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.futuretech.pdfreaderconverter.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityCameraScreenBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout cLBackStartCamera;

  @NonNull
  public final ConstraintLayout cLBatchMode;

  @NonNull
  public final ConstraintLayout cLCameraOverlay;

  @NonNull
  public final ConstraintLayout cLImportFromGallery;

  @NonNull
  public final ConstraintLayout cLMain;

  @NonNull
  public final ConstraintLayout cLThumbnail;

  @NonNull
  public final PreviewView cameraPreview;

  @NonNull
  public final ImageView iVBatchMode;

  @NonNull
  public final ImageView iVCapture;

  @NonNull
  public final ImageView iVImport;

  @NonNull
  public final ImageView iVThumbnail;

  @NonNull
  public final ImageView iVThumbnailArrow;

  @NonNull
  public final LayoutMainToolbarBinding toolbar;

  @NonNull
  public final TextView tvBadgeIcon;

  @NonNull
  public final TextView tvBatchMode;

  @NonNull
  public final TextView tvImport;

  @NonNull
  public final ImageView viewButton;

  protected ActivityCameraScreenBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout cLBackStartCamera, ConstraintLayout cLBatchMode,
      ConstraintLayout cLCameraOverlay, ConstraintLayout cLImportFromGallery,
      ConstraintLayout cLMain, ConstraintLayout cLThumbnail, PreviewView cameraPreview,
      ImageView iVBatchMode, ImageView iVCapture, ImageView iVImport, ImageView iVThumbnail,
      ImageView iVThumbnailArrow, LayoutMainToolbarBinding toolbar, TextView tvBadgeIcon,
      TextView tvBatchMode, TextView tvImport, ImageView viewButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cLBackStartCamera = cLBackStartCamera;
    this.cLBatchMode = cLBatchMode;
    this.cLCameraOverlay = cLCameraOverlay;
    this.cLImportFromGallery = cLImportFromGallery;
    this.cLMain = cLMain;
    this.cLThumbnail = cLThumbnail;
    this.cameraPreview = cameraPreview;
    this.iVBatchMode = iVBatchMode;
    this.iVCapture = iVCapture;
    this.iVImport = iVImport;
    this.iVThumbnail = iVThumbnail;
    this.iVThumbnailArrow = iVThumbnailArrow;
    this.toolbar = toolbar;
    this.tvBadgeIcon = tvBadgeIcon;
    this.tvBatchMode = tvBatchMode;
    this.tvImport = tvImport;
    this.viewButton = viewButton;
  }

  @NonNull
  public static ActivityCameraScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_camera_screen, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCameraScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityCameraScreenBinding>inflateInternal(inflater, R.layout.activity_camera_screen, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCameraScreenBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_camera_screen, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityCameraScreenBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityCameraScreenBinding>inflateInternal(inflater, R.layout.activity_camera_screen, null, false, component);
  }

  public static ActivityCameraScreenBinding bind(@NonNull View view) {
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
  public static ActivityCameraScreenBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityCameraScreenBinding)bind(component, view, R.layout.activity_camera_screen);
  }
}
