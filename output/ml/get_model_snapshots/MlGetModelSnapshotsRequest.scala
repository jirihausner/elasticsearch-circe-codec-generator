package com.converted.elasticsearch.ml.get_model_snapshots

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field, Id }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id, 
		snapshot_id: Id
	)
	@JsonCodec case class QueryParameters(
		desc: Boolean, 
		end: Time, 
		from: integer, 
		size: integer, 
		sort: Field, 
		start: Time
	)
	@JsonCodec case class Body(
		start: Time, 
		end: Time
	)
}

