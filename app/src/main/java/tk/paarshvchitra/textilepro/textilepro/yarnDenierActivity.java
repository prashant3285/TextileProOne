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


public class yarnDenierActivity extends Activity {

    Double x = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn_denier);


    Spinner spinUnit = (Spinner)findViewById(R.id.spinnerUnit);

    spinUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            switch (i) {
                case 0:
                    x = 1.0;
                    break;
                case 1:
                    x = 5313.0;
                    //y = 5315/jv1;
                    break;
                case 2:
                    x = 8999.4;
                    //y = 8999.4/jv1;
                    break;
                case 3:
                    x = 9.0;
                    //y = jv1*9;
                    break;
                case 4:
                    x = 0.9;
                    //y = jv1 * 0.9;
                    break;
                case 5:
                    x = 310.07;
                    //y = jv1 * 310.07;
                    break;
                case 6:
                    x = 7972.5;
                    //y = 7972.5/jv1;
                    break;
                case 7:
                    x = 17439.8;
                    //y = 17439.8/jv1;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

        final EditText v1;
        final TextView den1;
        final TextView ne1;
        final TextView nm1;
        final TextView tex1;
        final TextView dtex1;
        final TextView dand1;
        final TextView wool1;
        final TextView worst1;
        Button c1;

        v1 = (EditText)findViewById(R.id.conversionValue);
        den1 = (TextView)findViewById(R.id.ldDenierResult);
        ne1 = (TextView)findViewById(R.id.ldNeResult);
        nm1 = (TextView)findViewById(R.id.ldNmResult);
        tex1 = (TextView)findViewById(R.id.ldTexResult);
        dtex1 = (TextView)findViewById(R.id.ldDtexResult);
        dand1 = (TextView)findViewById(R.id.ldDandeeResult);
        wool1 = (TextView)findViewById(R.id.ldWoolenResult);
        worst1 = (TextView)findViewById(R.id.ldWorstedResult);
        c1 = (Button)findViewById(R.id.buttonLdCalculate);

        c1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Double y = 0.0;
               Double jv1 = 0.0;
               Double jden1 = 0.0;
               Double jne1 = 0.0;
               Double jnm1 = 0.0;
               Double jtex1 = 0.0;
               Double jdtex1 = 0.0;
               Double jdand1 = 0.0;
               Double jwool1 = 0.0;
               Double jworst1 = 0.0;

               if (v1.getText().length()==0)

               {

                   v1.setError("Field cannot be left blank.");
               }

               else {
                   jv1 = Double.parseDouble(v1.getText().toString());

                   if (x == 1.0 || x == 9.0 || x == 0.9 || x == 310.07) {
                       y = jv1 * x;
                   } else {
                       y = x / jv1;
                   }

                   jden1 = y;
                   jne1 = 5315 / y;
                   jnm1 = 8999.4 / y;
                   jtex1 = y / 9;
                   jdtex1 = (y * 10) / 9;
                   jdand1 = y / 310.07;
                   jworst1 = 7972.5 / y;
                   jwool1 = 17439.8 / y;

                   den1.setText(String.format("%.2f", jden1));
                   ne1.setText(String.format("%.2f", jne1));
                   nm1.setText(String.format("%.2f", jnm1));
                   tex1.setText(String.format("%.2f", jtex1));
                   dtex1.setText(String.format("%.2f", jdtex1));
                   dand1.setText(String.format("%.2f", jdand1));
                   worst1.setText(String.format("%.2f", jworst1));
                   wool1.setText(String.format("%.2f", jwool1));
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
        getMenuInflater().inflate(R.menu.menu_yarn_denier, menu);
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
