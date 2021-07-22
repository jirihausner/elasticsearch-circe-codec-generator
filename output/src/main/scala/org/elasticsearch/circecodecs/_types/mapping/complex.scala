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

package org.elasticsearch.circecodecs._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ PropertyName }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs._types.mapping.{ CorePropertyBase, IndexOptions }
import org.elasticsearch.circecodecs._types.mapping.{ DynamicMapping }
import org.elasticsearch.circecodecs._types.mapping.{ Property, PropertyBase }

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
