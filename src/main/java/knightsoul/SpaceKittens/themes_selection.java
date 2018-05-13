package knightsoul.SpaceKittens;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class themes_selection extends AppCompatActivity {

    private static final String TAG = "level_selection";
    private int[] current = new int[10];
    private Button backBTN;
    private MediaPlayer buttonSound;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themes_selection2);
        backBTN = (Button) findViewById(R.id.btn_back);
        getImages();
        buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button);

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                finish();
            }

        });
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        loadData();
        mNames.add("Default");
        mNames.add("Asteroid");

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

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        Themes_RecycleViewAdapter adapter = new Themes_RecycleViewAdapter(this, mNames);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
    }
}
