package com.judy.atm;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {


    private static final int RC_LOGIN = 100;
    boolean logon = false;
    List<String> fruits = Arrays.asList("香蕉","鳳梨","芭樂");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!logon) {//如果沒登入,則開啟logonActivity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, RC_LOGIN);

        }

        //listView
//        listView();

    }

    private void listView() {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
    class FruitAdapter extends RecyclerView.Adapter<>{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_1,parent,false);
            return new FruitViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    class FruitViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
        public FruitViewHolder(View itemView){
            super(itemView);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_LOGIN) { //登入成功後,收到的RC_LOGIN碼是正確的
            if (resultCode != RESULT_OK) {//沒有登入,只是按返回鍵,就會直接結束
                finish();
            } else {
                logon = true;
//                String nickname = getSharedPreferences("user", MODE_PRIVATE).getString("nickname", null);
//                int age = getSharedPreferences("user", MODE_PRIVATE).getInt("age", 0);
//                int gender = getSharedPreferences("user", MODE_PRIVATE).getInt("gender", 0);
//
//                if (nickname == null || age == 0 || gender == 0) {
//                    Intent nickname1 = new Intent(this, NicknameActivity.class);
//                    startActivity(nickname1);
//                }
                if(user.isVaild()){
                    Intent nickname1 = new Intent(this, NicknameActivity.class);
                    startActivity(nickname1);
                }
            }
        }
    }
}