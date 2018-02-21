package com.example.azaat.asmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {

    Button btEnetr,btCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btEnetr = (Button) findViewById(R.id.bt_enter);
        btCreate = (Button) findViewById(R.id.create_account);

        btCreate.setOnClickListener(this);
        btEnetr.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.bt_enter:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.create_account:
                intent = new Intent(this,Registration_activity.class);
                startActivity(intent);
                break;
        }
    }
}
