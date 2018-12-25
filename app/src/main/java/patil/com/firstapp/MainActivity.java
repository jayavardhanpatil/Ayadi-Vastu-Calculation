package patil.com.firstapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Integer> datamap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                    //button.setVisibility(View.INVISIBLE);

                    EditText editText = (EditText) findViewById(R.id.lengthFeet);
                    int length_feet = 0;
                    if (!editText.getText().toString().isEmpty()) {
                        length_feet = Integer.parseInt(editText.getText().toString());
                    }

                    editText = (EditText) findViewById(R.id.lengthInches);
                    int length_inches = 0;
                    if (!editText.getText().toString().isEmpty()) {
                        length_inches = Integer.parseInt(editText.getText().toString());
                    }

                    editText = (EditText) findViewById(R.id.widthFeet);
                    int width_feet = 0;
                    if (!editText.getText().toString().isEmpty()) {
                        width_feet = Integer.parseInt(editText.getText().toString());
                    }

                    editText = (EditText) findViewById(R.id.widthInches);
                    int width_inches = 0;
                    if (!editText.getText().toString().isEmpty()) {
                        width_inches = Integer.parseInt(editText.getText().toString());
                    }

                    int totalLegthInInches = (length_feet * 12) + length_inches;
                    int totalwidthInInches = (width_feet * 12) + width_inches;


                    if(totalLegthInInches == 0 || totalwidthInInches == 0){
                        openAlert(v);
                    }else {

                        datamap.put("length_feet", length_feet);
                        datamap.put("length_inches", length_inches);
                        datamap.put("width_feet", width_feet);
                        datamap.put("width_inches", width_inches);
                        datamap.put("total_length", totalLegthInInches);
                        datamap.put("total_width", totalwidthInInches);
                        startresultActivity();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    IDNA.Error.valueOf("Something went wrong");
                }

            }
        });

    }

    private void startresultActivity(){
        Intent resultIntent = new Intent(this, ResultActivity.class);
        for(Map.Entry<String, Integer> d : datamap.entrySet()){
            resultIntent.putExtra(d.getKey(), d.getValue());
        }
        startActivity(resultIntent);
    }

    private void openAlert(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        alertDialogBuilder.setTitle("Alert");
        alertDialogBuilder.setMessage("Please enter the measurements");
        // set positive button: Yes message
        alertDialogBuilder.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int id) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        // show alert
        alertDialog.show();
    }

}
