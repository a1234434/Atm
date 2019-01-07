package com.judy.atm;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

    public class User2 {
        private Context context;
        String id;
        String nickname;
        int age;
        int gender;
        String address;
        //vailed 驗證
        boolean vailed;
        SharedPreferences settings;

        public User2(Context context) {
            this.context = context;
            settings = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNickname() {
            if (nickname == null) {
                nickname = settings.getString("nickname", null);
            }
            return nickname;
        }

        public void setNickname(String nickname) {
            settings.edit().putString("user", nickname).apply();
            this.nickname = nickname;
        }

        public int getAge() {
            if (age == 0) {
                age = settings.getInt("age", 0);
            }
            return age;
        }

        public void setAge(int age) {
            settings.edit().putInt("user", age).apply();
            this.age = age;
        }

        public int getGender() {
            if (gender == 0) {
                gender = settings.getInt("gender", 0);
            }
            return gender;
        }

        public void setGender(int gender) {
            settings.edit().putInt("user", 0).apply();
            this.gender = gender;
        }

        public String getAddress() {
            address = "dummy address";
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public boolean isVailed() {
            vailed = nickname != null && age != 0 && gender != 0;
            return vailed;
        }

    }

