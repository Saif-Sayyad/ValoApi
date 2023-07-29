package com.example.valoapi

import ValoAgents.ValoAgents
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.valoapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getValoAgents()
    }

    private fun getValoAgents() {
        val valoAgents = APIService.api.AgentsInterface()
        valoAgents.enqueue(object : Callback<ValoAgents>{
            override fun onFailure(call: Call<ValoAgents>, t: Throwable) {
                Log.d("VALORANT","Error in Fetching List",t)
            }

            override fun onResponse(
                call: Call<ValoAgents>,
                response: Response<ValoAgents>
            ) {
                val valoAgents = response.body()
                if(valoAgents!=null){
                  Log.d("VALORANT",valoAgents.toString())
//                    if(response.isSuccessful) {
//                        val res = response.body()
//                        binding.recyclerview.adapter = res?.let { ValoAdapter(it) }
//                    }

                }
            }
        })
    }
}
