package tk.paarshvchitra.textilepro.textilepro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Math.sqrt;


public class yarnDiameterActivity extends Activity {

    Double x = 0.0;
    int y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn_diameter);

        Spinner spinPolymer = (Spinner)findViewById(R.id.spinnerPolymer);

        spinPolymer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i) {
                    case 0:
                        x = 0.91;
                        //PP
                        break;
                    case 1:
                        x = 1.14;
                        //PA 6
                        break;
                    case 2:
                        x = 1.14;
                        //PA 6,6
                        break;
                    case 3:
                        x = 1.38;
                        //PET
                        break;
                    case 4:
                        x = 1.02;
                        //PA 12
                        break;
                    case 5:
                        x = 1.05;
                        //PA 6,12
                        break;
                    case 6:
                        x = 1.09;
                        //PA 6,11
                        //PA 6,11
                        break;
                    case 7:
                        x = 0.91;
                        //LDPE
                        break;
                    case 8:
                        x = 0.95;
                        //HDPE
                        break;
                    case 9:
                        x = 1.44;
                        //p-Aramid
                        break;
                    case 10:
                        x = 1.38;
                        //m-Aramid
                        break;
                    case 11:
                        x = 1.06;
                        //PS
                        break;
                    case 12:
                        x = 1.19;
                        //PMMA
                        break;
                    case 13:
                        x = 1.81;
                        //Carbon
                        break;
                    case 14:
                        x = 1.90;
                        //Carbon HM
                        break;
                    case 15:
                        x = 2.00;
                        //Carbon UHM
                        break;
                    case 16:
                        x = 1.18;
                        //PAN
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinMethod = (Spinner)findViewById(R.id.spinnerDiaMethod);

        spinMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                switch (i) {
                    case 0:
                        y = 1;
                        //Diameter
                        break;
                    case 1:
                        y = 2;
                        //Denier
                        break;
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final EditText d1;
        final TextView result1;
        final TextView result2;
        final TextView method1;
        Button c1;

        d1 = (EditText)findViewById(R.id.conversionYdValue);
        result1 = (TextView)findViewById(R.id.ydDensityResult);
        result2 = (TextView)findViewById(R.id.ydDiameterResult);
        method1 = (TextView)findViewById(R.id.ydDiameterMethod);
        c1 = (Button)findViewById(R.id.buttonYdCalculate);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Double jd1 = 0.0;
                Double a = 0.0;
                Double jresult2 = 0.0;
                Double jresult1 = 0.0;


                if (d1.getText().length()==0)

                {

                    d1.setError("Field cannot be left blank.");
                }

                else {
                    jd1 = Double.parseDouble(d1.getText().toString());

                    if (y == 1) {
                        jresult2 = (3.14*((jd1/1000)*(jd1/1000))*(x*1000000)*9000)/(4);
                        method1.setText("Denier");
                        jresult1=x;
                    }
                    if (y == 2) {
                        a= ((jd1/(x*1000000.0))/(9000.0*3.14));
                        jresult2 = sqrt(a)*2000;
                        method1.setText("Diameter (mm)");
                        jresult1=x;
                    }

                    result2.setText(String.format("%.2f", jresult2));
                    result1.setText(String.format("%.2f", jresult1));
                }
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yarn_diameter, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                aboutApp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean aboutApp()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title
        alertDialogBuilder.setTitle("Version - beta 1.11b");

        // set dialog message
        alertDialogBuilder
                .setMessage("This app is part of Project Hokage! The app is currently in beta phase, lot more to come soon. post your feedback and suggestion on http://paarshvchitra.tk/blog \n Changelog: *improved layout *improved keyboard response")
                .setCancelable(false)
                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
        return true;
    }
}
