package com.example.usersws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.usersws.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userAdapter= UserAdapter(UserProvider.UserList)
       linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager= linearLayoutManager
            adapter = userAdapter

        }






    }
}
