package com.pnpc.dt.app.model

import android.os.Parcel
import android.os.Parcelable

data class AdXmlData(
    var appId: String?,
    var averageRatingImageURL: String?,
    var bidRate: Float,
    var billingTypeId: Int,
    var callToAction: String?,
    var campaignDisplayOrder: Int,
    var campaignId: Int,
    var campaignTypeId: Int,
    var categoryName: String?,
    var clickProxyURL: String?,
    var creativeId: Int,
    var homeScreen: Boolean,
    var impressionTrackingURL: String?,
    var isRandomPick: Boolean,
    var numberOfRatings: String?,
    var productDescription: String?,
    var productId: String?,
    var productName: String?,
    var productThumbnail: String?,
    var rating: String?,
    var numberOfDownloads: String?,
    var tstiEligible: Boolean,
    var stiEnabled: Boolean,
    var postInstallActions: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(appId)
        parcel.writeString(averageRatingImageURL)
        parcel.writeFloat(bidRate)
        parcel.writeInt(billingTypeId)
        parcel.writeString(callToAction)
        parcel.writeInt(campaignDisplayOrder)
        parcel.writeInt(campaignId)
        parcel.writeInt(campaignTypeId)
        parcel.writeString(categoryName)
        parcel.writeString(clickProxyURL)
        parcel.writeInt(creativeId)
        parcel.writeByte(if (homeScreen) 1 else 0)
        parcel.writeString(impressionTrackingURL)
        parcel.writeByte(if (isRandomPick) 1 else 0)
        parcel.writeString(numberOfRatings)
        parcel.writeString(productDescription)
        parcel.writeString(productId)
        parcel.writeString(productName)
        parcel.writeString(productThumbnail)
        parcel.writeString(rating)
        parcel.writeString(numberOfDownloads)
        parcel.writeByte(if (tstiEligible) 1 else 0)
        parcel.writeByte(if (stiEnabled) 1 else 0)
        parcel.writeString(postInstallActions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AdXmlData> {
        override fun createFromParcel(parcel: Parcel): AdXmlData {
            return AdXmlData(parcel)
        }

        override fun newArray(size: Int): Array<AdXmlData?> {
            return arrayOfNulls(size)
        }
    }
}
