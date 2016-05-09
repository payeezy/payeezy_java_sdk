package com.firstdata.payeezy.models.transaction;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by FA7G14Q on 7/15/2015.
 */
@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.DEFAULT,setterVisibility= JsonAutoDetect.Visibility.DEFAULT,fieldVisibility= JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FraudScoreResponse {

    @JsonProperty("fraud_transaction_id")
    private String transactionId;
    @JsonProperty("cross_reference")
    private String crossReference;
    @JsonProperty("rules_tripped")
    private String rulesTripped;
    @JsonProperty("fraud_score")
    private String fraudScore;
    @JsonProperty("recommendation_code")
    private String recommendationCode;
    @JsonProperty("remarks")
    private String remarks;

      public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCrossReference() {
        return crossReference;
    }

    public void setCrossReference(String crossReference) {
        this.crossReference = crossReference;
    }

    public String getRulesTripped() {
        return rulesTripped;
    }

    public void setRulesTripped(String rulesTripped) {
        this.rulesTripped = rulesTripped;
    }

    public String getFraudScore() {
        return fraudScore;
    }

    public void setFraudScore(String fraudScore) {
        this.fraudScore = fraudScore;
    }

    public String getRecommendationCode() {
        return recommendationCode;
    }

    public void setRecommendationCode(String recommendationCode) {
        this.recommendationCode = recommendationCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
