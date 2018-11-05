package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivityPractice extends AppCompatActivity {

    public static final int RC_log =50;
    boolean loginp =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_practice);

        if(!loginp){
            Intent intent = new Intent(this,LoginActivityPractice.class);
            startActivityForResult(intent,RC_log);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_log){
            if(resultCode==RESULT_OK){
//                String a = data.getStringExtra("Accountp");
//                String p =data.getStringExtra("Passwordp");
//                Log.d("result",a+"/"+p);
                finish();
            }
        }
    }
}
