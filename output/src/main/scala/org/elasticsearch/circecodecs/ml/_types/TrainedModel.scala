/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.aggregations.pipeline.{ InferenceConfigContainer }
import org.elasticsearch.circecodecs._types.common.{ Field, Id, Name, VersionString }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs._types.Time.{ Time }

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
	tags: Seq[String], 
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
	field_names: Seq[Field]
)

@JsonCodec case class TrainedModelConfigMetadata(
	model_aliases: Seq[String], 
	feature_importance_baseline: Dictionary[String, String], 
	hyperparameters: Seq[Hyperparameter], 
	total_feature_importance: Seq[TotalFeatureImportance]
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
	importance: Seq[TotalFeatureImportanceStatistics], 
	classes: Seq[TotalFeatureImportanceClass]
)

@JsonCodec case class TotalFeatureImportanceClass(
	class_name: Name, 
	importance: Seq[TotalFeatureImportanceStatistics]
)

@JsonCodec case class TotalFeatureImportanceStatistics(
	mean_magnitude: double, 
	max: integer, 
	min: integer
)
