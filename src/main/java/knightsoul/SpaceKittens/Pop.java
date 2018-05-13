package knightsoul.SpaceKittens;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pop extends Activity {

    private Button menuBTN;
    private Button restartBTN;
    private Button nextBTN;
    private ImageView coinsIV;
    private TextView coinsTV;
    private int currentLevel;
    private int pack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        menuBTN = findViewById(R.id.btn_menu);
        restartBTN = findViewById(R.id.btn_restart);
        nextBTN = findViewById(R.id.btn_next);
        coinsTV = findViewById(R.id.tv_coins);
        coinsIV = findViewById(R.id.iv_coins);

        String string5 = getIntent().getExtras().getString("level");
        currentLevel = Integer.parseInt(string5);

        String string = getIntent().getExtras().getString("pack");
        pack = Integer.parseInt(string);

        if (currentLevel == 30) {
            nextBTN.setEnabled(false);
            nextBTN.setVisibility(View.INVISIBLE);
        }
        switch (pack) {
            case 1:
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = prefs.edit();
                int temp = prefs.getInt("current1", 1);

                if (currentLevel+1 > temp) {
                    coinsTV.setVisibility(View.VISIBLE);
                    coinsIV.setVisibility(View.VISIBLE);
                    int coins1 = prefs.getInt("c", 0);
                    editor.putInt("c", coins1+5);
                    editor.commit();
                }

                levelpack1 main1 = new levelpack1();
                main1.savePreferences(currentLevel, getApplicationContext());
                break;

            case 2:
                SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor1 = prefs1.edit();
                int temp1 = prefs1.getInt("current2", 1);

                if (currentLevel+1 > temp1) {
                    coinsTV.setVisibility(View.VISIBLE);
                    coinsIV.setVisibility(View.VISIBLE);
                    int coins2 = prefs1.getInt("c", 0);
                    editor1.putInt("c", coins2+5);
                    editor1.commit();
                }
                levelpack2 main2 = new levelpack2();
                main2.savePreferences(currentLevel, getApplicationContext());
                break;
            case 3:
                SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor2 = prefs2.edit();
                int temp2 = prefs2.getInt("current3", 1);

                if (currentLevel+1 > temp2) {
                    coinsTV.setVisibility(View.VISIBLE);
                    coinsIV.setVisibility(View.VISIBLE);
                    int coins3 = prefs2.getInt("c", 0);
                    editor2.putInt("c", coins3+5);
                    editor2.commit();
                }

                levelpack3 main3 = new levelpack3();
                main3.savePreferences(currentLevel, getApplicationContext());
        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.9));

        menuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartBTN.setEnabled(false);
                menuBTN.setEnabled(false);
                nextBTN.setEnabled(false);
                MediaPlayer buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button);
                MainActivity.gameMusic.release();
                MainActivity.gameMusic = null;
                buttonSound.start();
                buttonSound.reset();
                Title.playMusic();

                if (pack == 1) {
                    Intent startIntent = new Intent(getApplicationContext(), levelpack1.class);
                    startActivity(startIntent);
                } else if (pack == 2) {
                    Intent startIntent = new Intent(getApplicationContext(), levelpack2.class);
                    startActivity(startIntent);
                } else if (pack == 3) {
                    Intent startIntent = new Intent(getApplicationContext(), levelpack3.class);
                    startActivity(startIntent);
                }
                MainActivity.activity2.finish();

                finish();


            }
        });

        restartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartBTN.setEnabled(false);
                menuBTN.setEnabled(false);
                nextBTN.setEnabled(false);

                MediaPlayer buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button);
                buttonSound.start();

                if (pack == 1) {
                    switch (currentLevel) {
                        case 1:   //PRESSED
                            Levels1 level = new Levels1(getApplicationContext(), 1);
                            break;
                        case 2:   //HOLD AND DRAG
                            Levels1 level2 = new Levels1(getApplicationContext(), 2);
                            break;
                        case 3:     //RELEASE
                            Levels1 level3 = new Levels1(getApplicationContext(), 3);
                            break;
                        case 4:     //RELEASE
                            Levels1 level4 = new Levels1(getApplicationContext(), 4);
                            break;
                        case 5:     //RELEASE
                            Levels1 level5 = new Levels1(getApplicationContext(), 5);
                            break;
                        case 6:     //RELEASE
                            Levels1 level6 = new Levels1(getApplicationContext(), 6);
                            break;
                        case 7:     //RELEASE
                            Levels1 level7 = new Levels1(getApplicationContext(), 7);
                            break;
                        case 8:     //RELEASE
                            Levels1 level8 = new Levels1(getApplicationContext(), 8);
                            break;
                        case 9:     //RELEASE
                            Levels1 level9 = new Levels1(getApplicationContext(), 9);
                            break;
                        case 10:     //RELEASE
                            Levels1 level10 = new Levels1(getApplicationContext(), 10);
                            break;
                        case 11:     //RELEASE
                            Levels1 level11 = new Levels1(getApplicationContext(), 11);
                            break;
                        case 12:     //RELEASE
                            Levels1 level12 = new Levels1(getApplicationContext(), 12);
                            break;
                        case 13:     //RELEASE
                            Levels1 level13 = new Levels1(getApplicationContext(), 13);
                            break;
                        case 14:     //RELEASE
                            Levels1 level14 = new Levels1(getApplicationContext(), 14);
                            break;
                        case 15:     //RELEASE
                            Levels1 level15 = new Levels1(getApplicationContext(), 15);
                            break;
                        case 16:     //RELEASE
                            Levels1 level16 = new Levels1(getApplicationContext(), 16);
                            break;
                        case 17:     //RELEASE
                            Levels1 level17 = new Levels1(getApplicationContext(), 17);
                            break;
                        case 18:     //RELEASE
                            Levels1 level18 = new Levels1(getApplicationContext(), 18);
                            break;
                        case 19:     //RELEASE
                            Levels1 level19 = new Levels1(getApplicationContext(), 19);
                            break;
                        case 20:     //RELEASE
                            Levels1 level20 = new Levels1(getApplicationContext(), 20);
                            break;
                        case 21:     //RELEASE
                            Levels1 level21 = new Levels1(getApplicationContext(), 21);
                            break;
                        case 22:     //RELEASE
                            Levels1 level22 = new Levels1(getApplicationContext(), 22);
                            break;
                        case 23:     //RELEASE
                            Levels1 level23 = new Levels1(getApplicationContext(), 23);
                            break;
                        case 24:     //RELEASE
                            Levels1 level24 = new Levels1(getApplicationContext(), 24);
                            break;
                        case 25:     //RELEASE
                            Levels1 level25 = new Levels1(getApplicationContext(), 25);
                            break;
                        case 26:     //RELEASE
                            Levels1 level26 = new Levels1(getApplicationContext(), 26);
                            break;
                        case 27:     //RELEASE
                            Levels1 level27 = new Levels1(getApplicationContext(), 27);
                            break;
                        case 28:     //RELEASE
                            Levels1 level28 = new Levels1(getApplicationContext(), 28);
                            break;
                        case 29:     //RELEASE
                            Levels1 level29 = new Levels1(getApplicationContext(), 29);
                            break;
                        case 30:     //RELEASE
                            Levels1 level30 = new Levels1(getApplicationContext(), 30);
                            break;

                    }
                } else if (pack == 2) {
                    switch (currentLevel) {
                        case 1:   //PRESSED
                            Levels2 level = new Levels2(getApplicationContext(), 1);
                            break;
                        case 2:   //HOLD AND DRAG
                            Levels2 level2 = new Levels2(getApplicationContext(), 2);
                            break;
                        case 3:     //RELEASE
                            Levels2 level3 = new Levels2(getApplicationContext(), 3);
                            break;
                        case 4:     //RELEASE
                            Levels2 level4 = new Levels2(getApplicationContext(), 4);
                            break;
                        case 5:     //RELEASE
                            Levels2 level5 = new Levels2(getApplicationContext(), 5);
                            break;
                        case 6:     //RELEASE
                            Levels2 level6 = new Levels2(getApplicationContext(), 6);
                            break;
                        case 7:     //RELEASE
                            Levels2 level7 = new Levels2(getApplicationContext(), 7);
                            break;
                        case 8:     //RELEASE
                            Levels2 level8 = new Levels2(getApplicationContext(), 8);
                            break;
                        case 9:     //RELEASE
                            Levels2 level9 = new Levels2(getApplicationContext(), 9);
                            break;
                        case 10:     //RELEASE
                            Levels2 level10 = new Levels2(getApplicationContext(), 10);
                            break;
                        case 11:     //RELEASE
                            Levels2 level11 = new Levels2(getApplicationContext(), 11);
                            break;
                        case 12:     //RELEASE
                            Levels2 level12 = new Levels2(getApplicationContext(), 12);
                            break;
                        case 13:     //RELEASE
                            Levels2 level13 = new Levels2(getApplicationContext(), 13);
                            break;
                        case 14:     //RELEASE
                            Levels2 level14 = new Levels2(getApplicationContext(), 14);
                            break;
                        case 15:     //RELEASE
                            Levels2 level15 = new Levels2(getApplicationContext(), 15);
                            break;
                        case 16:     //RELEASE
                            Levels2 level16 = new Levels2(getApplicationContext(), 16);
                            break;
                        case 17:     //RELEASE
                            Levels2 level17 = new Levels2(getApplicationContext(), 17);
                            break;
                        case 18:     //RELEASE
                            Levels2 level18 = new Levels2(getApplicationContext(), 18);
                            break;
                        case 19:     //RELEASE
                            Levels2 level19 = new Levels2(getApplicationContext(), 19);
                            break;
                        case 20:     //RELEASE
                            Levels2 level20 = new Levels2(getApplicationContext(), 20);
                            break;
                        case 21:     //RELEASE
                            Levels2 level21 = new Levels2(getApplicationContext(), 21);
                            break;
                        case 22:     //RELEASE
                            Levels2 level22 = new Levels2(getApplicationContext(), 22);
                            break;
                        case 23:     //RELEASE
                            Levels2 level23 = new Levels2(getApplicationContext(), 23);
                            break;
                        case 24:     //RELEASE
                            Levels2 level24 = new Levels2(getApplicationContext(), 24);
                            break;
                        case 25:     //RELEASE
                            Levels2 level25 = new Levels2(getApplicationContext(), 25);
                            break;
                        case 26:     //RELEASE
                            Levels2 level26 = new Levels2(getApplicationContext(), 26);
                            break;
                        case 27:     //RELEASE
                            Levels2 level27 = new Levels2(getApplicationContext(), 27);
                            break;
                        case 28:     //RELEASE
                            Levels2 level28 = new Levels2(getApplicationContext(), 28);
                            break;
                        case 29:     //RELEASE
                            Levels2 level29 = new Levels2(getApplicationContext(), 29);
                            break;
                        case 30:     //RELEASE
                            Levels2 level30 = new Levels2(getApplicationContext(), 30);
                            break;
                    }
                } else if (pack == 3) {
                    switch (currentLevel) {
                        case 1:   //PRESSED
                            Levels3 level = new Levels3(getApplicationContext(), 1);
                            break;
                        case 2:   //HOLD AND DRAG
                            Levels3 level2 = new Levels3(getApplicationContext(), 2);
                            break;
                        case 3:     //RELEASE
                            Levels3 level3 = new Levels3(getApplicationContext(), 3);
                            break;
                        case 4:     //RELEASE
                            Levels3 level4 = new Levels3(getApplicationContext(), 4);
                            break;
                        case 5:     //RELEASE
                            Levels3 level5 = new Levels3(getApplicationContext(), 5);
                            break;
                        case 6:     //RELEASE
                            Levels3 level6 = new Levels3(getApplicationContext(), 6);
                            break;
                        case 7:     //RELEASE
                            Levels3 level7 = new Levels3(getApplicationContext(), 7);
                            break;
                        case 8:     //RELEASE
                            Levels3 level8 = new Levels3(getApplicationContext(), 8);
                            break;
                        case 9:     //RELEASE
                            Levels3 level9 = new Levels3(getApplicationContext(), 9);
                            break;
                        case 10:     //RELEASE
                            Levels3 level10 = new Levels3(getApplicationContext(), 10);
                            break;
                        case 11:     //RELEASE
                            Levels3 level11 = new Levels3(getApplicationContext(), 11);
                            break;
                        case 12:     //RELEASE
                            Levels3 level12= new Levels3(getApplicationContext(), 12);
                            break;
                        case 13:     //RELEASE
                            Levels3 level13 = new Levels3(getApplicationContext(), 13);
                            break;
                        case 14:     //RELEASE
                            Levels3 level14 = new Levels3(getApplicationContext(), 14);
                            break;
                        case 15:     //RELEASE
                            Levels3 level15 = new Levels3(getApplicationContext(), 15);
                            break;
                        case 16:     //RELEASE
                            Levels3 level16 = new Levels3(getApplicationContext(), 16);
                            break;
                        case 17:     //RELEASE
                            Levels3 level17 = new Levels3(getApplicationContext(), 17);
                            break;
                        case 18:     //RELEASE
                            Levels3 level18 = new Levels3(getApplicationContext(), 18);
                            break;
                        case 19:     //RELEASE
                            Levels3 level19 = new Levels3(getApplicationContext(), 19);
                            break;
                        case 20:     //RELEASE
                            Levels3 level20 = new Levels3(getApplicationContext(), 20);
                            break;
                        case 21:     //RELEASE
                            Levels3 level21 = new Levels3(getApplicationContext(), 21);
                            break;
                        case 22:     //RELEASE
                            Levels3 level22 = new Levels3(getApplicationContext(), 22);
                            break;
                        case 23:     //RELEASE
                            Levels3 level23 = new Levels3(getApplicationContext(), 23);
                            break;
                        case 24:     //RELEASE
                            Levels3 level24 = new Levels3(getApplicationContext(), 24);
                            break;
                        case 25:     //RELEASE
                            Levels3 level25 = new Levels3(getApplicationContext(), 25);
                            break;
                        case 26:     //RELEASE
                            Levels3 level26 = new Levels3(getApplicationContext(), 26);
                            break;
                        case 27:     //RELEASE
                            Levels3 level27 = new Levels3(getApplicationContext(), 27);
                            break;
                        case 28:     //RELEASE
                            Levels3 level28 = new Levels3(getApplicationContext(), 28);
                            break;
                        case 29:     //RELEASE
                            Levels3 level29 = new Levels3(getApplicationContext(), 29);
                            break;
                        case 30:     //RELEASE
                            Levels3 level30 = new Levels3(getApplicationContext(), 30);
                            break;
                    }
                }
                MainActivity.activity2.finish();

                finish();

            }

        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartBTN.setEnabled(false);
                menuBTN.setEnabled(false);
                nextBTN.setEnabled(false);

                MediaPlayer buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button);
                buttonSound.start();

                if (pack == 1) {
                    switch (currentLevel + 1) {
                        case 1:   //PRESSED
                            Levels1 level = new Levels1(getApplicationContext(), 1);
                            break;
                        case 2:   //HOLD AND DRAG
                            Levels1 level2 = new Levels1(getApplicationContext(), 2);
                            break;
                        case 3:     //RELEASE
                            Levels1 level3 = new Levels1(getApplicationContext(), 3);
                            break;
                        case 4:     //RELEASE
                            Levels1 level4 = new Levels1(getApplicationContext(), 4);
                            break;
                        case 5:     //RELEASE
                            Levels1 level5 = new Levels1(getApplicationContext(), 5);
                            break;
                        case 6:     //RELEASE
                            Levels1 level6 = new Levels1(getApplicationContext(), 6);
                            break;
                        case 7:     //RELEASE
                            Levels1 level7 = new Levels1(getApplicationContext(), 7);
                            break;
                        case 8:     //RELEASE
                            Levels1 level8 = new Levels1(getApplicationContext(), 8);
                            break;
                        case 9:     //RELEASE
                            Levels1 level9 = new Levels1(getApplicationContext(), 9);
                            break;
                        case 10:     //RELEASE
                            Levels1 level10 = new Levels1(getApplicationContext(), 10);
                            break;
                        case 11:     //RELEASE
                            Levels1 level11 = new Levels1(getApplicationContext(), 11);
                            break;
                        case 12:     //RELEASE
                            Levels1 level12 = new Levels1(getApplicationContext(), 12);
                            break;
                        case 13:     //RELEASE
                            Levels1 level13 = new Levels1(getApplicationContext(), 13);
                            break;
                        case 14:     //RELEASE
                            Levels1 level14 = new Levels1(getApplicationContext(), 14);
                            break;
                        case 15:     //RELEASE
                            Levels1 level15 = new Levels1(getApplicationContext(), 15);
                            break;
                        case 16:     //RELEASE
                            Levels1 level16 = new Levels1(getApplicationContext(), 16);
                            break;
                        case 17:     //RELEASE
                            Levels1 level17 = new Levels1(getApplicationContext(), 17);
                            break;
                        case 18:     //RELEASE
                            Levels1 level18 = new Levels1(getApplicationContext(), 18);
                            break;
                        case 19:     //RELEASE
                            Levels1 level19 = new Levels1(getApplicationContext(), 19);
                            break;
                        case 20:     //RELEASE
                            Levels1 level20 = new Levels1(getApplicationContext(), 20);
                            break;
                        case 21:     //RELEASE
                            Levels1 level21 = new Levels1(getApplicationContext(), 21);
                            break;
                        case 22:     //RELEASE
                            Levels1 level22 = new Levels1(getApplicationContext(), 22);
                            break;
                        case 23:     //RELEASE
                            Levels1 level23 = new Levels1(getApplicationContext(), 23);
                            break;
                        case 24:     //RELEASE
                            Levels1 level24 = new Levels1(getApplicationContext(), 24);
                            break;
                        case 25:     //RELEASE
                            Levels1 level25 = new Levels1(getApplicationContext(), 25);
                            break;
                        case 26:     //RELEASE
                            Levels1 level26 = new Levels1(getApplicationContext(), 26);
                            break;
                        case 27:     //RELEASE
                            Levels1 level27 = new Levels1(getApplicationContext(), 27);
                            break;
                        case 28:     //RELEASE
                            Levels1 level28 = new Levels1(getApplicationContext(), 28);
                            break;
                        case 29:     //RELEASE
                            Levels1 level29 = new Levels1(getApplicationContext(), 29);
                            break;
                        case 30:     //RELEASE
                            Levels1 level30 = new Levels1(getApplicationContext(), 30);
                            break;
                    }
                } else if (pack == 2) {
                    switch (currentLevel+1) {
                        case 1:   //PRESSED
                            Levels2 level = new Levels2(getApplicationContext(), 1);
                            break;
                        case 2:   //HOLD AND DRAG
                            Levels2 level2 = new Levels2(getApplicationContext(), 2);
                            break;
                        case 3:     //RELEASE
                            Levels2 level3 = new Levels2(getApplicationContext(), 3);
                            break;
                        case 4:     //RELEASE
                            Levels2 level4 = new Levels2(getApplicationContext(), 4);
                            break;
                        case 5:     //RELEASE
                            Levels2 level5 = new Levels2(getApplicationContext(), 5);
                            break;
                        case 6:     //RELEASE
                            Levels2 level6 = new Levels2(getApplicationContext(), 6);
                            break;
                        case 7:     //RELEASE
                            Levels2 level7 = new Levels2(getApplicationContext(), 7);
                            break;
                        case 8:     //RELEASE
                            Levels2 level8 = new Levels2(getApplicationContext(), 8);
                            break;
                        case 9:     //RELEASE
                            Levels2 level9 = new Levels2(getApplicationContext(), 9);
                            break;
                        case 10:     //RELEASE
                            Levels2 level10 = new Levels2(getApplicationContext(), 10);
                            break;
                        case 11:     //RELEASE
                            Levels2 level11 = new Levels2(getApplicationContext(), 11);
                            break;
                        case 12:     //RELEASE
                            Levels2 level12 = new Levels2(getApplicationContext(), 12);
                            break;
                        case 13:     //RELEASE
                            Levels2 level13 = new Levels2(getApplicationContext(), 13);
                            break;
                        case 14:     //RELEASE
                            Levels2 level14 = new Levels2(getApplicationContext(), 14);
                            break;
                        case 15:     //RELEASE
                            Levels2 level15 = new Levels2(getApplicationContext(), 15);
                            break;
                        case 16:     //RELEASE
                            Levels2 level16 = new Levels2(getApplicationContext(), 16);
                            break;
                        case 17:     //RELEASE
                            Levels2 level17 = new Levels2(getApplicationContext(), 17);
                            break;
                        case 18:     //RELEASE
                            Levels2 level18 = new Levels2(getApplicationContext(), 18);
                            break;
                        case 19:     //RELEASE
                            Levels2 level19 = new Levels2(getApplicationContext(), 19);
                            break;
                        case 20:     //RELEASE
                            Levels2 level20 = new Levels2(getApplicationContext(), 20);
                            break;
                        case 21:     //RELEASE
                            Levels2 level21 = new Levels2(getApplicationContext(), 21);
                            break;
                        case 22:     //RELEASE
                            Levels2 level22 = new Levels2(getApplicationContext(), 22);
                            break;
                        case 23:     //RELEASE
                            Levels2 level23 = new Levels2(getApplicationContext(), 23);
                            break;
                        case 24:     //RELEASE
                            Levels2 level24 = new Levels2(getApplicationContext(), 24);
                            break;
                        case 25:     //RELEASE
                            Levels2 level25 = new Levels2(getApplicationContext(), 25);
                            break;
                        case 26:     //RELEASE
                            Levels2 level26 = new Levels2(getApplicationContext(), 26);
                            break;
                        case 27:     //RELEASE
                            Levels2 level27 = new Levels2(getApplicationContext(), 27);
                            break;
                        case 28:     //RELEASE
                            Levels2 level28 = new Levels2(getApplicationContext(), 28);
                            break;
                        case 29:     //RELEASE
                            Levels2 level29 = new Levels2(getApplicationContext(), 29);
                            break;
                        case 30:     //RELEASE
                            Levels2 level30 = new Levels2(getApplicationContext(), 30);
                            break;
                    }
                } else if (pack == 3) {
                    switch (currentLevel+1) {
                        case 1:   //PRESSED
                            Levels3 level = new Levels3(getApplicationContext(), 1);
                            break;
                        case 2:   //HOLD AND DRAG
                            Levels3 level2 = new Levels3(getApplicationContext(), 2);
                            break;
                        case 3:     //RELEASE
                            Levels3 level3 = new Levels3(getApplicationContext(), 3);
                            break;
                        case 4:     //RELEASE
                            Levels3 level4 = new Levels3(getApplicationContext(), 4);
                            break;
                        case 5:     //RELEASE
                            Levels3 level5 = new Levels3(getApplicationContext(), 5);
                            break;
                        case 6:     //RELEASE
                            Levels3 level6 = new Levels3(getApplicationContext(), 6);
                            break;
                        case 7:     //RELEASE
                            Levels3 level7 = new Levels3(getApplicationContext(), 7);
                            break;
                        case 8:     //RELEASE
                            Levels3 level8 = new Levels3(getApplicationContext(), 8);
                            break;
                        case 9:     //RELEASE
                            Levels3 level9 = new Levels3(getApplicationContext(), 9);
                            break;
                        case 10:     //RELEASE
                            Levels3 level10 = new Levels3(getApplicationContext(), 10);
                            break;
                        case 11:     //RELEASE
                            Levels3 level11 = new Levels3(getApplicationContext(), 11);
                            break;
                        case 12:     //RELEASE
                            Levels3 level12 = new Levels3(getApplicationContext(), 12);
                            break;
                        case 13:     //RELEASE
                            Levels3 level13 = new Levels3(getApplicationContext(), 13);
                            break;
                        case 14:     //RELEASE
                            Levels3 level14 = new Levels3(getApplicationContext(), 14);
                            break;
                        case 15:     //RELEASE
                            Levels3 level15 = new Levels3(getApplicationContext(), 15);
                            break;
                        case 16:     //RELEASE
                            Levels3 level16 = new Levels3(getApplicationContext(), 16);
                            break;
                        case 17:     //RELEASE
                            Levels3 level17 = new Levels3(getApplicationContext(), 17);
                            break;
                        case 18:     //RELEASE
                            Levels3 level18 = new Levels3(getApplicationContext(), 18);
                            break;
                        case 19:     //RELEASE
                            Levels3 level19 = new Levels3(getApplicationContext(), 19);
                            break;
                        case 20:     //RELEASE
                            Levels3 level20 = new Levels3(getApplicationContext(), 20);
                            break;
                        case 21:     //RELEASE
                            Levels3 level21 = new Levels3(getApplicationContext(), 21);
                            break;
                        case 22:     //RELEASE
                            Levels3 level22 = new Levels3(getApplicationContext(), 22);
                            break;
                        case 23:     //RELEASE
                            Levels3 level23 = new Levels3(getApplicationContext(), 23);
                            break;
                        case 24:     //RELEASE
                            Levels3 level24 = new Levels3(getApplicationContext(), 24);
                            break;
                        case 25:     //RELEASE
                            Levels3 level25 = new Levels3(getApplicationContext(), 25);
                            break;
                        case 26:     //RELEASE
                            Levels3 level26 = new Levels3(getApplicationContext(), 26);
                            break;
                        case 27:     //RELEASE
                            Levels3 level27 = new Levels3(getApplicationContext(), 27);
                            break;
                        case 28:     //RELEASE
                            Levels3 level28 = new Levels3(getApplicationContext(), 28);
                            break;
                        case 29:     //RELEASE
                            Levels3 level29 = new Levels3(getApplicationContext(), 29);
                            break;
                        case 30:     //RELEASE
                            Levels3 level30 = new Levels3(getApplicationContext(), 30);
                            break;
                    }
                }
                MainActivity.activity2.finish();

                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
