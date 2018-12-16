package ru.mgvk.megacliker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    int[]      btnsIDs = {R.id.level1, R.id.level2, R.id.level3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(btnsIDs[getLevel()]);

    }

    private int getLevel() {
        return getSharedPreferences(Constants.PREFERENCES_FILE_NAME, MODE_PRIVATE).getInt(Constants.PREFERENCES_LEVEL_I, 0);
    }

    private void setLevel(int lvl) {

        Toast.makeText(this, "Выбран уровень " + (lvl + 1), Toast.LENGTH_SHORT).show();

        SharedPreferences p = getSharedPreferences(Constants.PREFERENCES_FILE_NAME, MODE_PRIVATE);
        p.edit().putInt(Constants.PREFERENCES_LEVEL_I, lvl).apply();

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.level1: {
                setLevel(0);
            }
            case R.id.level2: {
                setLevel(1);
            }
            case R.id.level3: {
                setLevel(2);
            }

        }

    }
}
