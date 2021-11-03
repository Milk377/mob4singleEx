package com.cookandroid.relativerayoutex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class sangpoom extends AppCompatActivity {

    List<RecycleItem> itemList = new ArrayList<>();
    int nowItemCount = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sangpoom);

        Button button1 = (Button) findViewById(R.id.btnAddsangPoom);
        Button button2 = (Button) findViewById(R.id.btnDelSangPoom);
        Button button3 = (Button) findViewById(R.id.btnMemberInfo);

        TextView textUserData = (TextView) findViewById(R.id.userData);
        TextView textUserData2 = (TextView) findViewById(R.id.userData2);
        TextView textUserData3 = (TextView) findViewById(R.id.userData3);
        TextView textUserData4 = (TextView) findViewById(R.id.userData4);


        JunyeokByunsoo js = (JunyeokByunsoo) getApplicationContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        add5ItemsFirst();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeList();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoveLastData();

            }
        });

        // 회원 정보 버튼
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (js.getloginOrNot()) {
                    Toast.makeText(getApplicationContext(), "로그인되어있습니다. ", Toast.LENGTH_SHORT).show();

                    String userDataString = "ID: " + js.getuserId();
                    String userDataString2 = "주소 " + js.getuserAddress();
                    String userDataString3 = "tel " + js.getuserPhone();
                    String userDataString4 = "Name : " + js.getuserName();

                    textUserData.setText(userDataString);
                    textUserData2.setText(userDataString2);
                    textUserData3.setText(userDataString3);
                    textUserData4.setText(userDataString4);


                } else {
                    Toast.makeText(getApplicationContext(), "로그인 되어있지 않습니다. ", Toast.LENGTH_SHORT).show();

                    builder.setTitle("로그인 한 상태가 아닙니다!");
                    builder.setMessage("회원가입을 하러 가시겠습니까?");

                    builder.setPositiveButton("예",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent intentJoinMember = new Intent(getApplicationContext(), joinmember.class);
                                    startActivity(intentJoinMember);
                                }
                            });
                    builder.setNegativeButton("아니오",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            });
                    builder.show();

                }


            }
        });


    }

    public void RemoveLastData() {
        itemList.remove(itemList.size() - 1);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 추가
        RecycleAdapter adapter = new RecycleAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void add5ItemsFirst()
    {

        itemList.add(new RecycleItem(R.drawable.image001, "item :" + nowItemCount));

        nowItemCount++;

        itemList.add(new RecycleItem(R.drawable.image002, "item :" + nowItemCount));

        nowItemCount++;

        itemList.add(new RecycleItem(R.drawable.image003, "item :" + nowItemCount));

        nowItemCount++;

        itemList.add(new RecycleItem(R.drawable.image004, "item :" + nowItemCount));

        nowItemCount++;

        itemList.add(new RecycleItem(R.drawable.image005, "item :" + nowItemCount));

        nowItemCount++;


        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 추가
        RecycleAdapter adapter = new RecycleAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }


    public void makeList() {


        itemList.add(new RecycleItem(R.drawable.image001, "item :" + nowItemCount));

        nowItemCount++;

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Adapter 추가
        RecycleAdapter adapter = new RecycleAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Layout manager 추가
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }


}
