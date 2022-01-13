package com.freshnin.adminapplication.callbacks;

public interface ImageUploadCallbacks {
    void onProgressUpdate(int percentage);

    void onError();

    void onFinish();
}
