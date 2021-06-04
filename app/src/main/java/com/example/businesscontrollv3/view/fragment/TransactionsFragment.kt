package com.example.businesscontrollv3.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.BusinessControllV3
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.view.adapter.AccountAdapter
import com.example.businesscontrollv3.view.adapter.TransactionAdapter
import com.example.businesscontrollv3.viewmodel.AccountViewModel
import com.example.businesscontrollv3.viewmodel.AccountViewModelFactory
import com.example.businesscontrollv3.viewmodel.TransactionViewModel
import com.example.businesscontrollv3.viewmodel.TransactionViewModelFactory

class TransactionsFragment : Fragment() {

    val transactionViewModel: TransactionViewModel by viewModels {
        TransactionViewModelFactory(requireActivity().application as BusinessControllV3)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_transactions, container, false)

        val recyclerView = root.findViewById<RecyclerView>(R.id.transactionsRecyclerView)
        recyclerView.adapter = TransactionAdapter(transactionViewModel.transactionsList)

        return root
    }

}