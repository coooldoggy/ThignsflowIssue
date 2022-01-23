package com.coooldoggy.thignsflowissue.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coooldoggy.thignsflowissue.R
import com.coooldoggy.thignsflowissue.databinding.ItemImageBinding
import com.coooldoggy.thignsflowissue.databinding.ItemIssueBinding
import com.coooldoggy.thignsflowissue.framework.model.IssueData

class MainIssueAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private val TAG = MainIssueAdapter::class.java.simpleName
    }

    var issueList : List<IssueData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            0 -> {
                val view = try {
                    LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
                }catch (e: Throwable){
                    View(parent.context)
                }
                ImageHolder(view)
            }
            else -> {
                val view = try {
                    LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
                }catch (e: Throwable){
                    View(parent.context)
                }
                IssueHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            0 -> {
                (holder as? ImageHolder)?.runCatching {
                  bind("https://s3.ap-northeast-2.amazonaws.com/hellobot-kr-test/image/main_logo.png")
                }
            }
            else -> {
                (holder as? IssueHolder)?.runCatching {
                    Log.d(TAG, "IssueHolder ${issueList[position]}")
                    bind(issueList[position])
                }
            }
        }

    }

    override fun getItemCount(): Int = issueList.size
    override fun getItemViewType(position: Int): Int {
        if (position > 1 && (position + 1) % 5 == 0){
            return 0
        }
        return 1
    }


    inner class ImageHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var binding: ItemImageBinding = ItemImageBinding.bind(itemView)

        fun bind(imageUrl: String){
            binding.model = imageUrl
        }
    }

    inner class IssueHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var binding : ItemIssueBinding = ItemIssueBinding.bind(itemView)

        fun bind(data: IssueData){
            Log.d(TAG, "$data")
            binding.apply {
                tvIssueName.text = data.title
                tvIssueNumber.text = "#${data.id}"
            }
        }

    }
}