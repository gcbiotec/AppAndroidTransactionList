package com.example.businesscontrollv3.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.businesscontrollv3.view.fragment.AccountsFragment
import com.example.businesscontrollv3.view.fragment.ResumeFragment
import com.example.businesscontrollv3.view.fragment.TransactionsFragment

class MainSectionsPagerAdapter(private val lifecycle: Lifecycle, fm: FragmentManager) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ResumeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ResumeFragment.ARG_SECTION_NUMBER, position)
                }
            }
            1 -> TransactionsFragment()
            2 -> AccountsFragment()
            else -> throw IllegalAccessException("Posicao desconhecida")
        }
    }



}