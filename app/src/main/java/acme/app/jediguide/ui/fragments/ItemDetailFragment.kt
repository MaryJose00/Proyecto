package acme.app.jediguide.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import acme.app.jediguide.R
import acme.app.jediguide.databinding.FragmentHomeBinding
import acme.app.jediguide.databinding.FragmentItemDetailBinding
import acme.app.jediguide.model.entities.StarWarsItemModel
import acme.app.jediguide.model.usercase.StarWarsItemsUserCase
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ItemDetailFragment : Fragment() {

    private lateinit var binding: FragmentItemDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }

    private fun initFragment() {
        if(arguments != null) {
            val url = requireArguments().getString("baseUrl") ?: ""
            lifecycleScope.launch(Dispatchers.Main) {
                val item: StarWarsItemModel = withContext(Dispatchers.IO) {
                    StarWarsItemsUserCase().getFullAnimeItem(url)
                }
                binding.tvTitle.text = item.name
            }
        }
    }


}