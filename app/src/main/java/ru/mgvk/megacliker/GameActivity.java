package ru.mgvk.megacliker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private          int         points = 0;
    private          Button      btn;
    private          FrameLayout l;
    private          Thread      t;
    private volatile boolean     works  = true;
    private          TextView    pointsText, levelText;
    private int timeout = Constants.LEVELS_TIMEOUTS[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn = findViewById(R.id.btn);
        l = findViewById(R.id.layout);
        pointsText = findViewById(R.id.pointsText);
        levelText = findViewById(R.id.text_lvl);
        timeout = loadLevelTimeout(getLevel());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameActivity.this, "CAPTURED!!!",
                        Toast.LENGTH_SHORT).show();
                points++;
                pointsText.setText("Points: " + points);
            }
        });


        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                points--;
                pointsText.setText("Points: " + points);
            }
        });

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (works) {
                    try {
                        Thread.sleep((long) (Math.random() * 200 + timeout));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final float w = (float) ((l.getWidth() - btn.getWidth()) * Math.random());
                    final float h = (float) ((l.getHeight() - btn.getWidth()) * Math.random());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            btn.setX(w);
                            btn.setY(h);

                        }
                    });
                }
            }
        });
        t.start();

    }

    private int getLevel() {
        int lvl = getSharedPreferences(Constants.PREFERENCES_FILE_NAME, MODE_PRIVATE)
                .getInt(Constants.PREFERENCES_LEVEL_I, 0);
        levelText.setText("Уровень " + (lvl + 1));
        return lvl;
    }


    private int loadLevelTimeout(int lvl) {
        return Constants.getTimeout(lvl);
    }
}
