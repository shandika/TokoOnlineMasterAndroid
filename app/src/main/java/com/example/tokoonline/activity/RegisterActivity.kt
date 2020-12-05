package com.example.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tokoonline.MainActivity
import com.example.tokoonline.R
import com.example.tokoonline.app.ApiConfig
import com.example.tokoonline.helper.SharedPref
import com.example.tokoonline.model.ResponModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.edt_email
import kotlinx.android.synthetic.main.activity_register.edt_password
import kotlinx.android.synthetic.main.activity_register.pb
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        s = SharedPref(this)

        btn_register.setOnClickListener {
            register()
        }

        btn_google.setOnClickListener {
            dataDummy()
        }

    }

    fun dataDummy() {
        edt_nama.setText("Shandika")
        edt_email.setText("shandika@gmail.com")
        edt_phone.setText("018029839021")
        edt_password.setText("tifrp16c")
    }

    fun register(){
        if (edt_nama.text.isEmpty()){
            edt_nama.error = "Kolom nama tidak boleh kosong"
            edt_nama.requestFocus()
            return
        } else if (edt_email.text.isEmpty()){
            edt_email.error = "Kolom email tidak boleh kosong"
            edt_email.requestFocus()
            return
        } else if (edt_phone.text.isEmpty()){
            edt_phone.error = "Kolom nomor telepon tidak boleh kosong"
            edt_phone.requestFocus()
            return
        } else if (edt_password.text.isEmpty()){
            edt_password.error = "Kolom password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }

        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(), edt_email.text.toString(), edt_phone.text.toString(), edt_password.text.toString()).enqueue(object : Callback<ResponModel>{

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@RegisterActivity, "Error:" + t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                pb.visibility = View.VISIBLE
                val respon = response.body()!!
                if (respon.success == 1) {
                    s.setStatusLogin(true)
                    s.setUser(respon.user)
                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@RegisterActivity, "Selamat datang " + respon.user.name, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@RegisterActivity, "Error:" + respon.message, Toast.LENGTH_SHORT).show()
                }
            }

        })

    }

}