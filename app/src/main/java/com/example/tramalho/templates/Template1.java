package com.example.tramalho.templates;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Template1 extends Fragment {

    private Model model = new Model();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();

        if(arguments != null) {
            model = arguments.getParcelable(MainActivity.MODEL_ARG);
        }

        return inflater.inflate(R.layout.fragment_template1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setText(view, R.id.title_id, model.title);
        setText(view, R.id.subtitle_id, model.subtitle);
        setText(view, R.id.message_id, model.message);

        ColumnValueView deliveryCV = view.findViewById(R.id.delivery_id);
        deliveryCV.setValue(model.value1);
        deliveryCV.setLabel(model.column1);

        TwoColumnValueView deliveryInfoCV = view.findViewById(R.id.delivery_info_id);
        deliveryInfoCV.setColumnValue1(model.labelValueL1, model.labelValueV1);
        deliveryInfoCV.setColumnValue2(model.labelValueL2, model.labelValueV2);
    }

    private void setText(View view, int rId, String text) {
        TextView textView = view.findViewById(rId);
        textView.setText(text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
