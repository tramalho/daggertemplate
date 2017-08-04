package com.example.tramalho.templates;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by tramalho on 04/08/17.
 */

public class ColumnValueView extends LinearLayout{
    private TextView label;
    private TextView value;

    public ColumnValueView(Context context) {
       this(context, null);
    }

    public ColumnValueView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColumnValueView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ColumnValueView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        this.setOrientation(VERTICAL);
        inflate(getContext(), R.layout.label_value_colunar, this);

        label = findViewById(R.id.colunar_label_id);
        value = findViewById(R.id.colunar_value_id);
    }

    public void setLabel(String label) {
        this.label.setText(label);
    }

    public void setValue(String value) {
        this.value.setText(value);
    }
}
