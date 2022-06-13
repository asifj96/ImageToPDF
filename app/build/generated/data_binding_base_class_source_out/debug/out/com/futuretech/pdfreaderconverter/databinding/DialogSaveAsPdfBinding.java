// Generated by data binding compiler. Do not edit!
package com.futuretech.pdfreaderconverter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.futuretech.pdfreaderconverter.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogSaveAsPdfBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout cLCancelSave;

  @NonNull
  public final ConstraintLayout cLEditText;

  @NonNull
  public final ConstraintLayout cLSaveAsGallery;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final ImageView iVClearText;

  @NonNull
  public final ImageView iVLowQuality;

  @NonNull
  public final ImageView iVMaxQuality;

  @NonNull
  public final ImageView iVMediumQuality;

  @NonNull
  public final ImageView iVRegularQuality;

  @NonNull
  public final ImageView iVSelectedPDF;

  @NonNull
  public final LinearLayout llCircle;

  @NonNull
  public final LinearLayout llSelectQuality;

  @NonNull
  public final LinearLayout llText;

  @NonNull
  public final TextView tVLowQuality;

  @NonNull
  public final TextView tVMaxQuality;

  @NonNull
  public final TextView tVMediumQuality;

  @NonNull
  public final TextView tVRegularQuality;

  @NonNull
  public final TextView tvCancel;

  @NonNull
  public final TextView tvPdfTitle;

  @NonNull
  public final TextView tvSave;

  @NonNull
  public final TextView tvSelectQuality;

  @NonNull
  public final TextView tvTitle;

  @NonNull
  public final View view;

  @NonNull
  public final View view1;

  @NonNull
  public final View viewLine;

  @NonNull
  public final View viewLineEditText;

  @NonNull
  public final View viewLow;

  @NonNull
  public final View viewMedium;

  @NonNull
  public final View viewRegular;

  protected DialogSaveAsPdfBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout cLCancelSave, ConstraintLayout cLEditText, ConstraintLayout cLSaveAsGallery,
      EditText edtName, ImageView iVClearText, ImageView iVLowQuality, ImageView iVMaxQuality,
      ImageView iVMediumQuality, ImageView iVRegularQuality, ImageView iVSelectedPDF,
      LinearLayout llCircle, LinearLayout llSelectQuality, LinearLayout llText,
      TextView tVLowQuality, TextView tVMaxQuality, TextView tVMediumQuality,
      TextView tVRegularQuality, TextView tvCancel, TextView tvPdfTitle, TextView tvSave,
      TextView tvSelectQuality, TextView tvTitle, View view, View view1, View viewLine,
      View viewLineEditText, View viewLow, View viewMedium, View viewRegular) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cLCancelSave = cLCancelSave;
    this.cLEditText = cLEditText;
    this.cLSaveAsGallery = cLSaveAsGallery;
    this.edtName = edtName;
    this.iVClearText = iVClearText;
    this.iVLowQuality = iVLowQuality;
    this.iVMaxQuality = iVMaxQuality;
    this.iVMediumQuality = iVMediumQuality;
    this.iVRegularQuality = iVRegularQuality;
    this.iVSelectedPDF = iVSelectedPDF;
    this.llCircle = llCircle;
    this.llSelectQuality = llSelectQuality;
    this.llText = llText;
    this.tVLowQuality = tVLowQuality;
    this.tVMaxQuality = tVMaxQuality;
    this.tVMediumQuality = tVMediumQuality;
    this.tVRegularQuality = tVRegularQuality;
    this.tvCancel = tvCancel;
    this.tvPdfTitle = tvPdfTitle;
    this.tvSave = tvSave;
    this.tvSelectQuality = tvSelectQuality;
    this.tvTitle = tvTitle;
    this.view = view;
    this.view1 = view1;
    this.viewLine = viewLine;
    this.viewLineEditText = viewLineEditText;
    this.viewLow = viewLow;
    this.viewMedium = viewMedium;
    this.viewRegular = viewRegular;
  }

  @NonNull
  public static DialogSaveAsPdfBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_save_as_pdf, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogSaveAsPdfBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogSaveAsPdfBinding>inflateInternal(inflater, R.layout.dialog_save_as_pdf, root, attachToRoot, component);
  }

  @NonNull
  public static DialogSaveAsPdfBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_save_as_pdf, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogSaveAsPdfBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogSaveAsPdfBinding>inflateInternal(inflater, R.layout.dialog_save_as_pdf, null, false, component);
  }

  public static DialogSaveAsPdfBinding bind(@NonNull View view) {
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
  public static DialogSaveAsPdfBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogSaveAsPdfBinding)bind(component, view, R.layout.dialog_save_as_pdf);
  }
}
