package tk.paarshvchitra.textilepro.textilepro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class yarnActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yarn);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_yarn, menu);
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

    public void yarnDenierCaller (View view){
        Intent intent = new Intent (this, yarnDenierActivity.class);
        startActivity(intent);

    }

    public void yarnDiameterCaller (View view){
        Intent intent = new Intent (this, yarnDiameterActivity.class);
        startActivity(intent);

    }
}
