package com.example.apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    private EditText newNameET;

    private Button submitNewNameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        newNameET = findViewById(R.id.newNameET);
        submitNewNameBtn = findViewById(R.id.submitNewNameBtn);

        String oldName = getIntent().getExtras().getString("currentUsername");
        newNameET.setText(oldName);


        submitNewNameBtn.setOnClickListener(
                (v) -> {

                    Intent data = new Intent();
                    String newName = newNameET.getText().toString();
                    data.putExtra("newUsername", newName);
                    setResult(RESULT_OK, data);
                    finish();
                }
        );


    }
}