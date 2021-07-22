package com.converted.elasticsearch.ccr.get_auto_follow_pattern

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexPattern, IndexPatterns, Name }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class AutoFollowPattern(
	name: Name, 
	pattern: AutoFollowPatternSummary
)


@JsonCodec case class AutoFollowPatternSummary(
	active: Boolean, 
	remote_cluster: String, 
	follow_index_pattern: IndexPattern, 
	leader_index_patterns: IndexPatterns, 
	max_outstanding_read_requests: integer
)

