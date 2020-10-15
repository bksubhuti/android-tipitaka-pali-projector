package com.paauk.tipitakapaliprojector


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
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
            displayZoomControls = true
            builtInZoomControls = true
            useWideViewPort = true
            loadWithOverviewMode = true
        }

        webView.loadUrl("file:///android_asset/tipitaka_projector_data/index.htm");
    }
}