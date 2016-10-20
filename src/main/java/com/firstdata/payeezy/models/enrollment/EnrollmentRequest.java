package com.firstdata.payeezy.models.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollmentRequest extends ConnectPayTokenRequest {

	@JsonProperty("applicaiton")
	private EnrollmentApp enrollmentApplication;
	
	@JsonProperty("user")
	private EnrollmentUser enrollmentUser;
	
	@JsonProperty("additional_info")
	private AdditionalPersonalInfo additionalPersonalInfo;

	@JsonProperty("reason")
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	// for physical cards
	// may have to pass card id and pin
	
	@JsonProperty("enrollment_id")
	private String enrollmentId;
	
	@JsonProperty("pin")
	private String pin;
	

	

	public EnrollmentApp getEnrollmentApplication() {
		return enrollmentApplication;
	}

	public void setEnrollmentApplication(EnrollmentApp enrollmentApplication) {
		this.enrollmentApplication = enrollmentApplication;
	}

	public EnrollmentUser getEnrollmentUser() {
		return enrollmentUser;
	}

	public void setEnrollmentUser(EnrollmentUser enrollmentUser) {
		this.enrollmentUser = enrollmentUser;
	}

	public AdditionalPersonalInfo getAdditionalPersonalInfo() {
		return additionalPersonalInfo;
	}

	public void setAdditionalPersonalInfo(
			AdditionalPersonalInfo additionalPersonalInfo) {
		this.additionalPersonalInfo = additionalPersonalInfo;
	}

	public String getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}


	
	public static class EnrollmentUser {
		
		
		@JsonProperty("routing_number")
		private String routingNumber;
		
		@JsonProperty("account_number")
		private String accountNumber;
		
		@JsonProperty("ssn")
		private String socialSecurityNumber;
		
		@JsonProperty("driver_license_number")
		private String driverLicenseNumber;
		
		@JsonProperty("driver_license_state")
		private String driverLicenseState;
		
		
		public String getRoutingNumber() {
			return routingNumber;
		}
		public void setRoutingNumber(String routingNumber) {
			this.routingNumber = routingNumber;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getSocialSecurityNumber() {
			return socialSecurityNumber;
		}
		public void setSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
		}
		public String getDriverLicenseNumber() {
			return driverLicenseNumber;
		}
		public void setDriverLicenseNumber(String driverLicenseNumber) {
			this.driverLicenseNumber = driverLicenseNumber;
		}
		public String getDriverLicenseState() {
			return driverLicenseState;
		}
		public void setDriverLicenseState(String driverLicenseState) {
			this.driverLicenseState = driverLicenseState;
		}
		
				
	}
	
	public static class AdditionalPersonalInfo {
		
		@JsonProperty("dob")
		private String dateOfBirth;
		
		@JsonProperty("gender")
		private String gender;
		
		@JsonProperty("member_date")
		private String memberDate;
		
		@JsonProperty("terms_and_conditions_version")
		private String termsAndConditionVersion;
		
		
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getMemberDate() {
			return memberDate;
		}
		public void setMemberDate(String memberDate) {
			this.memberDate = memberDate;
		}
		public String getTermsAndConditionVersion() {
			return termsAndConditionVersion;
		}
		public void setTermsAndConditionVersion(String termsAndConditionVersion) {
			this.termsAndConditionVersion = termsAndConditionVersion;
		}
		
		
		
	}
	

	
	
}
