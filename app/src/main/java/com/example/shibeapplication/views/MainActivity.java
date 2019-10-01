package com.example.shibeapplication.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shibeapplication.R;
import com.example.shibeapplication.adapters.ShibeAdapter;
import com.example.shibeapplication.viewmodels.ShibeViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.rv_shibeContainer) RecyclerView rvShibes;
    @BindView(R.id.btn_switch) Button btnSwitch;
    private ShibeViewModel viewModel;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view and viewModel instantiation
        ButterKnife.bind(this);
        viewModel = new ShibeViewModel();

        //set Event Listeners
        viewModel
                .getShibes(20)
                .enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {

                        ShibeAdapter adapter = new ShibeAdapter(response.body());
                        rvShibes.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Image Fetch failed.", Toast.LENGTH_SHORT).show();
                        Log.e("FailedImageFetch","Failed to retrieve images of Shibes");
                        t.printStackTrace();
                    }
                });
        btnSwitch.setOnClickListener(this);

        //Set the layout manager
        manager = new GridLayoutManager(this, 1);
        rvShibes.setLayoutManager(manager);


    }

    @Override
    public void onClick(View view) {
        int spanCount = manager.getSpanCount();
        if (spanCount == 1){
            manager.setSpanCount(4);
        }else if(spanCount == 4){
            manager.setSpanCount(1);
        }
    }
}
