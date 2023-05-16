package com.example.architectureexample.presentation.ui.base

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<VB : ViewBinding, VM : ViewModel>(viewBinding: VB) :
    RecyclerView.ViewHolder(viewBinding.root) {
    abstract fun bind(viewModel: VM)
}