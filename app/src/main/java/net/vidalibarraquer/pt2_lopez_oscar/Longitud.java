package net.vidalibarraquer.pt2_lopez_oscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Longitud extends AppCompatActivity implements View.OnClickListener{
    Button btn_home;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(this);

        et = findViewById(R.id.editTemp);
        et.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
        case R.id.btn_home:
            startActivity(new Intent(this, MainActivity.class));
    }


    }
}