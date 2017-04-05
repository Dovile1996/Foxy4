package com.example.dovile.foxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends MainActivity {
    private EditText mUsernameView;
    private EditText mPasswordView;
    private EditText mPassword2View;
    private EditText mEmailView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Button registruotis = (Button) findViewById(R.id.button3);

        mUsernameView = (EditText) findViewById(R.id.Vart);
        mPasswordView = (EditText) findViewById(R.id.Slapt1);
        mPassword2View = (EditText) findViewById(R.id.Slapt2);
        mEmailView = (EditText) findViewById(R.id.Elp);

        registruotis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mUsernameView.setError(null);
                mPasswordView.setError(null);
                mPassword2View.setError(null);
                mEmailView.setError(null);
                String username = mUsernameView.getText().toString();
                String password = mPasswordView.getText().toString();
                String email = mEmailView.getText().toString();
                EditText password2EditText = (EditText) findViewById(R.id.Slapt2);
                String password2 = password2EditText.getText().toString();

                boolean cancel = false;
                View focusView = null;

                if (!isValid(username)) {
                    mUsernameView.setError("Neteisingas vartotojo vardas.");
                    focusView = mPasswordView;
                    cancel = true;
                }
                if (!isValid(password)) {
                    mPasswordView.setError("Neteisingas slaptažodis.");
                    focusView = mPasswordView;
                    cancel = true;
                }
                if (!isValid2(email)) {
                    mEmailView.setError("Neteisingas el.paštas.");
                    focusView = mEmailView;
                    cancel = true;
                }
                if (password2.matches("")) {
                    mPassword2View.setError("Pakartokite slaptažodį.");
                    focusView = mPassword2View;
                    cancel = true;
                }
                if (password.matches(username)) {
                    mPasswordView.setError("Prisijungimo vardas ir slaptažodis negali sutapti.");
                    focusView = mPasswordView;
                    cancel = true;
                }
                if (!password.matches(password2)) {
                    mPassword2View.setError("Slaptažodžiai nesutampa.");
                    focusView = mPassword2View;
                    cancel = true;
                }
                if (cancel) {
                    focusView.requestFocus();
                }
                else {
                    Intent intent = new Intent(SignUp.this, SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValid(String credentials){
        final String CREDENTIALS_PATTERN ="^([0-9a-zA-Z]{3,15})+$";
        Pattern pattern =Pattern.compile(CREDENTIALS_PATTERN);
        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }
    private boolean isValid2(String credentials){
        final String CREDENTIALS_PATTERN2 ="^([0-9a-zA-Z]+@+[a-z]+.+[a-z])+$";
        Pattern pattern2 =Pattern.compile(CREDENTIALS_PATTERN2);
        Matcher matcher = pattern2.matcher(credentials);
        return matcher.matches();
    }

}
