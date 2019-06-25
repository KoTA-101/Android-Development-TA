package com.example.innstant.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.innstant.data.OpenConnectionTask;

public class SignUpViewModel extends ViewModel {
    public void openServerConnection() {
        new OpenConnectionTask().execute();
    }
}
