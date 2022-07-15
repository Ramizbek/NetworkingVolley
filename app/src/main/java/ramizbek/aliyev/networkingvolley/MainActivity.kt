package ramizbek.aliyev.networkingvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ramizbek.aliyev.networkingvolley.databinding.ActivityMainBinding
import ramizbek.aliyev.networkingvolley.utils.MyNetworkHelper
import ramizbek.aliyev.networkingvolley.utils.isNetworkConnected

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myNetworkHelper: MyNetworkHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myNetworkHelper = MyNetworkHelper(this)

//        if(isNetworkConnected(this)){
        if(myNetworkHelper.isNetworkConnected()){
            binding.tvInfo.text = "Connected"
        }else{
            binding.tvInfo.text = "Disconnected"

        }
    }
}