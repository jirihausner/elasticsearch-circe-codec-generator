package com.converted.elasticsearch.ingest._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ VersionNumber }
import com.converted.elasticsearch.ingest._types.{ ProcessorContainer }

@JsonCodec case class Pipeline(
	description: String, 
	on_failure: Seq[ProcessorContainer], 
	processors: Seq[ProcessorContainer], 
	version: VersionNumber
)

object PipelineFailure extends Enumeration {
	type PipelineFailure = Value

	val badAuthentication = Value(0, "BadAuthentication")
	val badResponse = Value(1, "BadResponse")
	val pingFailure = Value(2, "PingFailure")
	val sniffFailure = Value(3, "SniffFailure")
	val couldNotStartSniffOnStartup = Value(4, "CouldNotStartSniffOnStartup")
	val maxTimeoutReached = Value(5, "MaxTimeoutReached")
	val maxRetriesReached = Value(6, "MaxRetriesReached")
	val unexpected = Value(7, "Unexpected")
	val badRequest = Value(8, "BadRequest")
	val noNodesAttempted = Value(9, "NoNodesAttempted")
}

implicit val pipelineFailureDecoder: Decoder[PipelineFailure.Value] = Decoder.decodeEnumeration(PipelineFailure)
implicit val pipelineFailureEncoder: Encoder[PipelineFailure.Value] = Decoder.encodeEnumeration(PipelineFailure)

@JsonCodec case class PipelineConfig(
	description: String, 
	version: VersionNumber, 
	processors: Seq[ProcessorContainer]
)
