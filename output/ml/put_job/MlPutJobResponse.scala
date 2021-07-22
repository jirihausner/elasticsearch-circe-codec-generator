package com.converted.elasticsearch.ml.put_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ AnalysisConfig, AnalysisLimits }
import com.converted.elasticsearch._ml._types.Job.{ DataDescription }
import com.converted.elasticsearch._ml._types.ModelPlot.{ ModelPlotConfig }
import com.converted.elasticsearch._ml._types.Settings.{ CustomSettings }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ DateString, Time }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		allow_lazy_open: Boolean, 
		analysis_config: AnalysisConfig, 
		analysis_limits: AnalysisLimits, 
		background_persist_interval: Time, 
		create_time: DateString, 
		custom_settings: CustomSettings, 
		data_description: DataDescription, 
		daily_model_snapshot_retention_after_days: long, 
		groups: Array[String], 
		description: String, 
		job_id: Id, 
		job_type: String, 
		model_plot_config: ModelPlotConfig, 
		model_snapshot_id: Id, 
		model_snapshot_retention_days: long, 
		renormalization_window_days: long, 
		results_index_name: String, 
		results_retention_days: long
	)
}

