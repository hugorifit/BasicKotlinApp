package com.ifit.basickotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.ifit.basickotlinapp.adapter.PersonAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class MainActivity : AppCompatActivity() {


    //var data = listOf("1", "2", "2")


    fun initRecyclerView(){
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewId)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        recyclerView.adapter =  PersonAdapter(PersonProvider.data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()



        /* Creates an instance of the UserService using a simple Retrofit builder using Moshi
 * as a JSON converter, this will append the endpoints set on the UserService interface
 * (for example '/api', '/api?results=2') with the base URL set here, resulting on the
 * full URL that will be called: 'https://randomuser.me/api' */
        val service = Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(UserService::class.java)

        /* Calls the endpoint set on getUsers (/api) from UserService using enqueue method
 * that creates a new worker thread to make the HTTP call */
        service.getUsers().enqueue(object : Callback<UserResponse> {

            /* The HTTP call failed. This method is run on the main thread */
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG_", "An error happened!")
                t.printStackTrace()
            }

            /* The HTTP call was successful, we should still check status code and response body
             * on a production app. This method is run on the main thread */
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                /* This will print the response of the network call to the Logcat */
                Log.d("TAG_", response.body().toString())
            }
        })

    }
}



/* Kotlin data/model classes that map the JSON response, we could also add Moshi
 * annotations to help the compiler with the mappings on a production app */
data class UserResponse(val results: List<User>)
data class User(val email: String, val phone: String)

/* Retrofit service that maps the different endpoints on the API, you'd create one
 * method per endpoint, and use the @Path, @Query and other annotations to customize
 * these at runtime */
interface UserService {
    @GET("/api")
    fun getUsers(): Call<UserResponse>
}
