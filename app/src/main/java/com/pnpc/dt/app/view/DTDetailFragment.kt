package com.pnpc.dt.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pnpc.dt.app.databinding.DtDetailFragmentViewBinding
import com.pnpc.dt.app.viewmodel.AdsViewModel

class DTDetailFragment : Fragment() {
    private var viewBinding: DtDetailFragmentViewBinding? = null

    companion object {
        const val DT_DETAIL = "DT_DETAIL"

        fun newInstance(): DTDetailFragment {
            val dtDetailFragment = DTDetailFragment()
            return dtDetailFragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adsViewModel: AdsViewModel? = activity?.let { ViewModelProvider(it).get(AdsViewModel::class.java) }
        val binding = DtDetailFragmentViewBinding.inflate(layoutInflater, container, false)
        viewBinding = binding

        val currentAd = adsViewModel?.selectedAd?.value



        return binding.root
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}