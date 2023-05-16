package com.example.architectureexample.utils

import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.architectureexample.presentation.ui.base.BaseAdapter
import com.example.architectureexample.presentation.ui.base.BaseViewHolder
import com.example.architectureexample.presentation.ui.base.BaseViewModel
import com.example.architectureexample.presentation.ui.base.listener.OnItemClickListener
import com.example.architectureexample.presentation.ui.crypto_list.adapter.CryptoListAdapter
import com.example.architectureexample.presentation.ui.crypto_list.viewmodel.CryptoViewModel

@BindingAdapter("onItemClickListener")
fun RecyclerView.initAdapter(
    onItemClickListener: OnItemClickListener<CryptoViewModel>
) {
    this.adapter = CryptoListAdapter(onItemClickListener)
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("data")
fun RecyclerView.updateData(data: List<CryptoViewModel>?) {
    val adapter = this.adapter as CryptoListAdapter?
    adapter?.updateData(data)
}