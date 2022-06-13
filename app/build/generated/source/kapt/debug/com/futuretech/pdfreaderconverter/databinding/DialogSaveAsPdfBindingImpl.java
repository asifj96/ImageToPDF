package com.futuretech.pdfreaderconverter.databinding;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DialogSaveAsPdfBindingImpl extends DialogSaveAsPdfBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvTitle, 1);
        sViewsWithIds.put(R.id.view, 2);
        sViewsWithIds.put(R.id.cLEditText, 3);
        sViewsWithIds.put(R.id.edtName, 4);
        sViewsWithIds.put(R.id.iVClearText, 5);
        sViewsWithIds.put(R.id.viewLineEditText, 6);
        sViewsWithIds.put(R.id.iVSelectedPDF, 7);
        sViewsWithIds.put(R.id.tvPdfTitle, 8);
        sViewsWithIds.put(R.id.tvSelectQuality, 9);
        sViewsWithIds.put(R.id.llSelectQuality, 10);
        sViewsWithIds.put(R.id.llCircle, 11);
        sViewsWithIds.put(R.id.iVLowQuality, 12);
        sViewsWithIds.put(R.id.viewLow, 13);
        sViewsWithIds.put(R.id.iVMediumQuality, 14);
        sViewsWithIds.put(R.id.viewMedium, 15);
        sViewsWithIds.put(R.id.iVRegularQuality, 16);
        sViewsWithIds.put(R.id.viewRegular, 17);
        sViewsWithIds.put(R.id.iVMaxQuality, 18);
        sViewsWithIds.put(R.id.llText, 19);
        sViewsWithIds.put(R.id.tVLowQuality, 20);
        sViewsWithIds.put(R.id.tVMediumQuality, 21);
        sViewsWithIds.put(R.id.tVRegularQuality, 22);
        sViewsWithIds.put(R.id.tVMaxQuality, 23);
        sViewsWithIds.put(R.id.cLCancelSave, 24);
        sViewsWithIds.put(R.id.view1, 25);
        sViewsWithIds.put(R.id.tvCancel, 26);
        sViewsWithIds.put(R.id.viewLine, 27);
        sViewsWithIds.put(R.id.tvSave, 28);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DialogSaveAsPdfBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }
    private DialogSaveAsPdfBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[24]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[0]
            , (android.widget.EditText) bindings[4]
            , (android.widget.ImageView) bindings[5]
            , (android.widget.ImageView) bindings[12]
            , (android.widget.ImageView) bindings[18]
            , (android.widget.ImageView) bindings[14]
            , (android.widget.ImageView) bindings[16]
            , (android.widget.ImageView) bindings[7]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.TextView) bindings[20]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[21]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[1]
            , (android.view.View) bindings[2]
            , (android.view.View) bindings[25]
            , (android.view.View) bindings[27]
            , (android.view.View) bindings[6]
            , (android.view.View) bindings[13]
            , (android.view.View) bindings[15]
            , (android.view.View) bindings[17]
            );
        this.cLSaveAsGallery.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}