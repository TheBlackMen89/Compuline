package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCarroCompras(
    var tvTotal: TextView,
    var carroCompras: ArrayList<Producto>
): RecyclerView.Adapter<AdaptadorCarroCompras.ViewHolder>() {

    var total: Double = 0.0

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val marca = itemView.findViewById(R.id.tvMarca) as TextView
        val tvDescripcion = itemView.findViewById(R.id.tvDescripcion) as TextView
        val tvPrecio = itemView.findViewById(R.id.tvPrecio) as TextView
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_carro_compras, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = carroCompras[position]

        holder.marca.text = producto.marca
        holder.tvDescripcion.text = producto.descripcion
        holder.tvPrecio.text = "$${producto.precio}"

        // Calcula el total cada vez que se actualiza el contenido
        recalcularTotal()

    }

    override fun getItemCount(): Int {
        return carroCompras.size
    }

    private fun recalcularTotal() {
        total = 0.0
        carroCompras.forEach {
            total += it.precio
        }
        tvTotal.text = "$$total"
    }

private operator fun Double.plusAssign(precio: String) {
    total = 0.0
    carroCompras.forEach {
        total += it.precio
    }
    tvTotal.text = "$$total"
}
}
