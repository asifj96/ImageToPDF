// Generated by data binding compiler. Do not edit!
package com.futuretech.pdfreaderconverter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.futuretech.pdfreaderconverter.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemListPdfFilesBinding extends ViewDataBinding {
  @NonNull
  public final ConstraintLayout cLMedia;

  @NonNull
  public final ConstraintLayout cLPdfIcon;

  @NonNull
  public final ImageView iVDeleteFile;

  @NonNull
  public final ImageView iVIcon;

  @NonNull
  public final ImageView iVRenameFile;

  @NonNull
  public final ImageView iVShareFile;

  @NonNull
  public final MaterialCardView mCvDocument;

  @NonNull
  public final TextView tvDateTime;

  @NonNull
  public final TextView tvSize;

  @NonNull
  public final TextView tvTitle;

  protected ItemListPdfFilesBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ConstraintLayout cLMedia, ConstraintLayout cLPdfIcon, ImageView iVDeleteFile,
      ImageView iVIcon, ImageView iVRenameFile, ImageView iVShareFile, MaterialCardView mCvDocument,
      TextView tvDateTime, TextView tvSize, TextView tvTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cLMedia = cLMedia;
    this.cLPdfIcon = cLPdfIcon;
    this.iVDeleteFile = iVDeleteFile;
    this.iVIcon = iVIcon;
    this.iVRenameFile = iVRenameFile;
    this.iVShareFile = iVShareFile;
    this.mCvDocument = mCvDocument;
    this.tvDateTime = tvDateTime;
    this.tvSize = tvSize;
    this.tvTitle = tvTitle;
  }

  @NonNull
  public static ItemListPdfFilesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_list_pdf_files, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemListPdfFilesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemListPdfFilesBinding>inflateInternal(inflater, R.layout.item_list_pdf_files, root, attachToRoot, component);
  }

  @NonNull
  public static ItemListPdfFilesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_list_pdf_files, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemListPdfFilesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemListPdfFilesBinding>inflateInternal(inflater, R.layout.item_list_pdf_files, null, false, component);
  }

  public static ItemListPdfFilesBinding bind(@NonNull View view) {
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
  public static ItemListPdfFilesBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemListPdfFilesBinding)bind(component, view, R.layout.item_list_pdf_files);
  }
}