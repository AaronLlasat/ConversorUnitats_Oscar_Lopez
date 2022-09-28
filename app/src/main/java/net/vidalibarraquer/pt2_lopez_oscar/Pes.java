package net.vidalibarraquer.pt2_lopez_oscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Pes extends AppCompatActivity implements View.OnClickListener {
    Button btn_home;


    EditText Pes;

    RadioButton rb_Kg;
    RadioButton rb_oz;
    RadioButton rb_lb;
    RadioButton rb_st;

    TextView tvResultKg;
    TextView tvResultOz;
    TextView tvResultLb;
    TextView tvResultSt;

    TextView tvKg;
    TextView tvOz;
    TextView tvLb;
    TextView tvSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pes);

        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(this);

        tvKg = findViewById(R.id.tvKg);
        tvKg.setOnClickListener(this);

        tvOz = findViewById(R.id.tvOz);
        tvOz.setOnClickListener(this);

        tvLb = findViewById(R.id.tvLb);
        tvLb.setOnClickListener(this);

        tvSt = findViewById(R.id.tvSt);
        tvSt.setOnClickListener(this);


        rb_Kg = findViewById(R.id.rb_Kg);
        rb_Kg.setOnClickListener(this);

        rb_oz = findViewById(R.id.rb_oz);
        rb_oz.setOnClickListener(this);

        rb_lb = findViewById(R.id.rb_lb);
        rb_lb.setOnClickListener(this);

        rb_st = findViewById(R.id.rb_st);
        rb_st.setOnClickListener(this);

        Pes = findViewById(R.id.Pes);
        Pes.setOnClickListener(this);

        tvResultKg = findViewById(R.id.tvResultKg);
        tvResultKg.setOnClickListener(this);

        tvResultOz = findViewById(R.id.tvResultOz);
        tvResultOz.setOnClickListener(this);

        tvResultLb = findViewById(R.id.tvResultLb);
        tvResultLb.setOnClickListener(this);

        tvResultSt = findViewById(R.id.tvResultSt);
        tvResultSt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String Kg = getString(R.string.Kg);
        String Oz = getString(R.string.Oz);
        String Lb = getString(R.string.Lb);
        String St = getString(R.string.Stone);



        try {
            if (view.getId() == R.id.btn_home){
                startActivity(new Intent(this, MainActivity.class));

            }else {
                double p = Double.parseDouble(Pes.getText().toString());
                boolean checked = ((RadioButton) view).isChecked();
                switch (view.getId()) {
                    case R.id.rb_Kg:
                        if (checked)
                            publicar( Kg , Oz , Lb , St);
                            tvResultKg.setText( p +"");
                        tvResultLb.setText(KgToLb(p) );
                        tvResultOz.setText(KgToOz(p) );
                        tvResultSt.setText(KgToSt(p) );
                        break;

                    case R.id.rb_oz:
                        if (checked)
                            publicar( Kg , Oz , Lb , St);
                        tvResultKg.setText(OzToKg(p) );
                        tvResultLb.setText(OzToLb(p) );
                        tvResultOz.setText( (p) +"");
                        tvResultSt.setText(OzToSt(p) );
                        break;

                    case R.id.rb_lb:
                        if (checked)
                            publicar( Kg , Oz , Lb , St);
                        tvResultKg.setText(LbToKg(p) );
                        tvResultLb.setText( p+"");
                        tvResultOz.setText(LbToOz(p));
                        tvResultSt.setText(LbToSt(p) );
                        break;
                    case R.id.rb_st:
                        if (checked)
                            publicar( Kg , Oz , Lb , St);
                        tvResultKg.setText(StToKg(p) );
                        tvResultLb.setText(StToLb(p) );
                        tvResultOz.setText(StToOz(p) );
                        tvResultSt.setText((p) +"");
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + view.getId());
                }

            }

        } catch (Exception e) {
            e.getLocalizedMessage();

        }
    }

    //kg to..
    public String KgToLb(double p){ //ok
        double l = p * 2.2046226218;
        return format(l);
    }
    public String KgToOz(double p){ //ok
        double o = p * 35.2739619;
        return format(o);

    }
    public String KgToSt(double p){ //ok
        double s = p * 0.15747;
        return format(s);
    }

    //Lliures to...

    public String LbToKg(double p){ //ok
        double k = p * 0.45359237;
        return format(k);
    }

    public String LbToOz(double p){ //ok
        double o = p * 16;
        return format(o);
    }
    public String LbToSt(double p){ //ok
        double s = p / 14;
        return format(s);
    }

//Oz to..

    public String OzToKg(double p){ //ok
        double k = p * 0.0283495231 ;
        return format(k);
    }
    public String OzToLb(double p){ //ok
        double l = p /16;
        return format(l);
    }
    public String OzToSt(double p){ //ok
        double s = p * 0.00446428571429;
        return format(s);
    }
    //celsius to..

    public String StToKg(double p) {  //ok
        double k = p/0.15747;
        return format(k);
    }
    public String StToOz(double p) {
        double o = p/224;
        return format(o);
    }
    public String StToLb(double p) {
        double l = p *14000;
        return format(l);
    }
    //format decimal
    public String format(double t){
        DecimalFormat decimalFormat = new DecimalFormat("#####.##");
        return decimalFormat.format(t);

    }
    public void publicar(String Kg ,String Oz ,String Lb ,String St){
        tvKg.setText(Kg);
        tvOz.setText(Oz);
        tvLb.setText(Lb);
        tvSt.setText(St);

    }

}
