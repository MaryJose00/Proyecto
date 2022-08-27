package acme.app.jediguide.ui.activities


import acme.app.jediguide.R
import acme.app.jediguide.databinding.ActivityMainBinding
import acme.app.jediguide.ui.fragments.CategoriesFragment
import acme.app.jediguide.ui.fragments.HomeFragment
import acme.app.jediguide.ui.fragments.ProfileFragment
import acme.app.jediguide.ui.fragments.SearchFragment
import acme.app.jediguide.utils.HandlerFragments
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    /* viewBinding*/
    private lateinit var binding: ActivityMainBinding

    /* Manager Fragment */
    private val fragment = HandlerFragments(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnMenu.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    initActivity()
                    true
                }
                R.id.search -> {
                    fragment.replaceFragment(
                        SearchFragment(),
                        binding.fragmentContent.id,
                        null,
                        null
                    )
                    true
                }
                R.id.categories -> {
                    fragment.replaceFragment(
                        CategoriesFragment(),
                        binding.fragmentContent.id,
                        null,
                        null
                    )
                    true
                }
                R.id.profile -> {
                    fragment.replaceFragment(
                        ProfileFragment(),
                        binding.fragmentContent.id,
                        null,
                        null
                    )
                    true
                }
                else -> false
            }
        }
        initActivity()
    }

    private fun initActivity() {
        fragment.replaceFragment(HomeFragment(fragment), binding.fragmentContent.id, null, null)
    }

}