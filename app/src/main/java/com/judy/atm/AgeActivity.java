package com.judy.atm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {
    private
    int[] numbers = {19, 20, 21, 22, 23, 24, 25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());
    }

    public void next(View view) {
        EditText age = findViewById(R.id.ed_age);
        int a = Integer.parseInt(age.getText().toString());
//        getSharedPreferences("user",MODE_PRIVATE).edit()
//                .putInt("age",a).apply();
        user.setAge(a);
        Intent gender = new Intent(this, GenderActivity.class);
        startActivity(gender);
    }

    public void back(View view) {
        finish();
    }

    class AgeAdapter extends RecyclerView.Adapter<Ageholder> {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =getLayoutInflater().inflate(R.layout.age_row, parent,false);
            return new ;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            holder.ageText.setText (numbers[position] + "");
            if (numbers[position] == 19) {

            }

        }

        @Override
        public int getItemCount() {
            return numbers.length;
        }
    }
        class Ageholder extends RecyclerView.ViewHolder {
            TextView ageText;

            public Ageholder(View itemView) {
                super(itemView);
                ageText = findViewById(R.id.recycler);
            }
    }
}

