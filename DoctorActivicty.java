package com.example.android.slidingtabsbasic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class DoctorActivicty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_activicty);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
       final String d=(String) bundle.getString("docName");
        ArrayList<String> listOfPres = new ArrayList<>();
        for (int i =1;i<4;i++) {
            listOfPres.add(d +"'s "+ i + " prescription");
        }
        setTitle(" prescription by " + d);
        ListView lv =(ListView) findViewById(R.id.listOfPres);
        PrescriptionAdapter PresAdapter = new PrescriptionAdapter(getApplicationContext(),getLayoutInflater(),listOfPres);
        lv.setAdapter(PresAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent();
                intent.setClass(getApplicationContext(),ActualPrescription.class);
                intent.putExtra("docName", d);
                startActivity(intent);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doctor_activicty, menu);
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
