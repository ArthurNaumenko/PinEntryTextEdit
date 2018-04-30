package com.codebzrk.pinentrytextedit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.util.AttributeSet;


public class PinEntryTextEdit extends AppCompatEditText {

    Paint mLinePaint, mTextPaint;
    private Rect mTextBounds;
    private Rect mCanvasBounds;

    public PinEntryTextEdit(Context context) {
        super(context);
    }

    public PinEntryTextEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        setBackgroundResource(R.drawable.text_field_shape);

        mLinePaint = new Paint();
        mLinePaint.setColor(getResources().getColor(R.color.darkGray));
        mLinePaint.setStrokeWidth(4);

        applyFontSize(context, attrs);

        mTextBounds = new Rect();
        mCanvasBounds = new Rect();
    }

    private void applyFontSize(Context context, AttributeSet attrs) {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(getResources().getColor(R.color.darkGray));
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        float scaledSizeInPixels = getResources().getDimensionPixelSize(R.dimen.text_size);
        mTextPaint.setTextSize(scaledSizeInPixels);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        float mWidth = getWidth() / 4;
        float startX = mWidth;
        float startY = getHeight() / 6;


        Editable text = getText();
        float mWidth2 = getWidth() / 8;
        float textStartX = mWidth2;

        mCanvasBounds.set(getPaddingLeft(), getPaddingTop(),
                getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());

        for (int i = 0; i < 4 ; i++) {

            if (i < 3) {
                canvas.drawLine(
                        startX,
                        startY * 2,
                        startX,
                        startY * 4,
                        mLinePaint);
            }

            if (getText().length() == 4) {
                mTextPaint.setColor(getResources().getColor(R.color.green));
            } else {
                mTextPaint.setColor(getResources().getColor(R.color.darkGray));
            }

            if (getText().length() > i ) {
                mTextPaint.getTextBounds(text.toString(), i, i + 1, mTextBounds);
                float mTextHeight = mTextBounds.height();
                canvas.drawText(text,
                        i,
                        i + 1,
                        textStartX,
                        mCanvasBounds.centerY() + (mTextHeight / 2f),
                        mTextPaint);
                textStartX += mWidth2 + mWidth2;
            }
            startX += mWidth;
        }
    }
}
