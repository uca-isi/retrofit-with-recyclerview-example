package chocoyolabs.myapplication.Api;

import java.util.List;

import chocoyolabs.myapplication.models.Penalty;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/")
    Call<List<Penalty>> getPenalties();
}
