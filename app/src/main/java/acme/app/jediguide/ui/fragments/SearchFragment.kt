package acme.app.jediguide.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acme.app.jediguide.R
import acme.app.jediguide.databinding.FragmentItemDetailBinding
import acme.app.jediguide.databinding.FragmentSearchBinding
import acme.app.jediguide.model.entities.StarWarsItemModel
import acme.app.jediguide.model.usercase.StarWarsItemsUserCase
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class SearchFragment : Fragment() , SearchView.OnQueryTextListener{

    private lateinit var binding: FragmentSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        //binding.search.setOnQueryTextListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initFragment()
    }

    private fun initFragment() {
/*

        if(arguments != null) {
            val url = requireArguments().getString("baseUrl") ?: ""
            lifecycleScope.launch(Dispatchers.Main) {
                val item: StarWarsItemModel = withContext(Dispatchers.IO) {
                    StarWarsItemsUserCase().getFullAnimeItem()
                }
                binding.tvTitle.text = item.name
                Picasso.get().load(item.url).into(binding.ivPersonaje)
                binding.tvGender.text = item.gender
                binding.tvAltura.text = item.height
                binding.tvCumpleaOs.text = item.birth_year
            }
        }*/
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()) {
            //searchByName(query.lowercase())
        }
        return true

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

    /*
    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<DogsResponse> = getRetrofit().create(ApiService::class.java).getDogsByBreeds("$query/images")
            val puppies = call.body()
            runOnUiThread() {
                if(call.isSuccessful) {
                    //show recycle view
                    val images = puppies?.images?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    //show error

                }
            }
        }

    }*/

}