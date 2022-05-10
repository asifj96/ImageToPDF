package com.futuretech.pdfreaderconverter.databinding;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentEditImageBindingImpl extends FragmentEditImageBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(23);
        sIncludes.setIncludes(0, 
            new String[] {"layout_main_toolbar"},
            new int[] {1},
            new int[] {com.futuretech.pdfreaderconverter.R.layout.layout_main_toolbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.viewPagerImages, 2);
        sViewsWithIds.put(R.id.cLCounter, 3);
        sViewsWithIds.put(R.id.iVPreviousImage, 4);
        sViewsWithIds.put(R.id.tvImagesNo, 5);
        sViewsWithIds.put(R.id.iVNextImage, 6);
        sViewsWithIds.put(R.id.mCvBottomBar, 7);
        sViewsWithIds.put(R.id.cLCropImage, 8);
        sViewsWithIds.put(R.id.iVCropImage, 9);
        sViewsWithIds.put(R.id.tvCrop, 10);
        sViewsWithIds.put(R.id.cLFilterImage, 11);
        sViewsWithIds.put(R.id.iVFilterImage, 12);
        sViewsWithIds.put(R.id.tvFilter, 13);
        sViewsWithIds.put(R.id.cLSignature, 14);
        sViewsWithIds.put(R.id.iVSignature, 15);
        sViewsWithIds.put(R.id.tvSignature, 16);
        sViewsWithIds.put(R.id.cLText, 17);
        sViewsWithIds.put(R.id.iVText, 18);
        sViewsWithIds.put(R.id.tvText, 19);
        sViewsWithIds.put(R.id.cLDone, 20);
        sViewsWithIds.put(R.id.iVDone, 21);
        sViewsWithIds.put(R.id.tvDone, 22);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentEditImageBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }
    private FragmentEditImageBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[20]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[11]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[14]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[17]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.ImageView) bindings[21]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.ImageView) bindings[4]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.LinearLayout) bindings[7]
            , (com.futuretech.pdfreaderconverter.databinding.LayoutMainToolbarBinding) bindings[1]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[19]
            , (androidx.viewpager.widget.ViewPager) bindings[2]
            );
        this.cLMain.setTag(null);
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