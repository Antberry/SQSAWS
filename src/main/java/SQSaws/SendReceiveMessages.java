/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package SQSaws;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */

//snippet-keyword:[Amazon Simple Queue Service]

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.*;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;

import java.util.List;


public class SendReceiveMessages {

    private static final String QUEUE_NAME = "https://sqs.us-west-2.amazonaws.com/823352092046/QueueA"	;

    public static void main(String[] args) {
//        final AmazonSQS amazonSQS = AmazonSQSClientBuilder.defaultClient();
        final AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withRegion(Regions.US_WEST_2).build();


        String queueURL = QUEUE_NAME;

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueURL)
                .withMessageBody("hello world")
                .withDelaySeconds(5);
        amazonSQS.sendMessage(send_msg_request);

        SendMessageBatchRequest send_batch_request = new SendMessageBatchRequest()
                .withQueueUrl(queueURL)
                .withEntries(
                        new SendMessageBatchRequestEntry(
                                "msg_1", "Hello from message 1"),
                        new SendMessageBatchRequestEntry(
                                "msg_2", "Hello from message 2")
                                .withDelaySeconds(10));
        amazonSQS.sendMessageBatch(send_batch_request);

        List<Message> messages = amazonSQS.receiveMessage(queueURL).getMessages();

        for (Message m : messages) {
            System.out.println(m.getBody());
            amazonSQS.deleteMessage(queueURL, m.getReceiptHandle());
        }
    }

}
