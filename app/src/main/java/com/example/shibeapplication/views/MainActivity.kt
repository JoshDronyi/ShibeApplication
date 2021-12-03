package com.example.shibeapplication.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shibeapplication.databinding.ActivityMainBinding
import com.example.shibeapplication.viewmodels.ShibeViewModel
import com.example.shibeapplication.views.adapters.ShibeAdapter
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var viewModel: ShibeViewModel

    private var gridManager: GridLayoutManager? = null
    private var linearManager: LinearLayoutManager? = null

    @Inject
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //view and viewModel instantiation

        //set Event Listeners
        viewModel
                .getShibes(20)
                .enqueue(object : Callback<List<String>> {
                    override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                        response.body()?.let {
                            binding.rvShibeContainer.adapter = ShibeAdapter(it)
                        }
                    }

                    override fun onFailure(call: Call<List<String>>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Image Fetch failed.", Toast.LENGTH_SHORT).show()
                        Log.e("FailedImageFetch", "Failed to retrieve images of Shibes")
                        t.printStackTrace()
                    }
                })
        binding.btnSwitch.setOnClickListener(this)

        //Set the layout manager
        gridManager = GridLayoutManager(this, 3)
        linearManager = LinearLayoutManager(this)

        binding.rvShibeContainer.layoutManager = gridManager
    }

    override fun onClick(view: View) {
        with(binding.rvShibeContainer) {
            when (layoutManager) {
                is GridLayoutManager -> {
                    layoutManager = linearManager
                }
                is LinearLayoutManager -> {
                    layoutManager = gridManager
                }
            }
        }
    }
}