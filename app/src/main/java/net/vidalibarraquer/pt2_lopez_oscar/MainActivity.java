package net.vidalibarraquer.pt2_lopez_oscar;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_Temperatura;
    Button btn_Longitud;
    Button btn_Pes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Temperatura = findViewById(R.id.btn_Temperatura);
        btn_Temperatura.setOnClickListener(this);

        btn_Longitud = findViewById(R.id.btn_Longitud);
        btn_Longitud.setOnClickListener(this);

        btn_Pes = findViewById(R.id.btn_Pes);
        btn_Pes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try {

        switch (view.getId()) {
            case R.id.btn_Temperatura:
                startActivity(new Intent(this, Temperatura.class));
                break;
            case R.id.btn_Longitud:
                startActivity(new Intent(this, Longitud.class));
                break;
            case R.id.btn_Pes:
                startActivity(new Intent(this, Pes.class));
                break;
            default:
                break;
        }
        }catch(Exception e){

            }



        }


    }
