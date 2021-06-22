import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.kafka.common.serialization.StringSerializer
import java.util.Properties

object Producer {
  def main(args: Array[String]) = {
    val props = new Properties()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092, localhost:9092")

    val ser = new StringSerializer
    val producer = new KafkaProducer(props, ser, ser)

    def eventSend(event:String):Unit = producer.send(new ProducerRecord("test1", "first", event))

    eventSend("First Message")
    eventSend("Second Message")
    producer.close()
  }


}
