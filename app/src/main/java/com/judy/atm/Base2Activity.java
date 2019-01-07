package com.judy.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Base2Activity extends AppCompatActivity {
    User2 user2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base2);
        user2 =new User2(this);
    }
}
