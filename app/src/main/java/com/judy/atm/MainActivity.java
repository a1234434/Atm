package com.judy.atm;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private static final int RC_LOGIN = 100;
    boolean logon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {//如果沒登入,則開啟logonActivity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_LOGIN) { //登入成功後,收到的RC_LOGIN碼是正確的
            if (resultCode != RESULT_OK) {//沒有登入,只是按返回鍵,就會直接結束
                finish();
            } else {
                Intent nickname = new Intent(this, NicknameActivity.class);
                startActivity(nickname);
            }
        }
    }
}