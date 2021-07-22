package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Name }
import com.converted.elasticsearch._types.Numeric.{ double }

@JsonCodec case class DataframeEvaluationContainer(
	classification: DataframeEvaluationClassification, 
	outlier_detection: DataframeEvaluationOutlierDetection, 
	regression: DataframeEvaluationRegression
)

@JsonCodec case class DataframeEvaluationClassification(
	actual_field: Field, 
	predicted_field: Field, 
	top_classes_field: Field, 
	metrics: DataframeEvaluationClassificationMetrics
)

@JsonCodec case class DataframeEvaluationOutlierDetection(
	actual_field: Field, 
	predicted_probability_field: Field, 
	metrics: DataframeEvaluationOutlierDetectionMetrics
)

@JsonCodec case class DataframeEvaluationRegression(
	actual_field: Field, 
	predicted_field: Field, 
	metrics: DataframeEvaluationRegressionMetrics
)

@JsonCodec case class DataframeEvaluationMetrics(
	auc_roc: DataframeEvaluationClassificationMetricsAucRoc, 
	precision: Dictionary[String, UserDefinedValue], 
	recall: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class DataframeEvaluationClassificationMetrics(
	accuracy: Dictionary[String, UserDefinedValue], 
	multiclass_confusion_matrix: Dictionary[String, UserDefinedValue]
) extends DataframeEvaluationMetrics

@JsonCodec case class DataframeEvaluationOutlierDetectionMetrics(
	confusion_matrix: Dictionary[String, UserDefinedValue]
) extends DataframeEvaluationMetrics

@JsonCodec case class DataframeEvaluationClassificationMetricsAucRoc(
	class_name: Name, 
	include_curve: Boolean
)

@JsonCodec case class DataframeEvaluationRegressionMetrics(
	mse: Dictionary[String, UserDefinedValue], 
	msle: DataframeEvaluationRegressionMetricsMsle, 
	huber: DataframeEvaluationRegressionMetricsHuber, 
	r_squared: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class DataframeEvaluationRegressionMetricsMsle(
	offset: double
)

@JsonCodec case class DataframeEvaluationRegressionMetricsHuber(
	delta: double
)
