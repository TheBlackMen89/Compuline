package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.ArrayList

class AdaptadorProducto(
        var context: Context,
        var tvCantProductos: TextView,
        var btnVerCarro: Button,
        var listaProductos: ArrayList<Producto>,
        var carroCompras: ArrayList<Producto>,
) : RecyclerView.Adapter<AdaptadorProducto.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                val tvMarca = itemView.findViewById(R.id.tvMarca) as TextView
                val tvDescripcion = itemView.findViewById(R.id.tvDescripcion) as TextView
                val cbCarro = itemView.findViewById(R.id.cbCarro) as CheckBox
                val tvPrecio = itemView.findViewById(R.id.tvPrecio) as TextView
                val imageView = itemView.findViewById(R.id.imageView) as ImageView
                val btnVerCarro = itemView.findViewById(R.id.btnVerCarro) as Button  // Agrega esta línea


        }

        override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
        ): ViewHolder {
                val vista = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_rv_productos, parent, false)
                return ViewHolder(vista)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val producto = listaProductos[position]

                holder.tvMarca.text = producto.marca
                holder.tvDescripcion.text = producto.descripcion
                holder.tvPrecio.text = producto.precio.toString()
                Glide.with(context)
                        .load(producto.imagen)
                        .into(holder.imageView)

                holder.cbCarro.setOnCheckedChangeListener { _, _ ->
                        // Tu lógica para cambiar la cantidad y la lista de compras
                }
                holder.btnVerCarro.setOnClickListener {
                        val intent = Intent(holder.itemView.context, CarroComprasActivity::class.java)
                        intent.putExtra("carro_compras", carroCompras)
                        holder.itemView.context.startActivity(intent)
                }
        }

        override fun getItemCount(): Int {
                return listaProductos.size
        }
}
