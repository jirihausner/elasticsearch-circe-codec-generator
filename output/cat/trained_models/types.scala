package com.converted.elasticsearch.cat.trained_models

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize, Id, VersionString }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class TrainedModelsRecord(
	id: Id, 
	created_by: String, 
	heap_size: ByteSize, 
	operations: String, 
	license: String, 
	create_time: DateString, 
	version: VersionString, 
	description: String, 
	`ingest.pipelines`: String, 
	`ingest.count`: String, 
	`ingest.time`: String, 
	`ingest.current`: String, 
	`ingest.failed`: String, 
	`data_frame.id`: String, 
	`data_frame.create_time`: String, 
	`data_frame.source_index`: String, 
	`data_frame.analysis`: String
)

