package net.vidalibarraquer.pt2_lopez_oscar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Longitud extends AppCompatActivity implements View.OnClickListener {

    Button btn_home;
    EditText Distancia;

    RadioButton rb_km;
    RadioButton rb_mi;
    RadioButton rb_yarda;
    RadioButton rb_pulgada;

    TextView tvResultKm;
    TextView tvResultPulgada;
    TextView tvResultYarda;
    TextView tvResultMilla;

    TextView tvKm;
    TextView tvPulgada;
    TextView tvYarda;
    TextView tvMilla;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_longitud);


        Distancia = findViewById(R.id.Distancia);
        Distancia.setOnClickListener(this);

        tvKm = findViewById(R.id.tvKm);
        tvKm.setOnClickListener(this);

        tvPulgada = findViewById(R.id.tvPulgada);
        tvPulgada.setOnClickListener(this);

        tvYarda = findViewById(R.id.tvYarda);
        tvYarda.setOnClickListener(this);

        tvMilla = findViewById(R.id.tvMilla);
        tvMilla.setOnClickListener(this);

        tvResultKm = findViewById(R.id.tvResultKm);
        tvResultKm.setOnClickListener(this);

        tvResultPulgada = findViewById(R.id.tvResultPulgada);
        tvResultPulgada.setOnClickListener(this);

        tvResultYarda = findViewById(R.id.tvResultYarda);
        tvResultYarda.setOnClickListener(this);

        tvResultMilla = findViewById(R.id.tvResultMilla);
        tvResultMilla.setOnClickListener(this);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(this);

        rb_km = findViewById(R.id.rb_km);
        rb_km.setOnClickListener(this);

        rb_mi = findViewById(R.id.rb_mi);
        rb_mi.setOnClickListener(this);

        rb_yarda = findViewById(R.id.rb_yarda);
        rb_yarda.setOnClickListener(this);

        rb_pulgada = findViewById(R.id.rb_pulgada);
        rb_pulgada.setOnClickListener(this);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {

        String km = getString(R.string.km);
        String mi = getString(R.string.mi);
        String yd = getString(R.string.Yd);
        String inch = getString(R.string.Polzada);



        try {
            if (view.getId() == R.id.btn_home) {
                startActivity(new Intent(this, MainActivity.class));

            } else {
                double d = Double.parseDouble(Distancia.getText().toString());
                boolean checked = ((RadioButton) view).isChecked();
                switch (view.getId()) {
                    case R.id.rb_km:
                        if (checked)
                            publicar(km , mi ,yd ,inch);
                            tvResultKm.setText( d+"");
                        tvResultMilla.setText(KmToMile(d));
                        tvResultYarda.setText(KmToYard(d));
                        tvResultPulgada.setText(KmToInch(d));

                        break;
                    case R.id.rb_mi:
                        if (checked)
                            publicar(km , mi ,yd ,inch);
                            tvResultKm.setText(MileToKm(d));
                        tvResultMilla.setText( d+"");
                        tvResultYarda.setText(MileToYard(d));
                        tvResultPulgada.setText(MileToInch(d));
                        break;

                    case R.id.rb_yarda:
                        if (checked)
                            publicar(km , mi ,yd ,inch);
                            tvResultKm.setText( YardToKm(d));
                        tvResultMilla.setText(YardToMile(d));
                        tvResultYarda.setText( d+"");
                        tvResultPulgada.setText(YardToInch(d));
                        break;
                    case R.id.rb_pulgada:
                        if (checked)
                            publicar(km , mi ,yd ,inch);
                            tvResultKm.setText(InchToKm(d));
                        tvResultMilla.setText(InchToMile(d));
                        tvResultYarda.setText(InchToYard(d));
                        tvResultPulgada.setText(d+"");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + view.getId());
                }

            }

        } catch (Exception e) {
            e.getLocalizedMessage();

        }
    }



//km to..
        public String KmToMile(double d){
            double m = d * 0.62137;
            return format(m);
        }
        public String KmToYard(double d){
            double y = d * 1093.61;
            return format(y);

        }
        public String KmToInch(double d){
            double i = d * 39370.1;
            return format(i);
        }

        //Mile to...

        public String MileToKm(double d){
            double k = d /0.62137;
            return format(k);
        }

        public String MileToYard(double d){
            double y =  d *1760;
            return format(y);
        }
        public String MileToInch(double d){
            double i = d * 63360;
            return format(i);
        }

//Yard to..

        public String YardToKm(double d){
            double k = d *0.0009144;
            return format(k);
        }
        public String YardToMile(double d){
            double k = d *0.00056818;
            return format(k);
        }
        public String YardToInch(double d){
            double k = d * 36;
            return format(k);
        }
        //Inch to..

        public String InchToKm(double d) {
            double k = d/39370;
            return format(k);
        }
        public String InchToMile(double d) {
            double m = d/63360;
            return format(m);
        }
        public String InchToYard(double d) {
            double y = d * 0.0277778;
            return format(y);
        }
//format decimal
        public String format(double t){
            DecimalFormat decimalFormat = new DecimalFormat("#######.#####");
            return decimalFormat.format(t);

        }
        public void publicar(String km ,String mi ,String yd ,String inch){
            tvKm.setText(km );
            tvPulgada.setText(inch);
            tvYarda.setText(yd);
            tvMilla.setText(mi);
        }

    }
