package com.example.redditnews.pojo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(

	@Json(name="data")
	val data: Data? = null,

	@Json(name="kind")
	val kind: String? = null
) : Parcelable

@Parcelize
data class S(

	@Json(name="u")
	val U: String? = null,

	@Json(name="x")
	val X: Int? = null,

	@Json(name="y")
	val Y: Int? = null
) : Parcelable



@Parcelize
@Entity(tableName = "newsTable")
data class Data(

	@Json(name="modhash")
	val modhash: String? = null,

	@Json(name="children")
	val children: List<ChildrenItem?>? = null,

	@Json(name="dist")
	val dist: Int? = null,

	@Json(name="after")
	val after: String? = null,

	@Json(name="saved")
	val saved: Boolean? = null,

	@Json(name="hide_score")
	val hideScore: Boolean? = null,

	@Json(name="total_awards_received")
	val totalAwardsReceived: Int? = null,

	@Json(name="subreddit_id")
	val subredditId: String? = null,

	@Json(name="score")
	val score: Int? = null,

	@Json(name="num_comments")
	val numComments: Int? = null,

	@Json(name="whitelist_status")
	val whitelistStatus: String? = null,

	@Json(name="spoiler")
	val spoiler: Boolean? = null,

	@PrimaryKey
	@Json(name="id")
	val id: String = "",

	@Json(name="created_utc")
	val createdUtc: Double? = null,

	@Json(name="allow_live_comments")
	val allowLiveComments: Boolean? = null,

	@Json(name="media_embed")
	val mediaEmbed: MediaEmbed? = null,

	@Json(name="domain")
	val domain: String? = null,

	@Json(name="no_follow")
	val noFollow: Boolean? = null,

	@Json(name="ups")
	val ups: Int? = null,

	@Json(name="author_flair_type")
	val authorFlairType: String? = null,

	@Json(name="permalink")
	val permalink: String? = null,

	@Json(name="wls")
	val wls: Int? = null,

	@Json(name="gilded")
	val gilded: Int? = null,

	@Json(name="send_replies")
	val sendReplies: Boolean? = null,

	@Json(name="archived")
	val archived: Boolean? = null,

	@Json(name="can_mod_post")
	val canModPost: Boolean? = null,

	@Json(name="is_self")
	val isSelf: Boolean? = null,

	@Json(name="author_fullname")
	val authorFullname: String? = null,

	@Json(name="selftext")
	val selftext: String? = null,

	@Json(name="upvote_ratio")
	val upvoteRatio: Double? = null,

	@Json(name="selftext_html")
	val selftextHtml: String? = null,

	@Json(name="is_crosspostable")
	val isCrosspostable: Boolean? = null,

	@Json(name="clicked")
	val clicked: Boolean? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="parent_whitelist_status")
	val parentWhitelistStatus: String? = null,

	@Json(name="stickied")
	val stickied: Boolean? = null,

	@Json(name="author_is_blocked")
	val authorIsBlocked: Boolean? = null,

	@Json(name="quarantine")
	val quarantine: Boolean? = null,

	@Json(name="link_flair_background_color")
	val linkFlairBackgroundColor: String? = null,

	@Json(name="over_18")
	val over18: Boolean? = null,

	@Json(name="subreddit")
	val subreddit: String? = null,

	@Json(name="can_gild")
	val canGild: Boolean? = null,

	@Json(name="is_robot_indexable")
	val isRobotIndexable: Boolean? = null,

	@Json(name="is_created_from_ads_ui")
	val isCreatedFromAdsUi: Boolean? = null,

	@Json(name="author_premium")
	val authorPremium: Boolean? = null,

	@Json(name="locked")
	val locked: Boolean? = null,

	@Json(name="thumbnail")
	val thumbnail: String? = null,

	@Json(name="downs")
	val downs: Int? = null,

	@Json(name="created")
	val created: Double? = null,

	@Json(name="author")
	val author: String? = null,

	@Json(name="link_flair_text_color")
	val linkFlairTextColor: String? = null,

	@Json(name="is_video")
	val isVideo: Boolean? = null,

	@Json(name="is_original_content")
	val isOriginalContent: Boolean? = null,

	@Json(name="subreddit_name_prefixed")
	val subredditNamePrefixed: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="media_only")
	val mediaOnly: Boolean? = null,

	@Json(name="pinned")
	val pinned: Boolean? = null,

	@Json(name="hidden")
	val hidden: Boolean? = null,

	@Json(name="author_patreon_flair")
	val authorPatreonFlair: Boolean? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="num_crossposts")
	val numCrossposts: Int? = null,

	@Json(name="secure_media_embed")
	val secureMediaEmbed: SecureMediaEmbed? = null,

	@Json(name="subreddit_type")
	val subredditType: String? = null,

	@Json(name="is_meta")
	val isMeta: Boolean? = null,

	@Json(name="subreddit_subscribers")
	val subredditSubscribers: Int? = null,

	@Json(name="link_flair_type")
	val linkFlairType: String? = null,

	@Json(name="visited")
	val visited: Boolean? = null,

	@Json(name="pwls")
	val pwls: Int? = null,

	@Json(name="contest_mode")
	val contestMode: Boolean? = null,

	@Json(name="is_reddit_media_domain")
	val isRedditMediaDomain: Boolean? = null,

	@Json(name="url_overridden_by_dest")
	val urlOverriddenByDest: String? = null

) : Parcelable


@Parcelize
data class Oembed(

	@Json(name="author_name")
	val authorName: String? = null,

	@Json(name="provider_url")
	val providerUrl: String? = null,

	@Json(name="title")
	val title: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="thumbnail_url")
	val thumbnailUrl: String? = null,

	@Json(name="version")
	val version: String? = null,

	@Json(name="thumbnail_height")
	val thumbnailHeight: Int? = null,

	@Json(name="author_url")
	val authorUrl: String? = null,

	@Json(name="thumbnail_width")
	val thumbnailWidth: Int? = null,

	@Json(name="width")
	val width: Int? = null,

	@Json(name="html")
	val html: String? = null,

	@Json(name="provider_name")
	val providerName: String? = null,

	@Json(name="height")
	val height: Int? = null
) : Parcelable

@Parcelize
data class MediaEmbed(

	@Json(name="scrolling")
	val scrolling: Boolean? = null,

	@Json(name="width")
	val width: Int? = null,

	@Json(name="content")
	val content: String? = null,

	@Json(name="height")
	val height: Int? = null
) : Parcelable



@Parcelize
data class Media(

	@Json(name="oembed")
	val oembed: Oembed? = null,

	@Json(name="type")
	val type: String? = null
) : Parcelable

@Parcelize
data class SecureMediaEmbed(

	@Json(name="scrolling")
	val scrolling: Boolean? = null,

	@Json(name="media_domain_url")
	val mediaDomainUrl: String? = null,

	@Json(name="width")
	val width: Int? = null,

	@Json(name="content")
	val content: String? = null,

	@Json(name="height")
	val height: Int? = null
) : Parcelable

@Parcelize
data class ChildrenItem(

	@Json(name="data")
	val data: Data? = null,

	@Json(name="kind")
	val kind: String? = null
) : Parcelable

@Parcelize
data class SecureMedia(

	@Json(name="oembed")
	val oembed: Oembed? = null,

	@Json(name="type")
	val type: String? = null
) : Parcelable
