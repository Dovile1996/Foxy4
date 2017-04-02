package com.example.dovile.foxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.app.Activity;
import android.view.View.OnClickListener;

public class NewPost extends SecondActivity {

    private Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_post);
    }

    public void CreatePost (View v){

        EditText kiekisEditText = (EditText) findViewById(R.id.kiekis);
        String sKiekis = kiekisEditText.getText().toString();
        EditText kainaEditText = (EditText) findViewById(R.id.kaina);
        String sKaina = kainaEditText.getText().toString();
        EditText ilgisEditText = (EditText) findViewById(R.id.ilgis);
        String sIlgis = ilgisEditText.getText().toString();
        EditText plotisEditText = (EditText) findViewById(R.id.plotis);
        String sPlotis = plotisEditText.getText().toString();
        if (sKiekis.matches("") || sKaina.matches("") || sIlgis.matches("") || sPlotis.matches("")) {
            Toast.makeText(this, "Patikrinkite, ar įvedėte visus duomenis.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent (NewPost.this, NewPost.class);
        startActivity(intent);
        Toast.makeText(this, "Įrašas įtrauktas sėkmingai!", Toast.LENGTH_SHORT).show();
    }

}
