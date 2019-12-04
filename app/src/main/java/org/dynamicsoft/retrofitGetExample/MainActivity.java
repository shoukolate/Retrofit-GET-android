package org.dynamicsoft.retrofitGetExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<CheckObj> call = apiInterface.checkObj();
        call.enqueue(new Callback<CheckObj>() {
            @Override
            public void onResponse(@NotNull Call<CheckObj> call, @NotNull Response<CheckObj> response) {
                CheckObj resource = response.body();
                assert resource != null;
                Toast.makeText(MainActivity.this, resource.myobj, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(@NotNull Call<CheckObj> call, @NotNull Throwable t) {
                call.cancel();
            }
        });
    }
}