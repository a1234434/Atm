package com.judy.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Age2Activity extends Base2Activity {
    private int number[] = {18, 19, 20, 21, 22, 23, 24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age2);
        RecyclerView recyclerView = findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void next(View view) {
        EditText agee = findViewById(R.id.ed_ag);
        int ageee = Integer.parseInt(agee.getText().toString());
        getSharedPreferences("user", MODE_PRIVATE).edit().
                putInt("age", ageee).apply();
        user2.setAge(ageee);
        Intent intent1 = new Intent(this, Gender2Activity.class);
        startActivity(intent1);
    }

    public void back(View view) {
        finish();
//        Intent intent =new Intent(this,Nickname2Activity.class);
//        startActivity(intent);
    }

    class Age2Adaper extends RecyclerView.Adapter<Age2Adaper.Age2holder> {

        @NonNull
        @Override
        public Age2Adaper.Age2holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =getLayoutInflater().inflate(R.layout.age_row2,parent,false);
            return new Age2holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Age2Adaper.Age2holder age2holder, final int position) {
         age2holder.ageText2.setText(number[position]+" ");
         if(number[position]==20){
             age2holder.ageText2.setTextColor(Color.RED);
         }
         age2holder.ageText2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Log.d("Age2Activity","onclick"+number[position]);
             }
         });
        }

        @Override
        public int getItemCount() {
            return number.length;
        }
//    class Age2Adapter extends RecyclerView.Adapter<Age2holder>{
//
//        @NonNull
//        @Override
//        public Age2holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view =getLayoutInflater().inflate(R.layout.age_row2,parent,false);
//            return new Age2holder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull Age2holder age2holder, int position) {
//            age2holder.ageText2.setText(number[position]+" ");
//            if(number[position]==19){
//                age2holder.ageText2.setTextColor(Color.RED);
//            }
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return number.length;
//        }
//    }

        class Age2holder extends RecyclerView.ViewHolder {
            TextView ageText2;

            public Age2holder(@NonNull View itemView) {
                super(itemView);
                ageText2 = findViewById(R.id.tv_age2);
            }
        }
    }
}