package com.apppruebaa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apppruebaa.databinding.FragmentCapituloItemBinding
import com.apppruebaa.model.Capitulo

class CapituloAdapter : RecyclerView.Adapter<CapituloAdapter.CapituloViewHolder>() {
    private var listaCapitulos = emptyList<Capitulo>()
    inner class CapituloViewHolder(private val itemBinding: FragmentCapituloItemBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(capitulo: Capitulo) {
            itemBinding.tvTitulo.text = capitulo.titulo
            itemBinding.tvRevision.text = capitulo.revision.toString()
            itemBinding.tvPrecio.text = capitulo.precio.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CapituloViewHolder {
        val itemBinding = FragmentCapituloItemBinding
            .inflate(LayoutInflater.from(parent.context)
                ,parent
                ,false)
        return CapituloViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: CapituloViewHolder, position: Int) {
        val capituloActual = listaCapitulos[position]
        holder.dibuja(capituloActual)
    }
    override fun getItemCount(): Int {
        return listaCapitulos.size
    }
    fun setCapitulos(capitulos : List<Capitulo>) {
        listaCapitulos = capitulos
        notifyDataSetChanged()  //Se notifica que el conjunto de datos cambio y se redibuja toda la lista
    }
}