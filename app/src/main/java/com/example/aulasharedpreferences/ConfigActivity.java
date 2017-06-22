package com.example.aulasharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {
    EditText et_01;
    CheckBox cb_01, cb_02, cb_03, cb_04;
    Button bt_02;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        // carrega as preferências padrão de usuário
        //Tudo o que é setado em SharedPreferences o Android trata de armazenar e compartilhar entre as atividades.
        //Além disso o Android armazena estas configurações em disco e as deixa sempre disponível
        //através de uma instância de SharedPreferences na próxima vez que reinicializar seu App.
        //Basta passar o this de sua classe para o Android que ele recupera o SharedPreference p/ você.
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        spEditor =  sharedPreferences.edit();

        et_01 = (EditText)findViewById(R.id.et_01);
        String str = sharedPreferences.getString("et_01","");
        if(str.length() > 0){
            et_01.setText(str);
        }

        cb_01 = (CheckBox)findViewById(R.id.cb_01);
        Boolean b = sharedPreferences.getBoolean("cb_01", false);
        cb_01.setChecked(b);

        cb_02 = (CheckBox)findViewById(R.id.cb_02);
        b = sharedPreferences.getBoolean("cb_02", false);
        cb_02.setChecked(b);

        cb_03 = (CheckBox)findViewById(R.id.cb_03);
        b = sharedPreferences.getBoolean("cb_03", false);
        cb_03.setChecked(b);

        cb_04 = (CheckBox)findViewById(R.id.cb_04);
        b = sharedPreferences.getBoolean("cb_04", false);
        cb_04.setChecked(b);



        bt_02 = (Button)findViewById(R.id.bt_02);
        bt_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spEditor.putString("et_01", et_01.getText().toString());
                spEditor.putBoolean("cb_01", cb_01.isChecked());
                spEditor.putBoolean("cb_02", cb_02.isChecked());
                spEditor.putBoolean("cb_03", cb_03.isChecked());
                spEditor.putBoolean("cb_04", cb_04.isChecked());
                spEditor.commit();
//                finish();
            }
        });
    }

}
