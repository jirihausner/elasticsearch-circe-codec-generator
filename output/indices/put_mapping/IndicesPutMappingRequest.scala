package com.converted.elasticsearch.indices.put_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices, PropertyName, Type }
import com.converted.elasticsearch._types.mapping.dynamic-template.{ DynamicMapping, DynamicTemplate }
import com.converted.elasticsearch._types.mapping.meta-fields.{ AllField, FieldNamesField, IndexField, RoutingField, SizeField, SourceField }
import com.converted.elasticsearch._types.mapping.Property.{ Property }
import com.converted.elasticsearch._types.mapping.RuntimeFields.{ RuntimeFields }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_unavailable: Boolean, 
		include_type_name: Boolean, 
		master_timeout: Time, 
		timeout: Time, 
		write_index_only: Boolean
	)
	@JsonCodec case class Body(
		all_field: AllField, 
		date_detection: Boolean, 
		dynamic: Boolean | DynamicMapping, 
		dynamic_date_formats: Array[String], 
		dynamic_templates: Dictionary[String, DynamicTemplate] | Array[Dictionary[String, DynamicTemplate]], 
		field_names_field: FieldNamesField, 
		index_field: IndexField, 
		meta: Dictionary[String, UserDefinedValue], 
		numeric_detection: Boolean, 
		properties: Dictionary[PropertyName, Property], 
		routing_field: RoutingField, 
		size_field: SizeField, 
		source_field: SourceField, 
		runtime: RuntimeFields
	)
}

