Performance Implications of Cloud Database Selection for Serverless Data Pipelines

With the progressive growth in popularity of cloud computing technologies, an increasingly large number of users are turning to the cloud to build applications that are scalable, flexible, and cost-effective. We perform a case study on two different databases provided by Amazon Web Services (AWS), DynamoDB and RDS, when used alongside AWS Lambda. We analyze for run-time and throughput to develop an understanding of performance to determine the ideal database for usage with AWS Lambda. DynamoDB, a NoSQL database, has excellent query times but poor load times when run with AWS Lambda, while RDS, a SQL database, has excellent load times but worse query times. The ideal choice for applications with AWS Lambda and FaaS depends then on the specific needs of the application.


