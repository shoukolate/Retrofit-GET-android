package org.dynamicsoft.retrofitGetExample;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIInterface {

    @GET("myapifile.json")
    Call<CheckObj> checkObj();
}
