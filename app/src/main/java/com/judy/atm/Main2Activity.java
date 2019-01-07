package com.judy.atm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends Base2Activity {
    boolean login = false;
    public static final int RC_login =50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if(!login){//  if 沒登入,就進入loginActivty
            Intent intent = new Intent(this, Login2Activity.class);
            startActivityForResult(intent,RC_login);

        }
    }

    // ctrl+o
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_login){
            if(resultCode!=RESULT_OK){
                finish();
            }else{
                login=true;
                if(user2.isVailed()) {
                    Intent intent = new Intent(this, Nickname2Activity.class);
                    startActivity(intent);
                }
            }
        }
    }
}
