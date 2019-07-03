package com.zhangyang.consumber;


import com.zhangyang.config.RabbitConfigure2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMsg2 {

    /**
     * === 在RabbitMQ上创建queue,exchange,binding 方法二：直接在@RabbitListener声明 begin ===
     * 接收
     * @param content
     */
   /* @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
            value = @Queue(value = RabbitConfigure2.SPRING_BOOT_QUEUE+"3", durable = "true", autoDelete="true"),
            exchange = @Exchange(value = RabbitConfigure2.SPRING_BOOT_EXCHANGE, type = ExchangeTypes.TOPIC),
            key = RabbitConfigure2.SPRING_BOOT_BIND_KEY)
    )*/
    @RabbitListener(queues = RabbitConfigure2.SPRING_BOOT_QUEUE)
    public void receive_2(String content) {
        // ...
        System.out.println("[ReceiveMsg-2] receive msg: " + content);
    }

}
