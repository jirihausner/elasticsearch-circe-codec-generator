package com.converted.elasticsearch._global.rank_eval

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, IndexName, Type }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

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
	ratings: Array[DocumentRating], 
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
	unrated_docs: Array[UnratedDocument], 
	hits: Array[RankEvalHitItem], 
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
