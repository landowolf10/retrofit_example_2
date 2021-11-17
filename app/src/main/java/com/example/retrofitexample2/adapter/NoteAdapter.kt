package com.example.retrofitexample2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample2.R
import com.example.retrofitexample2.model.Note

class NoteAdapter(private var note: List<Note>): RecyclerView.Adapter<NoteAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.card_layout,
            parent,
            false
        )

        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        holder.render(note[position])
    }

    override fun getItemCount(): Int {
        return note.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        fun render(item: Note)
        {
            var noteCreator: TextView = itemView.findViewById(R.id.tvCreator)
            var noteDate: TextView = itemView.findViewById(R.id.tvDate)

            noteCreator.text = item.nombre_creador
            noteDate.text = item.fecha
        }
    }
}