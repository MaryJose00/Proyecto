package acme.app.jediguide.ui.adapters

import acme.app.jediguide.R
import acme.app.jediguide.data.entities.database.StarWarsItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StarWarsItemAdapter(private val itemClick: (item: StarWarsItem) -> Unit) :  RecyclerView.Adapter<StarWarsViewHolder>() {

    var dataList: List<StarWarsItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return StarWarsViewHolder(layoutInflater.inflate(R.layout.vh_items,parent, false))
    }

    override fun onBindViewHolder(holder: StarWarsViewHolder, position: Int) {
        val item = dataList[position]
        holder.render(item, itemClick)
    }

    override fun getItemCount(): Int = dataList.size
}