package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Fields }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

object BoundaryScanner extends Enumeration {
	type BoundaryScanner = Value

val chars = Value(0, "chars")
val sentence = Value(1, "sentence")
val word = Value(2, "word")
}

implicit val boundaryScannerDecoder: Decoder[BoundaryScanner.Value] = Decoder.decodeEnumeration(BoundaryScanner)
implicit val boundaryScannerEncoder: Encoder[BoundaryScanner.Value] = Decoder.encodeEnumeration(BoundaryScanner)


@JsonCodec case class Highlight(
	fields: Dictionary(Field, HighlightField), 
	`type`: HighlighterType, 
	boundary_chars: String, 
	boundary_max_scan: integer, 
	boundary_scanner: BoundaryScanner, 
	boundary_scanner_locale: String, 
	encoder: HighlighterEncoder, 
	fragmenter: HighlighterFragmenter, 
	fragment_offset: integer, 
	fragment_size: integer, 
	max_fragment_length: integer, 
	no_match_size: integer, 
	number_of_fragments: integer, 
	order: HighlighterOrder, 
	post_tags: Array(String), 
	pre_tags: Array(String), 
	require_field_match: Boolean, 
	tags_schema: HighlighterTagsSchema, 
	highlight_query: QueryContainer, 
	max_analyzed_offset: String | integer
)


object HighlighterEncoder extends Enumeration {
	type HighlighterEncoder = Value

val default = Value(0, "default")
val html = Value(1, "html")
}

implicit val highlighterEncoderDecoder: Decoder[HighlighterEncoder.Value] = Decoder.decodeEnumeration(HighlighterEncoder)
implicit val highlighterEncoderEncoder: Encoder[HighlighterEncoder.Value] = Decoder.encodeEnumeration(HighlighterEncoder)


object HighlighterFragmenter extends Enumeration {
	type HighlighterFragmenter = Value

val simple = Value(0, "simple")
val span = Value(1, "span")
}

implicit val highlighterFragmenterDecoder: Decoder[HighlighterFragmenter.Value] = Decoder.decodeEnumeration(HighlighterFragmenter)
implicit val highlighterFragmenterEncoder: Encoder[HighlighterFragmenter.Value] = Decoder.encodeEnumeration(HighlighterFragmenter)


object HighlighterOrder extends Enumeration {
	type HighlighterOrder = Value

val score = Value(0, "score")
}

implicit val highlighterOrderDecoder: Decoder[HighlighterOrder.Value] = Decoder.decodeEnumeration(HighlighterOrder)
implicit val highlighterOrderEncoder: Encoder[HighlighterOrder.Value] = Decoder.encodeEnumeration(HighlighterOrder)


object HighlighterTagsSchema extends Enumeration {
	type HighlighterTagsSchema = Value

val styled = Value(0, "styled")
}

implicit val highlighterTagsSchemaDecoder: Decoder[HighlighterTagsSchema.Value] = Decoder.decodeEnumeration(HighlighterTagsSchema)
implicit val highlighterTagsSchemaEncoder: Encoder[HighlighterTagsSchema.Value] = Decoder.encodeEnumeration(HighlighterTagsSchema)


object HighlighterType extends Enumeration {
	type HighlighterType = Value

val plain = Value(0, "plain")
val fvh = Value(1, "fvh")
val unified = Value(2, "unified")
}

implicit val highlighterTypeDecoder: Decoder[HighlighterType.Value] = Decoder.decodeEnumeration(HighlighterType)
implicit val highlighterTypeEncoder: Encoder[HighlighterType.Value] = Decoder.encodeEnumeration(HighlighterType)


@JsonCodec case class HighlightField(
	boundary_chars: String, 
	boundary_max_scan: integer, 
	boundary_scanner: BoundaryScanner, 
	boundary_scanner_locale: String, 
	field: Field, 
	force_source: Boolean, 
	fragmenter: HighlighterFragmenter, 
	fragment_offset: integer, 
	fragment_size: integer, 
	highlight_query: QueryContainer, 
	matched_fields: Fields, 
	max_fragment_length: integer, 
	no_match_size: integer, 
	number_of_fragments: integer, 
	order: HighlighterOrder, 
	phrase_limit: integer, 
	post_tags: Array(String), 
	pre_tags: Array(String), 
	require_field_match: Boolean, 
	tags_schema: HighlighterTagsSchema, 
	`type`: HighlighterType | String
)

