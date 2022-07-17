package ramizbek.aliyev.networkingvolley

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.RequestTask
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import ramizbek.aliyev.networkingvolley.databinding.ActivityMainBinding
import ramizbek.aliyev.networkingvolley.utils.MyNetworkHelper

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myNetworkHelper: MyNetworkHelper
    private lateinit var requestQueue: RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myNetworkHelper = MyNetworkHelper(this)
        requestQueue = Volley.newRequestQueue(this)

//        loadImage(binding.imageView, "https://i.imgur.com/Nwk25LA.jpg")
//        loadObject()
    }

    //class olib kelish
    fun loadObject() {
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            "http://ip.jsontest.com",
            null,
            {
                //class olib kelish
                val strring = it?.getString("ip")
                binding.tvInfo.text = strring
            },
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        )
        requestQueue.add(jsonObjectRequest)
    }

    // Like piccaso but original / image olib kelish
    fun loadImage(imageView: ImageView, url: String) {
        val imageRequest = ImageRequest(
            url,
            /** Called when a response is received.  */
            {
                imageView.setImageBitmap(it)
            },
            0, 0, ImageView.ScaleType.CENTER_CROP,
            Bitmap.Config.ARGB_8888
        ) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

        }
        requestQueue.add(imageRequest)
    }
}