package com.example.usersws

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.usersws.databinding.ItemUserBinding

class UserAdapter(private val users:List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    private lateinit var context: Context


    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val binding= ItemUserBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Se encarga de indicar qué elemento va a ser "pintado"
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]

        with(holder){
            binding.tvName.text = user.getFullName()
            binding.tvOrder.text = (position+1).toString()

            //carga de imagen
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imgPhoto)


        }

        
    }

    override fun getItemCount(): Int = users.size
}