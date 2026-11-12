package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja3ContextualActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja3_contextual)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))
        txtResultado = findViewById(R.id.txtResultado)

        // 1. Registramos el TextView para menús contextuales de forma tradicional
        registerForContextMenu(txtResultado)

        // ZONA A: Forzar la apertura del menú con un clic simple normal
        txtResultado.setOnClickListener { vista ->
            // Abre el menú contextual inmediatamente al hacer clic
            openContextMenu(vista)
        }
    }

    // ZONA B: Funciones para construir e inflar el menú
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_hoja3, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ctx_editar -> {
                txtResultado.text = getString(R.string.ctx_editar)
                true
            }
            R.id.ctx_archivar -> {
                txtResultado.text = getString(R.string.ctx_archivar)
                true
            }
            R.id.ctx_eliminar -> {
                txtResultado.text = getString(R.string.ctx_eliminar)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}



