package com.coooldoggy.thignsflowissue.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.coooldoggy.thignsflowissue.MainActivity
import com.coooldoggy.thignsflowissue.R
import com.coooldoggy.thignsflowissue.databinding.FragmentIssueDetailBinding
import com.coooldoggy.thignsflowissue.ui.viewmodel.IssueDataViewModel

class IssueDetailFragment: Fragment() {
    companion object{
        private val TAG = IssueDetailFragment::class.java.simpleName
    }

    private var viewDataBinding: FragmentIssueDetailBinding? = null
    private val viewModel by navGraphViewModels<IssueDataViewModel>(R.id.nav_graph_main)
    private val requestArgs by navArgs<IssueDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setData(profileImg = requestArgs.issueData.user?.avatarUrl ?: "",
        userName = requestArgs.issueData.user?.login ?: "",
        body = requestArgs.issueData.body ?: "")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate<FragmentIssueDetailBinding>(inflater, R.layout.fragment_issue_detail, container, false).apply {
            model = viewModel
            lifecycleOwner = this@IssueDetailFragment
        }
        return viewDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.title.value = "#${requestArgs.issueData.id}"
        (requireActivity() as? MainActivity)?.setActionBarTitle(viewModel.title.value ?: "")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding = null
    }
}