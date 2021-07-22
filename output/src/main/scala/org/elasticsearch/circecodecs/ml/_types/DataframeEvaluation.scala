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

package org.elasticsearch.circecodecs.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Field, Name }
import org.elasticsearch.circecodecs._types.Numeric.{ double }

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
