package com.example.isrmensualarrendamiento

import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.room.Room
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*
import java.io.File


class MainActivity : AppCompatActivity() {
    var llamar: String = ""

    private val calculoViewModel: CalculoViewModel by viewModels{
        CalculoViewModelFactory(
            CalculoRepository(
                CalculosDataBase.getDataBase(this).calculosDao()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.ayuda -> consume {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("geo:27.4418732,-99.5170302,19(Mexico)")
                )
                intent.setClassName(
                    "com.google.android.apps.maps",
                    "com.google.android.maps.MapsActivity"
                )
                startActivity(intent)
            }

            R.id.llamar -> consume {
                if(llamar == "")
                {
                    lbResultado.text = "No hay contacto escrito"
                }
                else
                {
                    val callIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + llamar))
                    startActivity(callIntent)
                }

            }


            else -> super.onOptionsItemSelected(item)
        }
    }

    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }

    fun UltimoCalculo(view: View) {
        try {
            val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
            val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

            val fileToRead = "Ultimo_calculo.txt"
            if(swExterno.isChecked)
            {
                var encryptedFile = EncryptedFile.Builder(File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileToRead), this, masterKeyAlias, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build()
                val contents = encryptedFile.openFileInput().bufferedReader().useLines { lines ->
                    lines.fold("") { working, line ->
                        "$working\n$line"
                    }
                }
                lbResultado.text = contents
            }
            else
            {
                var encryptedFile = EncryptedFile.Builder(File(filesDir, fileToRead), this, masterKeyAlias, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build()

                val contents = encryptedFile.openFileInput().bufferedReader().useLines { lines ->
                    lines.fold("") { working, line ->
                        "$working\n$line"
                    }
                }
                lbResultado.text = contents
            }
        }
        catch (x: Exception)
        {
            lbResultado.text = "No hay calculo previo"
        }
    }

    fun Calculo(view: View) {
        var Cantidad1 = txtSubTotal.text.toString()
        var Cantidad2 = Cantidad1.toDouble()
        var Resultado = Calcular(Cantidad2)
    }

    fun Calcular(cantidad: Double)
    {
        var A: Double
        var B: Double
        var C: Double
        C = 0.00
        if(cantidad in 0.01..578.52)
        {
            A = cantidad - 0.01
            B = A * 1.92
            C = B + 0
        }
        else if(cantidad in 578.53..4910.18)
        {
            A = cantidad - 578.53
            B = A * 6.40
            C = B + 11.11
        }
        else if(cantidad in 4910.19..8629.20)
        {
            A = cantidad - 4910.19
            B = A * 10.88
            C = B + 288.33
        }
        else if(cantidad in 8629.21..10031.07)
        {
            A = cantidad - 8629.21
            B = A * 16.00
            C = B + 692.96
        }
        else if(cantidad in 10031.08..12009.94)
        {
            A = cantidad - 10031.08
            B = A * 17.92
            C = B + 917.26
        }
        else if(cantidad in 12009.95..24222.31)
        {
            A = cantidad - 12009.95
            B = A * 21.36
            C = B + 1271.87
        }
        else if(cantidad in 24222.32..38177.69)
        {
            A = cantidad - 24222.32
            B = A * 23.52
            C = B + 3880.44
        }
        else if(cantidad in 38177.70..72887.50)
        {
            A = cantidad - 38177.70
            B = A * 30.00
            C = B + 7162.74
        }
        else if(cantidad in 72887.51..97183.33)
        {
            A = cantidad - 72887.51
            B = A * 32.00
            C = B + 17575.69
        }
        else if(cantidad in 97183.34..291550.00)
        {
            A = cantidad - 97183.34
            B = A * 34.00
            C = B + 25350.35
        }
        else if(cantidad >= 291550.01)
        {
            A = cantidad - 291550.01
            B = A * 35.00
            C = B + 91435.02
        }

        //var Calculo = CalculosRealizados(txtNombre.text.toString(),txtNombre.text.toString(),txtSubTotal.text.toString().toDouble(),C)
        //calculoViewModel.guardarCalculos(Calculo)

        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

        val fileToWrite = "Ultimo_calculo.txt"

        if(swExterno.isChecked)
        {
            var encryptedFile = EncryptedFile.Builder(File(this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileToWrite), this, masterKeyAlias, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build()
            encryptedFile.openFileOutput().bufferedWriter().use { writer ->
                writer.write(txtNombre.text.toString() + "\n Subtotal: " + txtSubTotal.text.toString() + "\n ISR a pagar: "+ C)
            }
        }
        else
        {
            var encryptedFile = EncryptedFile.Builder(File(filesDir, fileToWrite), this, masterKeyAlias, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB).build()
            encryptedFile.openFileOutput().bufferedWriter().use { writer ->
                writer.write(txtNombre.text.toString() + "\n Subtotal: " + txtSubTotal.text.toString() + "\n ISR a pagar: "+ C)
            }
        }
        lbResultado.text = "ISR a pagar: " + C

    }

    fun Contactos(view: View) {
        var projection = arrayOf(
            ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        var c: Cursor
        var sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC"
        var selectionClause = ContactsContract.Data.MIMETYPE + "='" + ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND " + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL"

        c = contentResolver.query(
            ContactsContract.Data.CONTENT_URI,
            projection,
            selectionClause,
            null,
            sortOrder)!!

        while (c.moveToNext())
        {
            if(c.getString(0) == txtNombre.text.toString())
            {
                lbResultado.append("\n Nombre: " + c.getString(0) + " Numero: " + c.getString(1))
                llamar = c.getString(1)
            }
        }
    }
}
