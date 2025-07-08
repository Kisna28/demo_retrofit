package com.example.demo_retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo_retrofit.adapter.UserAdapter
import com.example.demo_retrofit.databinding.ActivityMainBinding
import com.example.demo_retrofit.model.User
import com.example.demo_retrofit.model.UserResponse
import com.example.demo_retrofit.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
     private lateinit var binding: ActivityMainBinding
     private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = UserAdapter(userList)
        binding.userRecyclerView.layoutManager = LinearLayoutManager(this)
      fetchUsers()
    }

    private fun fetchUsers() {
        val call = RetrofitInstance.api.getUsers()
        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        userList.addAll(it.users)
                        binding.userRecyclerView.adapter = UserAdapter(userList)
                    }
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error fetching users", Toast.LENGTH_SHORT).show()
            }
        })
    }
}