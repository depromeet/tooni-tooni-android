/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T: ViewDataBinding>(
    @LayoutRes private val resId: Int
) : AppCompatActivity(resId), BaseView {

    protected lateinit var binding: T

    override fun initView() {
        /* explicitly empty */
    }

    override fun subscribe() {
        /* explicitly empty */
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, resId)
        binding.lifecycleOwner = this
        initView()
        subscribe()
    }
}
