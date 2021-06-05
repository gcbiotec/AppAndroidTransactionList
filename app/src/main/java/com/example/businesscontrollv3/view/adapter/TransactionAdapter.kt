package com.example.businesscontrollv3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ItemTransactionBinding
import com.example.businesscontrollv3.model.Transaction
import com.example.businesscontrollv3.model.projection.TransactionProjection
import com.example.businesscontrollv3.utils.CardListener

class TransactionAdapter(
    val transactionProjectionList: List<TransactionProjection>,
    val cardListener: CardListener
) :

    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
          val binding = ItemTransactionBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transactionProjectionList[position], cardListener)
//        holder.date.text = transactionList[position].toString()
//        holder.value.text = transactionList[position].toString()
//        holder.category.text = transactionList[position].toString()
//        holder.description.text = transactionList[position].toString()
//        holder.idResponsible.text = transactionList[position].toString()

    }

    override fun getItemCount(): Int = transactionProjectionList.size

    class ViewHolder(val itemTransactionBinding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(itemTransactionBinding.root) {
        fun bind(item: TransactionProjection, cardListener: CardListener) {
            itemTransactionBinding.transactionProjection = item
            itemTransactionBinding.cardListener = cardListener
            itemTransactionBinding.executePendingBindings()
        }
    }
}


//    class ViewHolder(itemTransaction: View) : RecyclerView.ViewHolder(itemTransaction) {
//        val name: TextView = itemTransaction.findViewById(R.id.nameTV)
//        val type: TextView = itemTransaction.findViewById(R.id.typeTV)
//        val category: TextView = itemTransaction.findViewById(R.id.expenseCategoryTypeTV)
//        val description: TextView = itemTransaction.findViewById(R.id.descriptionTV)
//        val date: TextView = itemTransaction.findViewById(R.id.calendarViewTV)
//        val idResponsible: TextView = itemTransaction.findViewById(R.id.idResponsibleTV)
////        val value: TextView = itemTransaction.findViewById(R.id.valueTV)
//
//    }
//}