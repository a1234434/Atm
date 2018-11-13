package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }

    public void next(View view){
        EditText ednickname =findViewById(R.id.ed_nickname);
        String n = ednickname.getText().toString();
        if(n=="Judy"){
            Intent intent =new Intent(this,AgeActivity.class) ;
            startActivity(intent);
        }
    }
}
