package com.example.admin.userdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        TextView textName,textEmail;
        EditText editName,editEmail;
        View dlgV;
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
        textName=(TextView)findViewById(R.id.text_name);
        textEmail=(TextView)findViewById(R.id.text_email);

    }

    @Override
    public void onClick(View v) {
         dlgV=View.inflate(getApplicationContext(),R.layout.dialog,null); //전역변수로 뺐다.
        //큰 화면이 아닌 일부분의 화면에 보이게끔 (창,,등등) 하기 위한 dlgV
        //  컨택스트,객체생성하고 싶은 xml (xmㅣ문서에 있는 것을 설정),다른 뷰가 또 있다면 써주고 아니면 NUll
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Input User Information");
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setView(dlgV);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                editName=(EditText)dlgV.findViewById(R.id.edit_name);  //음성녹음 해둠
                editEmail=(EditText)dlgV.findViewById(R.id.edit_email);
                textName.setText(editName.getText());
                //setText: 화면에 보여지게 쓰는것
                //getText: 화면에 입력하는 것
                textEmail.setText(editEmail.getText());
            }
        }); //두번째 인자값에 핸들러 들어간다.(현재는 익명클래스)
        dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast toast=new Toast(MainActivity.this);//그냥 this는 핸들러의 객체를 의미한다.
                View toastV=View.inflate(MainActivity.this,R.layout.toast,null); //녹음시작
                TextView textToast=(TextView)toastV.findViewById(R.id.text_toast);
                textToast.setText("취소되었군요.");
                toast.setView(toastV);
                toast.show();
            }
        });
        dialog.show();
    }
}
