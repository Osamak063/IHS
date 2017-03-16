package com.example.osamakhalid.ihs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText green,yellow,red;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        green=(EditText) findViewById(R.id.green);
        red=(EditText) findViewById(R.id.red);
        yellow=(EditText) findViewById(R.id.yellow);
        b=(Button) findViewById(R.id.done);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
//Add your data to bundle
                bundle.putString("x", green.getText().toString());
                bundle.putString("y", yellow.getText().toString());
                bundle.putString("z", red.getText().toString());

//Add the bundle to the intent

                Intent i= new Intent(MainActivity.this,Signals.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}
