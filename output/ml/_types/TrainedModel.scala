package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.aggregations.pipeline.{ InferenceConfigContainer }
import com.converted.elasticsearch._types.common.{ Field, Id, Name, VersionString }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class TrainedModelStats(
	model_id: Id, 
	pipeline_count: integer, 
	inference_stats: TrainedModelInferenceStats, 
	ingest: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class TrainedModelInferenceStats(
	failure_count: long, 
	inference_count: long, 
	cache_miss_count: long, 
	missing_all_fields_count: long, 
	timestamp: Time
)

@JsonCodec case class TrainedModelConfig(
	model_id: Id, 
	tags: Array[String], 
	version: VersionString, 
	compressed_definition: String, 
	created_by: String, 
	create_time: Time, 
	default_field_map: Dictionary[String, String], 
	description: String, 
	estimated_heap_memory_usage_bytes: integer, 
	estimated_operations: integer, 
	inference_config: InferenceConfigContainer, 
	input: TrainedModelConfigInput, 
	license_level: String, 
	metadata: TrainedModelConfigMetadata
)

@JsonCodec case class TrainedModelConfigInput(
	field_names: Array[Field]
)

@JsonCodec case class TrainedModelConfigMetadata(
	model_aliases: Array[String], 
	feature_importance_baseline: Dictionary[String, String], 
	hyperparameters: Array[Hyperparameter], 
	total_feature_importance: Array[TotalFeatureImportance]
)

@JsonCodec case class Hyperparameter(
	absolute_importance: double, 
	name: Name, 
	relative_importance: double, 
	supplied: Boolean, 
	value: double
)

@JsonCodec case class TotalFeatureImportance(
	feature_name: Name, 
	importance: Array[TotalFeatureImportanceStatistics], 
	classes: Array[TotalFeatureImportanceClass]
)

@JsonCodec case class TotalFeatureImportanceClass(
	class_name: Name, 
	importance: Array[TotalFeatureImportanceStatistics]
)

@JsonCodec case class TotalFeatureImportanceStatistics(
	mean_magnitude: double, 
	max: integer, 
	min: integer
)
