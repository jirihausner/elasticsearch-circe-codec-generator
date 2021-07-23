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

package org.elasticsearch.circecodecs.indices.get_index_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.indices.types.Alias.{ Alias }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ IndexName, Metadata, Name, VersionNumber }
import org.elasticsearch.circecodecs.types.mapping.TypeMapping.{ TypeMapping }
import org.elasticsearch.circecodecs.types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		index_templates: Seq[IndexTemplateItem]
	)
}

@JsonCodec case class IndexTemplateItem(
	name: Name, 
	index_template: IndexTemplate
)

@JsonCodec case class IndexTemplate(
	index_patterns: Seq[Name], 
	composed_of: Seq[Name], 
	template: IndexTemplateSummary, 
	version: VersionNumber, 
	priority: long, 
	_meta: Metadata, 
	allow_auto_create: Boolean, 
	data_stream: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class IndexTemplateSummary(
	aliases: Dictionary[IndexName, Alias], 
	mappings: TypeMapping, 
	settings: Dictionary[String, UserDefinedValue]
)
