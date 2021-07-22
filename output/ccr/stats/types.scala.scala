package com.converted.elasticsearch.ccr.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ccr._types.FollowIndexStats.{ FollowIndexStats }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.common.{ Name, VersionNumber }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class AutoFollowedCluster(
	cluster_name: Name, 
	last_seen_metadata_version: VersionNumber, 
	time_since_last_check_millis: DateString
)


@JsonCodec case class AutoFollowStats(
	auto_followed_clusters: Array(AutoFollowedCluster), 
	number_of_failed_follow_indices: Long, 
	number_of_failed_remote_cluster_state_requests: Long, 
	number_of_successful_follow_indices: Long, 
	recent_auto_follow_errors: Array(ErrorCause)
)


@JsonCodec case class FollowStats(
	indices: Array(FollowIndexStats)
)

