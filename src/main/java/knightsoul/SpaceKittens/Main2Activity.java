package knightsoul.SpaceKittens;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
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

public class Main2Activity extends Activity {

    private int touchX;
    private int touchY;

    private MediaPlayer gameMusic;
    private MediaPlayer explosionSound;
    private MediaPlayer successSound;
    private MediaPlayer failSound;

    private ViewGroup mainLayout;
    private ViewGroup main2Layout;
    private ArrayList<Bomb> bomb = new ArrayList<>();
    private ArrayList<ImageView> object = new ArrayList<>();
    private ArrayList<Integer> TimerLeft = new ArrayList<>();
    private ArrayList<Integer> currentSize = new ArrayList<>();
    private CountDownTimer move;
    private ArrayList<ImageView> explosion = new ArrayList<>();
    private int score = 0;
    private TextView scoreLabel;
    private int width;
    private int height;
    private int clicked = 0;
    private int maxClick;
    private int currentLevel;

    private int explosionSize;
    private int balls;
    private int goal;
    private int pack;

    private ImageView click1;
    private ImageView click2;
    private ImageView click3;
    private ImageView click4;
    private ImageView click5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2_main);
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        mainLayout = (RelativeLayout) findViewById(R.id.blue);
        mainLayout.setOnTouchListener(handleTouch);
        main2Layout = (RelativeLayout) findViewById(R.id.red);
        main2Layout.setOnTouchListener(handleTouch);

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

        if (maxClick >= 2)
            click2.setVisibility(View.VISIBLE);
        if (maxClick >= 3)
            click3.setVisibility(View.VISIBLE);
        if (maxClick >= 4)
            click4.setVisibility(View.VISIBLE);
        if (maxClick >= 5)
            click5.setVisibility(View.VISIBLE);


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
        height = displayMetrics.heightPixels - 50;
        width = displayMetrics.widthPixels;

        double ratio = (height * width) / (1280 * 670);
        explosionSize = (int) (explosionSize * ratio);

        scoreLabel.setText("0/" + goal);

        gameMusic = MediaPlayer.create(this, R.raw.gamemusic);
        explosionSound = MediaPlayer.create(this, R.raw.explosion);
        successSound = MediaPlayer.create(this, R.raw.success);
        failSound = MediaPlayer.create(this, R.raw.fail);

        if (gameMusic.isPlaying() == false) {
            gameMusic.start();
            gameMusic.setLooping(true);
        }

        for (int j = 0; j < balls; j++)
            generate();

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
            if (score >= goal) {
                Intent startIntent = new Intent(getApplicationContext(), Pop.class);
                //Show how to pass information to another activity
                successSound.start();

                startIntent.putExtra("level", "" + currentLevel);
                startIntent.putExtra("pack", "" + pack);
                startActivity(startIntent);
            } else {
                Intent startIntent = new Intent(getApplicationContext(), PopFail.class);
                failSound.start();

                startIntent.putExtra("level", "" + currentLevel);
                startIntent.putExtra("pack", "" + pack);

                startActivity(startIntent);
            }
            move.cancel();
            gameMusic.stop();
            finish();
        }
    }

    public void moveExplosion(int k) {
        TimerLeft.set(k, TimerLeft.get(k) + (explosionSize / 20));
        if (explosion.get(k).getVisibility() != View.GONE && explosion.get(k).getX() != 0 && explosion.get(k).getY() !=0) {
            if (TimerLeft.get(k) <= explosionSize) {
                RelativeLayout.LayoutParams b = new RelativeLayout.LayoutParams(TimerLeft.get(k), TimerLeft.get(k));
                b.setMargins((int) (explosion.get(k).getX() - (explosionSize / 40)), (int) (explosion.get(k).getY() - (explosionSize / 40)), 0, 0);
                currentSize.set((k), TimerLeft.get(k));
                explosion.get(k).setLayoutParams(b);
            }
        }
        if (TimerLeft.get(k) >= 4*explosionSize){
            explosion.get(k).setVisibility(View.GONE);
            explosion.remove(k);
            TimerLeft.remove(k);
            currentSize.remove(k);
        }
    }

    public void moveObject(int i) {
        if (object.get(i).getVisibility() != View.GONE) {
            if ((int)object.get(i).getX() <= 0 || object.get(i).getX() + object.get(i).getWidth() > width)
                bomb.get(i).setDx(-bomb.get(i).getDx());
            if ((int)object.get(i).getY() <= 0 || object.get(i).getY() + object.get(i).getHeight() > height)
                bomb.get(i).setDy(-bomb.get(i).getDy());

            object.get(i).setX(object.get(i).getX() + bomb.get(i).getDx());
            object.get(i).setY(object.get(i).getY() + bomb.get(i).getDy());

            for (int j = 0; j < explosion.size(); j++) {
                if (explosion.get(j).getVisibility() != View.GONE && explosion.get(j).getX() != 0 && explosion.get(j).getY() !=0) {
                    if (checkIntersection(i, j) == true) {
                        addExplosion(i);
                        object.get(i).setVisibility(View.GONE);
                        object.remove(i);
                        score++;
                        scoreLabel.setText(score + "/" + goal);
                        break;
                    }
                }
            }
        }
    }

    public void onBackPressed() {
        gameMusic.stop();
        System.exit(0);
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

                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.explosion);
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

                        explosionSound.start();
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

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.explosion);
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

        TimerLeft.add(0);
        currentSize.add(0);
        explosion.add(iv);

        explosionSound.start();

    }

    public void generate() {

        Random random = new Random();
        //position objects manually
        int randomNum2 = 0;

        int randomNum = random.nextInt(11) - 5;
        if (randomNum >= 0) {
            int temp = random.nextInt(2);
            if (temp == 0)
                randomNum2 = 5 - randomNum;
            else
                randomNum2 = - (5 - randomNum);
        } else if (randomNum < 0) {
            int temp = random.nextInt(2);
            if (temp == 0)
                randomNum2 = 5 + randomNum;
            else
                randomNum2 = - (5 + randomNum);
        }

        randomNum++;
        randomNum2++;

        object.add(new ImageView(getApplicationContext()));

        // Set an image for ImageView
        object.get(object.size()-1).setImageDrawable(getDrawable(R.drawable.sneezie));

        // Create layout parameters for ImageView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(explosionSize/2,explosionSize/2);

        // Add layout parameters to ImageView
        object.get(object.size()-1).setLayoutParams(lp);

        // Finally, add the ImageView to layout
        mainLayout.addView(object.get(object.size()-1));
        bomb.add(new Bomb());
        bomb.get(bomb.size()-1).setDx(randomNum);
        bomb.get(bomb.size()-1).setDy(randomNum2);

        int sneezieX = random.nextInt(width - explosionSize) + explosionSize/2;
        int sneezieY = random.nextInt(height - explosionSize) + explosionSize/2;

        lp.setMargins(sneezieX, sneezieY, 0, 0);

    }
}