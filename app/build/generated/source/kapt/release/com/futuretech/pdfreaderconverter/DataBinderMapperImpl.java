package com.futuretech.pdfreaderconverter;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.futuretech.pdfreaderconverter.databinding.ActivityCameraScreenBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityCropScreenBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityEditImageScreenBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityFilterScreenBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityGalleryScreenBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityHomeFilesBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityMainBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ActivityPdfFileViewerBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.DialogConfirmationBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.DialogPdfPasswordBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.DialogSaveAsPdfBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.FileOperationDialogBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.FragmentEditImageBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.FragmentPdfFilesBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.FragmentRootBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.FragmentSplashBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ItemColorsListBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ItemFilterListBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ItemGalleryBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ItemHomeBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ItemHomeDialogBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.ItemListPdfFilesBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.LayoutMainToolbarBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.LayoutRootItemBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.LayoutSearchItemBindingImpl;
import com.futuretech.pdfreaderconverter.databinding.LoadingDialogBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYCAMERASCREEN = 1;

  private static final int LAYOUT_ACTIVITYCROPSCREEN = 2;

  private static final int LAYOUT_ACTIVITYEDITIMAGESCREEN = 3;

  private static final int LAYOUT_ACTIVITYFILTERSCREEN = 4;

  private static final int LAYOUT_ACTIVITYGALLERYSCREEN = 5;

  private static final int LAYOUT_ACTIVITYHOMEFILES = 6;

  private static final int LAYOUT_ACTIVITYMAIN = 7;

  private static final int LAYOUT_ACTIVITYPDFFILEVIEWER = 8;

  private static final int LAYOUT_DIALOGCONFIRMATION = 9;

  private static final int LAYOUT_DIALOGPDFPASSWORD = 10;

  private static final int LAYOUT_DIALOGSAVEASPDF = 11;

  private static final int LAYOUT_FILEOPERATIONDIALOG = 12;

  private static final int LAYOUT_FRAGMENTEDITIMAGE = 13;

  private static final int LAYOUT_FRAGMENTPDFFILES = 14;

  private static final int LAYOUT_FRAGMENTROOT = 15;

  private static final int LAYOUT_FRAGMENTSPLASH = 16;

  private static final int LAYOUT_ITEMCOLORSLIST = 17;

  private static final int LAYOUT_ITEMFILTERLIST = 18;

  private static final int LAYOUT_ITEMGALLERY = 19;

  private static final int LAYOUT_ITEMHOME = 20;

  private static final int LAYOUT_ITEMHOMEDIALOG = 21;

  private static final int LAYOUT_ITEMLISTPDFFILES = 22;

  private static final int LAYOUT_LAYOUTMAINTOOLBAR = 23;

  private static final int LAYOUT_LAYOUTROOTITEM = 24;

  private static final int LAYOUT_LAYOUTSEARCHITEM = 25;

  private static final int LAYOUT_LOADINGDIALOG = 26;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(26);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_camera_screen, LAYOUT_ACTIVITYCAMERASCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_crop_screen, LAYOUT_ACTIVITYCROPSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_edit_image_screen, LAYOUT_ACTIVITYEDITIMAGESCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_filter_screen, LAYOUT_ACTIVITYFILTERSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_gallery_screen, LAYOUT_ACTIVITYGALLERYSCREEN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_home_files, LAYOUT_ACTIVITYHOMEFILES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.activity_pdf_file_viewer, LAYOUT_ACTIVITYPDFFILEVIEWER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.dialog_confirmation, LAYOUT_DIALOGCONFIRMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.dialog_pdf_password, LAYOUT_DIALOGPDFPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.dialog_save_as_pdf, LAYOUT_DIALOGSAVEASPDF);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.file_operation_dialog, LAYOUT_FILEOPERATIONDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.fragment_edit_image, LAYOUT_FRAGMENTEDITIMAGE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.fragment_pdf_files, LAYOUT_FRAGMENTPDFFILES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.fragment_root, LAYOUT_FRAGMENTROOT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.fragment_splash, LAYOUT_FRAGMENTSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.item_colors_list, LAYOUT_ITEMCOLORSLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.item_filter_list, LAYOUT_ITEMFILTERLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.item_gallery, LAYOUT_ITEMGALLERY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.item_home, LAYOUT_ITEMHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.item_home_dialog, LAYOUT_ITEMHOMEDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.item_list_pdf_files, LAYOUT_ITEMLISTPDFFILES);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.layout_main_toolbar, LAYOUT_LAYOUTMAINTOOLBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.layout_root_item, LAYOUT_LAYOUTROOTITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.layout_search_item, LAYOUT_LAYOUTSEARCHITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.futuretech.pdfreaderconverter.R.layout.loading_dialog, LAYOUT_LOADINGDIALOG);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYCAMERASCREEN: {
          if ("layout/activity_camera_screen_0".equals(tag)) {
            return new ActivityCameraScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_camera_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYCROPSCREEN: {
          if ("layout/activity_crop_screen_0".equals(tag)) {
            return new ActivityCropScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_crop_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYEDITIMAGESCREEN: {
          if ("layout/activity_edit_image_screen_0".equals(tag)) {
            return new ActivityEditImageScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_edit_image_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYFILTERSCREEN: {
          if ("layout/activity_filter_screen_0".equals(tag)) {
            return new ActivityFilterScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_filter_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYGALLERYSCREEN: {
          if ("layout/activity_gallery_screen_0".equals(tag)) {
            return new ActivityGalleryScreenBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_gallery_screen is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYHOMEFILES: {
          if ("layout/activity_home_files_0".equals(tag)) {
            return new ActivityHomeFilesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_home_files is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYPDFFILEVIEWER: {
          if ("layout/activity_pdf_file_viewer_0".equals(tag)) {
            return new ActivityPdfFileViewerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_pdf_file_viewer is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGCONFIRMATION: {
          if ("layout/dialog_confirmation_0".equals(tag)) {
            return new DialogConfirmationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_confirmation is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGPDFPASSWORD: {
          if ("layout/dialog_pdf_password_0".equals(tag)) {
            return new DialogPdfPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_pdf_password is invalid. Received: " + tag);
        }
        case  LAYOUT_DIALOGSAVEASPDF: {
          if ("layout/dialog_save_as_pdf_0".equals(tag)) {
            return new DialogSaveAsPdfBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for dialog_save_as_pdf is invalid. Received: " + tag);
        }
        case  LAYOUT_FILEOPERATIONDIALOG: {
          if ("layout/file_operation_dialog_0".equals(tag)) {
            return new FileOperationDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for file_operation_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEDITIMAGE: {
          if ("layout/fragment_edit_image_0".equals(tag)) {
            return new FragmentEditImageBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_edit_image is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTPDFFILES: {
          if ("layout/fragment_pdf_files_0".equals(tag)) {
            return new FragmentPdfFilesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_pdf_files is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTROOT: {
          if ("layout/fragment_root_0".equals(tag)) {
            return new FragmentRootBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_root is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSPLASH: {
          if ("layout/fragment_splash_0".equals(tag)) {
            return new FragmentSplashBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_splash is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCOLORSLIST: {
          if ("layout/item_colors_list_0".equals(tag)) {
            return new ItemColorsListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_colors_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFILTERLIST: {
          if ("layout/item_filter_list_0".equals(tag)) {
            return new ItemFilterListBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_filter_list is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMGALLERY: {
          if ("layout/item_gallery_0".equals(tag)) {
            return new ItemGalleryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_gallery is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMHOME: {
          if ("layout/item_home_0".equals(tag)) {
            return new ItemHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_home is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMHOMEDIALOG: {
          if ("layout/item_home_dialog_0".equals(tag)) {
            return new ItemHomeDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_home_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMLISTPDFFILES: {
          if ("layout/item_list_pdf_files_0".equals(tag)) {
            return new ItemListPdfFilesBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_list_pdf_files is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTMAINTOOLBAR: {
          if ("layout/layout_main_toolbar_0".equals(tag)) {
            return new LayoutMainToolbarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_main_toolbar is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTROOTITEM: {
          if ("layout/layout_root_item_0".equals(tag)) {
            return new LayoutRootItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_root_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSEARCHITEM: {
          if ("layout/layout_search_item_0".equals(tag)) {
            return new LayoutSearchItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_search_item is invalid. Received: " + tag);
        }
        case  LAYOUT_LOADINGDIALOG: {
          if ("layout/loading_dialog_0".equals(tag)) {
            return new LoadingDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for loading_dialog is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.github.gcacace.signaturepad.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(26);

    static {
      sKeys.put("layout/activity_camera_screen_0", com.futuretech.pdfreaderconverter.R.layout.activity_camera_screen);
      sKeys.put("layout/activity_crop_screen_0", com.futuretech.pdfreaderconverter.R.layout.activity_crop_screen);
      sKeys.put("layout/activity_edit_image_screen_0", com.futuretech.pdfreaderconverter.R.layout.activity_edit_image_screen);
      sKeys.put("layout/activity_filter_screen_0", com.futuretech.pdfreaderconverter.R.layout.activity_filter_screen);
      sKeys.put("layout/activity_gallery_screen_0", com.futuretech.pdfreaderconverter.R.layout.activity_gallery_screen);
      sKeys.put("layout/activity_home_files_0", com.futuretech.pdfreaderconverter.R.layout.activity_home_files);
      sKeys.put("layout/activity_main_0", com.futuretech.pdfreaderconverter.R.layout.activity_main);
      sKeys.put("layout/activity_pdf_file_viewer_0", com.futuretech.pdfreaderconverter.R.layout.activity_pdf_file_viewer);
      sKeys.put("layout/dialog_confirmation_0", com.futuretech.pdfreaderconverter.R.layout.dialog_confirmation);
      sKeys.put("layout/dialog_pdf_password_0", com.futuretech.pdfreaderconverter.R.layout.dialog_pdf_password);
      sKeys.put("layout/dialog_save_as_pdf_0", com.futuretech.pdfreaderconverter.R.layout.dialog_save_as_pdf);
      sKeys.put("layout/file_operation_dialog_0", com.futuretech.pdfreaderconverter.R.layout.file_operation_dialog);
      sKeys.put("layout/fragment_edit_image_0", com.futuretech.pdfreaderconverter.R.layout.fragment_edit_image);
      sKeys.put("layout/fragment_pdf_files_0", com.futuretech.pdfreaderconverter.R.layout.fragment_pdf_files);
      sKeys.put("layout/fragment_root_0", com.futuretech.pdfreaderconverter.R.layout.fragment_root);
      sKeys.put("layout/fragment_splash_0", com.futuretech.pdfreaderconverter.R.layout.fragment_splash);
      sKeys.put("layout/item_colors_list_0", com.futuretech.pdfreaderconverter.R.layout.item_colors_list);
      sKeys.put("layout/item_filter_list_0", com.futuretech.pdfreaderconverter.R.layout.item_filter_list);
      sKeys.put("layout/item_gallery_0", com.futuretech.pdfreaderconverter.R.layout.item_gallery);
      sKeys.put("layout/item_home_0", com.futuretech.pdfreaderconverter.R.layout.item_home);
      sKeys.put("layout/item_home_dialog_0", com.futuretech.pdfreaderconverter.R.layout.item_home_dialog);
      sKeys.put("layout/item_list_pdf_files_0", com.futuretech.pdfreaderconverter.R.layout.item_list_pdf_files);
      sKeys.put("layout/layout_main_toolbar_0", com.futuretech.pdfreaderconverter.R.layout.layout_main_toolbar);
      sKeys.put("layout/layout_root_item_0", com.futuretech.pdfreaderconverter.R.layout.layout_root_item);
      sKeys.put("layout/layout_search_item_0", com.futuretech.pdfreaderconverter.R.layout.layout_search_item);
      sKeys.put("layout/loading_dialog_0", com.futuretech.pdfreaderconverter.R.layout.loading_dialog);
    }
  }
}
