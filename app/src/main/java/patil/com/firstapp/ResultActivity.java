package patil.com.firstapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView lengthFeet, lengthinches, widthFeet, widthInches;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        lengthFeet = findViewById(R.id.length_feet);
        lengthFeet.setText(String.valueOf(getIntent().getIntExtra("length_feet", 0)));
        lengthFeet.setVisibility(View.VISIBLE);

        lengthinches = findViewById(R.id.Length_Inches);
        lengthinches.setText(String.valueOf(getIntent().getIntExtra("length_inches", 0)));
        lengthinches.setVisibility(View.VISIBLE);


        widthFeet = findViewById(R.id.width_Feet);
        widthFeet.setText(String.valueOf(getIntent().getIntExtra("width_feet", 0)));
        widthFeet.setVisibility(View.VISIBLE);
        widthFeet.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


        widthInches = findViewById(R.id.width_Inches);
        widthInches.setText(String.valueOf(getIntent().getIntExtra("width_inches", 0)));
        widthInches.setVisibility(View.VISIBLE);
        widthInches.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        int totalArea = getArea((int) getIntent().getExtras().get("total_length"), (int) getIntent().getExtras().get("total_width"));
        TextView tableField = findViewById(R.id.value_sq_in);
        tableField.setText(String.valueOf(totalArea) + " SqInchs");

        tableField = findViewById(R.id.value_aaya);
        tableField.setText(getAya(totalArea));

        tableField = findViewById(R.id.value_dhan);
        tableField.setText(getDhan(totalArea));

        tableField = findViewById(R.id.value_run);
        tableField.setText(getRun(totalArea));

        tableField = findViewById(R.id.value_tithi);
        tableField.setText(getTithi(totalArea));

        tableField = findViewById(R.id.value_week);
        tableField.setText(getWeek(totalArea));

        tableField = findViewById(R.id.value_nakshtra);
        tableField.setText(getNakshatra(totalArea));

        tableField = findViewById(R.id.value_yog);
        tableField.setText(getYog(totalArea));

        tableField = findViewById(R.id.value_karam);
        tableField.setText(getKaram(totalArea));

        tableField = findViewById(R.id.value_aunsh);
        tableField.setText(getAunsh(totalArea));

        tableField = findViewById(R.id.value_aayushy);
        int ayushya = getAayushy(totalArea);
        tableField.setText(String.valueOf(ayushya));

        tableField = findViewById(R.id.value_dikpal);
        tableField.setText(getDikpal(ayushya));
    }

    private int getArea(int length, int width){
        return (length * width);
    }

    private String getAya(int totalArea) {
        int d = (totalArea % 8);
        String value = "";
        switch (d){
            case 0: value = "Kakay";
            break;
            case 1: value = "Dhvaja";
            break;
            case 2: value = "Dhumr";
            break;
            case 3: value = "Sinha";
            break;
            case 4: value = "Shvan";
            break;
            case 5: value = "Vrashabh";
            break;
            case 6: value = "Khar";
            break;
            case 7: value = "Gaja";
            break;
        }
        return value;
    }

    private String getDhan(int totalArea){
        return String.valueOf((totalArea * 8) % 12);
    }

    private String getRun(int totalAre){
        return String.valueOf((totalAre * 3) % 8);
    }

    private String getTithi(int totalAre){
        int d = ((totalAre * 8) % 30);
        String value = "";

        switch (d){
            case 0: value = "Amavase";
            break;
            case 1: value = "Prathama";
                break;
            case 2: value = "Dvitiya";
                break;
            case 3: value = "Tritiya";
                break;
            case 4: value = "Chaturthi";
                break;
            case 5: value = "Panchami";
                break;
            case 6: value = "Shashthi";
                break;
            case 7: value = "Saptami";
                break;
            case 8: value = "Asthami";
                break;
            case 9: value = "Navami";
                break;
            case 10: value = "Dashami";
                break;
            case 11: value = "Ekadashi";
                break;
            case 12: value = "Dvadashi";
                break;
            case 13: value = "Trayodashi";
                break;
            case 14: value = "Chaturdashi";
                break;
            case 15: value = "Pornima";
                break;
            case 16: value = "Prathama";
                break;
            case 17: value = "Dvitiya";
                break;
            case 18: value = "Tritiya";
                break;
            case 19: value = "Chaturthi";
                break;
            case 20: value = "Panchami";
                break;
            case 21: value = "Shashthi";
                break;
            case 22: value = "Saptami";
                break;
            case 23: value = "Asthami";
                break;
            case 24: value = "Navami";
                break;
            case 25: value = "Dashami";
                break;
            case 26: value = "Ekadashi";
                break;
            case 27: value = "Dvadashi";
                break;
            case 28: value = "Trayodashi";
                break;
            case 29: value = "Chaturdashi";
                break;
        }
        return value;
    }

    private String getWeek(int totalAre){
        int d = ((totalAre*9) % 7);
        String value = "";
        switch (d){
            case 0 : value = "Saturday";
            break;
            case 1 : value = "Sunday";
                break;
            case 2 : value = "Monday";
                break;
            case 3 : value = "Tuesday";
                break;
            case 4 : value = "Wednesday";
                break;
            case 5 : value = "Thursday";
                break;
            case 6 : value = "Friday";
                break;
        }
        return value;
    }

    private String getNakshatra(int totalArea){
        int d = ((totalArea * 8) % 27);
        String value = "";
        switch (d) {
            case 0:
                value = "Revati";
                break;
            case 1:
                value = "Ashvini";
                break;
            case 2:
                value = "Bharani";
                break;
            case 3:
                value = "Kritika";
                break;
            case 4:
                value = "Rohini";
                break;
            case 5:
                value = "Mraghashisha";
                break;
            case 6:
                value = "Aaridha";
                break;
            case 7:
                value = "Punarvasu";
                break;
            case 8:
                value = "Pushya";
                break;
            case 9:
                value = "Aslesha";
                break;
            case 10:
                value = "Magha";
                break;
            case 11:
                value = "Purva";
                break;
            case 12:
                value = "Vuttara";
                break;
            case 13:
                value = "Hastya";
                break;
            case 14:
                value = "Chitta";
                break;
            case 15:
                value = "Swati";
                break;
            case 16:
                value = "Vishakha";
                break;
            case 17:
                value = "Anuradha";
                break;
            case 18:
                value = "Jesta";
                break;
            case 19:
                value = "Mula";
                break;
            case 20:
                value = "Purvashadh";
                break;
            case 21:
                value = "Uttarashadh";
                break;
            case 22:
                value = "Shravana";
                break;
            case 23:
                value = "Dhanista";
                break;
            case 24:
                value = "Shatatara";
                break;
            case 25:
                value = "Purvabhadrapada";
                break;
            case 26:
                value = "Uttarbhadrapada";
                break;
        }
        return value;
    }

    private String getYog(int totalArea){
        int d = ((totalArea * 4) % 27);
        String value = "";
        switch (d) {
            case 0:
                value = "Vaidhavati";
                break;
            case 1:
                value = "Vishkhambh";
                break;
            case 2:
                value = "Preeti";
                break;
            case 3:
                value = "Aayushman";
                break;
            case 4:
                value = "Soubhagy";
                break;
            case 5:
                value = "Shobhan";
                break;
            case 6:
                value = "Atigand";
                break;
            case 7:
                value = "Sukarm";
                break;
            case 8:
                value = "Dhruti";
                break;
            case 9:
                value = "Shul";
                break;
            case 10:
                value = "Gand";
                break;
            case 11:
                value = "Rvadi";
                break;
            case 12:
                value = "Dhruv";
                break;
            case 13:
                value = "Vyaghat";
                break;
            case 14:
                value = "Harshan";
                break;
            case 15:
                value = "Vajra";
                break;
            case 16:
                value = "Sidhi";
                break;
            case 17:
                value = "Vyatipat";
                break;
            case 18:
                value = "Variyan";
                break;
            case 19:
                value = "Parigh";
                break;
            case 20:
                value = "Shiv";
                break;
            case 21:
                value = "Sidha";
                break;
            case 22:
                value = "Sadhy";
                break;
            case 23:
                value = "Shubh";
                break;
            case 24:
                value = "Shukl";
                break;
            case 25:
                value = "Bhram";
                break;
            case 26:
                value = "Aaindr";
                break;
        }
        return value;
    }

    private String getKaram(int totalArea){
        int d = ((totalArea * 5) % 11);
        String value = "";
        switch (d){
            case 0:
                value = "Kistugn";
                break;
            case 1:
                value = "Bav";
                break;
            case 2:
                value = "Balav";
                break;
            case 3:
                value = "Kaulav";
                break;
            case 4:
                value = "Taitil";
                break;
            case 5:
                value = "Garaj";
                break;
            case 6:
                value = "Vanij";
                break;
            case 7:
                value = "Bhadra";
                break;
            case 8:
                value = "Shakuni";
                break;
            case 9:
                value = "Chatuspad";
                break;
            case 10:
                value = "Nagavan";
                break;
        }
        return value;
    }

    private String getAunsh(int totalArea){
        int d = ((totalArea * 6) % 9);
        String value = "";
        switch (d) {
            case 0:
                value = "Santosh";
                break;
            case 1:
                value = "Nast";
                break;
            case 2:
                value = "Varadhi";
                break;
            case 3:
                value = "Sampattu";
                break;
            case 4:
                value = "Dukh";
                break;
            case 5:
                value = "Maran bhiti";
                break;
            case 6:
                value = "Chor bhay";
                break;
            case 7:
                value = "Santan vradhi";
                break;
            case 8:
                value = "Pashu vradh";
                break;
        }
        return value;
    }

    private int getAayushy(int totalArea){
        return ((totalArea * 9) % 120);
    }

    private String getDikpal(int ayushya){
        int d = (ayushya % 8);
        String value = "";
        switch (d) {
            case 0:
                value = "Eshany";
                break;
            case 1:
                value = "Indra";
                break;
            case 2:
                value = "Agni";
                break;
            case 3:
                value = "Yama";
                break;
            case 4:
                value = "Nairuty";
                break;
            case 5:
                value = "Varun";
                break;
            case 6:
                value = "Vayuvy";
                break;
            case 7:
                value = "Kuber";
                break;
        }
        return value;
    }
}
