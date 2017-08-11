package com.example.tramalho.templates.di.component;

import android.support.v4.app.Fragment;

import com.example.tramalho.templates.Template1;
import com.example.tramalho.templates.Template2;
import com.example.tramalho.templates.di.module.RepositoryModule;

import dagger.Component;

/**
 * Created by tramalho on 11/08/17.
 */

@Component(modules = RepositoryModule.class)
public interface TemplateComponent {
    void inject(Template1 fragment);
    void inject(Template2 fragment);
}
