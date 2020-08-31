package com.genxmultiplexer.customalertdialog

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var buttonDismiss: Button
    lateinit var buttonOk: Button
    lateinit var textViewMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onBackPressed() {
        val builder: AlertDialog.Builder
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = AlertDialog.Builder(this)
        } else {
            builder = AlertDialog.Builder(this)
        }
        val view = LayoutInflater.from(this).inflate(R.layout.alertdialog_layout, null)
        buttonDismiss = view.findViewById(R.id.buttonDissmisId)
        buttonOk = view.findViewById(R.id.buttonOkId)
        textViewMessage = view.findViewById(R.id.tVmessageId)
        builder.setCancelable(true)
        builder.setView(view)

        val alertDialog: AlertDialog = builder.create()
        alertDialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
        alertDialog.show()

        buttonDismiss.setOnClickListener {
            alertDialog.dismiss()
        }
        buttonOk.setOnClickListener {
            textViewMessage.text = "You are clicked ok"
        }
    }

}