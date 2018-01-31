package com.developmethis.csguide.csguidereadmodule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void wow(View view) {
        Intent intent = new Intent(this,read.class);
        Bundle b = new Bundle();
        b.putString("Contentid", "c1");
        intent.putExtras(b);
        startActivity(intent);
    }
}
