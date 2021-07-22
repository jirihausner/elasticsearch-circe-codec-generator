package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.scripts_painless_execute.types.{ PainlessExecutionPosition }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.{ HttpHeaders, Id, Ids, IndexName, Uuid }
import com.converted.elasticsearch._types.{ integer, long }

@JsonCodec case class ErrorCause(
	`type`: String, 
	reason: String, 
	caused_by: ErrorCause, 
	shard: integer | String, 
	stack_trace: String, 
	root_cause: Array(ErrorCause), 
	bytes_limit: long, 
	bytes_wanted: long, 
	column: integer, 
	col: integer, 
	failed_shards: Array(ShardFailure), 
	grouped: Boolean, 
	index: IndexName, 
	index_uuid: Uuid, 
	language: String, 
	licensed_expired_feature: String, 
	line: integer, 
	max_buckets: integer, 
	phase: String, 
	property_name: String, 
	processor_type: String, 
	resource_id: Ids, 
	resource_type: String, 
	script: String, 
	script_stack: Array(String), 
	header: HttpHeaders, 
	lang: String, 
	position: PainlessExecutionPosition
)


@JsonCodec case class MainError(
	headers: Dictionary(String, String), 
	root_cause: Array(ErrorCause)
) extends ErrorCause


@JsonCodec case class ShardFailure(
	index: IndexName, 
	node: String, 
	reason: ErrorCause, 
	shard: integer, 
	status: String
)


@JsonCodec case class BulkIndexByScrollFailure(
	cause: MainError, 
	id: Id, 
	index: IndexName, 
	status: integer, 
	`type`: String
)

