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

public class DrawFragment extends Fragment {

    private EditText operand1EditText, operand2EditText;
    private Button drawButton;
    private DrawView drawView;

    public DrawFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_draw, container, false);
        operand1EditText = view.findViewById(R.id.operand1_edit_text);
        operand2EditText = view.findViewById(R.id.operand2_edit_text);
        drawButton = view.findViewById(R.id.draw_button);
        drawView = view.findViewById(R.id.draw_view);

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


