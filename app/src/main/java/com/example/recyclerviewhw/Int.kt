package com.example.recyclerviewhw

interface RowClickListener<T> {
    fun onRowClick(pos: Int, item:T)
}