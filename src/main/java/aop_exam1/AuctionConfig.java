package aop_exam1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AuctionConfig {
	@Bean
	public AuctionInterface getAuctionDao() {
		return new AuctionDao();
	}
	
	@Bean
	public AuctionAdvice getAuction() {
		return new AuctionAdvice();
	}
}
