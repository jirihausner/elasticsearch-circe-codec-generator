package com.converted.elasticsearch.ml.update_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ PerPartitionCategorization, AnalysisMemoryLimit }
import com.converted.elasticsearch._ml._types.Detector.{ Detector }
import com.converted.elasticsearch._ml._types.ModelPlot.{ ModelPlotConfig }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
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
		analysis_limits: AnalysisMemoryLimit, 
		background_persist_interval: Time, 
		custom_settings: Dictionary[String, UserDefinedValue], 
		categorization_filters: Array[String], 
		description: String, 
		model_plot_config: ModelPlotConfig, 
		daily_model_snapshot_retention_after_days: long, 
		model_snapshot_retention_days: long, 
		renormalization_window_days: long, 
		results_retention_days: long, 
		groups: Array[String], 
		detectors: Array[Detector], 
		per_partition_categorization: PerPartitionCategorization
	)
}

