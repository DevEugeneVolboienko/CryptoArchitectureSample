package com.example.architectureexample.presentation.ui.crypto_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.architectureexample.databinding.ItemCryptoBinding
import com.example.architectureexample.presentation.ui.base.BaseAdapter
import com.example.architectureexample.presentation.ui.base.BaseViewHolder
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel

class CryptoListAdapter(
    onItemClickListener: OnItemClickListener<CryptoViewModel>
) : BaseAdapter<ItemCryptoBinding, CryptoViewModel, CryptoListAdapter.CryptoViewHolder>(
    onItemClickListener
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder =
        CryptoViewHolder(
            ItemCryptoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    fun updateData(items: List<CryptoViewModel>?) {
        data = items ?: emptyList()
        notifyDataSetChanged()
    }

    inner class CryptoViewHolder(private val viewBinding: ItemCryptoBinding) :
        BaseViewHolder<ItemCryptoBinding, CryptoViewModel>(viewBinding) {
        override fun bind(viewModel: CryptoViewModel) {
            with(viewBinding) {
                this.viewModel = viewModel
                root.setOnClickListener {
                    onItemClickListener.onClick(viewModel)
                }
                executePendingBindings()
            }
        }
    }
}