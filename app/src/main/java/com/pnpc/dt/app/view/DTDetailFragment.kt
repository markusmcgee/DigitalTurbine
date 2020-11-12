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
        binding.appId.text = (currentAd as Map<*, *>)["appId"].toString()
        binding.averageRatingImageURL.text = (currentAd as Map<*, *>)["averageRatingImageURL"].toString()
        binding.bidRate.text = (currentAd as Map<*, *>)["bidRate"].toString()
        binding.billingTypeId.text = (currentAd as Map<*, *>)["billingTypeId"].toString()
        binding.callToAction.text = (currentAd as Map<*, *>)["callToAction"].toString()
        binding.campaignDisplayOrder.text = (currentAd as Map<*, *>)["campaignDisplayOrder"].toString()
        binding.campaignId.text = (currentAd as Map<*, *>)["campaignId"].toString()
        binding.campaignTypeId.text = (currentAd as Map<*, *>)["campaignTypeId"].toString()
        binding.categoryName.text = (currentAd as Map<*, *>)["categoryName"].toString()
        binding.clickProxyURL.text = (currentAd as Map<*, *>)["clickProxyURL"].toString()
        binding.creativeId.text = (currentAd as Map<*, *>)["creativeId"].toString()
        binding.homeScreen.text = (currentAd as Map<*, *>)["homeScreen"].toString()
        binding.impressionTrackingURL.text = (currentAd as Map<*, *>)["impressionTrackingURL"].toString()
        binding.isRandomPick.text = (currentAd as Map<*, *>)["isRandomPick"].toString()
        binding.numberOfRatings.text = (currentAd as Map<*, *>)["numberOfRatings"].toString()
        binding.productDescription.text = (currentAd as Map<*, *>)["productDescription"].toString()
        binding.productId.text = (currentAd as Map<*, *>)["productId"].toString()
        binding.productName.text = (currentAd as Map<*, *>)["productName"].toString()
        binding.productThumbnail.text = (currentAd as Map<*, *>)["productThumbnail"].toString()
        binding.rating.text = (currentAd as Map<*, *>)["rating"].toString()
        binding.numberOfDownloads.text = (currentAd as Map<*, *>)["numberOfDownloads"].toString()
        binding.tstiEligible.text = (currentAd as Map<*, *>)["tstiEligible"].toString()
        binding.stiEnabled.text = (currentAd as Map<*, *>)["stiEnabled"].toString()
        binding.postInstallActions.text = (currentAd as Map<*, *>)["postInstallActions"].toString()


        return binding.root
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}