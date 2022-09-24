package net.vidalibarraquer.pt2_lopez_oscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Temperatura extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb_kelvin;
    RadioButton rb_Celsius;
    RadioButton rb_Farenheit;
    RadioButton rb_Rankine;
    EditText et;
    Button btn_home;
    TextView tvResultKelvin;
    TextView tvResultCelsius;
    TextView tvResultFarenheit;
    TextView tvResultRankine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(this);

        rb_kelvin = findViewById(R.id.rb_kelvin);
        rb_kelvin.setOnClickListener(this);

        rb_Celsius = findViewById(R.id.rb_Celsius);
        rb_Celsius.setOnClickListener(this);

        rb_Farenheit = findViewById(R.id.rb_Farenheit);
        rb_Farenheit.setOnClickListener(this);

        rb_Rankine = findViewById(R.id.rb_Rankine);
        rb_Rankine.setOnClickListener(this);

        et = findViewById(R.id.et);
        et.setOnClickListener(this);

        tvResultKelvin = findViewById(R.id.tvResultKelvin);
        tvResultKelvin.setOnClickListener(this);

        tvResultCelsius = findViewById(R.id.tvResultCelsius);
        tvResultCelsius.setOnClickListener(this);

        tvResultFarenheit = findViewById(R.id.tvResultFarenheit);
        tvResultFarenheit.setOnClickListener(this);

        tvResultRankine = findViewById(R.id.tvResultRankine);
        tvResultRankine.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        double t = Double.parseDouble(et.getText().toString());
        boolean checked = ((RadioButton) view).isChecked();
        try {

            switch (view.getId()) {
                case R.id.rb_kelvin:
                    if (checked)

                        tvResultCelsius.setText("Celsius  " + (KelvinToCesius(t)) + "º");
                    tvResultKelvin.setText("Kelvin  " + t + "º");
                    tvResultFarenheit.setText("Fareheit  " + KelvinToFareheit(t) + "º");
                    tvResultRankine.setText("Rankine  " + KelvinToRankine(t) + "º");
                    break;

                case R.id.rb_Celsius:
                    if (checked)
                        tvResultKelvin.setText("Kelvin  " + CelsiustoKelvin(t) + "º");
                    tvResultCelsius.setText("Celsius  " + t + "º");
                    tvResultFarenheit.setText("Fareheit  " + CelsiustoFarenheit(t) + "º");
                    tvResultRankine.setText("Rankine  " + CelsiustoRankine(t) + "º");
                    break;

                case R.id.rb_Farenheit:
                    if (checked)
                        tvResultKelvin.setText("Kelvin  " + FarenheitToKelvin(t) + "º");
                    tvResultCelsius.setText("Celsius  " + FarenheitToCelcius(t) + "º");
                    tvResultFarenheit.setText("Fareheit  " + t + "º");
                    tvResultRankine.setText("Rankine  " + FarenheitToRankine(t) + "º");
                    break;
                case R.id.rb_Rankine:
                    if (checked)
                        tvResultKelvin.setText("Kelvin  " + t + "º");
                    tvResultCelsius.setText("Celsius  " + RankinetoCesius(t) + "º");
                    tvResultFarenheit.setText("Fareheit  " + RankinetoFareheit(t) + "º");
                    tvResultRankine.setText("Rankine  " + RankinetoKelvin(t) + "º");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }

        } catch (Exception e) {

        }

        switch (view.getId()) {
            case R.id.btn_home:
                startActivity(new Intent(this, MainActivity.class));
        }


    }


//kelvin to..
    public String KelvinToCesius(double t){
        double c = t - 273.15;
        return format(c);
    }
    public String KelvinToFareheit(double t){
        double f =(t - 273.15) * 9/5 + 32;
        return format(f);

    }
    public String KelvinToRankine(double t){
        double r = t *1.8;
        return format(r);
    }

   //Rankine to...

    public String RankinetoKelvin(double t){
        double k = t /1.8;
        return format(k);
    }

    public String RankinetoFareheit(double t){
        double f =  t -459.67;
        return format(f);
    }
    public String RankinetoCesius(double t){
        double c = (t - 491.37) /1.8;
        return format(c);
    }

//farenheit to..

    public String FarenheitToKelvin(double t){
        double k= (t -32)/1.8 +273.15;
        return format(k);
    }
    public String FarenheitToRankine(double t){
        double r= t +459.67;
        return format(r);
    }
    public String FarenheitToCelcius(double t){
        double c = (t -32)*1.8;
        return format(c);
    }
    //celsius to..

    public String CelsiustoKelvin(double t) {
        double k= t +273.15;
        return format(k);
    }
    public String CelsiustoRankine(double t) {
        double r= (t +273.15)*1.8;
        return format(r);
    }
    public String CelsiustoFarenheit(double t) {
        double f= (t *1.8) + 32;
        return format(f);
    }

    public String format(double t){
        DecimalFormat decimalFormat = new DecimalFormat("#####.##");
        return decimalFormat.format(t);

    }

}


