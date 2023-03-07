package com.example.coursework;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class DrawFragment extends Fragment {

    private EditText operand1EditText, operand2EditText;
    private Button drawButton;
    private DrawView drawView;
    private CustomViewModel viewModel;

    public DrawFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(CustomViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_draw, container, false);
        operand1EditText = view.findViewById(R.id.operand1_edit_text);
        operand2EditText = view.findViewById(R.id.operand2_edit_text);
        drawButton = view.findViewById(R.id.draw_button);
        drawView = view.findViewById(R.id.draw_view);

        // Getting the 1st operand
        viewModel.getOperand1().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String value) {
                operand1EditText.setText(value);
            }
        });

        // Getting the 2nd operand
        viewModel.getOperand2().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String value) {
                operand2EditText.setText(value);
            }
        });

        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String operand1String = operand1EditText.getText().toString();
                String operand2String = operand2EditText.getText().toString();

                if (TextUtils.isEmpty(operand1String) || TextUtils.isEmpty(operand2String)) {
                    Toast.makeText(getActivity(), "Please enter values for both operands", Toast.LENGTH_SHORT).show();
                    return;
                }

                int operand1 = Integer.parseInt(operand1String);
                int operand2 = Integer.parseInt(operand2String);
                drawView.setOperands(operand1, operand2);
            }
        });

        return view;
    }
}


