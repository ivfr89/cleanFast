package com.developer.ivan.cleanapiexample.datasources

import com.developer.ivan.data.datasources.INetworkDataSource


class NetworkDataSource() : INetworkDataSource {

    override fun isConnectedInternet(): Boolean = true

}