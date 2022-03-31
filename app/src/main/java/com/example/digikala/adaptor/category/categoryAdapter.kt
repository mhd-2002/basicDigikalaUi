package com.example.digikala.adaptor.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digikala.R
import com.squareup.picasso.Picasso

class CategoryAdapter(var context:Context,var categoryItem:ArrayList<CategoryModel> ):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var ivCategory:AppCompatImageView = itemView.findViewById(R.id.iv_category)
        var tvNAme:AppCompatTextView= itemView.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.category_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = categoryItem[position]
        holder.tvNAme.text=data.categoryName
        Picasso.get().load(data.imageUrl).transform(CircleTransform()).into(holder.ivCategory)

    }

    override fun getItemCount(): Int {
        return categoryItem.size
    }


}