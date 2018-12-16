package ru.mgvk.megacliker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_play: {
                startActivity(new Intent(this,
                        GameActivity.class));
                break;
            }
            case R.id.btn_settings: {
                Toast.makeText(this, "qwerty", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,
                        SettingsActivity.class));
                break;
            }
            case R.id.btn_stat: {

            }


        }


    }
}
