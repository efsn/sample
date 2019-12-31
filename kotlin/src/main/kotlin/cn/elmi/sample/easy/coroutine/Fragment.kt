package cn.elmi.sample.easy.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

private val parentJob = Job()

private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob)

private fun originalBitMapAsync(tutorial: Tutorial): Deferred<Bitmap> =
    coroutineScope.async(Dispatchers.IO) {
        URL(tutorial.url).openStream().use {
            return@async BitmapFactory.decodeStream(it)
        }
    }

private suspend fun originalBitmapAsync(tutorial: Tutorial): Bitmap =
    withContext(Dispatchers.IO) {
        URL(tutorial.url).openStream().use {
            return@withContext BitmapFactory.decodeStream(it)
        }
    }

private fun loadSnowFilterAsync(orginalBitmap: Bitmap): Deferred<Bitmap> =
    coroutineScope.async(Dispatchers.Default) {
        SnowFilter.applySnowEffect(orginalBitmap)
    }

private suspend fun loadSnowFilterAsync(originalBitmap: Bitmap): Bitmap =
    withContext(Dispatchers.Default) {
        SnowFilter.applySnowEffect(originalBitmap)
    }

private val coroutineExceptionHandler: CoroutineExceptionHandler =
    CoroutineExceptionHandler { _, throwable ->
        coroutineScope.launch(Dispatchers.Main) {
            errorMessage.visibility = ""
            errorMessage.text = getString(R.string.error_message)
        }
        GlobalScope.launch { println("Caught $throwable") }
    }