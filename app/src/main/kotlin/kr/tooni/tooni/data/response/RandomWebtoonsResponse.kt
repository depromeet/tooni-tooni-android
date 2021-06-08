/*
 * Created by Leo on 2021. 06. 08 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Webtoons

data class RandomWebtoonsResponse(
    val data: Webtoons
) : BaseResponse()
