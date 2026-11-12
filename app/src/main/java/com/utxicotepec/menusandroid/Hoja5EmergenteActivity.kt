package com.utxicotepec.menusandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja5EmergenteActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja5_emergente)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))
        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: Configurar el botón ancla y el menú emergente
        val btnDesplegar = findViewById<Button>(R.id.btnDesplegar)

        btnDesplegar.setOnClickListener { vistaBoton ->
            // Se crea el PopupMenu anclado a 'vistaBoton' para que salga justo debajo de él
            val popup = PopupMenu(this, vistaBoton)
            popup.menuInflater.inflate(R.menu.menu_hoja5, popup.menu)

            // Controlar los clics de las opciones del menú emergente
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.pop_descargar -> {
                        txtResultado.text = getString(R.string.pop_descargar)
                        true
                    }
                    R.id.pop_imprimir -> {
                        txtResultado.text = getString(R.string.pop_imprimir)
                        true
                    }
                    R.id.pop_enviar -> {
                        txtResultado.text = getString(R.string.pop_enviar)
                        true
                    }
                    else -> false
                }
            }

            // Mostrar el menú
            popup.show()
        }
    }
    // ZONA B: No requiere funciones adicionales
}
