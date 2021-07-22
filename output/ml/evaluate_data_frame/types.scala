package com.converted.elasticsearch.ml.evaluate_data_frame

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Numeric.{ double, integer }

@JsonCodec case class DataframeOutlierDetectionSummary(
	auc_roc: DataframeEvaluationSummaryAucRoc, 
	precision: Dictionary[String, double], 
	recall: Dictionary[String, double], 
	confusion_matrix: Dictionary[String, ConfusionMatrixTreshold]
)

@JsonCodec case class DataframeClassificationSummary(
	auc_roc: DataframeEvaluationSummaryAucRoc, 
	accuracy: DataframeClassificationSummaryAccuracy, 
	multiclass_confusion_matrix: DataframeClassificationSummaryMulticlassConfusionMatrix, 
	precision: DataframeClassificationSummaryPrecision, 
	recall: DataframeClassificationSummaryRecall
)

@JsonCodec case class DataframeRegressionSummary(
	huber: DataframeEvaluationValue, 
	mse: DataframeEvaluationValue, 
	msle: DataframeEvaluationValue, 
	r_squared: DataframeEvaluationValue
)

@JsonCodec case class DataframeEvaluationValue(
	value: double
)

@JsonCodec case class DataframeEvaluationSummaryAucRoc(
	curve: Seq[DataframeEvaluationSummaryAucRocCurveItem]
) extends DataframeEvaluationValue

@JsonCodec case class DataframeEvaluationSummaryAucRocCurveItem(
	tpr: double, 
	fpr: double, 
	threshold: double
)

@JsonCodec case class DataframeClassificationSummaryPrecision(
	classes: Seq[DataframeEvaluationClass], 
	avg_precision: double
)

@JsonCodec case class DataframeClassificationSummaryRecall(
	classes: Seq[DataframeEvaluationClass], 
	avg_recall: double
)

@JsonCodec case class DataframeClassificationSummaryAccuracy(
	classes: Seq[DataframeEvaluationClass], 
	overall_accuracy: double
)

@JsonCodec case class DataframeEvaluationClass(
	class_name: Name
) extends DataframeEvaluationValue

@JsonCodec case class DataframeClassificationSummaryMulticlassConfusionMatrix(
	confusion_matrix: Seq[ConfusionMatrixItem], 
	other_actual_class_count: integer
)

@JsonCodec case class ConfusionMatrixItem(
	actual_class: Name, 
	actual_class_doc_count: integer, 
	predicted_classes: Seq[ConfusionMatrixPrediction], 
	other_predicted_class_doc_count: integer
)

@JsonCodec case class ConfusionMatrixPrediction(
	predicted_class: Name, 
	count: integer
)

@JsonCodec case class ConfusionMatrixTreshold(
	tp: integer, 
	fp: integer, 
	tn: integer, 
	fn: integer
)
