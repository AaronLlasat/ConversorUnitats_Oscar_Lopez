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


        double temp = Double.parseDouble(editTemp.getText().toString());

        try {
            boolean checked = ((RadioButton) view).isChecked();
            switch (view.getId()) {
                case R.id.rb_kelvin:
                    if (checked)

                    tvResultCelsius.setText(KelvinToCesius(temp)+ " Celsius");
                    tvResultKelvin.setText( temp + "Kelvin");
                    tvResultFarenheit.setText(KelvinToFareheit(temp)+" Fareheit");
                    tvResultRankine.setText(KelvinToRankine(temp)+" Rankine");
                    break;

                case R.id.rb_Celsius:
                    if (checked)
                        tvResultKelvin.setText("Kelvin");
                    tvResultCelsius.setText("Celsius");
                    tvResultFarenheit.setText("Fareheit");
                    tvResultRankine.setText("Rankine");
                    break;

                case R.id.rb_Farenheit:
                    if (checked)
                        tvResultKelvin.setText("Kelvin");
                    tvResultCelsius.setText("Celsius");
                    tvResultFarenheit.setText("Fareheit");
                    tvResultRankine.setText("Rankine");
                    break;
                case R.id.rb_Rankine:
                    if (checked)
                        tvResultKelvin.setText("Kelvin");
                    tvResultCelsius.setText("Celsius");
                    tvResultFarenheit.setText("Fareheit");
                    tvResultRankine.setText("Rankine");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + view.getId());
            }
        } catch (Exception e) {

        }
    }


    public double KelvinToCesius(double temp){
        DecimalFormat df = new DecimalFormat("#.0");

        double c = temp - 273.15;
        return c;
    }
    public double KelvinToFareheit(double temp){
        double f  = (temp - 273.15) * 9/5 + 32;

        return f;

    }
    public double KelvinToRankine(double temp){
        double r = temp - 273.15;
        return r;

    }

}