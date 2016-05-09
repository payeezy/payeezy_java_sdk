# payeezy_java_sdk
Payeezy Java SDK

Payeezy Java SDK is built to make developers life easy to integrate with the Payeezy API (https://developers.payeezy.com) for processing payements with various payement methods. Download the SDK, install it and start testing against the sandbox environment with developer credentials.

To install it, run java -jar payeezy-java-client-1.0.jar and answer the questions to setup your credentials. Inputs apikey, token, secret, js_security_key (if you are transarmor enabled and plan on making token based transactions) and environment are mandatory. Choose sandbox if you are trying the documented api's. This will create a file .payeezy.properties in your home directory with the configuration settings for the SDK.  You can regenerate this file anytime by rerunning, or you may edit the settings manually.

Maven

1) Add the dependency

For Maven:

Add the following dependency in your pom.xml
	<dependency>
		<groupId>com.firstdata.payeezy</groupId>
		<artifactId>payeezy-java-client</artifactId>
		<version>1.0</version>
	</dependency>


Create your configuration file with one of the following
	Run java -jar payeezy-java-client-1.0.jar
	Add file .payeezy.properties to your home directory with the correct properties in it

Use PayeezyClientHelper provides different methods to integrate with different transactions seemlessly. The SDK is supplied with objects to build your transaction requests easily and pass to the appropriate functions defined in PayeezyClientHelper.

You can use the alternative constructor PayeezyClientHelper(Properties properties) to pass the properties without the need of running the client to setup your payeezy configuration properties.

Please refer to PayeezyClientHelper java documentation to understand the various methods available.

Primary Transactions
-------------------------

1) Authorize
2) Purchase
3) Authorize_score
4) Score_only (Applicable to all payment methods)
5) Purchase_Score (Valid only for Value link)


Secondary Transactions
-------------------------
Secondary transactions like void, refund can be performed once a primary transaction is completed in case if you need to reverse a transaction.

Tokenize Credit Cards
-----------------------
Credit Cards can be tokenized using our secure tokens api.

# TokenBased Transactions - 
*	Generate Token with ta_token - auth false - GET API
*	Generate Token with ta_token - auth true - GET API
*	Generate Token without  ta_token & auth -  - GET API with 0$ Auth

## Contributing

1. Fork it 
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request  


## Feedback
We appreciate the time you take to try out our sample code and welcome your feedback. Here are a few ways to get in touch:
* For generally applicable issues and feedback, create an issue in this repository.
* support@payeezy.com - for personal support at any phase of integration
* [1.855.799.0790](tel:+18557990790)  - for personal support in real time 

## Terms of Use
Terms and conditions for using Payeezy Direct API SDK: Please see [Payeezy Terms & conditions](https://developer.payeezy.com/terms-use)
 
### License
The Payeezy Java SKD is open source and available under the MIT license. See the LICENSE file for more info.

