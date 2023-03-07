package com.example.coursework;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class CalculatorFragment extends Fragment implements View.OnClickListener {

    private EditText operand1EditText;
    private EditText operand2EditText;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultTextView;
    private CustomViewModel viewModel;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CustomViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        // Find views by id
        operand1EditText = view.findViewById(R.id.operand1_edittext);
        operand2EditText = view.findViewById(R.id.operand2_edittext);
        addButton = view.findViewById(R.id.add_button);
        subtractButton = view.findViewById(R.id.subtract_button);
        multiplyButton = view.findViewById(R.id.multiply_button);
        divideButton = view.findViewById(R.id.divide_button);
        resultTextView = view.findViewById(R.id.result_textview);

        // Set onClickListener to buttons
        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (TextUtils.isEmpty(operand1EditText.getText().toString()) || TextUtils.isEmpty(operand2EditText.getText().toString())) {
            Toast.makeText(getActivity(), "Please enter values for both operands", Toast.LENGTH_SHORT).show();
            return;
        }

        int operand1 = Integer.parseInt(operand1EditText.getText().toString());
        int operand2 = Integer.parseInt(operand2EditText.getText().toString());
        int result = 0;

        switch (view.getId()) {
            case R.id.add_button:
                result = operand1 + operand2;
                break;
            case R.id.subtract_button:
                result = operand1 - operand2;
                break;
            case R.id.multiply_button:
                result = operand1 * operand2;
                break;
            case R.id.divide_button:
                if (operand2 == 0) {
                    Toast.makeText(getActivity(), "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = operand1 / operand2;
                break;
        }

        // Passing the data between Fragments using ViewModel
        viewModel.setOperand1(String.valueOf(operand1));
        viewModel.setOperand2(String.valueOf(operand2));

        resultTextView.setText("Result: " + result);
    }
}


