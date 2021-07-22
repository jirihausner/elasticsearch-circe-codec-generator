package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ ByteSize, Field, Id, IndexName, Indices, Name, VersionString }
import com.converted.elasticsearch._types.mapping.RuntimeFields.{ RuntimeFields }
import com.converted.elasticsearch._types.Node.{ NodeAttributes }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long, Percentage }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ DateString }
import com.converted.elasticsearch.ml._types.{ DataframeState }

@JsonCodec case class DataframeAnalyticsSource(
	index: Indices, 
	query: QueryContainer, 
	_source: DataframeAnalysisAnalyzedFields, 
	runtime_mappings: RuntimeFields
)

@JsonCodec case class DataframeAnalyticsFieldSelection(
	is_included: Boolean, 
	is_required: Boolean, 
	feature_type: String, 
	mapping_types: Array(String), 
	name: Field, 
	reason: String
)

@JsonCodec case class DataframeAnalyticsMemoryEstimation(
	expected_memory_with_disk: String, 
	expected_memory_without_disk: String
)

@JsonCodec case class DataframeAnalyticsDestination(
	index: IndexName, 
	results_field: Field
)

@JsonCodec case class DataframeAnalysisContainer(
	outlier_detection: DataframeAnalysisOutlierDetection, 
	regression: DataframeAnalysisRegression, 
	classification: DataframeAnalysisClassification
)

@JsonCodec case class DataframeAnalysisOutlierDetection(
	n_neighbors: integer, 
	method: String, 
	feature_influence_threshold: double, 
	compute_feature_influence: Boolean, 
	outlier_fraction: double, 
	standardization_enabled: Boolean
)

@JsonCodec case class DataframeAnalysis(
	dependent_variable: String, 
	prediction_field_name: Field, 
	alpha: double, 
	lambda: double, 
	gamma: double, 
	eta: double, 
	eta_growth_rate_per_tree: double, 
	feature_bag_fraction: double, 
	max_trees: integer, 
	soft_tree_depth_limit: integer, 
	soft_tree_depth_tolerance: double, 
	downsample_factor: double, 
	max_optimization_rounds_per_hyperparameter: integer, 
	early_stopping_enabled: Boolean, 
	num_top_feature_importance_values: integer, 
	feature_processors: Array(DataframeAnalysisFeatureProcessor), 
	randomize_seed: double, 
	training_percent: Percentage
)

@JsonCodec case class DataframeAnalysisRegression(
	loss_function: String, 
	loss_function_parameter: double
) extends DataframeAnalysis

@JsonCodec case class DataframeAnalysisClassification(
	class_assignment_objective: String, 
	num_top_classes: integer
) extends DataframeAnalysis
type DataframeAnalysisAnalyzedFields = Array(String) | DataframeAnalysisAnalyzedFieldsIncludeExclude

@JsonCodec case class DataframeAnalysisAnalyzedFieldsIncludeExclude(
	includes: Array(String), 
	excludes: Array(String)
)

@JsonCodec case class DataframeAnalysisFeatureProcessor(
	frequency_encoding: DataframeAnalysisFeatureProcessorFrequencyEncoding, 
	multi_encoding: DataframeAnalysisFeatureProcessorMultiEncoding, 
	n_gram_encoding: DataframeAnalysisFeatureProcessorNGramEncoding, 
	one_hot_encoding: DataframeAnalysisFeatureProcessorOneHotEncoding, 
	target_mean_encoding: DataframeAnalysisFeatureProcessorTargetMeanEncoding
)

@JsonCodec case class DataframeAnalysisFeatureProcessorFrequencyEncoding(
	feature_name: Name, 
	field: Field, 
	frequency_map: Dictionary(String, double)
)

@JsonCodec case class DataframeAnalysisFeatureProcessorMultiEncoding(
	processors: Array(integer)
)

@JsonCodec case class DataframeAnalysisFeatureProcessorNGramEncoding(
	feature_prefix: String, 
	field: Field, 
	length: integer, 
	n_grams: Array(integer), 
	start: integer, 
	custom: Boolean
)

@JsonCodec case class DataframeAnalysisFeatureProcessorOneHotEncoding(
	field: Field, 
	hot_map: String
)

@JsonCodec case class DataframeAnalysisFeatureProcessorTargetMeanEncoding(
	default_value: integer, 
	feature_name: Name, 
	field: Field, 
	target_map: Dictionary(String, UserDefinedValue)
)

@JsonCodec case class DataframeAnalyticsSummary(
	id: Id, 
	source: DataframeAnalyticsSource, 
	dest: DataframeAnalyticsDestination, 
	analysis: DataframeAnalysisContainer, 
	description: String, 
	model_memory_limit: String, 
	max_num_threads: integer, 
	analyzed_fields: DataframeAnalysisAnalyzedFields, 
	allow_lazy_start: Boolean, 
	create_time: long, 
	version: VersionString
)

@JsonCodec case class DataframeAnalytics(
	analysis_stats: DataframeAnalyticsStatsContainer, 
	assignment_explanation: String, 
	data_counts: DataframeAnalyticsStatsDataCounts, 
	id: Id, 
	memory_usage: DataframeAnalyticsStatsMemoryUsage, 
	node: NodeAttributes, 
	progress: Array(DataframeAnalyticsStatsProgress), 
	state: DataframeState
)

@JsonCodec case class DataframeAnalyticsStatsProgress(
	phase: String, 
	progress_percent: integer
)

@JsonCodec case class DataframeAnalyticsStatsMemoryUsage(
	memory_reestimate_bytes: long, 
	peak_usage_bytes: long, 
	status: String, 
	timestamp: DateString
)

@JsonCodec case class DataframeAnalyticsStatsDataCounts(
	skipped_docs_count: integer, 
	test_docs_count: integer, 
	training_docs_count: integer
)

@JsonCodec case class DataframeAnalyticsStatsContainer(
	classification_stats: DataframeAnalyticsStatsHyperparameters, 
	outlier_detection_stats: DataframeAnalyticsStatsOutlierDetection, 
	regression_stats: DataframeAnalyticsStatsHyperparameters
)

@JsonCodec case class DataframeAnalyticsStatsHyperparameters(
	hyperparameters: Hyperparameters, 
	iteration: integer, 
	timestamp: DateString, 
	timing_stats: TimingStats, 
	validation_loss: ValidationLoss
)

@JsonCodec case class DataframeAnalyticsStatsOutlierDetection(
	parameters: OutlierDetectionParameters, 
	timestamp: DateString, 
	timing_stats: TimingStats
)

@JsonCodec case class Hyperparameters(
	alpha: double, 
	lambda: double, 
	gamma: double, 
	eta: double, 
	eta_growth_rate_per_tree: double, 
	feature_bag_fraction: double, 
	downsample_factor: double, 
	max_attempts_to_add_tree: integer, 
	max_optimization_rounds_per_hyperparameter: integer, 
	max_trees: integer, 
	num_folds: integer, 
	num_splits_per_feature: integer, 
	soft_tree_depth_limit: integer, 
	soft_tree_depth_tolerance: double
)

@JsonCodec case class OutlierDetectionParameters(
	compute_feature_influence: Boolean, 
	feature_influence_threshold: double, 
	method: String, 
	n_neighbors: integer, 
	outlier_fraction: double, 
	standardization_enabled: Boolean
)

@JsonCodec case class TimingStats(
	elapsed_time: integer, 
	iteration_time: integer
)

@JsonCodec case class ValidationLoss(
	fold_values: Array(String), 
	loss_type: String
)
