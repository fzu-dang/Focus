package com.example.focus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EdittextActivity extends AppCompatActivity {
    public static String textlx;
    public static int lxlx;
    private Button mBtnLogin,mBtnZHUce,mBtnFORget,mBtntiaoguo;
    private EditText email2,password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        mBtntiaoguo=findViewById(R.id.btn_yk);
        mBtntiaoguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EdittextActivity.this,Timercounter.class);
                startActivity(intent);
            }
        });

        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email2=(EditText) findViewById(R.id.et_1);
                password2=(EditText) findViewById(R.id.et_2);
                Thread xx= new Thread(new SubThread_HH(email2.getText().toString(),password2.getText().toString()));//跳转到登录SubThread_HH子进程
                xx.start();
                try {
                    xx.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(lxlx==200){

                    Intent intent = new Intent(EdittextActivity.this,Timercounter.class);
                    startActivity(intent);
                }
            }
        });
        mBtnZHUce = findViewById(R.id.btn_zhuce);//注册按钮，按完跳转到注册界面
        mBtnZHUce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EdittextActivity.this,ZHUCEActivity.class);
                startActivity(intent);
            }
        });
        mBtnFORget = findViewById(R.id.btn_forget);//忘记密码，按完跳转到忘记密码界面
        mBtnFORget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EdittextActivity.this,ForgetActivity.class);
                startActivity(intent);
            }
        });
//        mBtnyanzheng = findViewById(R.id.btn_yz);//邮箱验证，按完跳转到邮箱验证
//        mBtnyanzheng.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(EdittextActivity.this,YOUXIANGYANZHENG.class);
//                startActivity(intent);
//            }
//        });
    }
}