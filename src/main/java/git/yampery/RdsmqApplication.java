package git.yampery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RdsmqApplication {

	/**
                            
     * @author: zhangxuesong 
     * @Description:
     * 
     * 设计方案:参考images 目录下的图片
     * 
     * 1. 将整个Redis当做消息池，以kv形式存储消息
     * 2. 使用ZSET做优先队列，按照score维持优先级
     * 3. 使用LIST结构，以先进先出的方式消费
     * 4. zset和list存储消息地址（对应消息池的每个key）
     * 5. 自定义路由对象，存储zset和list名称，以点对点的方式将消息从zset路由到正确的list
     * 6. 使用定时器维持路由
     * 7. 根据TTL规则实现消息延迟
     * @date:   2019年6月6日 下午7:32:36   
     * @Param 
     *
     */
	public static void main(String[] args) {
		SpringApplication.run(RdsmqApplication.class, args);
	}
}
