package com.utxicotepec.menusandroid

import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Hoja4AccionActivity : AppCompatActivity() {

    private lateinit var txtResultado: TextView

    // Variable de control para evitar abrir múltiples barras a la vez
    private var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hoja4_accion)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val barras = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(barras.left, barras.top, barras.right, barras.bottom)
            insets
        }

        setSupportActionBar(findViewById<MaterialToolbar>(R.id.toolbar))
        txtResultado = findViewById(R.id.txtResultado)

        // ZONA A: Activar el modo de acción al mantener presionado el texto
        txtResultado.setOnLongClickListener { view ->
            when (actionMode) {
                null -> {
                    actionMode = startActionMode(actionModeCallback)
                    view.isSelected = true
                    true
                }
                else -> false
            }
        }
    }

    // ZONA B: Callback que controla la barra contextual y los clics en sus opciones
    private val actionModeCallback = object : ActionMode.Callback {

        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            mode.menuInflater.inflate(R.menu.menu_hoja4, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.acc_copiar -> {
                    txtResultado.text = getString(R.string.acc_copiar)
                    mode.finish() // Cierra la barra contextual al elegir una opción
                    true
                }
                R.id.acc_cortar -> {
                    txtResultado.text = getString(R.string.acc_cortar)
                    mode.finish()
                    true
                }
                R.id.acc_pegar -> {
                    txtResultado.text = getString(R.string.acc_pegar)
                    mode.finish()
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }
    }
}
