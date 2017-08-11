package com.example.tramalho.templates;

import com.example.tramalho.templates.di.component.DaggerTemplateComponent;
import com.example.tramalho.templates.di.component.TemplateComponent;
import com.example.tramalho.templates.di.module.RepositoryModule;

/**
 * Created by tramalho on 11/08/17.
 */

public class TemplateApplication extends android.app.Application {

    private static TemplateComponent templateComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        templateComponent =
                DaggerTemplateComponent.builder()
                        .repositoryModule(new RepositoryModule())
                .build();
    }

    public static TemplateComponent getTemplateComponent() {
        return templateComponent;
    }
}
