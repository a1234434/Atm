package com.judy.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivityPractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_practice);

    }

    public void login(View view){
        EditText account = findViewById(R.id.ed_useridp);
        EditText password =findViewById(R.id.ed_paswdp);
        String a = account.getText().toString();
        String p =password.getText().toString();
        if(a.equals("Judy")&&p.equals("1234")){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
//            getIntent().putExtra("useridp",a);
//            getIntent().putExtra("paswdp",p);
            setResult(RESULT_OK);
            finish();
        }else {
            new AlertDialog.Builder(this)
                    .setMessage("登入失敗")
                    .setTitle("ATM")
                    .setPositiveButton("Ok",null).show();
        }
    }
}
