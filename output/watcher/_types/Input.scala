package com.converted.elasticsearch.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search_template.SearchTemplateRequest.{ Request as SearchTemplateRequest }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, IndexName, Password, SearchType, Username }
import com.converted.elasticsearch._types.Networking.{ Host }
import com.converted.elasticsearch._types.Numeric.{ uint }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class ChainInput(
	inputs: Seq[InputContainer]
)

object ConnectionScheme extends Enumeration {
	type ConnectionScheme = Value

	val http = Value(0, "http")
	val https = Value(1, "https")
}

implicit val connectionSchemeDecoder: Decoder[ConnectionScheme.Value] = Decoder.decodeEnumeration(ConnectionScheme)
implicit val connectionSchemeEncoder: Encoder[ConnectionScheme.Value] = Decoder.encodeEnumeration(ConnectionScheme)

@JsonCodec case class HttpInput(
	http: HttpInput, 
	extract: Seq[String], 
	request: HttpInputRequestDefinition, 
	response_content_type: ResponseContentType
)

@JsonCodec case class HttpInputAuthentication(
	basic: HttpInputBasicAuthentication
)

@JsonCodec case class HttpInputBasicAuthentication(
	password: Password, 
	username: Username
)

object HttpInputMethod extends Enumeration {
	type HttpInputMethod = Value

	val head = Value(0, "head")
	val get = Value(1, "get")
	val post = Value(2, "post")
	val put = Value(3, "put")
	val delete = Value(4, "delete")
}

implicit val httpInputMethodDecoder: Decoder[HttpInputMethod.Value] = Decoder.decodeEnumeration(HttpInputMethod)
implicit val httpInputMethodEncoder: Encoder[HttpInputMethod.Value] = Decoder.encodeEnumeration(HttpInputMethod)

@JsonCodec case class HttpInputProxy(
	host: Host, 
	port: uint
)

@JsonCodec case class HttpInputRequestDefinition(
	auth: HttpInputAuthentication, 
	body: String, 
	connection_timeout: Time, 
	headers: Dictionary[String, String], 
	host: Host, 
	method: HttpInputMethod, 
	params: Dictionary[String, String], 
	path: String, 
	port: uint, 
	proxy: HttpInputProxy, 
	read_timeout: Time, 
	scheme: ConnectionScheme, 
	url: String
)

@JsonCodec case class IndicesOptions(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	ignore_throttled: Boolean
)

@JsonCodec sealed trait Input

@JsonCodec case class InputContainer(
	chain: ChainInput, 
	http: HttpInput, 
	search: SearchInput, 
	simple: Dictionary[String, UserDefinedValue]
)

object InputType extends Enumeration {
	type InputType = Value

	val http = Value(0, "http")
	val search = Value(1, "search")
	val simple = Value(2, "simple")
}

implicit val inputTypeDecoder: Decoder[InputType.Value] = Decoder.decodeEnumeration(InputType)
implicit val inputTypeEncoder: Encoder[InputType.Value] = Decoder.encodeEnumeration(InputType)

object ResponseContentType extends Enumeration {
	type ResponseContentType = Value

	val json = Value(0, "json")
	val yaml = Value(1, "yaml")
	val text = Value(2, "text")
}

implicit val responseContentTypeDecoder: Decoder[ResponseContentType.Value] = Decoder.decodeEnumeration(ResponseContentType)
implicit val responseContentTypeEncoder: Encoder[ResponseContentType.Value] = Decoder.encodeEnumeration(ResponseContentType)

@JsonCodec case class SearchInput(
	extract: Seq[String], 
	request: SearchInputRequestDefinition, 
	timeout: Time
)

@JsonCodec case class SearchInputRequestDefinition(
	body: SearchInputRequestBody, 
	indices: Seq[IndexName], 
	indices_options: IndicesOptions, 
	search_type: SearchType, 
	template: SearchTemplateRequest, 
	rest_total_hits_as_int: Boolean
)

@JsonCodec case class SearchInputRequestBody(
	query: QueryContainer
)

@JsonCodec case class SimpleInput(
	payload: Dictionary[String, UserDefinedValue]
)
