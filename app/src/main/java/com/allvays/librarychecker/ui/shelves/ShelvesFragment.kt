package com.allvays.librarychecker.ui.shelves

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.allvays.librarychecker.MainActivity
import com.allvays.librarychecker.R
import com.allvays.librarychecker.adapter.ShelvesRecyclerAdapter
import com.allvays.librarychecker.databinding.FragmentShelvesBinding
import com.allvays.librarychecker.model.Book
import com.allvays.librarychecker.model.Shelf
import com.allvays.librarychecker.ui.sheets.ShelvesAdderBottomSheet
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.util.*


class ShelvesFragment : Fragment() {

    private lateinit var shelvesViewModel: ShelvesViewModel
    private lateinit var binding: FragmentShelvesBinding

    init {
        lifecycleScope.launch {
            whenStarted {
                shelvesViewModel.shelvesList.postValue(
                    mutableListOf(
                        (Shelf(
                            UUID.randomUUID(), "Shelf title #1", mutableListOf(
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title2",
                                    "Author2",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title3",
                                    "Author3",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title4",
                                    "Author4",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title5",
                                    "Author6",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title6",
                                    "Author7",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title8",
                                    "Author8",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_004
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                ),
                                Book(
                                    "Title1",
                                    "Author1",
                                    resources.getString(R.string.lorem_ipsum),
                                    R.drawable.ic_book,
                                    R.drawable.nature_001
                                )
                            )
                        ))
                    )
                )
                Log.d("SOMINCF", "launch")
                //setRecycler()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.let {
            shelvesViewModel =
                ViewModelProviders.of(it).get(ShelvesViewModel::class.java)
        }
        binding = FragmentShelvesBinding.inflate(layoutInflater, container, false)
        (activity as MainActivity).binding.appBarMain.fab.setImageResource(R.drawable.ic_book)
        binding.progressBar.show()
        setListeners()
        Log.d("SOMINCF", "Before setrec")
        setRecycler()
        Log.d("SOMINCF", "after setrec")
        return binding.root
    }


    private fun setRecycler() {
        shelvesViewModel.shelvesList.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), "observed", Toast.LENGTH_SHORT).show()
            val adapter = ShelvesRecyclerAdapter(this)
            adapter.setData(it)
            binding.shelvesRecycler.adapter = adapter
            binding.shelvesRecycler.layoutManager = LinearLayoutManager(requireContext())
            binding.progressBar.hide()
        })
    }


    private fun setListeners() {
        /*binding.button.setOnClickListener {
            val list = shelvesViewModel.shelvesList.value
            list?.let {
                it.add(
                    Shelf(
                        UUID.randomUUID(), "Second shelf",
                        mutableListOf(
                            Book(
                                "Korova",
                                "Bunin",
                                "sYnOpSiS",
                                R.drawable.ic_book,
                                R.drawable.nature_004
                            )
                        )
                    )
                )

                shelvesViewModel.shelvesList.postValue(it)
            }
        }*/

        activity?.let { activity ->
            (activity as MainActivity).binding.appBarMain.fab.setOnClickListener { view ->
                fragmentManager?.let {
                    ShelvesAdderBottomSheet().show(it,"modal_bottom_sheet")
                }
            }
        }
    }


    override fun onPause() {
        super.onPause()
        activity?.let {
            (it as MainActivity).binding.appBarMain.fab.setOnClickListener(null)
        }
    }
}
