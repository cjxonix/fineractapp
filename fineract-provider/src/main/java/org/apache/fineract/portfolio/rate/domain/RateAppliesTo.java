/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.fineract.portfolio.rate.domain;

public enum RateAppliesTo {

  INVALID(0, "rateAppliesTo.invalid"),
  LOAN(1, "rateAppliesTo.loan");

  private final Integer value;
  private final String code;

  private RateAppliesTo(final Integer value, final String code) {
    this.value = value;
    this.code = code;
  }

  public Integer getValue() {
    return this.value;
  }

  public String getCode() {
    return this.code;
  }

  public static RateAppliesTo fromInt(final Integer rateAppliesTo) {
    RateAppliesTo rateAppliesToType = RateAppliesTo.INVALID;

    if (rateAppliesTo != null) {
      switch (rateAppliesTo) {
        case 1:
          rateAppliesToType = LOAN;
          break;
        default:
          rateAppliesToType = INVALID;
          break;
      }
    }

    return rateAppliesToType;
  }

  public boolean isLoanRate() {
    return this.value.equals(RateAppliesTo.LOAN.getValue());
  }

  public static Object[] validValues() {
    return new Object[]{RateAppliesTo.LOAN.getValue()};
  }
}
