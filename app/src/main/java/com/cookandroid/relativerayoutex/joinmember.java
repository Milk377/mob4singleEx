package com.cookandroid.relativerayoutex;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class joinmember extends AppCompatActivity {

    Button b1,idCheckBtn, joinNowBtn;
    EditText editTextId;
    EditText editTextName;
    EditText editTextPassWord;
    EditText editTextAddress;
    EditText editTextPhoneNumber;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinmember);

        EditText editTextId = findViewById(R.id.editTextIDjoin);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextPassWord = findViewById(R.id.editTextPassword);
        EditText editTextAddress = findViewById(R.id.editTextAddress);
        EditText editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);



        joinNowBtn = findViewById(R.id.buttonGaip);

        joinNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String filename = editTextId.getText().toString() +".txt";
                Boolean exist = false;
                Boolean passWordValidCheck = true;


                try {
                    FileInputStream inFs = openFileInput(filename);
                    // byte[] txt = new byte[30];
                    // inFs.read(txt);
                    // String str = new String(txt);
                    Toast.makeText(getApplicationContext(), editTextId.getText().toString() +"는 이미 존재합니다.", Toast.LENGTH_SHORT).show();
                    inFs.close();
                    exist = true;

                } catch (IOException e) {
                    // 파일이 존재하지 않을경우 에러를 발생시키는 것을 이용한다.

                    Toast.makeText(getApplicationContext(), "가입이 가능한 아이디입니다." , Toast.LENGTH_SHORT).show();
                }

                //비밀번호 체크
                String passwordCheck = editTextPassWord.getText().toString();

                if(passwordCheck.contains("!")) passWordValidCheck = false;
                if(passwordCheck.contains("@")) passWordValidCheck = false;
                if(passwordCheck.contains("#")) passWordValidCheck = false;
                if(passwordCheck.contains("$")) passWordValidCheck = false;
                if(passwordCheck.contains("%")) passWordValidCheck = false;
                if(passwordCheck.contains("^")) passWordValidCheck = false;
                if(passwordCheck.contains("&")) passWordValidCheck = false;
                if(passwordCheck.contains("*")) passWordValidCheck = false;
                if(passwordCheck.contains("(")) passWordValidCheck = false;
                if(passwordCheck.contains(")")) passWordValidCheck = false;
                if(passwordCheck.contains("-")) passWordValidCheck = false;
                if(passwordCheck.contains("+")) passWordValidCheck = false;
                if(passwordCheck.contains("=")) passWordValidCheck = false;
                if(passwordCheck.contains("'")) passWordValidCheck = false;
                if(passwordCheck.contains(";")) passWordValidCheck = false;
                if(passwordCheck.contains("\"")) passWordValidCheck = false;
                if(passwordCheck.contains("\\=")) passWordValidCheck = false;
                if(passwordCheck.contains(".")) passWordValidCheck = false;
                if(passwordCheck.contains("<")) passWordValidCheck = false;
                if(passwordCheck.contains(">")) passWordValidCheck = false;
                if(passwordCheck.contains("~")) passWordValidCheck = false;
                if(passwordCheck.contains("`")) passWordValidCheck = false;

                //자리수 체크
                if(passwordCheck.length() >=17) passWordValidCheck = false;




                if(exist == false && passWordValidCheck == true) {
                    try{


                        // 사용자 데이터를 저장한다. 아이디,비밀번호,주소,전화번호,이름
                        FileOutputStream outFs = openFileOutput(filename.toString(), Context.MODE_PRIVATE);
                        String str = editTextId.getText().toString() + "_" + editTextPassWord.getText().toString() + "_" +
                                editTextAddress.getText().toString() + "_" + editTextPhoneNumber.getText().toString() + "_" + editTextName.getText().toString() + "__";


                        outFs.write(str.getBytes());
                        outFs.close();
                        Toast.makeText(getApplicationContext(),"회원 가입 성공",Toast.LENGTH_SHORT).show();


                    } catch (IOException e ) {
                        Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();

                    }

                } else {
                    Toast.makeText(getApplicationContext(),"회원 가입 실패 ",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"비밀번호를 확인하세요 ",Toast.LENGTH_SHORT).show();


                }

                finish();


            }

        });
/*


        idCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                // 중복 데이터 체크

                // 중복되는 아이디가 있으면 에러 메세지를 띄우고 가입이 안되게
                // 중복되는 아이디가 없으면 정상적으로 진행 되도록 함.

                String Idcheck = editTextId.getText().toString();



            }

        });
*/


             /* public void onClick(View v) {


             */


        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();  //현재 실행중인 Activity를 종료한다.
            }
        });

        // 그러면 이제 해야하는건

    }

}
