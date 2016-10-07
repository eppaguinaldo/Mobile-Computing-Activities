package com.example.earl.firstandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Earl on 05/10/2016.
 */
public class After_Login extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        findViewById(R.id.onTouchButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view) {
                Intent intent = new Intent(After_Login.this, OnTouch.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.soBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(After_Login.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
