package com.coooldoggy.thignsflowissue.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.coooldoggy.thignsflowissue.R
import com.coooldoggy.thignsflowissue.databinding.FragmentMainIssueBinding
import com.coooldoggy.thignsflowissue.ui.viewmodel.MainIssueViewModel

class MainIssueFragment: Fragment() {
    companion object{
        private val TAG = MainIssueFragment::class.java.simpleName
    }

    private var viewDataBinding: FragmentMainIssueBinding? = null
    private val viewModel by navGraphViewModels<MainIssueViewModel>(R.id.nav_graph_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
            rvIssue.adapter = viewModel.issueAdapter
            rvIssue.layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.issueList.observe(viewLifecycleOwner, {
            viewModel.issueAdapter.issueList = it
            viewModel.issueAdapter.notifyDataSetChanged()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewDataBinding = null
    }
}