package coml.example.administrator.exercise17;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String SharedPreferencesFileName="config";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    private final static String Key_UserName="UserName";
    private final static String Key_UserNumber="UserNumber";
    private final static String Key_UserTel="UserTel";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences=getSharedPreferences(SharedPreferencesFileName, MODE_PRIVATE);
        editor=preferences.edit();

        Button btnWrite = (Button)findViewById(R.id.ButtonWrite);
        Button btnRead = (Button)findViewById(R.id.ButtonRead);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(Key_UserName,"屈亮亮");
                editor.putString(Key_UserNumber,"2014011377");
                editor.putString(Key_UserTel,"13717902399");
                editor.apply();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserName = preferences.getString(Key_UserName,null);
                String strUserNumber = preferences.getString(Key_UserNumber,null);
                String strUserTel = preferences.getString(Key_UserTel,null);
                if(strUserName!=null && strUserNumber!=null && strUserTel!=null) {
                    Toast.makeText(MainActivity.this,"姓名:" + strUserName + "学号:" + strUserNumber
                    + "手机号:" + strUserTel,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
