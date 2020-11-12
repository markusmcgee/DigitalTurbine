package com.pnpc.dt.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pnpc.dt.app.adapter.DTItemAdapter
import com.pnpc.dt.app.databinding.DtListFragmentViewBinding
import com.pnpc.dt.app.viewmodel.AdsViewModel


class DTListFragment : Fragment() {

    private var viewBinding: DtListFragmentViewBinding? = null
    private lateinit var recyclerView: RecyclerView

    companion object {
        const val DT_LIST = "DT_LIST"
        fun newInstance(): DTListFragment {
            val dtListFragment = DTListFragment()
            return dtListFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adsViewModel: AdsViewModel? = activity?.let { ViewModelProvider(it).get(AdsViewModel::class.java) }
        val binding = DtListFragmentViewBinding.inflate(inflater, container, false)
        recyclerView = binding.dtRecyclerView
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val adapter = DTItemAdapter(adsViewModel)
        adsViewModel?.getAds()?.value?.let {
            adapter.replaceItems(it)
        }
        recyclerView.adapter = adapter
        viewBinding = binding
        return binding.root
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}