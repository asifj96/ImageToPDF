package com.futuretech.pdfreaderconverter.databinding;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCropScreenBindingImpl extends ActivityCropScreenBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(16);
        sIncludes.setIncludes(0, 
            new String[] {"layout_main_toolbar"},
            new int[] {1},
            new int[] {com.futuretech.pdfreaderconverter.R.layout.layout_main_toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.cropView, 2);
        sViewsWithIds.put(R.id.mCvBottomBar, 3);
        sViewsWithIds.put(R.id.cLRotate, 4);
        sViewsWithIds.put(R.id.iVRotate, 5);
        sViewsWithIds.put(R.id.tvRotateLeft, 6);
        sViewsWithIds.put(R.id.cLFlip, 7);
        sViewsWithIds.put(R.id.iVFlipHorizontal, 8);
        sViewsWithIds.put(R.id.tvFlipHorizontal, 9);
        sViewsWithIds.put(R.id.cLFitImage, 10);
        sViewsWithIds.put(R.id.iVReset, 11);
        sViewsWithIds.put(R.id.tvFitImage, 12);
        sViewsWithIds.put(R.id.cLApply, 13);
        sViewsWithIds.put(R.id.iVApply, 14);
        sViewsWithIds.put(R.id.tvApply, 15);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCropScreenBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private ActivityCropScreenBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[10]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[7]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[4]
            , (com.theartofdev.edmodo.cropper.CropImageView) bindings[2]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[11]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.LinearLayout) bindings[3]
            , (com.futuretech.pdfreaderconverter.databinding.LayoutMainToolbarBinding) bindings[1]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[6]
            );
        this.cLCropPreview.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        toolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        toolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeToolbar((com.futuretech.pdfreaderconverter.databinding.LayoutMainToolbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeToolbar(com.futuretech.pdfreaderconverter.databinding.LayoutMainToolbarBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): toolbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}