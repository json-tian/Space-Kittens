package knightsoul.SpaceKittens;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    private int touchX;
    private int touchY;
    private int ratios;
    public static Activity activity2;

    public static SoundPool expSound;
    public static MediaPlayer gameMusic;
    //private MediaPlayer explosionSound;
    private MediaPlayer successSound;
    private MediaPlayer failSound;
    private InterstitialAd mInterstitialAd;

    private ViewGroup mainLayout;
    private ArrayList<Bomb> bomb = new ArrayList<>();
    private ArrayList<ImageView> object = new ArrayList<>();
    private ArrayList<Integer> TimerLeft = new ArrayList<>();
    private ArrayList<Integer> currentSize = new ArrayList<>();
    private CountDownTimer move;
    private ArrayList<ImageView> explosion = new ArrayList<>();
    private int score = 0;
    private TextView scoreLabel;
    private double width;
    private double height;
    private int clicked = 0;
    private int maxClick;
    private int currentLevel;
    private int adLoaded;

    private int explosionSize;
    private int balls;
    private int goal;
    private int pack;
    private int expMusic;
    private ImageView click1;
    private ImageView click2;
    private ImageView click3;
    private ImageView click4;
    private ImageView click5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        mainLayout = (RelativeLayout) findViewById(R.id.main);
        mainLayout.setOnTouchListener(handleTouch);
        this.activity2 = this;
        object.clear();
        explosion.clear();
        bomb.clear();
        //aa = new AudioAttributes().Builder().setContentType(AudioAttributes.CONTENT_TYPE_MOVIE).build();

        Random random = new Random();
        adLoaded = random.nextInt(3);

        if (adLoaded == 2) {
            mInterstitialAd = new InterstitialAd(this);
            //        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
            mInterstitialAd.setAdUnitId("ca-app-pub-3781115230256321/9519114291");
            mInterstitialAd.loadAd(new AdRequest.Builder().build());

            //MY ADUNITID:  "ca-app-pub-3781115230256321/9519114291"
        }
        click1 = (ImageView) findViewById(R.id.click1);
        click2 = (ImageView) findViewById(R.id.click2);
        click3 = (ImageView) findViewById(R.id.click3);
        click4 = (ImageView) findViewById(R.id.click4);
        click5 = (ImageView) findViewById(R.id.click5);

        String string1 = getIntent().getExtras().getString("goal");
        goal = Integer.parseInt(string1);

        String string2 = getIntent().getExtras().getString("balls");
        balls = Integer.parseInt(string2);

        String string3 = getIntent().getExtras().getString("explosionSize");
        explosionSize = Integer.parseInt(string3);

        String string4 = getIntent().getExtras().getString("clicks");
        maxClick = Integer.parseInt(string4);

        String string5 = getIntent().getExtras().getString("level");
        currentLevel = Integer.parseInt(string5);

        String string6 = getIntent().getExtras().getString("pack");
        pack = Integer.parseInt(string6);

        if (pack == 1) {
            mainLayout.setBackgroundResource(R.drawable.bg1);
        } else if (pack == 2) {
            mainLayout.setBackgroundResource(R.drawable.bg3);
        } else if (pack == 3) {
            mainLayout.setBackgroundResource(R.drawable.bg2);
        }

        Intent startIntent = new Intent(getApplicationContext(), instructions.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "" + balls);
        startIntent.putExtra("goal", "" + goal);
        startIntent.putExtra("clicks", "" + maxClick);
        startIntent.putExtra("level", "" + currentLevel);
        startIntent.putExtra("pack",  "" + pack);

        startActivity(startIntent);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        height = displayMetrics.heightPixels-60;
        width = displayMetrics.widthPixels-60;

        double ratio = (height * width) / (375000);
        explosionSize = (int) (explosionSize * (Math.sqrt(ratio)));

        ratios = (int) (explosionSize * (Math.sqrt(ratio)));
        for (int j = 0; j < balls; j++)
            generate();

        scoreLabel.setText("0/" + goal);

        if (gameMusic == null) {
            gameMusic = MediaPlayer.create(this, R.raw.gamemusic);
        }

            expSound = new SoundPool.Builder().setMaxStreams(5).build();
            expMusic = expSound.load(this, R.raw.explosion, 1);

        gameMusic.start();
        gameMusic.setLooping(true);
        if (maxClick >= 2)
            click2.setVisibility(View.VISIBLE);
        if (maxClick >= 3)
            click3.setVisibility(View.VISIBLE);
        if (maxClick >= 4)
            click4.setVisibility(View.VISIBLE);
        if (maxClick >= 5)
            click5.setVisibility(View.VISIBLE);

        click1.bringToFront();
        click2.bringToFront();
        click3.bringToFront();
        click4.bringToFront();
        click5.bringToFront();
        scoreLabel.bringToFront();


//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < object.size(); i++) {
//                    moveObject(i);
//                }
//            }
//        });
//        thread1.start();
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int k = 0; k < explosion.size(); k++) {
//                    moveExplosion(k);
//                }
//            }
//        });
//        thread2.start();
//
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                checkWinner();
//            }
//        });
//        thread3.start();

        move = new CountDownTimer(140000000, 50) {

            @Override
            public void onTick(long millisUntilFinished) {
                for (int i = 0; i < object.size(); i++) {
                    moveObject(i);
                }
                for (int k = 0; k < explosion.size(); k++) {
                    moveExplosion(k);
                }
                checkWinner();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void checkWinner() {
        boolean timer = false;

        if (TimerLeft.size() > 0) {
            if (TimerLeft.get(explosion.size()-1) < 4 * explosionSize)
                timer = true;
        }

        if (clicked == maxClick && timer == false) {
            //POPUP
            expSound.release();
            if (score >= goal) {
                Intent startIntent = new Intent(getApplicationContext(), Pop.class);
                //Show how to pass information to another activity

                startIntent.putExtra("level", "" + currentLevel);
                startIntent.putExtra("pack", "" + pack);
                startActivity(startIntent);
                successSound = MediaPlayer.create(this, R.raw.success);
                successSound.start();
            } else {

                Intent startIntent = new Intent(getApplicationContext(), PopFail.class);

                startIntent.putExtra("level", "" + currentLevel);
                startIntent.putExtra("pack", "" + pack);

                startActivity(startIntent);

                failSound = MediaPlayer.create(this, R.raw.fail);

                failSound.start();
            }
            move.cancel();
            if (adLoaded == 2) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }

        }
    }

    public void moveExplosion(int k) {
        TimerLeft.set(k, TimerLeft.get(k) + (explosionSize / 15));
        int timeLeft = TimerLeft.get(k);
        if (explosion.get(k).getX() != 0 && explosion.get(k).getY() !=0) {
            if (timeLeft <= (explosionSize*1.2)) {
                RelativeLayout.LayoutParams b = new RelativeLayout.LayoutParams(timeLeft, timeLeft);
                b.setMargins((int) (explosion.get(k).getX() - (explosionSize / 30)), (int) (explosion.get(k).getY() - (explosionSize / 30)), (int)width-((int)explosion.get(k).getX()+timeLeft), (int)height-((int)explosion.get(k).getY() + timeLeft));
                currentSize.set((k), timeLeft);
                explosion.get(k).setLayoutParams(b);
            }
        }
        if (TimerLeft.get(k) >= 2*explosionSize){
                explosion.get(k).setVisibility(View.GONE);
                explosion.get(k).setImageBitmap(null);
                explosion.remove(k);
                TimerLeft.remove(k);
                currentSize.remove(k);
        }
    }

    public void moveObject(int i) {
        //if (object.get(i).getVisibility() != View.GONE) {
        object.get(i).setRotation(object.get(i).getRotation() + bomb.get(i).getDirection());
            int x = (int)object.get(i).getX();
            int y = (int)object.get(i).getY();
            int dx = bomb.get(i).getDx();
            int dy = bomb.get(i).getDy();

            if ((x <= 0 && dx < 0) || (x + object.get(i).getWidth() > width && dx > 0))
                bomb.get(i).setDx(-dx);
            if ((y <= 0 && dy < 0) || (y + object.get(i).getHeight() > height && dy > 0))
                bomb.get(i).setDy(-dy);

            object.get(i).setX(x + dx);
            object.get(i).setY(y + dy);

            for (int j = 0; j < explosion.size(); j++) {
                if (explosion.get(j).getVisibility() != View.GONE && explosion.get(j).getX() != 0 && explosion.get(j).getY() !=0) {
                    if (checkIntersection(i, j) == true) {
                        addExplosion(i);
                        object.get(i).setVisibility(View.GONE);
                        object.remove(i);
                        bomb.remove(i);
                        score++;
                        scoreLabel.setText(score + "/" + goal);
                        break;
                    }
                }
            }
        //}
    }

    @Override
    public void onBackPressed() {
    }

    private View.OnTouchListener handleTouch = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            touchX = (int) event.getX();
            touchY = (int) event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:   //PRESSED

                    break;
                case MotionEvent.ACTION_MOVE:   //HOLD AND DRAG

                    break;
                case MotionEvent.ACTION_UP:     //RELEASE

                    if (clicked < maxClick) {
                        clicked++;

                        if (maxClick - clicked == 0) {
                            click1.setVisibility(View.INVISIBLE);
                        } else if (maxClick - clicked == 1) {
                            click2.setVisibility(View.INVISIBLE);
                        } else if (maxClick - clicked == 2) {
                            click3.setVisibility(View.INVISIBLE);
                        } else if (maxClick - clicked == 3) {
                            click4.setVisibility(View.INVISIBLE);
                        } else if (maxClick - clicked == 4) {
                            click5.setVisibility(View.INVISIBLE);
                        }

                        // Initialize a new ImageView widget
                        ImageView iv = new ImageView(getApplicationContext());
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.explosion2);
                        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
                        roundedBitmapDrawable.setCircular(true);
                        iv.setImageDrawable(roundedBitmapDrawable);

                        // Set an image for ImageView
                        //iv.setImageDrawable(getDrawable(R.drawable.explosion));

                        // Create layout parameters for ImageView
                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(0, 0);

                        lp.setMargins(touchX, touchY, 0, 0);
                        // Add layout parameters to ImageView
                        iv.setLayoutParams(lp);
                        // Finally, add the ImageView to layout
                        mainLayout.addView(iv);

                        TimerLeft.add(0);
                        currentSize.add(0);

                        expSound.play(expMusic, .25f, .25f, 1, 0, 1);
                        explosion.add(iv);

                        break;
                    }
            }

            return true;
        }
    };

    public boolean checkIntersection(int i, int j) {

//        int o1x = (int)(object.get(i).getX());
//        int o2x = (int)(object.get(i).getX() + (explosionSize/2));
//        int o1y = (int)(object.get(i).getY());
//        int o2y = (int)(object.get(i).getY() + (explosionSize/2));
//
//        int e1x = (int)(explosion.get(j).getX());
//        int e2x = (int)(explosion.get(j).getX() + explosionSize);
//        int e1y = (int)(explosion.get(j).getY());
//        int e2y = (int)(explosion.get(j).getY() + explosionSize);
//
//        if ((((o1x - e2x)*(o2x - e1x)) <= 0) && (((o1y - e2y)*(o2y - e1y)) <= 0))
//            return true;
//        return false;

        //FIRST BALL - OBJECT
        //SECOND BALL - EXPLOSION
        int firstBallx = (int) object.get(i).getX() + (explosionSize/4);
        int firstBally = (int) object.get(i).getY() + (explosionSize/4);
        int secondBallx = (int) explosion.get(j).getX() + (currentSize.get(j)/2);
        int secondBally = (int) explosion.get(j).getY() + (currentSize.get(j)/2);
        double firstBallRadius = (explosionSize/4);
        double secondBallRadius = (currentSize.get(j)/2);

        double distance = Math.sqrt(((firstBallx - secondBallx) * (firstBallx - secondBallx)) + ((firstBally - secondBally) * (firstBally - secondBally)));
        if (distance < (firstBallRadius + secondBallRadius))
        {
            return true;
        }

        return false;
    }

    public void addExplosion(int i) {
        // Initialize a new ImageView widget
        ImageView iv = new ImageView(getApplicationContext());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.explosion2);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        iv.setImageDrawable(roundedBitmapDrawable);

        // Set an image for ImageView
        //iv.setImageDrawable(getDrawable(R.drawable.explosion));

        // Create layout parameters for ImageView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(0,0);

        lp.setMargins((int)(object.get(i).getX() + (explosionSize/4)), (int)(object.get(i).getY() + (explosionSize/4)), 0, 0);
        // Add layout parameters to ImageView
        iv.setLayoutParams(lp);

        // Finally, add the ImageView to layout
        mainLayout.addView(iv);
        expSound.play(expMusic, .25f, .25f, 1, 0, 1);

        TimerLeft.add(0);
        currentSize.add(0);
        explosion.add(iv);

//        MediaPlayer expSound;
//        expSound = MediaPlayer.create(getApplicationContext(), R.raw.explosion);
//        expSound.start();

        scoreLabel.bringToFront();
        click1.bringToFront();
        click2.bringToFront();
        click3.bringToFront();
        click4.bringToFront();
        click5.bringToFront();


    }

    public void generate() {

        Random random = new Random();
        //position objects manually
        int randomNum2 = 0;

        int randomNum = random.nextInt(8) - 4;
        if (randomNum >= 0) {
            int temp = random.nextInt(2);
            if (temp == 0)
                randomNum2 = 4 - randomNum;
            else
                randomNum2 = - (4 - randomNum);
        } else if (randomNum < 0) {
            int temp = random.nextInt(2);
            if (temp == 0)
                randomNum2 = 4 + randomNum;
            else
                randomNum2 = - (4 + randomNum);
        }

        if (ratios <= 0.5) {
            if (randomNum == 4) {
                randomNum --;
            }
            if (randomNum2 == 4) {
                randomNum2--;
            }
        }
        if (randomNum == 0) {
            randomNum++;
        }
        if (randomNum2 == 0) {
            randomNum2++;
        }

        int x = random.nextInt(2);
        int y = random.nextInt(2);

        if (x == 1) {
            randomNum2 = (-1)*randomNum2;
        }

        if (y == 1) {
            randomNum = (-1)*randomNum;
        }

        object.add(new ImageView(getApplicationContext()));

        // Set an image for ImageView
        int catNum = random.nextInt(6)+1;
        switch(catNum) {
            case(1):
                if (explosionSize <= 100)
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.sneezie_small));
                else
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.sneezie));
                break;
            case(2):
                if (explosionSize <= 100)
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat2_small));
                else
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat2));
                break;

            case(3):
                if (explosionSize <= 100)
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat3_small));
                else
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat3));
                break;

            case(4):
                if (explosionSize <= 100)
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat4_small));
                else
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat4));
                break;

            case(5):
                if (explosionSize <= 100)
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat5_small));
                else
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat5));
                break;

            case(6):
                if (explosionSize <= 100)
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat6_small));
                else
                    object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.cat6));
                break;

        }


        // Create layout parameters for ImageView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(explosionSize/2,explosionSize/2);

        //        // Add layout parameters to ImageView
        object.get(object.size()-1).setLayoutParams(lp);

        // Finally, add the ImageView to layout
        mainLayout.addView(object.get(object.size()-1));
        bomb.add(new Bomb());
        bomb.get(bomb.size()-1).setDx(randomNum);
        bomb.get(bomb.size()-1).setDy(randomNum2);

        int startRotation = random.nextInt(2) + 1;
        if (startRotation == 1)
            startRotation = -1;
        else
            startRotation = 1;
        bomb.get(bomb.size()-1).setDirection(startRotation);
        int startPoint = random.nextInt(359);
        object.get(object.size()-1).setRotation(startPoint);
        int sneezieX = random.nextInt((int)width - explosionSize) + explosionSize/2;
        int sneezieY = random.nextInt((int)height - explosionSize) + explosionSize/2;

        lp.setMargins(sneezieX, sneezieY, 0, 0);

    }


}