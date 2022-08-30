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
import acme.app.jediguide.ui.activities.MainActivity
import acme.app.jediguide.utils.HandlerFragments
import android.annotation.SuppressLint
import android.content.Context.INPUT_METHOD_SERVICE
import android.inputmethodservice.InputMethodService
import android.view.inputmethod.InputMethodManager
import androidx.annotation.MainThread
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.lifecycleScope
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class SearchFragment(val handlerFragment: HandlerFragments) : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentSearchBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        binding.search.setOnQueryTextListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
    }

    private fun initFragment() {
    }

   override fun onQueryTextSubmit(query: String?): Boolean {
        if(!query.isNullOrEmpty()) {
            searchByName(query)
        }
        return true

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val bundle = Bundle()
            val url = query
            bundle.putString("baseUrl",url)
            val listBundle: List<Bundle> = listOf(bundle)
            handlerFragment.replaceFragment(ItemDetailFragment(), R.id.fragment_search, listBundle, "back")
        }
    }



}