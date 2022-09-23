package net.vidalibarraquer.pt2_lopez_oscar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Temperatura extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb_kelvin;
    RadioButton rb_Celsius;
    RadioButton rb_Farenheit;
    RadioButton rb_Rankine;
    EditText editTemp;
    TextView tv_temp_titol;
    TextView tvResultKelvin;
    TextView tvResultCelsius;
    TextView tvResultFarenheit;
    TextView tvResultRankine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);

        rb_kelvin = findViewById(R.id.rb_kelvin);
        rb_kelvin.setOnClickListener(this);

        rb_Celsius = findViewById(R.id.rb_Celsius);
        rb_Celsius.setOnClickListener(this);

        rb_Farenheit = findViewById(R.id.rb_Farenheit);
        rb_Farenheit.setOnClickListener(this);

        rb_Rankine = findViewById(R.id.rb_Rankine);
        rb_Rankine.setOnClickListener(this);

        editTemp = findViewById(R.id.editTemp);
        editTemp.setOnClickListener(this);

        tvResultKelvin = findViewById(R.id.tvResultKelvin);
        tvResultKelvin.setOnClickListener(this);

        tvResultCelsius = findViewById(R.id.tvResultCelsius);
        tvResultCelsius.setOnClickListener(this);

        tvResultFarenheit = findViewById(R.id.tvResultFarenheit);
        tvResultFarenheit.setOnClickListener(this);

        tvResultRankine = findViewById(R.id.tvResultRankine);
        tvResultRankine.setOnClickListener(this);

        tv_temp_titol = findViewById(R.id.tv_temp_titol);
        tv_temp_titol.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        try {
            double t = Double.parseDouble(editTemp.getText().toString());
            boolean checked = ((RadioButton) view).isChecked();
            switch (view.getId()) {
                case R.id.rb_kelvin:
                    if (checked)

                    tvResultCelsius.setText((KelvinToCesius(t))+ " Celsius");
                    tvResultKelvin.setText( t + "Kelvin");
                    tvResultFarenheit.setText(KelvinToFareheit(t)+" Fareheit");
                    tvResultRankine.setText(KelvinToRankine(t)+" Rankine");
                    break;

                case R.id.rb_Celsius:
                    if (checked)
                        tvResultKelvin.setText(CelsiustoKelvin(t)+" Kelvin");
                    tvResultCelsius.setText(t+ " Celsius");
                    tvResultFarenheit.setText(CelsiustoFarenheit(t)+" Fareheit");
                    tvResultRankine.setText(CelsiustoRankine(t)+" Rankine");
                    break;

                case R.id.rb_Farenheit:
                    if (checked)
                        tvResultKelvin.setText(FarenheitToKelvin(t)+" Kelvin");
                    tvResultCelsius.setText(FarenheitToCelcius(t)+" Celsius");
                    tvResultFarenheit.setText(t + "Fareheit");
                    tvResultRankine.setText(FarenheitToRankine(t) +" Rankine");
                    break;
                case R.id.rb_Rankine:
                    if (checked)
                        tvResultKelvin.setText(t +" Kelvin");
                    tvResultCelsius.setText(RankinetoCesius(t)+" Celsius");
                    tvResultFarenheit.setText(RankinetoFareheit(t) +"Fareheit");
                    tvResultRankine.setText(RankinetoKelvin(t)+" Rankine");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        } catch (Exception e) {

        }
    }

//kelvin to..
    public double KelvinToCesius(double t){
        return t - 273.15;
    }
    public double KelvinToFareheit(double t){
        return (t - 273.15) * 9/5 + 32;

    }
    public double KelvinToRankine(double t){
        return t - 273.15;

    }

   //Rankine to...

    public double RankinetoKelvin(double t){
        return t /1.8;
    }
    public double RankinetoFareheit(double t){
        return t -459.67;
    }
    public double RankinetoCesius(double t){
        return (t - 491.37) /1.8;
    }

//farenheit to..

    public double FarenheitToKelvin(double t){
        return (t -32)/1.8 +273.15;
    }
    public double FarenheitToRankine(double t){
        return t +459.67;
    }
    public double FarenheitToCelcius(double t){
        return (t -32)*1.8;
    }
    //celsius to..

    public double CelsiustoKelvin(double t){
        return t +273.15;

    }
    public double CelsiustoRankine(double t){
        return (t +273.15)*1.8;

    }
    public double CelsiustoFarenheit(double t){
        return (t *1.8) + 32;

    }
}