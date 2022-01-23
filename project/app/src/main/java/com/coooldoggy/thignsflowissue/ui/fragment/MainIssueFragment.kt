package com.coooldoggy.thignsflowissue.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.coooldoggy.thignsflowissue.MainActivity
import com.coooldoggy.thignsflowissue.R
import com.coooldoggy.thignsflowissue.databinding.FragmentMainIssueBinding
import com.coooldoggy.thignsflowissue.framework.model.IssueData
import com.coooldoggy.thignsflowissue.ui.adapter.MainIssueAdapter
import com.coooldoggy.thignsflowissue.ui.viewmodel.IssueDataViewModel
import com.coooldoggy.thignsflowissue.ui.viewmodel.MainIssueViewModel

class MainIssueFragment: Fragment() {
    companion object{
        private val TAG = MainIssueFragment::class.java.simpleName
    }

    private var viewDataBinding: FragmentMainIssueBinding? = null
    private val viewModel by navGraphViewModels<MainIssueViewModel>(R.id.nav_graph_main)
    private val issueDetailViewModel by navGraphViewModels<IssueDataViewModel>(R.id.nav_graph_main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate<FragmentMainIssueBinding>(inflater, R.layout.fragment_main_issue, container, false).apply {
            model = viewModel
            lifecycleOwner = this@MainIssueFragment
        }
        return viewDataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewDataBinding){
            if (this == null) return@with
            rvIssue.adapter = viewModel.issueAdapter.apply {
                issueClickListener = object : MainIssueAdapter.onClickIssue{
                    override fun onClickIssueItem(data: IssueData) {
                        view.findNavController().navigate(R.id.action_mainIssueFragment_to_issueDetailFragment,
                        IssueDetailFragmentArgs(
                            issueData = data
                        ).toBundle())
                    }

                    override fun onClickImage(url: String) {
                        kotlin.runCatching {
                            startActivity(
                                Intent(Intent.ACTION_VIEW).apply {
                                    data = url.toUri()
                                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                    addCategory(Intent.CATEGORY_BROWSABLE)
                                }
                            )
                        }
                    }
                }
            }
            rvIssue.layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.issueList.observe(viewLifecycleOwner, {
            viewModel.issueAdapter.issueList = it
            viewModel.issueAdapter.notifyDataSetChanged()
        })
        issueDetailViewModel.title.value = "ThignsFlowIssue"
        (requireActivity() as? MainActivity)?.setActionBarTitle(issueDetailViewModel.title.value ?: "")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding = null
    }
}