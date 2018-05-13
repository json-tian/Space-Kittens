package knightsoul.SpaceKittens;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;

public class Levels3 {

    private Context activity;
    private int level;

    public Levels3(Context activity, int level) {
        this.activity = activity;
        this.level = level;

        MediaPlayer buttonSound = MediaPlayer.create(activity, R.raw.button);
        buttonSound.start();

        switch (level) {
            case 1:   //PRESSED
                level1();
                break;
            case 2:   //HOLD AND DRAG
                level2();
                break;
            case 3:     //RELEASE
                level3();
                break;
            case 4:     //RELEASE
                level4();
                break;
            case 5:     //RELEASE
                level5();
                break;
            case 6:     //RELEASE
                level6();
                break;
            case 7:     //RELEASE
                level7();
                break;
            case 8:     //RELEASE
                level8();
                break;
            case 9:     //RELEASE
                level9();
                break;
            case 10:     //RELEASE
                level10();
                break;
            case 11:     //RELEASE
                level11();
                break;
            case 12:     //RELEASE
                level12();
                break;
            case 13:     //RELEASE
                level13();
                break;
            case 14:     //RELEASE
                level14();
                break;
            case 15:     //RELEASE
                level15();
                break;
            case 16:     //RELEASE
                level16();
                break;
            case 17:     //RELEASE
                level17();
                break;
            case 18:     //RELEASE
                level18();
                break;
            case 19:     //RELEASE
                level19();
                break;
            case 20:     //RELEASE
                level20();
                break;
            case 21:     //RELEASE
                level21();
                break;
            case 22:     //RELEASE
                level22();
                break;
            case 23:     //RELEASE
                level23();
                break;
            case 24:     //RELEASE
                level24();
                break;
            case 25:     //RELEASE
                level25();
                break;
            case 26:     //RELEASE
                level26();
                break;
            case 27:     //RELEASE
                level27();
                break;
            case 28:     //RELEASE
                level28();
                break;
            case 29:     //RELEASE
                level29();
                break;
            case 30:     //RELEASE
                level30();
                break;
        }
    }

    public void level1() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "40");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "25");
        startIntent.putExtra("clicks", "3");
        startIntent.putExtra("level", "1");
        startIntent.putExtra("pack", "3");


        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level2() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "60");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "40");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "2");
        startIntent.putExtra("pack", "3");


        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level3() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "80");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "50");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "3");
        startIntent.putExtra("pack", "3");


        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level4() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "65");
        startIntent.putExtra("explosionSize", "80");
        startIntent.putExtra("goal", "45");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "4");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level5() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "120");
        startIntent.putExtra("explosionSize", "50");
        startIntent.putExtra("goal", "70");
        startIntent.putExtra("clicks", "3");
        startIntent.putExtra("level", "5");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level6() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "30");
        startIntent.putExtra("explosionSize", "100");
        startIntent.putExtra("goal", "25");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "6");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level7() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "60");
        startIntent.putExtra("explosionSize", "100");
        startIntent.putExtra("goal", "50");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "7");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }

    public void level8() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "50");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "40");
        startIntent.putExtra("clicks", "3");
        startIntent.putExtra("level", "8");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level9() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "65");
        startIntent.putExtra("explosionSize", "80");
        startIntent.putExtra("goal", "50");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "9");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level10() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "80");
        startIntent.putExtra("explosionSize", "60");
        startIntent.putExtra("goal", "60");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "10");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level11() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "35");
        startIntent.putExtra("explosionSize", "100");
        startIntent.putExtra("goal", "25");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "11");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level12() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "75");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "50");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "12");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level13() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "60");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "50");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "13");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level14() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "80");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "40");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "14");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level15() {

        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "100");
        startIntent.putExtra("explosionSize", "50");
        startIntent.putExtra("goal", "60");
        startIntent.putExtra("clicks", "4");
        startIntent.putExtra("level", "15");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level16() { //TEST THIS LEVEL NEXT
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "35");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "30");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "16");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level17() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "55");
        startIntent.putExtra("explosionSize", "85");
        startIntent.putExtra("goal", "40");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "17");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level18() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "70");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "60");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "18");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level19() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "50");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "45");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "19");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level20() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "65");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "55");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "20");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level21() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "80");
        startIntent.putExtra("explosionSize", "60");
        startIntent.putExtra("goal", "60");
        startIntent.putExtra("clicks", "3");
        startIntent.putExtra("level", "21");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level22() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "100");
        startIntent.putExtra("explosionSize", "60");
        startIntent.putExtra("goal", "70");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "22");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level23() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "90");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "75");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "23");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level24() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "120");
        startIntent.putExtra("explosionSize", "50");
        startIntent.putExtra("goal", "90");
        startIntent.putExtra("clicks", "3");
        startIntent.putExtra("level", "24");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }public void level25() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "20");
        startIntent.putExtra("explosionSize", "100");
        startIntent.putExtra("goal", "18");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "25");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level26() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "40");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "25");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "26");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level27() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "40");
        startIntent.putExtra("explosionSize", "100");
        startIntent.putExtra("goal", "30");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "27");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level28() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "60");
        startIntent.putExtra("explosionSize", "75");
        startIntent.putExtra("goal", "50");
        startIntent.putExtra("clicks", "2");
        startIntent.putExtra("level", "28");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }public void level29() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "80");
        startIntent.putExtra("explosionSize", "40");
        startIntent.putExtra("goal", "60");
        startIntent.putExtra("clicks", "5");
        startIntent.putExtra("level", "29");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
    public void level30() {
        Intent startIntent = new Intent(activity, MainActivity.class);
        //Show how to pass information to another activity

        startIntent.putExtra("balls", "200");
        startIntent.putExtra("explosionSize", "50");
        startIntent.putExtra("goal", "175");
        startIntent.putExtra("clicks", "1");
        startIntent.putExtra("level", "30");
        startIntent.putExtra("pack", "3");

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            startIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(startIntent);
        } else {
            activity.startActivity(startIntent);
        }
    }
}
