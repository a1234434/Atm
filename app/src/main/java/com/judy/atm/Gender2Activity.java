package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Gender2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender2);
    }

   public void next(View view){
       EditText gend=findViewById(R.id.ed_gen);
       int gen =Integer.parseInt(gend.getText().toString());
       getSharedPreferences("user",MODE_PRIVATE).edit()
               .putInt("gender",gen).apply();
       Intent intent =new Intent(this, Main2Activity.class);
       startActivity(intent);
   }

   public void back(View view){
        finish();
   }
}
