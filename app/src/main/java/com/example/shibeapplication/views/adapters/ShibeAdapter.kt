package com.example.shibeapplication.views.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.shibeapplication.R
import com.example.shibeapplication.databinding.ShibeItemBinding
import com.example.shibeapplication.views.adapters.ShibeAdapter.ShibeViewHolder
import com.squareup.picasso.Picasso
import java.util.zip.Inflater

class ShibeAdapter(private val shibeURLs: List<String>) : RecyclerView.Adapter<ShibeViewHolder>() {
    private var context: Context? = null
    private lateinit var binding: ShibeItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShibeViewHolder {
        binding = ShibeItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)

        return ShibeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShibeViewHolder, position: Int) {
        val imageString = shibeURLs[position]
        val imagePosition = position.toString()

        holder.bindItem(imageString, imagePosition)
    }

    override fun getItemCount(): Int {
        return shibeURLs.size
    }

    inner class ShibeViewHolder(binding: ShibeItemBinding) : ViewHolder(binding.root), View.OnClickListener {
        override fun onClick(view: View) {
            Toast.makeText(context, view.tag.toString(), Toast.LENGTH_SHORT).show()
            Log.e("POSITION OF IMAGE", view.tag.toString())

            binding.rvShibeImage.setOnClickListener(this)
        }

        fun bindItem(image: String, position: String) {
            binding.rvShibeImage.tag = "Image position in array was :$position"
            Picasso.get()
                    .load(image)
                    .fit()
                    .into(binding.rvShibeImage)
        }
    }
}