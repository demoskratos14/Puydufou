package com.sejour.puydufou

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Affiche la page assets/index.html dans une WebView.
 * Tout lien externe (itinéraires Google Maps) est ouvert dans l'appli Google Maps
 * si elle est installée, sinon dans le navigateur.
 */
class MainActivity : Activity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        web = WebView(this)
        setContentView(web)

        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true // garde les « fait » / « supprimé » entre deux ouvertures

        web.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                val uri = request.url
                if (uri.scheme == "file") return false
                openExternal(uri)
                return true
            }
        }
        web.loadUrl("file:///android_asset/index.html")
    }

    private fun openExternal(uri: Uri) {
        val inMaps = Intent(Intent.ACTION_VIEW, uri).setPackage("com.google.android.apps.maps")
        try {
            startActivity(inMaps)
        } catch (e: ActivityNotFoundException) {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            } catch (e2: ActivityNotFoundException) {
                // aucune appli pour ouvrir le lien
            }
        }
    }
}
