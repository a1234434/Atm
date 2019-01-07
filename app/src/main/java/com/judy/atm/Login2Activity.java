package com.judy.atm;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login2Activity extends Base2Activity {


    private EditText password;
    private EditText userid;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        //Refactor-Extract-method
        userid = findViewById(R.id.ed_id);
        password = findViewById(R.id.ed_pass);
        String ui = userid.getText().toString();
        ui=getSharedPreferences("ATM",MODE_PRIVATE).getString("userid","");
        userid.setText(ui);

    }

    public void login(View view){
        String ui = userid.getText().toString();
        String ps= password.getText().toString();
        if(ui.equals("Judy")&&ps.equals("1234")){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getSharedPreferences("ATM",MODE_PRIVATE).edit().
                    putString("userid",ui).apply();
            setResult(RESULT_OK);
            finish();

        }else{
            new AlertDialog.Builder(this).setMessage("登入失敗").setTitle("ATM")
                    .setPositiveButton("Ok",null)
                    .setNegativeButton("Clear", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            userid.setText("");
                            password.setText("");
                        }
                    }).show();

        }

    }
}
