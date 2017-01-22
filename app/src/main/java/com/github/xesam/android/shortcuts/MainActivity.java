package com.github.xesam.android.shortcuts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.max)).setText("Max :" + new ShortcutMgr(this).getMax());
        findViewById(R.id.set_dynamic_shortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutMgr shortcutMgr = new ShortcutMgr(getApplicationContext());
                shortcutMgr.set();
            }
        });
        findViewById(R.id.add_dynamic_shortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutMgr shortcutMgr = new ShortcutMgr(getApplicationContext());
                shortcutMgr.add();
            }
        });
        findViewById(R.id.update_dynamic_shortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutMgr shortcutMgr = new ShortcutMgr(getApplicationContext());
                shortcutMgr.update();
            }
        });
        findViewById(R.id.remove_dynamic_shortcut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutMgr shortcutMgr = new ShortcutMgr(getApplicationContext());
                shortcutMgr.remove();
            }
        });
    }
}
