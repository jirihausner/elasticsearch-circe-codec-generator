package com.converted.elasticsearch.transform._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.aggregations.bucket.{ DateHistogramAggregation, GeoTileGridAggregation, HistogramAggregation, TermsAggregation }
import com.converted.elasticsearch._types.common.{ Field, IndexName, Indices }
import com.converted.elasticsearch._types.mapping.RuntimeFields.{ RuntimeFields }
import com.converted.elasticsearch._types.Numeric.{ float, integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Destination(
	index: IndexName, 
	pipeline: String
)

@JsonCodec case class Latest(
	sort: Field, 
	unique_key: Array(Field)
)

@JsonCodec case class Pivot(
	aggregations: Dictionary(String, AggregationContainer), 
	group_by: Dictionary(String, PivotGroupByContainer), 
	max_page_search_size: integer
)

@JsonCodec case class PivotGroupByContainer(
	date_histogram: DateHistogramAggregation, 
	geotile_grid: GeoTileGridAggregation, 
	histogram: HistogramAggregation, 
	terms: TermsAggregation
)

@JsonCodec case class RetentionPolicyContainer(
	time: RetentionPolicy
)

@JsonCodec case class RetentionPolicy(
	field: Field, 
	max_age: Time
)

@JsonCodec case class Settings(
	dates_as_epoch_millis: Boolean, 
	docs_per_second: float, 
	max_page_search_size: integer
)

@JsonCodec case class Source(
	index: Indices, 
	query: QueryContainer, 
	runtime_mappings: RuntimeFields
)

@JsonCodec sealed trait Sync

@JsonCodec case class SyncContainer(
	time: TimeSync
)

@JsonCodec case class TimeSync(
	delay: Time, 
	field: Field
)
