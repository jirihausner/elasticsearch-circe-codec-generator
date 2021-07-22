package com.converted.elasticsearch.cluster.reroute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Metrics }
import com.converted.elasticsearch._types.Time.{ Time }
import com.converted.elasticsearch.cluster.reroute.{ Command }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		dry_run: Boolean, 
		explain: Boolean, 
		metric: Metrics, 
		retry_failed: Boolean, 
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
		commands: Seq[Command]
	)
}

