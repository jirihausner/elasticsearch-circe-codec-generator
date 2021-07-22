package com.converted.elasticsearch._global.msearch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.PointInTimeReference.{ PointInTimeReference }
import com.converted.elasticsearch._global.search._types.suggester.{ SuggestContainer }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices, SearchType }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._global.search.SearchResponse.{ Response as SearchResponse }

@JsonCodec case class Header(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	index: Indices, 
	preference: String, 
	request_cache: Boolean, 
	routing: String, 
	search_type: SearchType
)


@JsonCodec case class Body(
	aggregations: Dictionary(String, AggregationContainer), 
	aggs: Dictionary(String, AggregationContainer), 
	query: QueryContainer, 
	from: integer, 
	size: integer, 
	pit: PointInTimeReference, 
	track_total_hits: Boolean | integer, 
	suggest: SuggestContainer | Dictionary(String, SuggestContainer)
)


@JsonCodec case class SearchResult[TDocument](
	status: integer
) extends SearchResponse(TDocument)

