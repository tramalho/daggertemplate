package com.example.tramalho.templates;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by tramalho on 04/08/17.
 */

public class TwoColumnValueView extends LinearLayout {
    private ColumnValueView columnValue1;
    private ColumnValueView columnValue2;

    public TwoColumnValueView(Context context) {
        this(context, null);
    }

    public TwoColumnValueView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwoColumnValueView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TwoColumnValueView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        this.setOrientation(HORIZONTAL);
        inflate(getContext(), R.layout.two_columns_label_value, this);

        columnValue1 = (ColumnValueView) findViewById(R.id.column_1);
        columnValue2 = (ColumnValueView) findViewById(R.id.column_2);
    }

    private void populate(ColumnValueView cl, String label, String value) {
        cl.setLabel(label);
        cl.setValue(value);
    }

    public void setColumnValue1(String label, String value) {
        populate(this.columnValue1, label, value);
    }

    public void setColumnValue2(String label, String value) {
        populate(this.columnValue2, label, value);
    }
}
