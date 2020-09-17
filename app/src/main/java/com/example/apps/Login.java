package com.example.apps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button logInBtn;
    private EditText userET;
    private EditText passwordET;
    private String user;
    private String pass;
    private static final int editUsername_CODE = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logInBtn = findViewById(R.id.logInBtn);
        userET = findViewById(R.id.userET);
        passwordET = findViewById(R.id.passET);

        logInBtn.setOnClickListener(

                (view) -> {

                    user = userET.getText().toString();
                    pass = passwordET.getText().toString();

                    Intent toProfile = new Intent(this, Profile.class);
                    toProfile.putExtra("currentUsername", user);
                    startActivityForResult(toProfile, editUsername_CODE);
                    //Toast.makeText(this,user+", "+pass, Toast.LENGTH_LONG).show();


                }

        );
    }//cierra la clase onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case editUsername_CODE:

                if (resultCode == RESULT_OK) {
                    String newName = data.getExtras().getString("newUsername");
                    userET.setText(newName);
                    Toast.makeText(this, "Se cambió el nombre de usuario exitosamente", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, "No se pudo cambiar el nombre de usuario, intente en unos instantes", Toast.LENGTH_LONG).show();
                }
                break;

            default:

                break;


        }//cierra el switch de requestCode
    }//cierra el onActivityResult
}//cierra la clase mainActivity