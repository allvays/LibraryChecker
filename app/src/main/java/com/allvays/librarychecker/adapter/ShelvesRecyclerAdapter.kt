package com.allvays.librarychecker.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.allvays.librarychecker.FRAGMENT_ID_TAG
import com.allvays.librarychecker.ID_TAG
import com.allvays.librarychecker.R
import com.allvays.librarychecker.databinding.ItemShelfCardViewBinding
import com.allvays.librarychecker.model.Shelf
import com.allvays.librarychecker.ui.shelves.ShelvesFragment
import java.lang.Exception


//const val FRAGMENT_TAG :String = "fragment"

class ShelvesRecyclerAdapter(private val fragment: ShelvesFragment) :
    RecyclerView.Adapter<ShelvesViewHolder>() {
    var shelvesList: MutableList<Shelf> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShelvesViewHolder {
        val itemShelfCardViewBinding: ItemShelfCardViewBinding = ItemShelfCardViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ShelvesViewHolder(itemShelfCardViewBinding,fragment)
    }

    override fun getItemCount(): Int = shelvesList.size


    override fun onBindViewHolder(holder: ShelvesViewHolder, position: Int) {
        holder.bind(shelvesList[position])
    }

    fun setData(shelvesList: MutableList<Shelf>){
        this.shelvesList = shelvesList
        notifyDataSetChanged()
    }
}

class ShelvesViewHolder(private val binding: ItemShelfCardViewBinding, private val fragment: ShelvesFragment) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(shelf: Shelf) {
        with(binding) {
            shelf.name?.let {
                shelfTitle.text = it
                shelfTitle.visibility = View.VISIBLE
            }
            if (shelf.bookList.isNotEmpty()) {
                try {
                    bookCover0.setImageResource(shelf.bookList[0].cover)
                    bookCover1.setImageResource(shelf.bookList[1].cover)
                    bookCover2.setImageResource(shelf.bookList[2].cover)
                    bookCover3.setImageResource(shelf.bookList[3].cover)
                    bookCover4.setImageResource(shelf.bookList[4].cover)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Log.d("HEREIAM",e.printStackTrace().toString())
                }

            }
        }


        binding.shelfCardView.setOnClickListener {
            val bundle = bundleOf(
                ID_TAG to shelf.id,
                FRAGMENT_ID_TAG to fragment.id
            )
            //val fragment = parent.context
            NavHostFragment.findNavController(fragment).navigate(R.id.action_nav_home_to_booksOnShelfFragment,bundle)
        }
    }

}