package com.converted.elasticsearch.eql._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.hits.{ TotalHits }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Id, IndexName }

@JsonCodec case class EqlHits[TEvent](
	total: TotalHits, 
	events: Array(HitsEvent(TEvent)), 
	sequences: Array(HitsSequence(TEvent))
)


@JsonCodec case class HitsEvent[TEvent](
	_index: IndexName, 
	_id: Id, 
	_source: TEvent, 
	fields: Dictionary(Field, Array(UserDefinedValue))
)


@JsonCodec case class HitsSequence[TEvent](
	events: Array(HitsEvent(TEvent)), 
	join_keys: Array(UserDefinedValue)
)

