package com.codebzrk.pinentrytextedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PinEntryTextEdit pinEditText = findViewById(R.id.pinEditText);
        confirmButton = findViewById(R.id.confirm_button);
        confirmButton.setEnabled(false);
        pinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().equals("1234")) {
                    confirmButton.setEnabled(true);
                    confirmButton.setBackground(getResources().getDrawable(R.drawable.green_button));
                } else {
                    confirmButton.setBackground(getResources().getDrawable(R.drawable.gray_button));
                    confirmButton.setEnabled(false);
                }
            }
        });
    }
}
