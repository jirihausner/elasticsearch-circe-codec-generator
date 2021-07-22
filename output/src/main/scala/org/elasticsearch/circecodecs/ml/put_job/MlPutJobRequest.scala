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

package org.elasticsearch.circecodecs.ml.put_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._ml._types.Analysis.{ AnalysisConfig, AnalysisLimits }
import org.elasticsearch.circecodecs._ml._types.Job.{ DataDescription }
import org.elasticsearch.circecodecs._ml._types.ModelPlot.{ ModelPlotConfig }
import org.elasticsearch.circecodecs._ml._types.Settings.{ CustomSettings }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ Id, IndexName }
import org.elasticsearch.circecodecs._types.Numeric.{ long }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id
	)
	@JsonCodec case class Body(
		allow_lazy_open: Boolean, 
		analysis_config: AnalysisConfig, 
		analysis_limits: AnalysisLimits, 
		background_persist_interval: Time, 
		custom_settings: CustomSettings, 
		data_description: DataDescription, 
		daily_model_snapshot_retention_after_days: long, 
		groups: Seq[String], 
		description: String, 
		model_plot_config: ModelPlotConfig, 
		model_snapshot_retention_days: long, 
		results_index_name: IndexName, 
		results_retention_days: long
	)
}
