package com.converted.elasticsearch.ml.put_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ AnalysisConfig, AnalysisLimits }
import com.converted.elasticsearch._ml._types.Job.{ DataDescription }
import com.converted.elasticsearch._ml._types.ModelPlot.{ ModelPlotConfig }
import com.converted.elasticsearch._ml._types.Settings.{ CustomSettings }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, IndexName }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

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
		groups: Array(String), 
		description: String, 
		model_plot_config: ModelPlotConfig, 
		model_snapshot_retention_days: long, 
		results_index_name: IndexName, 
		results_retention_days: long
	)
}

