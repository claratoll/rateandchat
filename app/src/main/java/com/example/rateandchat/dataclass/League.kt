package com.example.rateandchat.dataclass

import android.media.Image
import com.google.firebase.firestore.DocumentId

data class League(
    @DocumentId val documentId: String = "",
    var leagueName : String? = null,
    var leagueLogo : Image? =null

    )
