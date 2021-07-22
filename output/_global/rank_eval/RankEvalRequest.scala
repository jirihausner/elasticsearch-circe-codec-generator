package com.converted.elasticsearch._global.rank_eval

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices }
import com.converted.elasticsearch._global.rank_eval.{ RankEvalMetric, RankEvalRequestItem }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_unavailable: Boolean, 
		search_type: String
	)
	@JsonCodec case class Body(
		requests: Seq[RankEvalRequestItem], 
		metric: RankEvalMetric
	)
}

