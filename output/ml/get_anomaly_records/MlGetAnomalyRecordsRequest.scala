package com.converted.elasticsearch.ml.get_anomaly_records

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Page.{ Page }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field, Id }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id
	)
	@JsonCodec case class QueryParameters(
		exclude_interim: Boolean, 
		from: integer, 
		size: integer, 
		start: DateString, 
		end: DateString
	)
	@JsonCodec case class Body(
		desc: Boolean, 
		exclude_interim: Boolean, 
		page: Page, 
		record_score: double, 
		sort: Field, 
		start: DateString, 
		end: DateString
	)
}

