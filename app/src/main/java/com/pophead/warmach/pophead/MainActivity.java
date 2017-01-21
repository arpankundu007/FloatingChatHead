package com.pophead.warmach.pophead;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart = (Button) findViewById(R.id.button);
        final Intent intent = new Intent(MainActivity.this, ChatHeadService.class);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(intent);
//                Intent startMain = new Intent(Intent.ACTION_MAIN);
//                startMain.addCategory(Intent.CATEGORY_HOME);
//                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(startMain);
                  startNavigation();

            }
        });


    }

    public void startNavigation(){
        String packageName = "com.google.android.apps.maps";
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);

        if(intent == null) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+packageName));
        }
        startActivity(intent);
    }
}
