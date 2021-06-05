package com.example.businesscontrollv3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.databinding.ItemAccountBinding
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Transaction
import com.example.businesscontrollv3.model.projection.AccountProjection
import com.example.businesscontrollv3.model.projection.TransactionProjection
import com.example.businesscontrollv3.utils.CardListener
import kotlinx.android.synthetic.main.item_account.view.*

class AccountAdapter(
    var accountProjectionList: List<AccountProjection>,
    val cardListener: CardListener
) :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAccountBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(accountProjectionList[position], cardListener)
    }

    override fun getItemCount(): Int = accountProjectionList.size

    class ViewHolder(val itemAccountBinding: ItemAccountBinding) : RecyclerView.ViewHolder(itemAccountBinding.root) {
        fun bind(item: AccountProjection, cardListener: CardListener) {
            itemAccountBinding.accountProjection = item
            itemAccountBinding.cardListener = cardListener
            itemAccountBinding.executePendingBindings()
        }
    }
}