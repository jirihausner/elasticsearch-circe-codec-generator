package com.converted.elasticsearch.rollup.create_rollup_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._rollup._types.Groupings.{ Groupings }
import com.converted.elasticsearch._rollup._types.Metric.{ FieldMetric }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, IndexName }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class Body(
		cron: String, 
		groups: Groupings, 
		index_pattern: String, 
		metrics: Array[FieldMetric], 
		page_size: long, 
		rollup_index: IndexName
	)
}

