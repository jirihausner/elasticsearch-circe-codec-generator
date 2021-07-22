package com.converted.elasticsearch._global.bulk

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ InlineGet }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, IndexName, Routing, SequenceNumber, VersionNumber, VersionType }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class ResponseItemBase(
	_id: String | null, 
	_index: String, 
	status: integer, 
	error: ErrorCause, 
	_primary_term: long, 
	result: String, 
	_seq_no: SequenceNumber, 
	_shards: ShardStatistics, 
	_type: String, 
	_version: VersionNumber, 
	forced_refresh: Boolean, 
	get: InlineGet(Dictionary(String, UserDefinedValue))
)

@JsonCodec case class ResponseItemContainer(
	index: IndexResponseItem, 
	create: CreateResponseItem, 
	update: UpdateResponseItem, 
	delete: DeleteResponseItem
)

@JsonCodec case class IndexResponseItem extends ResponseItemBase

@JsonCodec case class CreateResponseItem extends ResponseItemBase

@JsonCodec case class UpdateResponseItem extends ResponseItemBase

@JsonCodec case class DeleteResponseItem extends ResponseItemBase

@JsonCodec case class Operation(
	_id: Id, 
	_index: IndexName, 
	retry_on_conflict: integer, 
	routing: Routing, 
	version: VersionNumber, 
	version_type: VersionType
)

@JsonCodec case class OperationContainer(
	index: IndexOperation, 
	create: CreateOperation, 
	update: UpdateOperation, 
	delete: DeleteOperation
)

@JsonCodec case class IndexOperation extends Operation

@JsonCodec case class CreateOperation extends Operation

@JsonCodec case class UpdateOperation extends Operation

@JsonCodec case class DeleteOperation extends Operation
