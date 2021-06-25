package kr.tooni.tooni.data.response

import kr.tooni.tooni.core.model.Authordetail

data class RecommendAuthorResponse(
    val data: Authordetail
) : BaseResponse()
