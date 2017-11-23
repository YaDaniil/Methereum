package com.yadaniil.methereum

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.toast
import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.Web3jFactory
import org.web3j.protocol.http.HttpService
import timber.log.Timber
import java.io.File
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var web3: Web3j
    private lateinit var credentials: Credentials

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectToInfura()
        initCredentials()
    }

    private fun connectToInfura() {
        try {
            web3 = Web3jFactory.build(HttpService("https://morden.infura.io/" + getString(R.string.INFURA_API_KEY)))
        } catch (e: IOException) {
            toast("connect to infura error")
        }
    }

    private fun initCredentials() {
        val walletFileString = WalletUtils.generateFullNewWalletFile("123456789", File(filesDir, ""))
        credentials = WalletUtils.loadCredentials("123456789", File(filesDir, walletFileString))
        Timber.d("Address: " + credentials.address)
    }

}
