package com.firstdata.payeezy.client;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

/**
 * This takes the input from the user to setup the information required for processing transactions.
 * The user can manually edit the configuration by locating the .payeezy_sdk.properties file
 */
public class PayeezyClientSetup {


	@SuppressWarnings("serial")
	private static final HashMap<String,String> URL_MAP = new HashMap<String,String>() {
		{
			put("sandbox","https://api-cert.payeezy.com");
			put("production","https://api.payeezy.com");
		}
	};
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = (new PayeezyConfiguration()).load();
		Properties config = new Properties();
		PrintStream configFile = new PrintStream(file);
		String lastUserInput;

		BufferedReader stdin = new BufferedReader
	      (new InputStreamReader(System.in));

		System.out.println("Welcome to Payeezy Java_SDK");
		System.out.print("Please input your API Key: ");
		config.put("apikey", stdin.readLine());
		System.out.print("Please input your token: ");
		config.put("token", stdin.readLine());
		System.out.print("Please input your secret: ");
		config.put("pzsecret", stdin.readLine());
		System.out.print("Please input your JS Security Key: ");
		config.put("js_security_key", stdin.readLine());
		boolean badInput = false;
		do{
			if( badInput ){
				System.out.println("====== Invalid choice entered ======");
			}
			System.out.println("Please choose an environment from the following list (example: 'sandbox'):");
			System.out.println("\tsandbox => https://api-cert.payeezy.com");
			System.out.println("\tproduction => https://api.payeezy.com");
			System.out.println("\tother => You will be asked for all the values");
			lastUserInput = stdin.readLine();
			if(
				lastUserInput.compareToIgnoreCase("sandbox") == 0 ||
				lastUserInput.compareToIgnoreCase("production") == 0
			) {
				// standard predefined cases
				config.put("url", URL_MAP.get(lastUserInput.toLowerCase()));
				badInput = false;
			} else if(lastUserInput.compareToIgnoreCase("other") == 0){
				// user wants to enter custom values
				System.out.println("Please input the URL for online transactions (ex: https://api-cert.payeezy.com):");
				config.put("url", stdin.readLine());
				badInput = false;
			} else{
				// error condition
				badInput = true;
			}
		} while( badInput );

		System.out.println("Values set for host: ");
		System.out.println("\n\tURL for transactions: " + config.getProperty("url"));
		System.out.print("Please input the proxy host, if no proxy hit enter: ");
		lastUserInput = stdin.readLine();
		config.put("proxyHost", (lastUserInput == null ? "" : lastUserInput));
		System.out.print("Please input the proxy port, if no proxy hit enter: ");
		lastUserInput = stdin.readLine();
		config.put("proxyPort", (lastUserInput == null ? "" : lastUserInput));
		//default http timeout set to 500 ms
		config.put("timeout", "500");
		config.put("printjson", "false");

		config.store(configFile, "");
		System.out.println("The Payeezy Configuration is complete, the file is located at " + file.getAbsolutePath());
	}
}
