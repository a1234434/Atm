package com.judy.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        EditText edUserid = findViewById(R.id.userid);
        EditText edPassword =findViewById(R.id.passwd);
        String u =edUserid.getText().toString();
        String p =edPassword.getText().toString();
        if(u.equals("Judy")&&p.equals("1234")){
                Toast.makeText(this, "成功", Toast.LENGTH_LONG).show();
                setResult(RESULT_OK);
                finish();

        }else{//登入失敗
            new AlertDialog.Builder(this).setTitle("Atm")
                    .setMessage("登入失敗").setPositiveButton("OK",null).show();
        }
    }
}
