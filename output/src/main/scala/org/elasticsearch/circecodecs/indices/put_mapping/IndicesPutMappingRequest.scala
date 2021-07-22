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

package org.elasticsearch.circecodecs.indices.put_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ ExpandWildcards, Indices, PropertyName, Type }
import org.elasticsearch.circecodecs._types.mapping.dynamic-template.{ DynamicMapping, DynamicTemplate }
import org.elasticsearch.circecodecs._types.mapping.meta-fields.{ AllField, FieldNamesField, IndexField, RoutingField, SizeField, SourceField }
import org.elasticsearch.circecodecs._types.mapping.Property.{ Property }
import org.elasticsearch.circecodecs._types.mapping.RuntimeFields.{ RuntimeFields }
import org.elasticsearch.circecodecs._types.Time.{ Time }

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
		dynamic_date_formats: Seq[String], 
		dynamic_templates: Dictionary[String, DynamicTemplate] | Seq[Dictionary[String, DynamicTemplate]], 
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

