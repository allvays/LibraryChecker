package com.allvays.librarychecker.ui.books

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.allvays.librarychecker.ID_TAG
import com.allvays.librarychecker.MainActivity
import com.allvays.librarychecker.R
import com.allvays.librarychecker.adapter.BooksCreativePagerAdapter
import com.allvays.librarychecker.adapter.BooksRecyclerAdapter
import com.allvays.librarychecker.databinding.FragmentBooksOnShelfBinding
import com.allvays.librarychecker.model.Shelf
import com.allvays.librarychecker.ui.shelves.ShelvesViewModel
import java.util.*

class BooksOnShelfFragment : Fragment() {
    private lateinit var binding: FragmentBooksOnShelfBinding
    private lateinit var shelfViewModel: ShelvesViewModel
    private lateinit var booksOnShelfViewModel: BooksOnShelfViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBooksOnShelfBinding.inflate(layoutInflater)
        activity?.let {
            booksOnShelfViewModel = ViewModelProviders.of(it).get(BooksOnShelfViewModel::class.java)
            shelfViewModel = ViewModelProviders.of(it).get(ShelvesViewModel::class.java)
            (it as MainActivity).binding.appBarMain.fab.setImageResource(R.drawable.ic_own_book_add)
        }


        /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            setCreativePager()
        else
            setRecycler()*/

        setRecycler()

        return binding.root
    }

    private fun setCreativePager() {
        booksOnShelfViewModel.list.observe(viewLifecycleOwner, Observer {
            binding.creativeViewPager.setCreativeViewPagerAdapter(
                BooksCreativePagerAdapter(
                    requireContext(),
                    it
                )
            )
        })
    }


    private fun setRecycler() {
        shelfViewModel.shelvesList.observe(viewLifecycleOwner, Observer {
            val adapter = BooksRecyclerAdapter()
            val shelf = it.find { shelf ->
                shelf.id == arguments?.get(ID_TAG) as UUID
            }
            shelf?.let {
                adapter.bookList = shelf.bookList
                adapter.notifyDataSetChanged()
                binding.booksRecycler.adapter = adapter
                binding.booksRecycler.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.booksRecycler.visibility = View.VISIBLE
            }
            
        })
    }

}