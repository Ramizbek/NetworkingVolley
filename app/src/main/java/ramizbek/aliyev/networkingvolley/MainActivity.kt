package ramizbek.aliyev.networkingvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ramizbek.aliyev.networkingvolley.databinding.ActivityMainBinding
import ramizbek.aliyev.networkingvolley.utils.isNetworkConnected

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isNetworkConnected(this)){
            binding.tvInfo.text = "Connected"
        }else{
            binding.tvInfo.text = "Disconnected"

        }
    }
}  