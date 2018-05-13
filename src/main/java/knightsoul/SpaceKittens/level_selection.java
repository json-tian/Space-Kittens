package knightsoul.SpaceKittens;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class level_selection extends AppCompatActivity {

    private static final String TAG = "level_selection";
    private int[] current = new int[10];
    private Button backBTN;
    private MediaPlayer buttonSound;
    public static Activity activity;
    public static boolean buttonClick = false;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_selection2);
        backBTN = (Button) findViewById(R.id.btn_back);
        this.activity = this;
        getImages();
        buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button);

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RecyclerViewAdapter.levelClick == false && buttonClick == false) {
                    buttonClick = true;
                    buttonSound.start();
                    buttonSound.reset();
                    Intent intent = new Intent(getApplicationContext(), Title.class);
                    startActivity(intent);
                    finish();
                }
            }

        });
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        loadData();
        mNames.add("Space Kittens\n" + current[1] + "/30");

        mNames.add("Earth\n" + current[2] + "/30");

        mNames.add("Mars\n" + current[3] + "/30");

        mNames.add("Jupiter\n" + "COMING SOON!");

        mNames.add("Saturn\n" + "COMING SOON!");

        mNames.add("Uranus\n" + "COMING SOON!");

        mNames.add("Neptune\n" + "COMING SOON!");

        mNames.add("Pluto\n" + "COMING SOON!");

        mNames.add("Beyond\n" + "COMING SOON!");

        initRecyclerView();

    }

    public void loadData() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        current[1] = prefs.getInt("current1", 1)-1;
        current[2] = prefs.getInt("current2", 1)-1;
        current[3] = prefs.getInt("current3", 1)-1;
        current[4] = prefs.getInt("current4", 1)-1;
        current[5] = prefs.getInt("current5", 1)-1;
        current[6] = prefs.getInt("current6", 1)-1;
        current[7] = prefs.getInt("current7", 1)-1;
        current[8] = prefs.getInt("current8", 1)-1;
        current[9] = prefs.getInt("current9", 1)-1;

        editor.commit();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
    }
}
