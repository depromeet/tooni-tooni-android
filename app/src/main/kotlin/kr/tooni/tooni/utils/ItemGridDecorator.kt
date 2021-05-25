/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.tooni.tooni.core.extensions.px

class ItemGridDecorator(
    private val spanCount: Int,
    private val margin: Margin
) : RecyclerView.ItemDecoration() {
    
    data class Margin(
        val top: Int, val bottom: Int, val left: Int, val right: Int, val middle: Middle
    ) {
        
        data class Middle(
            val vertical: Int,
            val horizontal: Int
        )
        
        object Template {
            val DEFAULT = Margin(
                top = 32.px(),
                bottom = 32.px(),
                left = 20.px(),
                right = 20.px(),
                middle = Middle(
                    vertical = 20.px(),
                    horizontal = 12.px()
                )
            )
        }
    }
    
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val itemPosition = parent.getChildAdapterPosition(view)
            .takeIf { it != RecyclerView.NO_POSITION } ?: return
        
        val spanIndex = (view.layoutParams as GridLayoutManager.LayoutParams).spanIndex
        val currentLine = itemPosition / spanCount
        val maxLine = (state.itemCount - 1) / spanCount
        
        if (spanIndex == 0) {
            outRect.left = margin.left
        }
    
        if (spanIndex == spanCount - 1) {
            outRect.right = margin.right
        }
        
        if (spanCount % 2 != 0) { // only executed when spanCount is odd
            if (spanIndex == spanCount / 2) {
                outRect.left = margin.middle.horizontal
                outRect.right = margin.middle.horizontal
            }
        }
        
        if (itemPosition < spanCount) {
            outRect.top = margin.top
        } else {
            outRect.top = margin.middle.vertical
        }
        
        if (currentLine == maxLine) {
            outRect.bottom = margin.bottom
        }
    }
}
