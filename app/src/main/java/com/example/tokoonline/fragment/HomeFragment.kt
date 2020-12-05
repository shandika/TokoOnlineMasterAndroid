package com.example.tokoonline.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.tokoonline.R
import com.example.tokoonline.adapter.AdapterProduk
import com.example.tokoonline.adapter.AdapterSlider
import com.example.tokoonline.model.Produk

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var vpSlider: ViewPager
    lateinit var rvProduk:RecyclerView
    lateinit var rvProdukTerlaris:RecyclerView
    lateinit var rvProdukElektronik:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvProdukTerlaris = view.findViewById(R.id.rv_produk_terlaris)
        rvProdukElektronik = view.findViewById(R.id.rv_produk_elektronik)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpSlider.adapter = adapterSlider

//        View 1
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

//        View 2
        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        rvProdukTerlaris.adapter = AdapterProduk(arrProdukTerlaris)
        rvProdukTerlaris.layoutManager = layoutManager2

//        View 3
        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvProdukElektronik.adapter = AdapterProduk(arrProdukElektronik)
        rvProdukElektronik.layoutManager = layoutManager3

        return view
    }

    val arrProduk: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()

        val p1 = Produk()
        p1.nama = "HP 14"
        p1.harga = "Rp. 5.000.000"
        p1.gambar = R.drawable.hp_14_bs749tu

        val p2 = Produk()
        p2.nama = "HP Envy 13"
        p2.harga = "Rp. 6.000.000"
        p2.gambar = R.drawable.hp_envy_13_aq0019tx

        val p3 = Produk()
        p3.nama = "HP Pavilion 13"
        p3.harga = "Rp. 7.000.000"
        p3.gambar = R.drawable.hp_pavilion_13_an0006na

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrProdukTerlaris: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()

        val p1 = Produk()
        p1.nama = "HP Pavilion 15"
        p1.harga = "Rp. 5.000.000"
        p1.gambar = R.drawable.hp_pavilion_15_cx0056wm

        val p2 = Produk()
        p2.nama = "HP Notebook 14"
        p2.harga = "Rp. 6.000.000"
        p2.gambar = R.drawable.hp_notebook_14_bs710tu

        val p3 = Produk()
        p3.nama = "HP Pavilion 13"
        p3.harga = "Rp. 7.000.000"
        p3.gambar = R.drawable.hp_pavilion_13_an0006na

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }

    val arrProdukElektronik: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()

        val p1 = Produk()
        p1.nama = "HP Notebook 14"
        p1.harga = "Rp. 5.000.000"
        p1.gambar = R.drawable.hp_notebook_14_bs709tu

        val p2 = Produk()
        p2.nama = "HP Pavilion 14"
        p2.harga = "Rp. 6.000.000"
        p2.gambar = R.drawable.hp_pavilion_14_ce1507sa

        val p3 = Produk()
        p3.nama = "HP Pavilion 13"
        p3.harga = "Rp. 7.000.000"
        p3.gambar = R.drawable.hp_pavilion_13_an0006na

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }


}