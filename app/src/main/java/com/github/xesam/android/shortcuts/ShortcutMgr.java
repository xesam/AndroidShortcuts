package com.github.xesam.android.shortcuts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.annotation.DrawableRes;

import java.util.Arrays;

/**
 * Created by xesamguo@gmail.com on 17-1-22.
 */

public class ShortcutMgr {
    private Context mContext;

    public ShortcutMgr(Context context) {
        this.mContext = context;
    }

    private boolean checkCompat() {
        return android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1;
    }

    public int getMax() {
        if (checkCompat()) {
            ShortcutManager shortcutManager = mContext.getSystemService(ShortcutManager.class);
            return shortcutManager.getMaxShortcutCountPerActivity();
        } else {
            return 0;
        }
    }

    public boolean set() {
        if (checkCompat()) {
            ShortcutManager shortcutManager = mContext.getSystemService(ShortcutManager.class);
            ShortcutInfo shortcut = new ShortcutInfo.Builder(mContext, "set_1")
                    .setShortLabel("[set]Chelaile")
                    .setLongLabel("Open [set]chelaile")
                    .setIcon(Icon.createWithResource(mContext, R.drawable.ic_launcher))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.chelaile.net.cn/")))
                    .build();
            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
            return true;
        } else {
            return false;
        }
    }

    public boolean add() {
        if (checkCompat()) {
            ShortcutManager shortcutManager = mContext.getSystemService(ShortcutManager.class);
            ShortcutInfo shortcut = new ShortcutInfo.Builder(mContext, "add_1")
                    .setShortLabel("[add]Chelaile")
                    .setLongLabel("Open [add]chelaile")
                    .setIcon(Icon.createWithResource(mContext, R.drawable.ic_launcher))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.chelaile.net.cn/")))
                    .build();
            shortcutManager.addDynamicShortcuts(Arrays.asList(shortcut));
            return true;
        } else {
            return false;
        }
    }

    public boolean remove() {
        if (checkCompat()) {
            ShortcutManager shortcutManager = mContext.getSystemService(ShortcutManager.class);
            shortcutManager.removeDynamicShortcuts(Arrays.asList("add_1"));
            return true;
        } else {
            return false;
        }
    }

    public boolean update() {
        if (checkCompat()) {
            ShortcutManager shortcutManager = mContext.getSystemService(ShortcutManager.class);
            ShortcutInfo shortcut = new ShortcutInfo.Builder(mContext, "add_1")
                    .setShortLabel("[update]Chelaile")
                    .setLongLabel("Open [update]chelaile")
                    .setIcon(Icon.createWithResource(mContext, R.drawable.ic_launcher))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.chelaile.net.cn/")))
                    .build();
            shortcutManager.updateShortcuts(Arrays.asList(shortcut));
            return true;
        } else {
            return false;
        }
    }

    public boolean report() {
        if (checkCompat()) {
            ShortcutManager shortcutManager = mContext.getSystemService(ShortcutManager.class);
            shortcutManager.reportShortcutUsed("add_1");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 创建快捷方式
     */
    public static void createShortcut(Context context, String shortcutName, @DrawableRes int logoResId, Intent shortCutIntent) {
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, shortcutName);
        intent.putExtra("duplicate", false);
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortCutIntent);
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(context, logoResId));
        context.sendBroadcast(intent);
    }


}
