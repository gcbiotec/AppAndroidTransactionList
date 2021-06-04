package com.example.businesscontrollv3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.model.Transaction

class TransactionAdapter(private val transactionList: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapter.ViewHolder {
        val itemTransaction =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return ViewHolder(itemTransaction)
    }

    override fun onBindViewHolder(holder: TransactionAdapter.ViewHolder, position: Int) {
        holder.date.text = transactionList[position].toString()
        holder.value.text = transactionList[position].toString()
        holder.category.text = transactionList[position].toString()
        holder.description.text = transactionList[position].toString()
        holder.idResponsible.text = transactionList[position].toString()

    }

    override fun getItemCount(): Int = transactionList.size

    class ViewHolder(itemTransaction: View) : RecyclerView.ViewHolder(itemTransaction) {
        val name: TextView = itemTransaction.findViewById(R.id.nameTV)
        val type: TextView = itemTransaction.findViewById(R.id.typeTV)
        val category: TextView = itemTransaction.findViewById(R.id.expenseCategoryTypeTV)
        val description: TextView = itemTransaction.findViewById(R.id.descriptionTV)
        val date: TextView = itemTransaction.findViewById(R.id.calendarViewTV)
        val idResponsible: TextView = itemTransaction.findViewById(R.id.idResponsibleTV)
        val value: TextView = itemTransaction.findViewById(R.id.valueTV)

    }
}