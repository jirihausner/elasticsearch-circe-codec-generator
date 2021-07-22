package com.converted.elasticsearch.enrich.execute_policy

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ TaskId }
import com.converted.elasticsearch.enrich.execute_policy.{ ExecuteEnrichPolicyStatus }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		status: ExecuteEnrichPolicyStatus, 
		task_id: TaskId
	)
}

