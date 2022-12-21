package com.bassem.shoestoreapp.screens

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginStart
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.bassem.shoestoreapp.R
import com.bassem.shoestoreapp.databinding.FragmentShoesListBinding
import com.bassem.shoestoreapp.models.Shoe
import com.bassem.shoestoreapp.viewmodels.ShoeViewModel
import android.view.View as View1

class ShoesListFragment : Fragment() {
    private lateinit var shoeViewModel: ShoeViewModel

    private lateinit var shoesListBinding: FragmentShoesListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View1? {


        shoesListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes_list, container, false
        )

        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        shoesListBinding.addShoeItemFloatingActionButton.setOnClickListener { v: View1 ->
            v.findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailsFragment())
        }
        setHasOptionsMenu(true)

        shoeViewModel.shoeItemsList.observe(viewLifecycleOwner) {
            Toast.makeText(this.context, it[0].name, Toast.LENGTH_LONG).show()

            Log.e("List item Size", "" + shoeViewModel.shoeItemsList.value!!.size)
            populateShoeData(shoeViewModel.shoeItemsList.value!!)
        }
        return shoesListBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.store_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
                return true
            }
        }
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    //populate shoes list item views
    private fun populateShoeData(shoesList: ArrayList<Shoe>) {

        for (shoe in shoesList) {
            val inflater = LayoutInflater.from(this.context).inflate(R.layout.item_shoe_row, null)
            inflater.findViewById<TextView>(R.id.shoe_name_textView).text = shoe.name
            inflater.findViewById<TextView>(R.id.size_text).text = shoe.shoeSize
            inflater.findViewById<TextView>(R.id.company_name_text).text = shoe.companyName
            inflater.findViewById<TextView>(R.id.description_text).text = shoe.description
            inflater.findViewById<ImageView>(R.id.shoe_image).setImageResource(shoe.image)


            shoesListBinding.shoeListContainer.addView(inflater, shoesListBinding.shoeListContainer.childCount)

            var lay:LinearLayout.LayoutParams= inflater.layoutParams as LinearLayout.LayoutParams
            lay.setMargins(10,10,10,10)
            inflater.layoutParams = lay

        }
    }
}