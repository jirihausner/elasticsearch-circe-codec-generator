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

package org.elasticsearch.circecodecs.ml.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.ml.types.Analysis.{ CategorizationAnalyzer }
import org.elasticsearch.circecodecs.types.common.{ VersionString }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }

@JsonCodec case class Defaults(
	anomaly_detectors: AnomalyDetectors, 
	datafeeds: Datafeeds
)

@JsonCodec case class NativeCode(
	build_hash: String, 
	version: VersionString
)

@JsonCodec case class Limits(
	max_model_memory_limit: String, 
	effective_max_model_memory_limit: String, 
	total_ml_memory: String
)

@JsonCodec case class Datafeeds(
	scroll_size: integer
)

@JsonCodec case class AnomalyDetectors(
	categorization_analyzer: CategorizationAnalyzer, 
	categorization_examples_limit: integer, 
	model_memory_limit: String, 
	model_snapshot_retention_days: integer, 
	daily_model_snapshot_retention_after_days: integer
)
