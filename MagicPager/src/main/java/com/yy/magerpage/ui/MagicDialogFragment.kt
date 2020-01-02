package com.yy.magerpage.ui

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yy.magerpage.R
import com.yy.magerpage.model.container.MagicDialogModel

import com.yy.magerpage.util.AnimUtils

import com.yy.magerpage.util.CacheManage
import com.yy.magerpage.util.LengthUtil
import kotlinx.android.synthetic.main.fragment_magic.view.*

/**
 * @Date Created: 2019-10-15
 * @Author: hexiang
 * @Description:对话框
 */
class MagicDialogFragment : DialogFragment() {

    private lateinit var root: View
    lateinit var model: MagicDialogModel

    companion object {

        fun newInstance(
            model: MagicDialogModel
        ): MagicDialogFragment {
            val fragment = MagicDialogFragment()
            fragment.model = model
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = layoutInflater.inflate(R.layout.fragment_dialog, container, false)
        root.magic_container_view?.callBack = object : MagicContainerView.MagicContainerCallBack {
            override fun onRefresh() {
                loadData()
            }
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
        activity?.let { CacheManage.addCacheDialog(it, this) }
    }

    private fun loadData() {
        root.magic_container_view?.analysis(model)
        initData(model)
    }

    private fun initData(model: MagicDialogModel) {
        val layoutParams = root.layoutParams
        layoutParams?.let {
            model.width.let {
                layoutParams.width = LengthUtil.formatWithAndHeight(model.width, root.context)
            }
            model.height.let {
                layoutParams.height = LengthUtil.formatWithAndHeight(model.height, root.context)
            }

            root.layoutParams = layoutParams
        }

        model.animStyle?.let {
            dialog.window?.setWindowAnimations(AnimUtils.formatAnimStyle(it))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.let { CacheManage.removeCacheDialog(it) }
    }
}