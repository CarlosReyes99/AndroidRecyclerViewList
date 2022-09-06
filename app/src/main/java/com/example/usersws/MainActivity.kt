package com.example.usersws

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.usersws.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime= preferences.getBoolean(getString(R.string.sp_first_time ), true)
        Log.i("Shared preferences","= ${getString(R.string.sp_first_time)} = $isFirstTime"   )
        Log.i("Shared preferences","= ${getString(R.string.sp_username)} = ${preferences.getString(getString(R.string.sp_username), "NA")}"  )

        if(isFirstTime){
            val dialogView= layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_title)
                .setView(dialogView)
                .setPositiveButton(R.string.dialog_confirm) { dialogInterface, i ->
                    val username =
                        dialogView.findViewById<TextInputEditText>(R.id.etUsername).text.toString()
                    Log.i("input edit: ", username)
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }

                }

                .show()
        }



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userAdapter= UserAdapter(UserProvider.UserList, this)
       linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= linearLayoutManager
            adapter = userAdapter

        }






    }

    override fun onClick(user: User) {
        Toast.makeText(this, "Hola, estoy haciendo pruebas "+user.getFullName(), Toast.LENGTH_SHORT).show()
    }
}
