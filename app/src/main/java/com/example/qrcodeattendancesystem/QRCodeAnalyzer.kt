package com.example.qrcodeattendancesystem

import android.graphics.ImageFormat
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

class QRCodeAnalyzer(val onQRCodeScanned: (result: String) -> Unit): ImageAnalysis.Analyzer {

//    private val supportedImageFormats = listOf(
//        ImageFormat.YUV_420_888,
//        ImageFormat.YUV_422_888,
//        ImageFormat.YUV_444_888
//    )

    @androidx.annotation.OptIn(androidx.camera.core.ExperimentalGetImage::class)
    override fun analyze(imageProxy: ImageProxy) {
//        if (imageProxy.format !in supportedImageFormats) return

        val mediaImage = imageProxy.image ?: return

        val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

        val options = BarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
            .build()

        val scanner = BarcodeScanning.getClient(options)

        scanner.process(image)
            .addOnCompleteListener { imageProxy.close() }
            .addOnSuccessListener { barcodes ->
                if (barcodes.isEmpty()) return@addOnSuccessListener
                barcodes[0].rawValue?.let { onQRCodeScanned(it) }
            }
    }
}