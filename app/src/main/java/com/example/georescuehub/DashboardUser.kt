package com.example.georescuehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.georescuehub.databinding.ActivityDashboardUserBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardUser : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardUserBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, MainScreen::class.java))
            finish()
        }
        replaceFragment(HomeFragment())
        binding.navBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.directory -> {
                    replaceFragment(DirectoryFragment())
                    true
                }
                R.id.maps -> {
                    replaceFragment(MapsFragment())
                    true
                }
                R.id.Guide -> {
                    replaceFragment(GuideFragment())
                    true
                }
                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

        private fun checkUser() {
            val firebaseUser = firebaseAuth.currentUser
            if (firebaseUser == null) {
                // Not logged in, go to the main screen
                binding.subTitleTv.text = "Not Logged In"
            } else {
                // Logged in, get and show user info
                val email = firebaseUser.email
                // Set to the TextView in the toolbar
                binding.subTitleTv.text = email
            }
        }
}

