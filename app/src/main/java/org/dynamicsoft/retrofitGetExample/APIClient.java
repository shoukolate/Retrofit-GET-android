package org.dynamicsoft.retrofitGetExample;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.dynamicsoft.retrofitGetExample.URLConstants.APIURL;

class APIClient {

    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return new Retrofit.Builder().baseUrl(APIURL).addConverterFactory(GsonConverterFactory.create()).client(client).build();

    }
}