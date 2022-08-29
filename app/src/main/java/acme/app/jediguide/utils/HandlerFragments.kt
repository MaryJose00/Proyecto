package acme.app.jediguide.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class HandlerFragments(val handler: FragmentManager) {

    private val SHIMMER_TAG = "shimmer"

    /*Function gor replace a Fragment */
    fun replaceFragment(
        fragment: Fragment, idFrameLayout: Int,
        args: List<Bundle>?, tag: String?
    ) {
        with(handler.beginTransaction()) {
            /* If data was to send to fragment */
            args?.forEach() { bundle ->
                fragment.arguments = bundle
            }


            if (!tag.isNullOrEmpty()) {
                this.addToBackStack(null)
            }
            /*Replace Fragment*/
            this.replace(idFrameLayout,fragment,tag)
            this.commit()
        }
    }

    fun RemoveFragment(tag: String) {
        val fragment = handler.findFragmentByTag(tag)
        if (fragment != null) {
            handler.beginTransaction().remove(fragment).commit()
        }
    }

}