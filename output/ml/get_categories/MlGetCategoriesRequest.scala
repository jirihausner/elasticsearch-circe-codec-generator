package com.converted.elasticsearch.ml.get_categories

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Page.{ Page }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ CategoryId, Id }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id, 
		category_id: CategoryId
	)
	@JsonCodec case class QueryParameters(
		from: integer, 
		size: integer, 
		partition_field_value: String
	)
	@JsonCodec case class Body(
		page: Page
	)
}

