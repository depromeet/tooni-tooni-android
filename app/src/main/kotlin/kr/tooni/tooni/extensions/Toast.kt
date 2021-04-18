/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni.extensions

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun Context.toast(stringRes: Int) = Toast.makeText(this, stringRes, Toast.LENGTH_SHORT).show()
fun Context.toastLong(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
fun Context.toastLong(stringRes: Int) = Toast.makeText(this, stringRes, Toast.LENGTH_LONG).show()

fun Fragment.toast(message: String) = requireContext().toast(message)
fun Fragment.toast(stringRes: Int) = requireContext().toast(stringRes)
fun Fragment.toastLong(message: String) = requireContext().toastLong(message)
fun Fragment.toastLong(stringRes: Int) = requireContext().toastLong(stringRes)
