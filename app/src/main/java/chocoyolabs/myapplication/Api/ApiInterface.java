package chocoyolabs.myapplication.Api;

import java.util.ArrayList;
import java.util.List;

import chocoyolabs.myapplication.models.Penalty;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by moisolutions on 13/2/18.
 */

public interface ApiInterface {
    @GET("/")
    Call<ArrayList<Penalty>> getPenalties();
}
