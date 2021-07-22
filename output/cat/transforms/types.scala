package com.converted.elasticsearch.cat.transforms

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, VersionString }

@JsonCodec case class TransformsRecord(
	id: Id, 
	state: String, 
	checkpoint: String, 
	documents_processed: String, 
	checkpoint_progress: String, 
	last_search_time: String, 
	changes_last_detection_time: String, 
	create_time: String, 
	version: VersionString, 
	source_index: String, 
	dest_index: String, 
	pipeline: String, 
	description: String, 
	transform_type: String, 
	frequency: String, 
	max_page_search_size: String, 
	docs_per_second: String, 
	reason: String, 
	search_total: String, 
	search_failure: String, 
	search_time: String, 
	index_total: String, 
	index_failure: String, 
	index_time: String, 
	documents_indexed: String, 
	delete_time: String, 
	documents_deleted: String, 
	trigger_count: String, 
	pages_processed: String, 
	processing_time: String, 
	checkpoint_duration_time_exp_avg: String, 
	indexed_documents_exp_avg: String, 
	processed_documents_exp_avg: String
)


object TransformState extends Enumeration {
	type TransformState = Value

val sTARTED = Value(0, "STARTED")
val iNDEXING = Value(1, "INDEXING")
val aBORTING = Value(2, "ABORTING")
val sTOPPING = Value(3, "STOPPING")
val sTOPPED = Value(4, "STOPPED")
val fAILED = Value(5, "FAILED")
}

implicit val transformStateDecoder: Decoder[TransformState.Value] = Decoder.decodeEnumeration(TransformState)
implicit val transformStateEncoder: Encoder[TransformState.Value] = Decoder.encodeEnumeration(TransformState)


object TransformType extends Enumeration {
	type TransformType = Value

val batch = Value(0, "batch")
val continuous = Value(1, "continuous")
}

implicit val transformTypeDecoder: Decoder[TransformType.Value] = Decoder.decodeEnumeration(TransformType)
implicit val transformTypeEncoder: Encoder[TransformType.Value] = Decoder.encodeEnumeration(TransformType)

