package com.firstdata.payeezy.samples;

import com.firstdata.payeezy.JSONHelper;
import com.firstdata.payeezy.PayeezyClientHelper;
import com.firstdata.payeezy.models.enrollment.*;
import com.firstdata.payeezy.models.transaction.PayeezyResponse;

/** Example to illustrate an authorization using a credit card
 */
public class ConnectPayEnrollmentSample {

    public static void main(String [] args){
        EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
        enrollmentRequest.setFirstName("Squirtle");
        enrollmentRequest.setLastName("Pokemon");
        // set the address
        com.firstdata.payeezy.models.enrollment.Address address = new Address();
        address.setAddressLine1("7979 Westheimer");
        address.setState("TX");
        address.setCity("Houston");
        address.setCountry("USA");
        address.setEmail("jsmith@email.com");
        address.setZip("77063");
        enrollmentRequest.setAddress(address);
        //set the phone
        Address.Phone phone = new Address.Phone();
        phone.setType("MOBILE");
        phone.setNumber("9999955555");
        address.setPhone(phone);
        //set the Application
        EnrollmentApp enrollmentApp = new EnrollmentApp();
        enrollmentRequest.setEnrollmentApplication(enrollmentApp);
        enrollmentApp.setApplication("PayeezyACH");
        enrollmentApp.setDevice("DeviceXYZ123");
        enrollmentApp.setImei("IMEI76856745");
        enrollmentApp.setApplicationId("76ed6b08-224d-4f2e-9771-28cb5c9f26bd");
        enrollmentApp.setDeviceId("DeviceID65657");
        enrollmentApp.setIpAddress("192.168.1.1");
        enrollmentApp.setTrueIpAddress("192.168.1.1");
        enrollmentApp.setOrganizationId("FirtsDataInternalUAID9999");

        EnrollmentRequest.EnrollmentUser user = new EnrollmentRequest.EnrollmentUser();
        user.setRoutingNumber("311373125");
        user.setAccountNumber("728001010");
        enrollmentRequest.setEnrollmentUser(user);

        PayeezyClientHelper clientHelper = new PayeezyClientHelper();

        try{
            PayeezyResponse payeezyResponse = clientHelper.enrollInConnectPay(enrollmentRequest);
            System.out.println("Status Code:"+payeezyResponse.getStatusCode());
            System.out.println("Response:"+payeezyResponse.getResponseBody());
            JSONHelper helper = new JSONHelper();
            ConnectPayTokenResponse enrollmentResponse = helper.fromJson(payeezyResponse.getResponseBody(), ConnectPayTokenResponse.class);
            // Validate Micro Deposits
            BAARequest baaRequest = new BAARequest();
            baaRequest.setEnrollmentId(enrollmentResponse.getEnrollmentId());
            baaRequest.setAuthenticationAnswer(11066);
            PayeezyResponse validationResponse = clientHelper.validateMicroDeposit(baaRequest);
            System.out.println("Status Code:"+validationResponse.getStatusCode());
            System.out.println("Response:"+validationResponse.getResponseBody());

            // update enrollment data data
            // the below example updates the address associated with the user
            enrollmentRequest.setEnrollmentId(enrollmentResponse.getEnrollmentId());
            address.setAddressLine1("2000 Broadway Street");
            address.setState("CA");
            address.setCity("Redwood City");
            address.setZip("07789");

            PayeezyResponse updateResponse =  clientHelper.updateConnectPayEnrollment(enrollmentRequest);
            System.out.println("Status Code:"+updateResponse.getStatusCode());
            System.out.println("Response:"+updateResponse.getResponseBody());

            // Close ConnectPay Enrollment
            enrollmentRequest.setReason("Fraudulent Activity");
            PayeezyResponse closeResponse = clientHelper.closeConnectPayEnrollment(enrollmentRequest);
            System.out.println("Status Code:"+closeResponse.getStatusCode());
            System.out.println("Response:"+closeResponse.getResponseBody());

        }catch (Exception e){
            e.printStackTrace();
       }
       System.exit(0);
    }
}
