package model;

import twitter4j.conf.ConfigurationBuilder;

public class Config {
	public static ConfigurationBuilder getOAuth() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("rkmgVX3HTnQRLFBlGMxtA1KKH")
				.setOAuthConsumerSecret("ahSdYuN1CGCCus4QhnuNAVECKTYLMNWcpilM8Xo7AxXVV4VxOH")
				.setOAuthAccessToken("4801131805-4A1sWliUkfBb3rygz5TcfgX32FuENNi0NVfbr1J")
				.setOAuthAccessTokenSecret("V9g0cERTgiF7uzwaxqFRLTu18K6sV9us9ABpqDYsLdzDb");

		return cb;
	}
}