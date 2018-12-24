package patil.com.firstapp;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

                    String totalLegthInInches = String.valueOf((length_feet * 12) + length_inches);
                    String totalwidthInInches = String.valueOf((width_feet * 12) + width_inches);

                }catch (Exception e){
                    e.printStackTrace();
                    IDNA.Error.valueOf("Something went wrong");
                }
                startresultActivity();
            }
        });

    }

    private void startresultActivity(){
        Intent resultIntent = new Intent(this, ResultActivity.class);
        startActivity(resultIntent);
    }
}
