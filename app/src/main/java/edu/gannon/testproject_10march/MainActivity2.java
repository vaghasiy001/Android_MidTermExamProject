package edu.gannon.testproject_10march;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends Activity {
    ArrayList<RestaurantModel> listArray = new ArrayList<RestaurantModel>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RestaurantModel objModel = (RestaurantModel)parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("Name", objModel.Name());
                intent.putExtra("Address", objModel.Address());
                startActivity(intent);
            }
        });
    }

    public void onClickSave(View v) {
        EditText edtName = (EditText) findViewById(R.id.txtName);
        EditText edtAddress = (EditText) findViewById(R.id.txtAddress);
        RadioGroup typeGroup = (RadioGroup)findViewById(R.id.typeGroup);
        if(!edtName.getText().toString().isEmpty() && !edtAddress.getText().toString().isEmpty()) {
            RestaurantModel obj = new RestaurantModel(edtName.getText().toString(), edtAddress.getText().toString(), typeGroup.getCheckedRadioButtonId());
            listArray.add(obj);
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, edtName.getText().toString() + " has been saved", Toast.LENGTH_SHORT);
            toast.show();
            PopulateListView();
            edtName.setText("");
            edtAddress.setText("");
            typeGroup.check(R.id.takeout);
        }
        else {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Both name and address are required.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void PopulateListView(){
        if(!listArray.isEmpty()) {
            ArrayAdapter<RestaurantModel> arrayAdapter = new ArrayAdapter<RestaurantModel>(this, android.R.layout.simple_list_item_1, listArray);
            listView.setAdapter(arrayAdapter);
        }
    }
}
