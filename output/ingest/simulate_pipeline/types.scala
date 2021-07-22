package com.converted.elasticsearch.ingest.simulate_pipeline

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._watcher._types.Action.{ ActionStatusOptions }
import com.converted.elasticsearch._types.common.{ Id, IndexName, Name, Type }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class Ingest(
	timestamp: DateString, 
	pipeline: Name
)

@JsonCodec case class PipelineSimulation(
	doc: DocumentSimulation, 
	processor_results: Seq[PipelineSimulation], 
	tag: String, 
	processor_type: String, 
	status: ActionStatusOptions
)

@JsonCodec case class Document(
	_id: Id, 
	_index: IndexName, 
	_source: UserDefinedValue
)

@JsonCodec case class DocumentSimulation(
	_id: Id, 
	_index: IndexName, 
	_ingest: Ingest, 
	_parent: String, 
	_routing: String, 
	_source: Dictionary[String, UserDefinedValue], 
	_type: Type
)
