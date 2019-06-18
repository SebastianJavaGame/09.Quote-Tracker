package com.scislak.logic;

import java.io.IOException;
import java.net.InetAddress;

public class ConnectionPage {
	
	public static boolean ableToGeneralConnection() {
		int timeout = 2000;
		  InetAddress[] addresses;
		try {
			addresses = InetAddress.getAllByName("www.google.com");
		  for (InetAddress address : addresses) {
		    if (address.isReachable(timeout))
		      return true;
		    else
		      return false;
		  }
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
