package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ PropertyName }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.mapping.{ CorePropertyBase, IndexOptions }
import com.converted.elasticsearch._types.mapping.{ DynamicMapping }
import com.converted.elasticsearch._types.mapping.{ Property, PropertyBase }

@JsonCodec case class FlattenedProperty(
	boost: double, 
	depth_limit: integer, 
	doc_values: Boolean, 
	eager_global_ordinals: Boolean, 
	index: Boolean, 
	index_options: IndexOptions, 
	null_value: String, 
	similarity: String, 
	split_queries_on_whitespace: Boolean, 
	`type`: "flattened""
) extends PropertyBase

@JsonCodec case class NestedProperty(
	enabled: Boolean, 
	include_in_parent: Boolean, 
	include_in_root: Boolean, 
	`type`: "nested""
) extends CorePropertyBase

@JsonCodec case class ObjectProperty(
	enabled: Boolean, 
	`type`: "object""
) extends CorePropertyBase
