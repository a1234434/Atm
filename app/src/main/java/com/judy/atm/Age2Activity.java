package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Age2Activity extends Base2Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age2);
    }

    public void next(View view){
        EditText agee=findViewById(R.id.ed_ag);
        int ageee =Integer.parseInt(agee.getText().toString());
//        getSharedPreferences("user",MODE_PRIVATE).edit().
//                putInt("age",ageee).apply();
        user2.setAge(ageee);
        Intent intent1 =new Intent(this,Gender2Activity.class);
        startActivity(intent1);
    }

    public void back(View view){
        finish();
//        Intent intent =new Intent(this,Nickname2Activity.class);
//        startActivity(intent);
    }
}
