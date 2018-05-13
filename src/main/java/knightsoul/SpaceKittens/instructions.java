package knightsoul.SpaceKittens;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class instructions extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);

        RelativeLayout button = (RelativeLayout) findViewById(R.id.view);
        TextView tv_goal = (TextView) findViewById(R.id.tv_goal);
        TextView tv_objects = (TextView) findViewById(R.id.tv_objects);
        TextView tv_level = (TextView) findViewById(R.id.tv_level);
        TextView tv_clicks = (TextView) findViewById(R.id.tv_clicks);

        String string1 = getIntent().getExtras().getString("goal");
        int goal = Integer.parseInt(string1);
        String string2 = getIntent().getExtras().getString("balls");
        int balls = Integer.parseInt(string2);
        String string3 = getIntent().getExtras().getString("clicks");
        int clicks = Integer.parseInt(string3);
        String string4 = getIntent().getExtras().getString("level");
        int level = Integer.parseInt(string4);
        String string5 = getIntent().getExtras().getString("pack");
        int pack = Integer.parseInt(string5);

        tv_goal.setText("GOAL: " + goal);
        tv_objects.setText("Objects: " + balls);
        tv_level.setText("Level " + pack + " - " + level);
        tv_clicks.setText("Clicks: " + clicks);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        //getWindow().setLayout((int) (width), (int) (height));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
