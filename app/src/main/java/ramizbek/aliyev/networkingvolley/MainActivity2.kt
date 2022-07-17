package ramizbek.aliyev.networkingvolley

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyLog
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ramizbek.aliyev.networkingvolley.adapter.RvAdapter
import ramizbek.aliyev.networkingvolley.databinding.ActivityMain2Binding
import ramizbek.aliyev.networkingvolley.models.User

class MainActivity2 : AppCompatActivity() {
    private  val TAG = "MainActivity2"
    private lateinit var binding: ActivityMain2Binding
    private lateinit var  userAdapter: RvAdapter
    private lateinit var requestQueue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        requestQueue = Volley.newRequestQueue(this)
        loadList()

    }

    fun loadList(){
        VolleyLog.DEBUG = true //qanday ma'lumot kelayotganini Logda ko'rsatib turadi

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            "https://api.github.com/users",
            null,
            {
            val type = object  :TypeToken<ArrayList<User>>(){}.type
                val list  = Gson().fromJson<ArrayList<User>>(it.toString(), type)
                userAdapter = RvAdapter(list)
                binding.rv.adapter = userAdapter
            },
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(jsonArrayRequest)
    }
    
}