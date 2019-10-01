package com.example.shibeapplication.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shibeapplication.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.rv_shibeContainer) RecyclerView rvShibes;
    @BindView(R.id.btn_switch) Button btnSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set Event Listeners
        btnSwitch.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        //TODO This is where you should switch the recycler view's manager from linear to grid or in grid from 1 col to 4 and back.
    }
}
