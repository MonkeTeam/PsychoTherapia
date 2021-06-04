package com.MonkeTeam.psychotherapia.utils.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.Button;

import com.MonkeTeam.psychotherapia.R;

public class ButtonUI
{
    public static final int NORMAL = 0;
    public static final int PACIFICO = 1;

    private static final String pacifico_path = "fonts/pacifico_regular.ttf";

    public static void makePrimary(
            Context context,
            Button button,
            final int font_choice,
            final boolean all_caps
    )
    {
        button.setBackgroundResource(R.drawable.primary_button);
        button.setAllCaps(all_caps);
        button.setTextColor(Color.parseColor("#606060"));

        Typeface typeface = ButtonUI.getTypeFace(context, font_choice);
        if(typeface != null)
        {
            button.setTypeface(typeface);
        }
    }

    public static void makeSecondary(
            Context context,
            Button button,
            final int font_choice,
            final boolean all_caps
    )
    {
        button.setBackgroundResource(R.drawable.secondary_button);
        button.setAllCaps(all_caps);
        button.setTextColor(Color.parseColor("#ffffff"));

        Typeface typeface = ButtonUI.getTypeFace(context, font_choice);
        if(typeface != null)
        {
            button.setTypeface(typeface);
        }
    }

    private static Typeface getTypeFace(final Context context, final int font_choice)
    {
        Typeface typeface;

        if(font_choice == ButtonUI.PACIFICO)
        {
            return Typeface.createFromAsset(context.getAssets(), ButtonUI.pacifico_path);
        }
        return null;
    }
}
