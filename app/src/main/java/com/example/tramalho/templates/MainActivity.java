package com.example.tramalho.templates;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private static final String FRAGMENT_TAG = "FRAGMENT_TAG";
    public static final String MODEL_ARG = "MODEL_ARG";
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         unbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.template1_id, R.id.template2_id})
    public void clickTemplate(Button button) {

        Model model = configModel(R.array.recibo_entrega);

        Fragment frag1 = new Template1();

        if(R.id.template2_id == button.getId()) {
            frag1 = new Template2();
            model = configModel(R.array.nota_de_compra);
        }

        Bundle args = new Bundle();
        args.putParcelable(MODEL_ARG, model);
        frag1.setArguments(args);

        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.details, frag1, FRAGMENT_TAG);
        fragTransaction.addToBackStack("ReplaceFragment");
        fragTransaction.commit();
    }

    private Model configModel(int rArrayId) {
        Model model = new Model();

        Resources res = getResources();
        String[] itens = res.getStringArray(rArrayId);

        model.title = itens[0];
        model.subtitle = itens[1];
        model.column1 = itens[2];
        model.value1 = itens[3];
        model.labelValueL1 = itens[4];
        model.labelValueV1 = itens[5];
        model.labelValueL2 = itens[6];
        model.labelValueV2 = itens[7];
        model.message = itens[8];
        model.labelValueL3 = itens[9];
        model.labelValueV3 = itens[10];

        return model;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
