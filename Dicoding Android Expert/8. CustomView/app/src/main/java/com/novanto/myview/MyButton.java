package com.novanto.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import static android.view.Gravity.CENTER;

public class MyButton extends AppCompatButton {
    private Drawable enabledBackground, disabledBackground;
    private int textColor;


    public MyButton(Context context) {
        super(context);
        init();
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        setBackground(isEnabled() ? enabledBackground :disabledBackground);
        setTextColor(textColor);
        setTextSize(12.f);
        setGravity(CENTER);
        setText(isEnabled() ? "Submit" : "Isi Dulu");
    }

    void init(){
        textColor = ContextCompat.getColor(getContext(), android.R.color.background_light);
        enabledBackground = getResources().getDrawable(R.drawable.bg_button);
        disabledBackground = getResources().getDrawable(R.drawable.bg_button_disable);
    }
}
