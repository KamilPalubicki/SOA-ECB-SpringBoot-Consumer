package amw.ecb.ecbconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class KafkaListeners extends SQLiteOperations {

    @KafkaListener(topics = "currenciesTopic", groupId = "ECB", containerFactory = "currencyKafkaListenerContainerFactory")
    public void listenGroupECB(Currency currency) {
        System.out.println("Received message: " + currency.getRate());
        addData(currency);
    }

    @PostConstruct
    public void onStartup() {
        deleteData();
    }
}
