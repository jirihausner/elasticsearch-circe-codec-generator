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

package org.elasticsearch.circecodecs.indices.put_index_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._indices._types.Alias.{ Alias }
import org.elasticsearch.circecodecs._indices._types.IndexSettings.{ IndexSettings }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ EmptyObject, IndexName, Indices, Metadata, Name, VersionNumber }
import org.elasticsearch.circecodecs._types.mapping.TypeMapping.{ TypeMapping }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class Body(
		index_patterns: Indices, 
		composed_of: Seq[Name], 
		template: IndexTemplateMapping, 
		data_stream: EmptyObject, 
		priority: integer, 
		version: VersionNumber, 
		_meta: Metadata
	)
}


@JsonCodec case class IndexTemplateMapping(
	aliases: Dictionary[IndexName, Alias], 
	mappings: TypeMapping, 
	settings: IndexSettings
)
