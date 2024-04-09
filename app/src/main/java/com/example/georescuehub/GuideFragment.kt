package com.example.georescuehub

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.georescuehub.databinding.FragmentGuideBinding

class GuideFragment : Fragment() {
    private lateinit var binding: FragmentGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using data binding
        binding = FragmentGuideBinding.inflate(inflater, container, false)

        // Set click listeners for buttons
        binding.commonBtn.setOnClickListener {
            val intent = Intent(requireActivity(), CommonActivity::class.java)
            startActivity(intent)
        }
        binding.fireBtn.setOnClickListener {
            val intent = Intent(requireActivity(), FireStation::class.java)
            startActivity(intent)
        }


        binding.policeBtn.setOnClickListener {
            val intent = Intent(requireActivity(), PoliceActivity::class.java)
            startActivity(intent)
        }

        // Return the root view
        return binding.root
    }
}
