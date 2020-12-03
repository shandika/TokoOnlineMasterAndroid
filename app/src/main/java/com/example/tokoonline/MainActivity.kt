package com.example.tokoonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.tokoonline.fragment.AkunFragment
import com.example.tokoonline.fragment.HomeFragment
import com.example.tokoonline.fragment.KeranjangFragment

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment()
    val fragmentAkun: Fragment = AkunFragment()
    val fragmentKeranjang: Fragment = KeranjangFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).show(fragmentAkun).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).show(fragmentKeranjang).commit()
    }
}