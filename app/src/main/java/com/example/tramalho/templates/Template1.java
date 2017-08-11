package com.example.tramalho.templates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tramalho.templates.di.component.TemplateComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Template1 extends Fragment implements Repository.Listener {

    @BindView(R.id.title_id)
    TextView title;
    @BindView(R.id.subtitle_id)
    TextView subtitle;
    @BindView(R.id.delivery_id)
    ColumnValueView deliveryCV;
    @BindView(R.id.delivery_info_id)
    TwoColumnValueView deliveryInfoCV;
    @BindView(R.id.message_id)
    TextView message;

    private Unbinder unbinder;

    @Inject Repository repository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_template1, container, false);

        unbinder = ButterKnife.bind(this, view);

        TemplateComponent templateComponent = TemplateApplication.getTemplateComponent();
        templateComponent.inject(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repository.setListener(this);
        repository.retrieveData(getString(R.string.endpoint_template));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void populate(Model model) {

        title.setText(model.title);
        subtitle.setText(model.subtitle);
        message.setText(model.message);

        deliveryCV.setValue(model.value1);
        deliveryCV.setLabel(model.column1);

        deliveryInfoCV.setColumnValue1(model.labelValueL1, model.labelValueV1);
        deliveryInfoCV.setColumnValue2(model.labelValueL2, model.labelValueV2);
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
