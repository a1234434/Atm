package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }

    public void next(View view){
        EditText gender =findViewById(R.id.ed_gender);
        int g = Integer.parseInt(gender.getText().toString());
//        getSharedPreferences("user",MODE_PRIVATE).edit()
//                .putInt("gender",g).apply();
        user.setGender(g);
        Intent main = new Intent(this,MainActivity.class);
        setResult(RESULT_OK);
        main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(main);
    }
    public void back(View view){
        finish();
    }
}
