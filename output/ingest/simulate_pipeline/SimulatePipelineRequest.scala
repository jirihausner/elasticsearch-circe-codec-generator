package com.converted.elasticsearch.ingest.simulate_pipeline

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ingest._types.Pipeline.{ Pipeline }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch.ingest.simulate_pipeline.{ Document }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class QueryParameters(
		verbose: Boolean
	)
	@JsonCodec case class Body(
		docs: Seq[Document], 
		pipeline: Pipeline
	)
}

