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

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class OctalFragment extends Fragment {

    private EditText decimalEditText;
    private TextView octalTextView;
    private Button convertButton;
    private CustomViewModel viewModel;

    public OctalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CustomViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_octal, container, false);

        // Get references to views
        decimalEditText = view.findViewById(R.id.decimal_edittext);
        octalTextView = view.findViewById(R.id.octal_textview);
        convertButton = view.findViewById(R.id.convert_button);

        // Getting the 1st operand
        viewModel.getOperand1().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String value) {
                decimalEditText.setText(value);
            }
        });

        // Set click listener for convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(decimalEditText.getText().toString())) {
                    Toast.makeText(getActivity(), "Please enter value", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert decimal number to octal
                int decimal = Integer.parseInt(decimalEditText.getText().toString());
                String octal = Integer.toOctalString(decimal);
                octalTextView.setText("Octal number: " + octal);
            }
        });

        return view;
    }
}

