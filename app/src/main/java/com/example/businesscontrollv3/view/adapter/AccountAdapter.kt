package com.example.businesscontrollv3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Transaction
import com.example.businesscontrollv3.model.projection.TransactionProjection
import com.example.businesscontrollv3.utils.CardListener
import kotlinx.android.synthetic.main.item_account.view.*

class AccountAdapter(var transactionProjectionList: List<TransactionProjection>,
                     val cardListener: CardListener
) :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountAdapter.ViewHolder {
                    val itemAccount = LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false )
                    return ViewHolder(itemAccount)
            }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.bind(transactionProjectionList[position], cardListener)
//                holder.name.text = accountList[position].name
//                holder.type.text = accountList[position].accountTypeEnum.type
//                holder.balance.text = accountList[position].balance.toString()
//                holder.response.text = accountList[position].responsibleId.toString()

    }

    override fun getItemCount(): Int = transactionProjectionList.size


    class ViewHolder (val itemTransactionBinding: ItemTransactionBinding) : RecyclerView.ViewHolder(itemTransactionBinding.root){
       fun bind(item: TransactionProjection, cardListener: CardListener) {

           itemTransactionBinding.transactionProjection = item
           itemTransactionBinding.cardListener = cardListener
           itemTransactionBinding.executePendingBindings()

//        val name: TextView = itemAccount.findViewById(R.id.nameTV)
//        val type: TextView = itemAccount.findViewById(R.id.typeTV)
//        val balance: TextView = itemAccount.findViewById(R.id.balanceTV)
//        val response: TextView = itemAccount.findViewById(R.id.responsibleTV)

       }
    }
}