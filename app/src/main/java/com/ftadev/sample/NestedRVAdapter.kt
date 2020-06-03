package com.ftadev.sample

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_cell.view.*

class NestedRVAdapter :
    RecyclerView.Adapter<NestedRVAdapter.RecyclerHolder>() {
    private var list: ArrayList<SubCategories> =
        ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerHolder {
        return RecyclerHolder.buildFor(
            parent
        )
    }

    override fun onBindViewHolder(
        holder: RecyclerHolder,
        position: Int
    ) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItems(items: List<SubCategories>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: SubCategories) {
            itemView.tv_title.text = result.title
            itemView.setOnClickListener {
                it.context.startActivity(Intent(it.context, SecondActivity::class.java))
            }
        }

        companion object {
            private const val LAYOUT = R.layout.nested_cell
            fun buildFor(viewGroup: ViewGroup): RecyclerHolder {
                return RecyclerHolder(
                    LayoutInflater.from(viewGroup.context).inflate(
                        LAYOUT,
                        viewGroup,
                        false
                    )
                )
            }
        }

    }

}