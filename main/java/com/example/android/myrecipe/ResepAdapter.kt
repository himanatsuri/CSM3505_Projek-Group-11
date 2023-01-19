package com.example.android.myrecipe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ResepAdapter (
    private val context: Context,
    private val resep: List<Resep>,
    val listener: (Resep) -> Unit
    ) : RecyclerView.Adapter<ResepAdapter.ResepViewHolder>(){

        class ResepViewHolder (view: View) : RecyclerView.ViewHolder(view){
            val gambarMasakan = view.findViewById<ImageView>(R.id.imageFood)
            val namaMasakan = view.findViewById<TextView>(R.id.foodName)
            val asalDaerah = view.findViewById<TextView>(R.id.foodFrom)

            fun bindView(resep: Resep, listener: (Resep) -> Unit){
                gambarMasakan.setImageResource(resep.gambarMasakan)
                namaMasakan.text = resep.namaMasakan
                asalDaerah.text = resep.asalDaerah
                itemView.setOnClickListener{
                    listener(resep)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder {
            return ResepViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_resep, parent, false)
            )
        }

        override fun getItemCount(): Int = resep.size

        override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
            holder.bindView(resep[position], listener)
        }
    }
