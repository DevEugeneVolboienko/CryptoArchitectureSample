package com.example.architectureexample.presentation.ui.base.listener

import androidx.lifecycle.ViewModel

interface OnItemClickListener<VM : ViewModel> {
    fun onClick(item: VM)
}