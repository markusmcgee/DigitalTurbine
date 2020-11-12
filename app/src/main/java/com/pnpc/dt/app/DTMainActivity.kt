package com.pnpc.dt.app

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import com.pnpc.dt.app.databinding.DtMainActivityViewBinding
import com.pnpc.dt.app.view.DTDetailFragment
import com.pnpc.dt.app.view.DTListFragment
import com.pnpc.dt.app.viewmodel.AdsViewModel

class DTMainActivity : FragmentActivity() {

    private lateinit var viewBinding: DtMainActivityViewBinding
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.currentState = Lifecycle.State.CREATED

        viewBinding = DtMainActivityViewBinding.inflate(LayoutInflater.from(this))
        setContentView(viewBinding.root)

        val adsViewModel: AdsViewModel by viewModels()

        adsViewModel.getAds()?.observe(this, Observer {
            if (it.size > 0) {
                val adListFragment = DTListFragment.newInstance()
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.main_fragment_container, adListFragment)
                fragmentTransaction.addToBackStack(DTListFragment.DT_LIST)
                fragmentTransaction.commit()
            }
        })

        adsViewModel.selectedAd.observe(this, {
            val adDetailFragment = DTDetailFragment.newInstance()
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_fragment_container, adDetailFragment)
                fragmentTransaction.addToBackStack(DTDetailFragment.DT_DETAIL)
            fragmentTransaction.commit()
        })
    }
}