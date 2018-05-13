package knightsoul.SpaceKittens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class Title extends AppCompatActivity implements RewardedVideoAdListener {

    private Button btn_play;
    private Button btn_multiplay;
    private Button themes;
    private Button ad_btn;
    private TextView coins;
    private ImageView cat;
    private CountDownTimer rotate;

    public static MediaPlayer titleMusic;
    public static MediaPlayer buttonSound;

    private RewardedVideoAd mRewardedVideoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
        loadData();
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_multiplay = (Button) findViewById(R.id.btn_multiplay);
        themes = (Button) findViewById(R.id.btn_themes);
        cat = (ImageView) findViewById(R.id.cat);
        coins = (TextView) findViewById(R.id.tv_coins);
        ad_btn = (Button) findViewById(R.id.btn_ad);
        buttonSound = MediaPlayer.create(getApplicationContext(), R.raw.button);

         //Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3781115230256321~5375446032");
        //MY APP ID: "ca-app-pub-3781115230256321~5375446032"

//        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
//        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
//        //MY APP ID: "ca-app-pub-3781115230256321~5375446032"

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);

        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();

        if (titleMusic != null) {
            if (!titleMusic.isPlaying()) {
                titleMusic = MediaPlayer.create(getApplicationContext(), R.raw.titlemusic);
                titleMusic.start();
                titleMusic.setLooping(true);
            }
        } else {
            titleMusic = MediaPlayer.create(getApplicationContext(), R.raw.titlemusic);
            titleMusic.start();
            titleMusic.setLooping(true);
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        int temp2 = prefs.getInt("c", 0);
        editor.commit();
        coins.setText("" + temp2);

        ad_btn.setEnabled(false);

        rotate = new CountDownTimer(1000000000, 40) {
            @Override
            public void onTick(long millisUntilFinished) {
                cat.setRotation(cat.getRotation() + 1);
            }

            @Override
            public void onFinish() {

            }
        }.start();

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSound.start();
                Intent startIntent = new Intent(getApplicationContext(), level_selection.class);
                startActivity(startIntent);
                finish();
            }
        });

        ad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mRewardedVideoAd.isLoaded()) {
                    titleMusic.stop();
                    mRewardedVideoAd.show();
                } else {
                    Toast.makeText(getApplicationContext(), "No ads ready. Please try again in a few seconds", Toast.LENGTH_SHORT).show();

                }
            }
        });

        btn_multiplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Work in Progress! Stay Tuned!", Toast.LENGTH_SHORT).show();

            }
        });

        themes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Coming soon! Keep collecting coins!", Toast.LENGTH_SHORT).show();

//                buttonSound.start();
//                Intent startIntent = new Intent(getApplicationContext(), themes_selection.class);
//                startActivity(startIntent);
            }
        });
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3781115230256321/9315277774",
                new AdRequest.Builder().build());

//        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
//                new AdRequest.Builder().build());
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Toast.makeText(this, "onRewarded! currency: " + reward.getType() + "  amount: " +
                reward.getAmount(), Toast.LENGTH_SHORT).show();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        int temp2 = prefs.getInt("c", 0);
        int temp3 = temp2 + 10;

        editor.putInt("c", temp3);
        editor.commit();
        coins.setText("" + temp3);
        titleMusic.start();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Toast.makeText(this, "onRewardedVideoAdLeftApplication",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Toast.makeText(this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        //Toast.makeText(this, "V", Toast.LENGTH_SHORT).show();
        ad_btn.setEnabled(true);
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        int temp1 = prefs.getInt("current1", 1)-1;
        int temp2 = prefs.getInt("current2", 1)-1;
        int temp3 = prefs.getInt("current3", 1)-1;
        int temp4 = prefs.getInt("current4", 1)-1;
        int temp5 = prefs.getInt("current5", 1)-1;
        int temp6 = prefs.getInt("current6", 1)-1;
        int temp7 = prefs.getInt("current7", 1)-1;
        int temp8 = prefs.getInt("current8", 1)-1;
        int temp9 = prefs.getInt("current9", 1)-1;
        int temp10 = prefs.getInt("current10", 1)-1;

        editor.commit();
    }
    public static void levelSelection(String text, Context context) {
        buttonSound.start();
        buttonSound.reset();
        if (text.startsWith("Space Kittens")) {
            RecyclerViewAdapter.levelClick = true;

            Intent intent = new Intent(context, levelpack1.class);
            context.startActivity(intent);
            level_selection.activity.finish();

        } else if (text.startsWith("Earth")) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            int temp = prefs.getInt("current1", 1);
            if (temp == 31) {
                RecyclerViewAdapter.levelClick = true;

                Intent intent = new Intent(context, levelpack2.class);
                context.startActivity(intent);
                level_selection.activity.finish();

            } else {
                Toast.makeText(context, "You must complete the previous pack", Toast.LENGTH_SHORT).show();
            }
        } else if (text.startsWith("Mars")) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            int temp = prefs.getInt("current2", 1);
            if (temp == 31) {
                RecyclerViewAdapter.levelClick = true;

                Intent intent = new Intent(context, levelpack3.class);
                context.startActivity(intent);
                level_selection.activity.finish();

            } else {
                Toast.makeText(context, "You must complete the previous pack", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "Level pack coming soon!", Toast.LENGTH_SHORT).show();

        }
    }

    public static void stopMusic() {
        if (titleMusic != null) {
            if (titleMusic.isPlaying()) {
                titleMusic.pause();
            }
        }
    }

    public static void playMusic() {
        titleMusic.start();
        titleMusic.setLooping(true);
    }

}
