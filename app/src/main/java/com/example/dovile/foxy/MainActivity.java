package com.example.dovile.foxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activity2 (View v){

        EditText usernameEditText = (EditText) findViewById(R.id.Username);
        String sUsername = usernameEditText.getText().toString();
        EditText passwordEditText = (EditText) findViewById(R.id.Password);
        String sPassword = passwordEditText.getText().toString();
        if (sUsername.matches("") || sPassword.matches("")) {
            Toast.makeText(this, "Neįvedėte prisijungimo duomenų", Toast.LENGTH_SHORT).show();
            return;
        }
        /**if (sUsername.matches("Administratorius") && sPassword.matches("d999t6t21")) {

        }
        else
        Toast.makeText(this, "Neteisingi prisijungimo duomenys", Toast.LENGTH_SHORT).show();
        return;*/
        Intent intent = new Intent (MainActivity.this, SecondActivity.class);
        startActivity(intent);

    }

    public void signup2 (View v){
        Intent intent = new Intent (MainActivity.this, SignUp.class);
        startActivity(intent);
    }

}
