/*
 * Created by Leo on 2021. 04. 17 ..
 */
package kr.tooni.tooni

import android.app.Application

class TooniApp : Application() {
    
    override fun onCreate() {
        super.onCreate()
        app = this
    }
    
    companion object {
        private lateinit var app: TooniApp
        
        // must be removed when di set
        fun get(): TooniApp {
            return app
        }
    }
}
