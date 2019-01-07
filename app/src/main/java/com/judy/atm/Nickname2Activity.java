package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Nickname2Activity extends Base2Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname2);

    }

    public void next(View view){
        EditText nick=findViewById(R.id.ed_nick);
        String nic=nick.getText().toString();
//        getSharedPreferences("user",MODE_PRIVATE).edit().
//                putString("nickname",nic).apply();
        user2.setNickname(nic);
            Intent intent = new Intent(this, Age2Activity.class);
            startActivity(intent);

    }
}
