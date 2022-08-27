package acme.app.jediguide.ui.fragments

import acme.app.jediguide.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acme.app.jediguide.data.entities.database.StarWarsItem
import acme.app.jediguide.databinding.FragmentHomeBinding
import acme.app.jediguide.model.usercase.StarWarsItemsUserCase
import acme.app.jediguide.ui.adapters.StarWarsItemAdapter
import acme.app.jediguide.utils.HandlerFragments
import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.security.Signature

class HomeFragment(val handlerFragment: HandlerFragments) : Fragment() {

    private var page: Int = 1

    private lateinit var binding: FragmentHomeBinding
    private val adapterRv = StarWarsItemAdapter { managedClickItem(it) }



    private fun managedClickItem(item: StarWarsItem) {
        val bundle = Bundle()
        val url = item.url.substring(29, item.url.length - 1)
        bundle.putString("baseUrl",url)
        val listBundle: List<Bundle> = listOf(bundle)
        handlerFragment.replaceFragment(ItemDetailFragment(), R.id.fragment_content,listBundle, "back")


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listRV.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            @SuppressLint("NotifyDataSetChanged")
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    page += 1
                    val listItems: MutableList<StarWarsItem> = adapterRv.dataList as MutableList<StarWarsItem>
                    lifecycleScope.launch(Dispatchers.Main) {
                        val newItems = withContext(Dispatchers.IO) {
                            StarWarsItemsUserCase().getAllAnimeItems(page)
                        }
                        listItems.addAll(newItems)
                        adapterRv.dataList = listItems
                        adapterRv.notifyDataSetChanged()
                    }

                }
            }
        })
        initFragment()
    }

    private fun initFragment() {
        lifecycleScope.launch(Dispatchers.Main) {
            val listItems = withContext(Dispatchers.IO) {
                StarWarsItemsUserCase().getAllAnimeItems(page)
            }
            adapterRv.dataList = listItems
            binding.listRV.layoutManager = LinearLayoutManager(activity?.baseContext,
                LinearLayoutManager.VERTICAL,
                false)
            binding.listRV.adapter = adapterRv


        }
    }

}