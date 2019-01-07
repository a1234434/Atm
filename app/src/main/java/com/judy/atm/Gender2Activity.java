package com.judy.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Gender2Activity extends Base2Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender2);
    }

   public void next(View view){
       EditText gend=findViewById(R.id.ed_gen);
       int gen =Integer.parseInt(gend.getText().toString());
//       getSharedPreferences("user",MODE_PRIVATE).edit()
//               .putInt("gender",gen).apply();
       user2.setGender(gen);
       Intent intent =new Intent(this, Main2Activity.class);
       setResult(RESULT_OK);
       //FLAG_ACTIVITY_CLEAR_TOP
       // 如果設定,並且這個Activity已經在當前的Task中執行,因此,不再是重新啟動一個這個Activity的例項,
       // 而是在這個Activity上方的所有Activity都將關閉,
       // 然後這個Intent會作為一個新的Intent投遞到老的Activity(現在位於頂端)中。
       //FLAG_ACTIVITY_SINGLE_TOP
       //如果設定,當這個Activity位於歷史stack的頂端執行時,不再啟動一個新的。
       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
       startActivity(intent);
   }

   public void back(View view){
//        finish();
   }
}
