package com.example.aulasharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button bt_01;
    TextView tv_01;
    SharedPreferences sharedPreferences;

    //instancia um listener para ouvir mudanças na Shared Preference
    //deve ser parâmetro global da classe Activity, não pode ser declarado apenas no escopo do onCreate
    SharedPreferences.OnSharedPreferenceChangeListener spChanged = new
            SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    Log.d("MAIN","onSharedPreferenceChanged: " + key);
                    setUsersPreferences();
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_01= (TextView)findViewById(R.id.tv_01);

        bt_01 = (Button)findViewById(R.id.bt_01);
        bt_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ConfigActivity.class);
                startActivity(it);
            }
        });

        // carrega as preferências padrão de usuário
        //Tudo o que é setado em SharedPreferences o Android trata de armazenar e compartilhar entre as atividades.
        //Além disso o Android armazena estas configurações em disco e as deixa sempre disponíveis
        //através de uma instância de SharedPreferences na próxima vez que reinicializar seu App.
        //Basta passar o this de sua classe para o Android que ele recupera o SharedPreference p/ você.
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //registra o Listener para mudanças na SharedPreferences
        sharedPreferences.registerOnSharedPreferenceChangeListener(spChanged);
    }

    protected void setUsersPreferences(){
        tv_01.setText("et_01 = ");
        tv_01.append(sharedPreferences.getString("et_01",""));

        tv_01.append(",\ncb_01 = ");
        if(sharedPreferences.getBoolean("cb_01",false)){
            tv_01.append(" true");
        }else tv_01.append(" false");

        tv_01.append(",\ncb_02 = ");
        if(sharedPreferences.getBoolean("cb_02",false)){
            tv_01.append(" true");
        }else tv_01.append(" false");

        tv_01.append(",\ncb_03 = ");
        if(sharedPreferences.getBoolean("cb_03",false)){
            tv_01.append(" true");
        }else tv_01.append(" false");

        tv_01.append(",\ncb_04 = ");
        if(sharedPreferences.getBoolean("cb_04",false)){
            tv_01.append(" true");
        }else tv_01.append(" false");
    }
}
