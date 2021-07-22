package com.converted.elasticsearch.ml.get_buckets

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Page.{ Page }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field, Id }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.Time.{ DateString, Timestamp }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id, 
		timestamp: Timestamp
	)
	@JsonCodec case class QueryParameters(
		from: integer, 
		size: integer, 
		exclude_interim: Boolean, 
		sort: Field, 
		desc: Boolean, 
		start: DateString, 
		end: DateString
	)
	@JsonCodec case class Body(
		anomaly_score: double, 
		desc: Boolean, 
		exclude_interim: Boolean, 
		expand: Boolean, 
		page: Page, 
		sort: Field, 
		start: DateString, 
		end: DateString
	)
}

