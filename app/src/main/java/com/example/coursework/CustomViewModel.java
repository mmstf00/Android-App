package com.example.coursework;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CustomViewModel extends ViewModel {
    private MutableLiveData<String> operand1 = new MutableLiveData<>();
    private MutableLiveData<String> operand2 = new MutableLiveData<>();

    public void setOperand1(String value) {
        operand1.setValue(value);
    }

    public LiveData<String> getOperand1() {
        return operand1;
    }

    public void setOperand2(String value) {
        operand2.setValue(value);
    }

    public LiveData<String> getOperand2() {
        return operand2;
    }
}
