/*
 * Created by Leo on 2021. 06. 06 ..
 */
package kr.tooni.tooni.data.preference

import kr.tooni.tooni.core.model.User

interface Preference {
    var uid: String
    var user: User
}
