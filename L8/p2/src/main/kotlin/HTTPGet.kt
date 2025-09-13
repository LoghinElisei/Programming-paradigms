package org.example

import okhttp3.Response

interface HTTPGet {
    fun getResponse():Response
}