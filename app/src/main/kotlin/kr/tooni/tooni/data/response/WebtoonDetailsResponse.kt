/*
 * Created by Leo on 2021. 05. 23 ..
 */
package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.WebtoonDetails

data class WebtoonDetailsResponse(
    val data: WebtoonDetails
) : BaseResponse()
