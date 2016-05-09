package com.firstdata.payeezy.models.transaction;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "transaction_type" 
 * (class com.firstdata.firstapi.service.transaction.payload.TransactionRequest), 
 * not marked as ignorable (11 known properties: "threeDomainSecureToken", "paymentMethod", "referenceNo", "descriptor", "card", "currency", 
 * "transactionType", "amount", "id", "billing", "transactionTag"])
 * @author f2ivckd
 *
 */

@JsonAutoDetect(getterVisibility= Visibility.DEFAULT,setterVisibility= Visibility.DEFAULT,fieldVisibility= Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class TransactionRequest {

	public TransactionRequest() {
	}

	@JsonProperty("rate_type")
	private String type;

	private String bin;

	@JsonProperty("transaction_type")
	private String transactionType;

	@JsonProperty("merchant_ref")
	private String referenceNo;

	@JsonProperty("mcc")
	private String mcc;
	
	@JsonProperty("method")
	private String paymentMethod;
	@JsonProperty("amount")
	private String amount;
	@JsonProperty("currency_code")
	private String currency;
	@JsonProperty("transaction_tag")
	private String transactionTag;

	@JsonProperty("credit_card")
	private Card card;
	@JsonProperty("token")
	private Token token;
	@JsonProperty("billing_address")
	private Address billing;
	
	@JsonProperty("split_tender_id")
	private String splitTenderId;
	
	@JsonProperty("soft_descriptors")
	private SoftDescriptor descriptor;
	
	@JsonProperty("split_shipment")
    private String splitShipment;
	
	@JsonProperty("3DS")
	private ThreeDomainSecureToken threeDomainSecureToken;
	
	@JsonProperty("eci_indicator")
    private String eciIndicator;
    
    @JsonProperty("level2")
    private Level2Properties level2Properties;
    
    @JsonProperty("level3")
    private Level3Properties level3Properties;
    
    @JsonProperty("paypal_transaction_details")
    private PaypalTransactionDetail paypal;
    

    @JsonProperty("tele_check")
	private TeleCheck teleCheck;
    
    @JsonProperty("valuelink")
    private ValueLink valuelink;
    

    @JsonProperty("direct_debit")
    private DebitCard debitCard;
    
    @JsonProperty("recurring_id")
    private String recurringId;
    
    // pass thru value for split tenders
    @JsonProperty("partial_redemption")
	private String partialRedemption;

    @JsonProperty("recurring")
    private Boolean recurring = Boolean.FALSE;

	@JsonProperty("request_origin")
	private TransactionRequestOrigin requestOrigin;

	private String origin;

	@JsonProperty("coupon")
	private CouponDetails couponDetails;

	@JsonProperty("loyalty")
	private Loyalty loyaltyDetails;

	@JsonProperty("member")
	private Member memberDetails;

	@JsonProperty("order_details")
	private OrderDetails orderDetails;

	@JsonProperty("sales_rep")
	private String salesRep;

	@JsonProperty("sales_ref_code")
	private String refCode;

	@JsonProperty("gift_message")
	private String giftMessage;

	@JsonProperty("sales_channel")
	private String salesChannel;

	@JsonProperty("gift_registry")
	private GiftRegistry giftRegistry;

	@JsonProperty("rate_reference")
	private RateReference rateReference;
	
	@JsonProperty("original_details")
	private OriginalDetails originalDetails;
	
	@JsonProperty("reversal_id")
	private String reversalId;

	@JsonProperty("post_date")
	private String postDate;

	@JsonProperty("gift_deposit_available")
	private String giftDepositAvailable;

	@JsonProperty("additional_shipping_details")
	private AdditionalShippingInfo additionalShipping;

	@JsonProperty("reference_3")
	private String reference3;

	@JsonProperty("user_name")
	private String userName;

	@JsonIgnore
	private boolean internalTransaction;

	public String getTransactionType() {
		return (transactionType != null ? transactionType.toLowerCase() : null);
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public ThreeDomainSecureToken getThreeDomainSecureToken() {
		return threeDomainSecureToken;
	}
	public void setThreeDomainSecureToken(ThreeDomainSecureToken threeDomainSecureToken) {
		this.threeDomainSecureToken = threeDomainSecureToken;
	}	
	
	public SoftDescriptor getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(SoftDescriptor descriptor) {
		this.descriptor = descriptor;
	}
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	
	public String getPaymentMethod() {
		return (paymentMethod != null ? paymentMethod.toLowerCase() : null);
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTransactionTag() {
		return transactionTag;
	}
	public void setTransactionTag(String transactionTag) {
		this.transactionTag = transactionTag;
	}

	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}

	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}

	public Address getBilling() {
		return billing;
	}
	public void setBilling(Address billing) {
		this.billing = billing;
	}

    public String getSplitShipment() {
        return splitShipment;
    }
    public void setSplitShipment(String splitShipment) {
        this.splitShipment = splitShipment;
    }
    
    public String getEciIndicator() {
        return eciIndicator;
    }
    
    public void setEciIndicator(String eciIndicator) {
        this.eciIndicator = eciIndicator;
    }
    
    public Level2Properties getLevel2Properties() {
        return level2Properties;
    }
    
    public void setLevel2Properties(Level2Properties level2Properties) {
        this.level2Properties = level2Properties;
    }
    
    public Level3Properties getLevel3Properties() {
        return level3Properties;
    }
    
    public void setLevel3Properties(Level3Properties level3Properties) {
        this.level3Properties = level3Properties;
    }
    
    public PaypalTransactionDetail getPaypal() {
        return paypal;
    }
    
    public void setPaypal(PaypalTransactionDetail paypal) {
        this.paypal = paypal;
    }


	/**
	 * @return the teleCheck
	 */
	public TeleCheck getTeleCheck() {
		return teleCheck;
	}
	/**
	 * @param teleCheck the teleCheck to set
	 */
	public void setTeleCheck(TeleCheck teleCheck) {
		this.teleCheck = teleCheck;
	}
	public String getSplitTenderId() {
		return splitTenderId;
	}
	public void setSplitTenderId(String splitTenderId) {
		this.splitTenderId = splitTenderId;
	}
	public ValueLink getValuelink() {
		return valuelink;
	}
	public void setValuelink(ValueLink valuelink) {
		this.valuelink = valuelink;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	/**
	 * @return the debitCard
	 */
	public DebitCard getDebitCard() {
		return debitCard;
	}
	
	/**
	 * @param debitCard the debitCard to set
	 */
	public void setDebitCard(DebitCard debitCard) {
		this.debitCard = debitCard;
	}
	
	/**
	 * @return the recurringId
	 */
	public String getRecurringId() {
		return recurringId;
	}
	/**
	 * @param recurringId the recurringId to set
	 */
	public void setRecurringId(String recurringId) {
		this.recurringId = recurringId;
	}

	public String getPartialRedemption() {
		return partialRedemption;
	}
	public void setPartialRedemption(String partialRedemption) {
		this.partialRedemption = partialRedemption;
	}
	/**
	 * @return the recurring
	 */
	@JsonIgnore
	public boolean isRecurring() {
		return recurring;
	}
	/**
	 * @param recurring the recurring to set
	 */
	public void setRecurring(Boolean recurring) {
		this.recurring = recurring;
	}

	@JsonProperty("customer")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CouponDetails getCouponDetails() {
		return couponDetails;
	}

	public void setCouponDetails(CouponDetails couponDetails) {
		this.couponDetails = couponDetails;
	}

	public Loyalty getLoyaltyDetails() {
		return loyaltyDetails;
	}

	public void setLoyaltyDetails(Loyalty loyaltyDetails) {
		this.loyaltyDetails = loyaltyDetails;
	}

	public Member getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(Member memberDetails) {
		this.memberDetails = memberDetails;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getSalesRep() {
		return salesRep;
	}

	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
	}

	public String getGiftMessage() {
		return giftMessage;
	}

	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}

	public String getRefCode() {
		return refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public TransactionRequestOrigin getRequestOrigin() {
		return requestOrigin;
	}

	public void setRequestOrigin(TransactionRequestOrigin requestOrigin) {
		this.requestOrigin = requestOrigin;
	}

	public String getSalesChannel() {
		return salesChannel;
	}

	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}

	public GiftRegistry getGiftRegistry() {
		return giftRegistry;
	}

	public void setGiftRegistry(GiftRegistry giftRegistry) {
		this.giftRegistry = giftRegistry;
	}

	public RateReference getRateReference() {
		return rateReference;
	}
	
	public void setRateReference(RateReference rateReference) {
		this.rateReference = rateReference;
	}
	
	/**
	 * @return the reversalId
	 */
	public String getReversalId() {
		return reversalId;
	}
	/**
	 * @param reversalId the reversalId to set
	 */
	public void setReversalId(String reversalId) {
		this.reversalId = reversalId;
	}
	public OriginalDetails getOriginalDetails() {
		return originalDetails;
	}
	public void setOriginalDetails(OriginalDetails originalDetails) {
		this.originalDetails = originalDetails;
	}

	public boolean isInternalTransaction() {
		return internalTransaction;
	}

	public void setInternalTransaction(boolean internalTransacion) {
		this.internalTransaction = internalTransacion;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getGiftDepositAvailable() {
		return giftDepositAvailable;
	}

	public void setGiftDepositAvailable(String giftDepositAvailable) {
		this.giftDepositAvailable = giftDepositAvailable;
	}

	public AdditionalShippingInfo getAdditionalShipping() {
		return additionalShipping;
	}

	public void setAdditionalShipping(AdditionalShippingInfo additionalShipping) {
		this.additionalShipping = additionalShipping;
	}

	public String getReference3() {
		return reference3;
	}

	public void setReference3(String reference3) {
		this.reference3 = reference3;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}
}
