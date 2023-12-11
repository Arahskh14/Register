package com.example.register.kategori

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ScrollView
import androidx.cardview.widget.CardView
import com.example.register.R

class CategorisFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categoris, container, false)
    }
    // Button for starting Kategori1 activity
//    val button1: Button = findViewById(R.id.button1)
//    button1.setOnClickListener {
//        val intent = Intent(this@Categorise, Kategori1::class.java)
//        startActivity(intent)
//    }
//
//    // Button for replacing fragment with MapFragment
//    val button2: Button = findViewById(R.id.button)
//    button2.setOnClickListener {
//        val fragment = MapsFragment()
//
//        // Pass data to the fragment
//        val bundle = Bundle()
//        bundle.putString("address", "JL. Cikarang")
//        bundle.putString("location", "Barat, Bekasi")
//        fragment.arguments = bundle
//
//        // Start the fragment transaction
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.map, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
//
//    // CardViews for handling clicks and opening MapFragment
//    val cardView2: CardView = findViewById(R.id.cardview1)
//    val cardView3: CardView = findViewById(R.id.cardview2)
//
//    cardView2.setOnClickListener { onCardClicked("Hapuna beach", "JL. Cikarang", "Barat, Bekasi") }
//    cardView3.setOnClickListener { onCardClicked("Waimea Bay", "JL. Cikarang", "Barat, Bekasi") }
//}
//
//private fun onCardClicked(name: String, address: String, location: String) {
//    val fragment = MapsFragment()
//
//    // Pass data to the fragment
//    val bundle = Bundle()
//    bundle.putString("name", name)
//    bundle.putString("address", address)
//    bundle.putString("location", location)
//    fragment.arguments = bundle
//
//    // Start the fragment transaction
//    supportFragmentManager.beginTransaction()
//        .replace(R.id.map, fragment)
//        .addToBackStack(null)
//        .commit()
//
//    // Assuming you have a reference to your ScrollView
//    val scrollView = findViewById<ScrollView>(R.id.scrollview)
//
//    // You can programmatically set the layout parameters to enable scrolling
//    val params = scrollView.layoutParams
//    params.height = ViewGroup.LayoutParams.MATCH_PARENT
//    scrollView.layoutParams = params
//}
//
//

}