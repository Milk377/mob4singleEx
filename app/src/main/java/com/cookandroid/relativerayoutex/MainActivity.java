package com.cookandroid.relativerayoutex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edtTextId;

    EditText edtTextPass;
    String setSaveStringData = "";





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin, btnWrite, btnMain;

        btnLogin = (Button) findViewById(R.id.idbtn2);
        btnWrite = (Button) findViewById(R.id.idbtn1);
        btnMain = (Button) findViewById(R.id.sangpoom);
        edtTextId = findViewById(R.id.editText1);
        edtTextPass = findViewById(R.id.editText2);


        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), sangpoom.class);
                startActivity(intent2);

            }
        });


        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), joinmember.class);
                startActivity(intent1);

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginData = edtTextId.getText().toString() + ".txt";
                String loginPassword = edtTextPass.getText().toString();


                try {
                    FileInputStream inFs = openFileInput(loginData);
                    byte[] txt = new byte[1024];
                    inFs.read(txt);
                    String str = new String(txt);

                    // str를 _ 를 기준으로 분리해서 배열에 넣고, 비밀번호와 아이디 일치여부를 따진다.
                    // 정상이라면 트루, 아니라면 false

                    String[] strArr = str.split("_");

                    //Toast.makeText(getApplicationContext(), "strArr[1] :"+strArr[1]  , Toast.LENGTH_SHORT).show();
                    inFs.close();

                    // 비밀번호가 일치한다면 일치
                    if(strArr[1].equals(edtTextPass.getText().toString()) )
                    {
                        Toast.makeText(getApplicationContext(), edtTextId.getText().toString() +"님 반갑습니다. 로그인 성공", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "상품 페이지로 진입했습니다." , Toast.LENGTH_SHORT).show();

                        Intent intentSangpoom = new Intent(getApplicationContext(), sangpoom.class);

                        // 로그인시 정보 세팅을 해야함
                        // join3_3spassword_dongjakgu_01055991380_kim__
                        // 아이디,비밀번호,주소,번호,이름 순서
                        JunyeokByunsoo js = (JunyeokByunsoo) getApplicationContext();
                        js.setloginOrNot(true);
                        js.setuserId(strArr[0]);
                        js.setuserPass(strArr[1]);
                        js.setuserAddress(strArr[2]);
                        js.setuserPhone(strArr[3]);
                        js.setuserName(strArr[4]);



                        startActivity(intentSangpoom);



                    }
                    else {

                        Toast.makeText(getApplicationContext(), "비밀번호를 확인해주세요." , Toast.LENGTH_SHORT).show();
                    };


                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "로그인 실패 아이디와 비밀번호를 확인해주세요." , Toast.LENGTH_SHORT).show();

                }


                // 비밀번호가 일치해서 true값이 되면




            }
        });
    }


}