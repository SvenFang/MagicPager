package com.yy.magerpage.ui

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.trello.rxlifecycle2.components.support.RxFragment
import com.yy.magerpage.Constant
import com.yy.magerpage.MagicPagerManager
import com.yy.magerpage.R
import com.yy.magerpage.model.container.MagicPagerModel
import com.yy.magerpage.model.request.PageRequestData

import com.yy.magerpage.provider.MagicProviderCallBack


/**
 * Created by Sven on 10/05/2019
 */
class MagicFragment : RxFragment() {

    private lateinit var magicContainerView: MagicContainerView

    companion object {

        const val TAG: String = "MagicFragment"

        /**
         * 传入type,key,params打开Activity
         */
        fun startMagic(
            requestData: PageRequestData
        ): MagicFragment {
            val bundle = Bundle()
            bundle.putSerializable(Constant.K_MAGIC_REQUEST_DATA, requestData)
            val fragment = MagicFragment()
            fragment.arguments = bundle
            return fragment
        }

        /**
         * 传入model打开Activity
         */
        fun startMagic(model: MagicPagerModel): MagicFragment {
            val bundle = Bundle()
            bundle.putSerializable(Constant.K_MAGIC_MODEL, model)
            val fragment = MagicFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_magic, container)
        initView(view)
        loadData()

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun initView(view: View) {
        magicContainerView = view.findViewById(R.id.magic_container_view)
        magicContainerView.callBack = object : MagicContainerView.MagicContainerCallBack {
            override fun onRefresh() {
                loadData()
            }
        }
    }

    private fun loadData() {

        val requestData = arguments?.getSerializable(Constant.K_MAGIC_REQUEST_DATA)
        val model = arguments?.getSerializable(Constant.K_MAGIC_MODEL)

        when {
            model is MagicPagerModel -> magicContainerView.analysis(model)
            requestData is PageRequestData -> MagicPagerManager.get().getMagic(
                requestData.type,
                requestData.key,
                requestData.params,
                object : MagicProviderCallBack {
                    override fun onSuccess(resp: MagicPagerModel) {
                        magicContainerView.analysis(resp)
                    }

                    override fun onError(error: String) {
                        showErrorView(error)
                    }
                })
            else -> {
                showErrorView(null)
            }
        }
    }

    private fun showErrorView(errorMsg: String?) {
        MagicPagerManager.get().errorPageProvider?.let {
            magicContainerView.analysis(it.getErrorPage(errorMsg))
        }
    }
}