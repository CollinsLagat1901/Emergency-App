package com.example.georescuehub

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Import your generated binding class
import com.example.georescuehub.databinding.FragmentDirectoryBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DirectoryFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentDirectoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDirectoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize RecyclerView and items here
        val recyclerView: RecyclerView = binding.bookRV
        val items: MutableList<Item> = mutableListOf()
        items.add(Item("Kenya", +254, R.drawable.kenya))
        items.add(Item("Police", 911, R.drawable.woman))
        items.add(Item("Ambulance", 911, R.drawable.nurse))
        items.add(Item("Fire Station", 114, R.drawable.firefighter))
        items.add(Item("Vet", 265, R.drawable.veterinary))
        items.add(Item("Hospital", 113, R.drawable.doctor))
        items.add(Item("Car Service", 25472320, R.drawable.mechanic))
        items.add(Item("Contact1", 71252364, R.drawable.man))
        items.add(Item("Contact2", 79465456, R.drawable.man2))
        items.add(Item("Contact3", 75465456, R.drawable.man3))
        items.add(Item("Contact4", 75465456, R.drawable.man4))
        items.add(Item("Contact5", 73335456, R.drawable.man5))
        items.add(Item("Contact6", 72255456, R.drawable.man9))


        // You can now use recyclerView and items as needed
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MyAdpter(requireContext(), items)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DirectoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
