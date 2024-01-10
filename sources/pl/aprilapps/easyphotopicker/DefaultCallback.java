package pl.aprilapps.easyphotopicker;

import pl.aprilapps.easyphotopicker.EasyImage;

public abstract class DefaultCallback implements EasyImage.Callbacks {
    public void onCanceled(EasyImage.ImageSource imageSource, int i) {
    }

    public void onImagePickerError(Exception exc, EasyImage.ImageSource imageSource, int i) {
    }
}
