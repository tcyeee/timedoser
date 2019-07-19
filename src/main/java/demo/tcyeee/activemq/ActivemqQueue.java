//package demo.tcyeee.activemq;
//
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * 消息的生产者
// *
// * @author tcyeee
// * @since 2018/4/1 22:18
// */
//@RestController
//public class ActivemqQueue {
//
//    @Resource
//    private JmsMessagingTemplate jmsMessagingTemplate;
//
//    @RequestMapping("/send")
//    public void send(String text) {
//
//        jmsMessagingTemplate.convertAndSend("cy", text);
//    }
//
//}
