package chocoyolabs.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import chocoyolabs.myapplication.Api.Api;
import chocoyolabs.myapplication.adapters.PenaltyAdapter;
import chocoyolabs.myapplication.models.Penalty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initViews();
        configureRecyclerView();
        fetchHttpRequest();
    }

    /**
     * To get reference of the view elements
     */
    private void initViews() {
        floatingActionButton = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
    }

    /**
     * To configure the RecyclerView
     */
    private void configureRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * To make an http request to an especific endpoint
     */
    private void fetchHttpRequest() {
        Toast.makeText(this, "Debug", Toast.LENGTH_SHORT).show();

        Call<List<Penalty>> call = Api.instance().getPenalties();
        call.enqueue(new Callback<List<Penalty>>() {
            @Override
            public void onResponse(@NonNull Call<List<Penalty>> call, Response<List<Penalty>> response) {
                if (response.body() != null) {
                    PenaltyAdapter penaltyAdapter = new PenaltyAdapter(response.body());
                    recyclerView.setAdapter(penaltyAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Penalty>> call, @NonNull Throwable t) {
                Log.i("Debug: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
