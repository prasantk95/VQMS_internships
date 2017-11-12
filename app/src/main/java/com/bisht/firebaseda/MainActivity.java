package com.bisht.firebaseda;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Button maddbut;
    private EditText magefield;
    private EditText mnamefield;
    private Firebase mrootref;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mnamefield=(EditText)findViewById(R.id.addname);
        magefield=(EditText)findViewById(R.id.addage);
        maddbut=(Button)findViewById(R.id.addbutton);
        mrootref= new Firebase("https://muchu-firebase.firebaseio.com/Users");



        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);






        maddbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mnamefield.getText().toString();
                String age=magefield.getText().toString();
               // Firebase mrefChild=mrootref.child("Name");

                String key = mrootref.child("posts").push().getKey();
                mrootref= new Firebase("https://muchu-firebase.firebaseio.com/Users/"+key);

                Firebase mrefChildname=mrootref.child("Name");
                mrefChildname.setValue(name);
                Firebase mrefChildage=mrootref.child("age");
                mrefChildage.setValue(age);

                //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_LONG).show();



            }
        });


    }


}
