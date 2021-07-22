package com.converted.elasticsearch.ml.get_calendar_events

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		calendar_id: Id
	)
	@JsonCodec case class QueryParameters(
		job_id: Id, 
		end: DateString, 
		from: integer, 
		start: String, 
		size: integer
	)
	@JsonCodec case class Body(
		end: DateString, 
		from: integer, 
		start: String, 
		size: integer
	)
}

