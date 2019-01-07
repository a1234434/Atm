package com.judy.atm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main2Activity extends Base2Activity {
    boolean login = false;
    public static final int RC_login =50;
    List<String> fruits =Arrays.asList("香蕉","芭樂","蘋果");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if(!login){//  if 沒登入,就進入loginActivty
            Intent intent = new Intent(this, Login2Activity.class);
            startActivityForResult(intent,RC_login);

            //RecyclerView
            RecyclerView recyclerView =findViewById(R.id.rec);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new FruitAdapter());

        }
    }
//listView
    private void listView(){
        ArrayAdapter<String> adapter= new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
    class FruitAdapter extends RecyclerView.Adapter<FruitViewHolder>{

        @NonNull
        @Override
        public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =LayoutInflater.from(parent.getContext()).
                 inflate(android.R.layout.simple_list_item_1,parent,false);
          return new FruitViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FruitViewHolder fruitholder, int poistion) {
          fruitholder.nameText2.setText(fruits.get(poistion));
        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }
    }

    class FruitViewHolder extends RecyclerView.ViewHolder {
        TextView nameText2;
    public FruitViewHolder(@NonNull View itemView) {
        super(itemView);
        nameText2=itemView.findViewById(R.id.text1);
    }
}

    // ctrl+o
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RC_login){
            if(resultCode!=RESULT_OK){
                finish();
            }else{
                login=true;
                if(!user2.isVailed()) {
                    Intent intent = new Intent(this, Nickname2Activity.class);
                    startActivity(intent);
                }
            }
        }
    }
}
