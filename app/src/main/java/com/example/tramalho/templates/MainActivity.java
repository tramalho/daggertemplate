package com.example.tramalho.templates;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

        Fragment frag1 = new Template1();

        if(R.id.template2_id == button.getId()) {
            frag1 = new Template2();
        }

        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.details, frag1, FRAGMENT_TAG);
        fragTransaction.addToBackStack("ReplaceFragment");
        fragTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
