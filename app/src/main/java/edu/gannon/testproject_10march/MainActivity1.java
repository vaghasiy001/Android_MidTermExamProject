package edu.gannon.testproject_10march;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity1);
    }

    public void onNameButtonClicked(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
