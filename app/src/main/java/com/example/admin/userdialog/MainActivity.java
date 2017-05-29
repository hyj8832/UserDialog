package com.example.admin.userdialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but=(Button)findViewById(R.id.but);
        //이벤트 소스가 but
        //Listner : 감시자역할 꼭 설정해야함!
        //Handler :처리자 (누른 것에 따른 처리를 하는 )
        //인터페이스를 추가해서 규격에 맞춰 OnClickListner가 일할 수 있게 해준다.
        but.setOnClickListener(this);//현재 객체 참조값.
    }

    @Override
    public void onClick(View v) {
        View dlgV=View.inflate(getApplicationContext(),R.layout.dialog,null);
        //  컨택스트,객체생성하고 싶은 xml (xmㅣ문서에 있는 것을 설정),다른 뷰가 또 있다면 써주고 아니면 NUll
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Input User Information");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setView(dlgV);
        dialog.setPositiveButton("OK",null);
        dialog.setNegativeButton("CANCEL",null);
        dialog.show();
    }
}
