package com.example.businesscontrollv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.view.adapter.MainSectionsPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionsPagerAdapter = MainSectionsPagerAdapter(lifecycle, supportFragmentManager)
        pager.adapter = sectionsPagerAdapter

        TabLayoutMediator(tabs, pager) {
            tab, position -> tab.text = when(position) {
                0 -> "Resumo"
                1 -> "Transações"
                2 -> "Contas"
                else -> ""
            }
        }.attach()

        bottomNavigationMenu.setOnNavigationItemSelectedListener(this::onOptionsItemSelected)
    }

    fun showSnackBar(view: View) {
        Snackbar
            .make(view, R.string.snack_bar_text, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.sair_text) {
                finish()
            }
            .show()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        Toast.makeText(applicationContext, R.string.toast_text, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.new_responsible -> {
                //Toast.makeText(this, "Adicionar novo Responsável", Toast.LENGTH_LONG).show()
               val intent = Intent(this, ResponsibleActivity::class.java)
                //val intent = Intent(this, AccountActivity::class.java)

                startActivity(intent)
                true
            }
            R.id.new_transaction -> true
            R.id.new_account -> true
            R.id.navigation_configurations -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}