package com.converted.elasticsearch.indices.get_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }

@JsonCodec case class Response extends DictionaryResponseBase[IndexName, IndexMappingRecord]

@JsonCodec case class IndexMappingRecord(
	item: TypeMapping, 
	mappings: TypeMapping
)
