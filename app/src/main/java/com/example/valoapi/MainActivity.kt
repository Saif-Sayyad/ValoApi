package com.example.valoapi

import ValoAgents.ValoAgents
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valoapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getValoAgents()
    }

    private fun getValoAgents() {
        val valoAgents = APIService.api.AgentsInterface()
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        valoAgents.enqueue(object : Callback<ValoAgents>{
            override fun onFailure(call: Call<ValoAgents>, t: Throwable) {
                Log.d("VALORANT","Error in Fetching List",t)
            }

            override fun onResponse(
                call: Call<ValoAgents>,
                response: Response<ValoAgents>
            ) {
                    if(response.isSuccessful) {
                        recyclerview.apply{
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = response.body()?.let { ValoAdapter(it) }
                        }
                    }
            }
        })
    }
}


