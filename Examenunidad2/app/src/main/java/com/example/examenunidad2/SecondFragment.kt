package com.example.examenunidad2

import android.accessibilityservice.GestureDescription
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_second.*


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        view.findViewById<Button>(R.id.btnRegistrar).setOnClickListener {
            val toast = Toast.makeText(this.context, "Registrado", Toast.LENGTH_LONG).show()
            Snackbar.make(
                root_layout, // Parent view
                "Bienvenido al TECMX!", // Message to show
                Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()

            val builder = AlertDialog.Builder(this.context)
            builder.setTitle("Bienvenido")
            builder.setMessage("Decidiras tu especialidad desde septimo semestre")
            builder.setPositiveButton("Aceptar", null)
            builder.show()
        }


    }



}

