package com.ftadev.sample

import Result
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.florent37.expansionpanel.ExpansionLayout
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection
import kotlinx.android.synthetic.main.recycler_cell.view.*

class RVAdapter(context: Context) :
    RecyclerView.Adapter<RVAdapter.RecyclerHolder>() {
    private var list: ArrayList<Result> =
        ArrayList()
    private val expansionsCollection = ExpansionLayoutCollection()
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
        expansionsCollection.add(holder.expansionLayout)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setItems(items: List<Result>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    class RecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mAdapter = NestedRVAdapter()

        var expansionLayout: ExpansionLayout = itemView.findViewById(R.id.expansionLayout)
        fun bind(result: Result) {
            itemView.tv_title.text = result.title
            expansionLayout.collapse(false)

            itemView.nested_rv.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = mAdapter
            }

            mAdapter.setItems(result.subCategories)
        }

        companion object {
            private const val LAYOUT = R.layout.recycler_cell
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

    init {
        expansionsCollection.openOnlyOne(true)
    }
}