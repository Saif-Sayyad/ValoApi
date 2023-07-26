import PlayerCards.PlayerCards
import ValoAgents.ValoAgents
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface Interface {
    @GET("agents")
    suspend fun AgentsInterface(): Call<List<ValoAgents>>
    @GET("playercards")
    suspend fun CardsInterface(): Call<List<PlayerCards>>
}

object APIService{
    val api: Interface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://valorant-api.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Interface::class.java)
    }
}