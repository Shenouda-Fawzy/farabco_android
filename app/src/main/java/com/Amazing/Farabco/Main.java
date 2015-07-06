package com.Amazing.Farabco;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.net.URI;
import java.net.URISyntaxException;


public class Main extends Activity {
    Farabco farabco;
    RadioGroup rg;
    RadioButton arabciRadio;
    RadioButton francoRadio;
    EditText outText;
    EditText inputTxt;
    Intent intent;
    static final String KEY = "MY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        farabco = new Farabco();

        intent = new Intent(Main.this , AboutMe.class);


        rg = (RadioGroup) findViewById(R.id.GroubRadio);
        arabciRadio = (RadioButton) findViewById(R.id.arabicRadio);
        francoRadio = (RadioButton) findViewById(R.id.francoRadio);
        outText = (EditText) findViewById(R.id.outpuTxt);
        inputTxt = (EditText) findViewById(R.id.inputTxt);
    }


    public void convertStatment(View v){
        if(arabciRadio.isChecked() == true){
            //outText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            farabco.setFrancoStatment(inputTxt.getText().toString());
            String convertedToFranco = farabco.getArabicStatment(); // converting to arabic
            outText.setText(convertedToFranco);
        }
        else{

            farabco.setArabicStatment(inputTxt.getText().toString());
            String convertedToArabic = farabco.getFrancoStatment(); // converting to arabic
            outText.setText(convertedToArabic);
        }
    } // end of convertStatemetn method

    public void goToAboutMe(View v){
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
