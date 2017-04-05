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
import android.widget.Spinner;

public class NewPost extends SecondActivity {
    private EditText mAmmountView;
    private EditText mPriceView;
    private EditText mLengthView;
    private EditText mWidthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_post);
        Button saugoti = (Button) findViewById(R.id.save);

        mAmmountView = (EditText) findViewById(R.id.kiekis);
        mPriceView = (EditText) findViewById(R.id.kaina);
        mLengthView = (EditText) findViewById(R.id.ilgis);
        mWidthView = (EditText) findViewById(R.id.plotis);

        saugoti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mAmmountView.setError(null);
                mPriceView.setError(null);
                mLengthView.setError(null);
                mWidthView.setError(null);

                String ammount = mAmmountView.getText().toString();
                String price = mPriceView.getText().toString();
                String length = mLengthView.getText().toString();
                String width = mWidthView.getText().toString();

                boolean cancel = false;
                View focusView = null;

                if (!isValid(ammount)) {
                    mAmmountView.setError("Neteisingai nurodytas kiekis.");
                    focusView = mAmmountView;
                    cancel = true;
                }
                if (!isValid2(price)) {
                    mPriceView.setError("Neteisingai nurodyta kaina.");
                    focusView = mPriceView;
                    cancel = true;
                }
                if (!isValid2(length)) {
                    mLengthView.setError("Neteisingai nurodytas ilgis.");
                    focusView = mLengthView;
                    cancel = true;
                }
                if (!isValid2(width)) {
                    mWidthView.setError("Neteisingai nurodytas plotis.");
                    focusView = mWidthView;
                    cancel = true;
                }

               final Spinner tipas = (Spinner) findViewById(R.id.tipas);
                final EditText kiekisEditText = (EditText) findViewById(R.id.kiekis);
                final Spinner uzsakymai = (Spinner) findViewById(R.id.uzsakymai);
                final EditText kainaEditText = (EditText) findViewById(R.id.kaina);
                final Spinner technika = (Spinner) findViewById(R.id.technika);
                final   EditText ilgisEditText = (EditText) findViewById(R.id.ilgis);
                final  EditText plotisEditText = (EditText) findViewById(R.id.plotis);
                final Spinner reguliavimas = (Spinner) findViewById(R.id.reguliavimas);

                //@Override

                //public void onClick (View v)
                        //{
                        String sKiekis = kiekisEditText.getText().toString();
                String sKaina = kainaEditText.getText().toString();
                String sIlgis = ilgisEditText.getText().toString();
                String sPlotis = plotisEditText.getText().toString();
                if (sKiekis.matches("") || sKaina.matches("") || sIlgis.matches("") || sPlotis.matches("")) {
                    Toast.makeText(NewPost.this, "Patikrinkite, ar įvedėte visus duomenis.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(NewPost.this,
                        String.valueOf(tipas.getSelectedItem()) + "\n" +
                                kiekisEditText.getText() + "\n" +
                                String.valueOf(uzsakymai.getSelectedItem()) + "\n" +
                                kainaEditText.getText() + "\n" +
                                String.valueOf(technika.getSelectedItem()) + "\n" +
                                ilgisEditText.getText() + "\n" +
                                plotisEditText.getText() + "\n" +
                                String.valueOf(reguliavimas.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
                if (cancel) {
                    focusView.requestFocus();
                }
                else {
                    Intent intent = new Intent(NewPost.this, NewPost.class);
                    startActivity(intent);
                }
            }

        });
    }

    private boolean isValid(String credentials) {
        final String CREDENTIALS_PATTERN = "^([0-9])+$";
        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);
        Matcher matcher = pattern.matcher(credentials);
        return matcher.matches();
    }

    private boolean isValid2(String credentials) {
        final String CREDENTIALS_PATTERN2 = "^([0-9]+.+[0-9])+$";
        Pattern pattern2 = Pattern.compile(CREDENTIALS_PATTERN2);
        Matcher matcher = pattern2.matcher(credentials);
        return matcher.matches();
    }
}
