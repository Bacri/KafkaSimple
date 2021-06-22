import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration
import java.util.{Collections, Properties}
import scala.collection.convert.ImplicitConversions.`iterable AsScalaIterable`

object Consumer {
  def main(args: Array[String]) = {

    val propsConsumer = new Properties()
    propsConsumer.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9092")
    propsConsumer.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    propsConsumer.put(ConsumerConfig.GROUP_ID_CONFIG, "test")

    val deSer = new StringDeserializer
    val consumer = new KafkaConsumer(propsConsumer, deSer, deSer)

    consumer.subscribe(Collections.singletonList("test1"))

    while (true) {
      val records:ConsumerRecords[String, String] = consumer.poll(Duration.ofMillis(100))
      for (record <- records) {
        println("Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset())
      }
    }

    consumer.close()
  }
}
