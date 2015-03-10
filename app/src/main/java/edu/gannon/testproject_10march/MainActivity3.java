package edu.gannon.testproject_10march;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        TextView txtName = (TextView)findViewById(R.id.txtName);
        TextView txtAddress = (TextView)findViewById(R.id.txtAddress);
        Bundle extras = getIntent().getExtras();
        txtName.setText(extras.getString("Name"));
        txtAddress.setText(extras.getString("Address"));
    }
}
