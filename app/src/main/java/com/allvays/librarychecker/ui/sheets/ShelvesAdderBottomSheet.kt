package com.allvays.librarychecker.ui.sheets

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.ViewModelProviders
import com.allvays.librarychecker.R
import com.allvays.librarychecker.databinding.FragmentBottomsheetShelfAdderBinding
import com.allvays.librarychecker.model.Shelf
import com.allvays.librarychecker.ui.shelves.ShelvesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import java.util.*

class ShelvesAdderBottomSheet: BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomsheetShelfAdderBinding
    private lateinit var shelvesViewModel: ShelvesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomsheetShelfAdderBinding.inflate(inflater,container,false)
        activity?.let {
            shelvesViewModel =
                ViewModelProviders.of(it).get(ShelvesViewModel::class.java)
        }
        setListeners()
        return binding.root
    }

    private fun setListeners() {
        with(binding){

                nameOfShelfEditText.setOnEditorActionListener { _, actionId, _ ->
                    if (actionId == EditorInfo.IME_ACTION_DONE && nameOfShelfEditText.length()>0){
                        val list = shelvesViewModel.shelvesList.value
                        list?.let {
                            it.add(Shelf(UUID.randomUUID(), nameOfShelfEditText.text.toString(),
                                mutableListOf()))
                            shelvesViewModel.shelvesList.postValue(it)
                        }
                        Snackbar.make(binding.root,"WOW",Snackbar.LENGTH_SHORT).show()
                        dismiss()
                        return@setOnEditorActionListener true
                    }else{
                        Log.d("BottoMSHit","false")
                        return@setOnEditorActionListener false
                    }
                }

            val i = arrayListOf<Int>(2345,25,323,55,134,1345,23767,456,345,7587,79)
            i.min()

        }
    }

    /**
     * Needed to override to set custom style to sheet
     * */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.RoundedBottomSheetDialog)
    }
}