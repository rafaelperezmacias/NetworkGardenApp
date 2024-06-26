package com.rpm.networkgardenapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rpm.networkgardenapp.databinding.ItemPokemonBinding
import com.rpm.networkgardenapp.domain.extension.load
import com.rpm.networkgardenapp.domain.model.Pokemon
import com.rpm.networkgardenapp.utils.PokemonImage

class PokemonListAdapter(

): ListAdapter<Pokemon, BaseListViewHolder<*>>(DiffUtilCallback) {

    private object DiffUtilCallback : DiffUtil.ItemCallback<Pokemon>() {

        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolderList(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolderList -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolderList(private val binding: ItemPokemonBinding): BaseListViewHolder<Pokemon>(binding.root) {

        override fun bind(item: Pokemon, position: Int) {
            with(binding) {
                txtName.text = item.name
                imagePokemon.load(PokemonImage.getPokemonImage(item.url))

                lytItemPokemon.setOnClickListener {
                    onPokemonClickListener?.let { click ->
                        click(item)
                    }
                }
            }
        }

    }

    private var onPokemonClickListener: ((Pokemon) -> Unit)? = null
    fun setPokemonClickListener(listener: (Pokemon) -> Unit) {
        onPokemonClickListener = listener
    }

}