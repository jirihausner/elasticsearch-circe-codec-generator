package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.behaviors.{ CommonQueryParameters }
import com.converted.elasticsearch._types.{ Id, IndexName, SequenceNumber, Type, VersionNumber, VersionString }
import com.converted.elasticsearch._types.{ ErrorCause, MainError }
import com.converted.elasticsearch._types.{ integer, long }
import com.converted.elasticsearch._types.{ Result }
import com.converted.elasticsearch._types.{ ShardStatistics }
import com.converted.elasticsearch._types.{ DateString }

@JsonCodec case class RequestBase extends CommonQueryParameters


@JsonCodec case class WriteResponseBase(
	_id: Id, 
	_index: IndexName, 
	_primary_term: Long, 
	result: Result, 
	_seq_no: SequenceNumber, 
	_shards: ShardStatistics, 
	_type: Type, 
	_version: VersionNumber, 
	forced_refresh: Boolean, 
	error: ErrorCause
)


@JsonCodec case class AcknowledgedResponseBase(
	acknowledged: Boolean
)


@JsonCodec sealed trait DictionaryResponseBase[TKey, TValue]


@JsonCodec sealed trait DynamicResponseBase


@JsonCodec case class ElasticsearchVersionInfo(
	build_date: DateString, 
	build_flavor: String, 
	build_hash: String, 
	build_snapshot: Boolean, 
	build_type: String, 
	lucene_version: VersionString, 
	minimum_index_compatibility_version: VersionString, 
	minimum_wire_compatibility_version: VersionString, 
	number: String
)


@JsonCodec case class ErrorResponseBase(
	error: MainError | String, 
	status: integer
)


@JsonCodec case class IndicesResponseBase(
	_shards: ShardStatistics
) extends AcknowledgedResponseBase


@JsonCodec case class ShardsOperationResponseBase(
	_shards: ShardStatistics
)


@JsonCodec sealed trait CustomResponseBuilderBase

