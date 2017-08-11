package com.example.tramalho.templates;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Template2 extends Fragment implements Repository.Listener {

    @BindView(R.id.title_id)
    TextView title;
    @BindView(R.id.subtitle_id)
    TextView subtitle;
    @BindView(R.id.delivery_id)
    ColumnValueView deliveryCV;
    @BindView(R.id.message_id)
    ColumnValueView message;
    @BindView(R.id.delivery_info_id)
    TwoColumnValueView deliveryInfoCV;
    @BindView(R.id.italic_id)
    TextView italic;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_template2, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Repository(this).request(getString(R.string.endpoint_template));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void populate(Model model) {
        title.setText(model.title);
        subtitle.setText(model.subtitle);
        italic.setText(model.message);

        deliveryCV.setValue(model.value1);
        deliveryCV.setLabel(model.column1);

        message.setLabel(model.labelValueL1);
        message.setValue(model.labelValueV1);

        deliveryInfoCV.setColumnValue1(model.labelValueL2, model.labelValueV2);
        deliveryInfoCV.setColumnValue2(model.labelValueL3, model.labelValueV3);
    }

    @Override
    public void success(Model model) {
        populate(model);
    }

    @Override
    public void failure() {
        Toast.makeText(getContext(), "Erro na requisição", Toast.LENGTH_LONG).show();
    }
}
