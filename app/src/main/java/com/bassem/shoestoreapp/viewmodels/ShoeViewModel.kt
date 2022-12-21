package com.bassem.shoestoreapp.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bassem.shoestoreapp.models.Shoe
import com.bassem.shoestoreapp.utils.SingleLiveEvent
import com.bassem.shoestoreapp.R


/**
 * @author Bassem Mohsen : basem3312@gmail.com on 12/21/2022.
 */
class ShoeViewModel : ViewModel() {
    private val _shoeDataItem = MutableLiveData<Shoe>()
    val shoeDataItem: LiveData<Shoe> get() = _shoeDataItem

    private val _isAddNewShoeItemSuccess = SingleLiveEvent<Boolean>()
    fun getIsLoginSuccess(): SingleLiveEvent<Boolean> {
        return _isAddNewShoeItemSuccess
    }

    private var _shoeItemsList = MutableLiveData<ArrayList<Shoe>>()
    val shoeItemsList: MutableLiveData<ArrayList<Shoe>>
        get() = _shoeItemsList

    init {

        _shoeDataItem.value = Shoe("", "", "", "",0)

        initShoeItemsListData()

    }

    //init shoes list data
    private fun initShoeItemsListData() {
        _shoeItemsList.value = ArrayList()

        var shoe1 = Shoe(
            "Shoe item one", "adidas", "43", "For men",
        R.drawable.img_addidas)
        _shoeItemsList.value?.add(shoe1)

        shoe1 = Shoe(
            "Shoe item Two", "adidas", "43", "For men",
            R.drawable.img_sports)
        _shoeItemsList.value?.add(shoe1)
        shoe1 = Shoe(
            "Shoe item Three", "adidas", "43", "For men",
            R.drawable.ic_shoes_addidas_white
        )

        _shoeItemsList.value?.add(shoe1)
        shoe1 = Shoe(
            "Shoe item Four", "adidas", "43", "For men",
            R.drawable.ic_nike)

        _shoeItemsList.value?.add(shoe1)

        shoe1 = Shoe(
            "Shoe item Five", "adidas", "43", "For men",
            R.drawable.ic_nike_3)

        _shoeItemsList.value?.add(shoe1)

    }

    //click listener to add new shoe item
    fun onAddShoeClicked(v: View) {
        Log.e("Name", _shoeDataItem.value?.name ?: "")
        Log.e("Company Name", _shoeDataItem.value?.companyName ?: "")
        Log.e("Shoes Size", _shoeDataItem.value?.shoeSize ?: "")
        Log.e("Description", _shoeDataItem.value?.description ?: "")
        if (_shoeDataItem.value?.name?.isEmpty() == true
            && _shoeDataItem.value?.companyName?.isEmpty() == true
            && _shoeDataItem.value?.shoeSize?.isEmpty() == true
            && _shoeDataItem.value?.description?.isEmpty() == true

        ) {
            _isAddNewShoeItemSuccess.value = false
        } else {
            _shoeDataItem.value!!.image=R.drawable.ic_girl_shoe
            _shoeItemsList.value?.add(shoeDataItem.value!!)
            _isAddNewShoeItemSuccess.value = true
            _shoeDataItem.value = Shoe("", "", "", "",0)

        }

    }
}