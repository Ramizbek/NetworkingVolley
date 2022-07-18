package ramizbek.aliyev.networkingvolley.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ramizbek.aliyev.networkingvolley.databinding.ItemRvBinding
import ramizbek.aliyev.networkingvolley.models.User

class RvAdapter(var list: ArrayList<User>) :
    RecyclerView.Adapter<RvAdapter.VH>() {

    inner class VH(var itemRV: ItemRvBinding) : RecyclerView.ViewHolder(itemRV.root) {
        fun onBind(user: User) {
            itemRV.tvName.text = user.login
            itemRV.tvCode.text = user.id.toString()
            Picasso.get().load(user.avatar_url).into(itemRV.tvLocation)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
//    interface RVClickCourses {
//        fun onClick(user: User) https://api.github .com/users
//
//    }
}