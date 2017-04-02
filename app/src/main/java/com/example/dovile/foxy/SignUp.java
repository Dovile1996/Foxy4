package com.example.dovile.foxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

   public void signup3 (View v){

       EditText usernameEditText = (EditText) findViewById(R.id.Vart);
       String sVart = usernameEditText.getText().toString();
       EditText password1EditText = (EditText) findViewById(R.id.Slapt1);
       String sSlapt1 = password1EditText.getText().toString();
       EditText password2EditText = (EditText) findViewById(R.id.Slapt2);
       String sSlapt2 = password2EditText.getText().toString();
       EditText emailEditText = (EditText) findViewById(R.id.Elp);
        String sElp = password2EditText.getText().toString();
        if (sVart.matches("") || sSlapt1.matches("") || sSlapt2.matches("") || sElp.matches("") ) {
            Toast.makeText(this, "Neįvedėte duomenų", Toast.LENGTH_SHORT).show();
            return;
        }
        if (sSlapt1.matches(sSlapt2)) {
            Toast.makeText(this, "Registracija sėkminga!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent (SignUp.this, MainActivity.class);
            startActivity(intent);
        }
       else Toast.makeText(this, "Slaptažodžiai nesutampa.", Toast.LENGTH_SHORT).show();
        return;

    }

}
