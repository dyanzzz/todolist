package com.rakamin.todolist.features

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rakamin.todolist.databinding.ItemBinding
import com.rakamin.todolist.domain.model.TodoList

class TodoListAdapter: ListAdapter<TodoList, TodoListAdapter.ViewHolder>(DiffCallback) {
    var itemOnClick: (TodoList) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TodoList) = with(binding) {
            tvTitle.text = item.title
            tvTanggal.text = item.date
            tvDeskripsi.text = item.description

            root.setOnClickListener {
                itemOnClick.invoke(item)
            }
        }
    }

    object DiffCallback: DiffUtil.ItemCallback<TodoList>() {
        override fun areItemsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
            return oldItem.id == newItem.id
        }

    }

}
