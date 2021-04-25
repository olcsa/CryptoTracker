package com.oliwasi.cryptotracker.network;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ActivityComponent.class)
public class NetworkModule {

    @Provides
    public static PublicApi providePublicApiService(){

        return  new Retrofit.Builder()
                .baseUrl(" https://poloniex.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(PublicApi.class);
    }
}
