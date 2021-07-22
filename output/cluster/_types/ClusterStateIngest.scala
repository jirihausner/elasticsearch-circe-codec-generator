package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ingest._types.Processors.{ ProcessorContainer }
import com.converted.elasticsearch._types.common.{ Id, VersionNumber }

@JsonCodec case class ClusterStateIngest(
	pipeline: Seq[ClusterStateIngestPipeline]
)

@JsonCodec case class ClusterStateIngestPipeline(
	id: Id, 
	config: ClusterStateIngestPipelineConfig
)

@JsonCodec case class ClusterStateIngestPipelineConfig(
	description: String, 
	version: VersionNumber, 
	processors: Seq[ProcessorContainer]
)
