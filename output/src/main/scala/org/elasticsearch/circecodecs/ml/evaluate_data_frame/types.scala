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

package org.elasticsearch.circecodecs.ml.evaluate_data_frame

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ Name }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer }

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
