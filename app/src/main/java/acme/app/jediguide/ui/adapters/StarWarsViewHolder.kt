package acme.app.jediguide.ui.adapters

import acme.app.jediguide.data.entities.api.StarWarsItemApi
import acme.app.jediguide.data.entities.database.StarWarsItem
import acme.app.jediguide.databinding.VhItemsBinding
import acme.app.jediguide.model.entities.StarWarsItemModel
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class StarWarsViewHolder(item: View): RecyclerView.ViewHolder(item) {

    private var binding: VhItemsBinding = VhItemsBinding.bind(item)


    fun render(starWarsItem: StarWarsItem, itemClick: (StarWarsItem) -> Unit) {
        Picasso.get().load(starWarsItem.image).into(binding.ivHero)
        binding.tvName.text = starWarsItem.name
        binding.tvRealName.text = starWarsItem.url
        binding.tvPublisher.text = starWarsItem.gender
        itemView.setOnClickListener() {
            itemClick(starWarsItem)
        }
    }
}