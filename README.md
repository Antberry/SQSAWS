# Sending and Recieving To/From SQS

## Setup SQS

From the AWS SQS console
- create new Queue
- Permissions recieve messages and delete messages
- click box labels everybody

## Create a Java Application
- Use AWS docs for SQS to setup Java application to send and recieve Messages.
[Docs](https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/examples-sqs-messages.html)
- Copy QueueA URL from SQS and add it into your Java application
- add this dependency in you build.gradle (compile 'com.amazonaws:aws-java-sdk-sqs:1.11.587')

