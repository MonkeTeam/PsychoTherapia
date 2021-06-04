package com.MonkeTeam.psychotherapia.utils.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

public class FontUI
{
    public static final String pacifico_path = "fonts/pacifico_regular.ttf";

    public static void makePacifio(Context context, TextView view)
    {
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), FontUI.pacifico_path);
        view.setTypeface(typeface);
    }
}
