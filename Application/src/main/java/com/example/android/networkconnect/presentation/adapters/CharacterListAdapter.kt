package com.example.android.networkconnect.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.networkconnect.data.CharacterInfoModel
import com.example.android.networkconnect.data.RickAndMortyModels
import com.example.android.networkconnect.databinding.CharacterItemBinding

class CharacterListAdapter(
    private val models: RickAndMortyModels
) :
    RecyclerView.Adapter<CharacterListAdapter.CharactersListViewHolder>() {

    inner class CharactersListViewHolder(itemView: CharacterItemBinding, var context: Context) :
        RecyclerView.ViewHolder(itemView.root) {
        private val image = itemView.characterImageView
        var name = itemView.characterNameTextView
        fun bind(model: CharacterInfoModel) {
            Glide.with(context).load(model.image).into(image)
            name.text = model.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        CharactersListViewHolder = CharactersListViewHolder(
        CharacterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        parent.context
    )

    override fun onBindViewHolder(holder: CharactersListViewHolder, position: Int) {
        holder.bind(models.characterList[position])
    }

    override fun getItemCount(): Int = models.characterList.size
}
