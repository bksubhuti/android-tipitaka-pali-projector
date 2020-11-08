package com.paauk.tipitakapaliprojector


import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {

     fun setorientation(){
        //


    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webview)
        webView.webViewClient =  WebViewClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
                Log.e("TPP", consoleMessage?.message() + " -- From line "
                        + consoleMessage?.lineNumber() + " of "
                        + consoleMessage?.sourceId());
                return super.onConsoleMessage(consoleMessage)
            }
        }

        with(webView.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
            displayZoomControls = false
            builtInZoomControls = true
            useWideViewPort = true
            loadWithOverviewMode = true
        }
        // here we can set the orientation according to settings..

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

//        webView.settings.javaScriptEnabled = true
  //      webView.addJavascriptInterface(JSBridge(this), "JSBridge")
        webView.loadUrl("file:///android_asset/tipitaka_projector_data/index.htm")




    }

   /* override fun onConfigurationChanged(newConfig: Configuration) {
        // Checks the orientation of the screen
            super.onConfigurationChanged(newConfig)

    }
*/




}
/*
class JSBridge(){
    private var mainActivity = null
    constructor () {}
    constructor(inst: ma){
        mainActivity = ma 

    }


    fun showMessageInNative(message:String){
        mainActivity.setorientation()

    }
}


 */