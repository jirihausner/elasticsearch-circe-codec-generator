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

import { Field } from '@_types/common'
import { integer } from '@_types/Numeric'
import { DetectionRule } from './Rule'

export class Detector {
  by_field_name?: Field
  custom_rules?: DetectionRule[]
  detector_description?: string
  detector_index?: integer
  exclude_frequent?: ExcludeFrequent
  field_name?: Field
  function: string
  use_null?: boolean
  over_field_name?: Field
  partition_field_name?: Field
}

export enum ExcludeFrequent {
  all = 0,
  none = 1,
  by = 2,
  over = 3
}
