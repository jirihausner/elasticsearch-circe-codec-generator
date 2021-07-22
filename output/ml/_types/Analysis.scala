package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time, TimeSpan }
import com.converted.elasticsearch.ml._types.{ Detector }
import com.converted.elasticsearch._types.analysis.char_filters.{ CharFilter }
import com.converted.elasticsearch._types.analysis.tokenizers.{ Tokenizer }
import com.converted.elasticsearch._types.analysis.token_filters.{ TokenFilter }

@JsonCodec case class AnalysisConfig(
	bucket_span: TimeSpan, 
	categorization_field_name: Field, 
	categorization_filters: Seq[String], 
	detectors: Seq[Detector], 
	influencers: Seq[Field], 
	latency: Time, 
	multivariate_by_fields: Boolean, 
	per_partition_categorization: PerPartitionCategorization, 
	summary_count_field_name: Field, 
	categorization_analyzer: CategorizationAnalyzer | String
)

@JsonCodec case class PerPartitionCategorization(
	enabled: Boolean, 
	stop_on_warn: Boolean
)

@JsonCodec case class AnalysisLimits(
	categorization_examples_limit: long, 
	model_memory_limit: String
)

@JsonCodec case class AnalysisMemoryLimit(
	model_memory_limit: String
)

@JsonCodec case class CategorizationAnalyzer(
	filter: Seq[String | TokenFilter], 
	tokenizer: String | Tokenizer, 
	char_filter: Seq[String | CharFilter]
)
