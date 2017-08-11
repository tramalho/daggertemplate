package com.example.tramalho.templates.di.module;

import com.example.tramalho.templates.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tramalho on 11/08/17.
 */
@Module
public class RepositoryModule {

    @Provides
    public Repository templateRepository() {
        return new Repository();
    }
}
