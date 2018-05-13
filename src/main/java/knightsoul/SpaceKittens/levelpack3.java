package knightsoul.SpaceKittens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class levelpack3 extends AppCompatActivity {

    int current3;
    Button[] level = new Button[31];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelpack3);

        level[1] = (Button) findViewById(R.id.button);
        level[2] = (Button) findViewById(R.id.button2);
        level[3] = (Button) findViewById(R.id.button3);
        level[4] = (Button) findViewById(R.id.button4);
        level[5] = (Button) findViewById(R.id.button5);
        level[6] = (Button) findViewById(R.id.button6);
        level[7] = (Button) findViewById(R.id.button7);
        level[8] = (Button) findViewById(R.id.button8);
        level[9] = (Button) findViewById(R.id.button9);
        level[10] = (Button) findViewById(R.id.button10);
        level[11] = (Button) findViewById(R.id.button11);
        level[12] = (Button) findViewById(R.id.button12);
        level[13] = (Button) findViewById(R.id.button13);
        level[14] = (Button) findViewById(R.id.button14);
        level[15] = (Button) findViewById(R.id.button15);
        level[16] = (Button) findViewById(R.id.button16);
        level[17] = (Button) findViewById(R.id.button17);
        level[18] = (Button) findViewById(R.id.button18);
        level[19] = (Button) findViewById(R.id.button19);
        level[20] = (Button) findViewById(R.id.button20);
        level[21] = (Button) findViewById(R.id.button21);
        level[22] = (Button) findViewById(R.id.button22);
        level[23] = (Button) findViewById(R.id.button23);
        level[24] = (Button) findViewById(R.id.button24);
        level[25] = (Button) findViewById(R.id.button25);
        level[26] = (Button) findViewById(R.id.button26);
        level[27] = (Button) findViewById(R.id.button27);
        level[28] = (Button) findViewById(R.id.button28);
        level[29] = (Button) findViewById(R.id.button29);
        level[30] = (Button) findViewById(R.id.button30);
        Button backBTN = (Button) findViewById(R.id.btn_back);

        loadData();
        refreshButton();

        Title.playMusic();


        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Intent intent = new Intent(getApplicationContext(), level_selection.class);
                startActivity(intent);
                finish();

            }
        });

        level[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),1);

                run();
            }
        });
        level[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),2);
                run();

            }
        });
        level[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),3);
                run();

            }
        });
        level[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),4);
                run();

            }
        });
        level[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),5);
                run();

            }
        });
        level[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),6);
                run();

            }
        });
        level[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),7);
                run();

            }
        });
        level[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),8);
                run();

            }
        });
        level[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),9);
                run();

            }
        });
        level[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),10);
                run();

            }
        });
        level[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),11);
                run();

            }
        });
        level[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),12);
                run();

            }
        });
        level[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),13);
                run();

            }
        });
        level[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),14);
                run();

            }
        });
        level[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),15);
                run();

            }
        });
        level[16].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),16);
                run();

            }
        });
        level[17].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),17);
                run();
            }
        });
        level[18].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),18);

                run();
            }
        });
        level[19].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),19);
                run();
            }
        });
        level[20].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),20);
                run();

            }
        });
        level[21].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),21);
                run();

            }
        });
        level[22].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),22);
                run();

            }
        });
        level[23].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),23);
                run();

            }
        });
        level[24].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),24);
                run();

            }
        });
        level[25].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),25);
                run();

            }
        });
        level[26].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),26);
                run();

            }
        });
        level[27].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),27);
                run();

            }
        });
        level[28].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),28);
                run();

            }
        });
        level[29].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),29);
                run();

            }
        });
        level[30].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {runBefore();
                Levels3 level = new Levels3(getApplicationContext(),30);
                run();

            }
        });

    }

    public static void savePreferences(int k, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        int temp = prefs.getInt("current3", 1);

        if (k+1 > temp) {
            editor.putInt("current3", k+1);
            editor.commit();
        }
    }

    public void loadData() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        current3 = prefs.getInt("current3", 1);
        editor.commit();
    }

    public void refreshButton() {
        for (int k = current3+1; k < level.length; k ++) {
            level[k].setBackgroundResource(R.drawable.level_unclicked);
            level[k].setEnabled(false);
        }

        for (int k = 1; k < current3;k ++) {
            level[k].setBackgroundResource(R.drawable.level_button3_done);
        }
    }

    public void run() {
        Title.stopMusic();
        finish();
    }
    public void runBefore() {
        for (int l = 1; l < level.length; l++) {
            level[l].setEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
    }
}
