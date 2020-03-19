package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val navigationItemSelectionListner = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when(item.itemId){
            R.id.view1 ->{
                println("Fragment 1 pressed")
                replaceFragment(Fragment1())
                return@OnNavigationItemSelectedListener true

            }
            R.id.view2 ->{
                println("Fragment 2 pressed")
                replaceFragment(Fragment2())
                return@OnNavigationItemSelectedListener true

            }
            R.id.view3 ->{
                println("Fragment 3 pressed")
                replaceFragment(Fragment3())
                return@OnNavigationItemSelectedListener true

            }

        }
        return@OnNavigationItemSelectedListener false

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav.setOnNavigationItemSelectedListener(navigationItemSelectionListner)
    }



    private fun replaceFragment(fragment: Fragment){

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()

    }


}
