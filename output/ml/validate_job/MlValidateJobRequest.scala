package com.converted.elasticsearch.ml.validate_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ AnalysisConfig, AnalysisLimits }
import com.converted.elasticsearch._ml._types.Job.{ DataDescription }
import com.converted.elasticsearch._ml._types.ModelPlot.{ ModelPlotConfig }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, IndexName }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Request(
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class Body(
		job_id: Id, 
		analysis_config: AnalysisConfig, 
		analysis_limits: AnalysisLimits, 
		data_description: DataDescription, 
		description: String, 
		model_plot: ModelPlotConfig, 
		model_snapshot_retention_days: Long, 
		results_index_name: IndexName
	)
}

