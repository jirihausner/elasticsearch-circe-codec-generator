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

package org.elasticsearch.circecodecs._global.rank_eval

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Id, IndexName, Type }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class RankEvalMetricBase(
	k: integer
)

@JsonCodec case class RankEvalMetricRatingTreshold(
	relevant_rating_threshold: integer
) extends RankEvalMetricBase

@JsonCodec case class RankEvalMetricPrecision(
	ignore_unlabeled: Boolean
) extends RankEvalMetricRatingTreshold

@JsonCodec case class RankEvalMetricRecall extends RankEvalMetricRatingTreshold

@JsonCodec case class RankEvalMetricMeanReciprocalRank extends RankEvalMetricRatingTreshold

@JsonCodec case class RankEvalMetricDiscountedCumulativeGain(
	normalize: Boolean
) extends RankEvalMetricBase

@JsonCodec case class RankEvalMetricExpectedReciprocalRank(
	maximum_relevance: integer
) extends RankEvalMetricBase

@JsonCodec case class RankEvalMetric(
	precision: RankEvalMetricPrecision, 
	recall: RankEvalMetricRecall, 
	mean_reciprocal_rank: RankEvalMetricMeanReciprocalRank, 
	dcg: RankEvalMetricDiscountedCumulativeGain, 
	expected_reciprocal_rank: RankEvalMetricExpectedReciprocalRank
)

@JsonCodec case class RankEvalRequestItem(
	id: Id, 
	request: RankEvalQuery, 
	ratings: Seq[DocumentRating], 
	template_id: Id, 
	params: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class RankEvalQuery(
	query: QueryContainer, 
	size: integer
)

@JsonCodec case class DocumentRating(
	_id: Id, 
	_index: IndexName, 
	rating: integer
)

@JsonCodec case class RankEvalMetricDetail(
	metric_score: double, 
	unrated_docs: Seq[UnratedDocument], 
	hits: Seq[RankEvalHitItem], 
	metric_details: Dictionary[String, Dictionary[String, UserDefinedValue]]
)

@JsonCodec case class RankEvalHitItem(
	hit: RankEvalHit, 
	rating: double
)

@JsonCodec case class RankEvalHit(
	_id: Id, 
	_index: IndexName, 
	_type: Type, 
	_score: double
)

@JsonCodec case class UnratedDocument(
	_id: Id, 
	_index: IndexName
)
