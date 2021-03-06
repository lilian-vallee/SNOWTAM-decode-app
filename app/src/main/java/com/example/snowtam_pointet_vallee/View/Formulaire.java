package com.example.snowtam_pointet_vallee.View;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snowtam_pointet_vallee.Controller.FormController;
import com.example.snowtam_pointet_vallee.R;

public class Formulaire extends AppCompatActivity {

    FormController controller = new FormController(this);   //create the controller

    TextView airport;           //where the user write the airport's code he wants

    TextView showCode;          //where the user read the codes he already wrote

    Button show_result;    //go to the next page whit results
    Button addAirport;     //add the code to a list which is used to show results

    Boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaire);

        /***
         * we use the findViewById method to link the xml object's id whit the code
         */
        airport = findViewById(R.id.airport1);

        showCode = findViewById(R.id.afficheText);

        show_result = findViewById(R.id.button_showResult);
        addAirport = findViewById(R.id.button_addAirport);


        addAirport.setOnClickListener(new View.OnClickListener() {      //click on the button +
            @Override
            public void onClick(View v) {
                CharSequence airportCode = airport.getText();           //get the code the user put on 'airport'

                //check the validity of the code
                if(controller.addAirport(airportCode)){                 //if check is ok
                    airport.setText("");                                //reset the view on 'airport'
                    showCode.setText((String) showCode.getText() + '\n' + airportCode);
                                                                        //add and show the new code
                    airport.setTextColor(Color.BLACK);                  //code is ok so reset text color to black
                }
                else {                                                  //if check isn't ok
                    Context context = getApplicationContext();
                    CharSequence text = getResources().getString(R.string.toast_codeError);

                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    airport.setTextColor(Color.RED);                    //text color to red => warning there is an error
                }
            }
        });

        show_result.setOnClickListener(new View.OnClickListener() {     //click on the button V
            @Override
            public void onClick(View v) {

                if(!controller.RequeteAPI()){
                    CharSequence text = getResources().getString(R.string.toast_codeLoad);
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                }
            }
        });


    }
}