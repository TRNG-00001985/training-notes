# Lecture/ Guided Plan

1. Cloud Computing
2. IAM
3. EC2
4. RDS
5. S3


### Cloud Computing

**Service Types**
- IaaS
- PaaS 
- SaaS 


![IaaS, PaaS, SaaS](./images/iaas-paas-saas.png)


**Public Cloud**
- Cloud resources and services are hosted and managed by a third-party cloud provider (ex: Amazon Web Services (AWS), Microsoft Azure, Google Cloud Platform).
- Users access these resources over the internet on a pay-as-you-go or subscription basis.

**Private Cloud**
- A cloud computing environment hosted and managed within an organization's own data center.
- Provides more control and privacy but requires more resources and maintenance.

### AWS

**Budget Alerts**
- AWS provides budgeting tools to monitor and control costs.
- you can set custom budgets and receive alerts when your actual or forecasted costs exceed the budgeted amount.

#### IAM (Identity and Access Management)

**Users**
- an IAM user is an individual identity with specific permissions to access and manage AWS resources.
- each user has unique security credentials (access key ID and secret access key).

**User Groups**
- a collection of IAM users.
- permissions can be assigned to groups instead of individual users for easier management.

**Roles**
- an IAM role is an identity with specific permissions that can be assumed by AWS services.
- roles are used to grant temporary, limited privileges instead of creating and managing long-term credentials.
# Lecture Plan

- AWS Services
- Console, CLI, SDK's
- Compute
  - EC2
  - AMI
  - EBS
  - Security Groups
  - ASG
---

### AWS Services Overview

**Compute:**

- EC2
- Elastic beanstalk
- ECS, App Sevice, Fargate and EKS

**Storage:**

- S3
- EBS
- EFS

**Database:**

- RDS
- Aurora
- ElastiCache
- DynamoDB


**Networking:**

- VPC
- ELB, API gateway
- Cloud Font, Route53

### Console, CLI and SDKs


One can access AWS account using console, CLI and SDK. 

1. console: UI
2. CLI: aws cli and access keys
3. AWS SDK: boto 3 (python)


[AWS cli installation](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)


## Compute

- computational resources. processing power, storage, networking, memory etc. 

examples:

1. EC2
2. Elastic bean stalk
3. Containers: ECS, EKS, Fargate, App runnner
4. Serverless: Lambda

### EC2 (Elastic Compute Cloud)

#### Instance type:

General Purpose: balance of copute, memory and networking resources.

ex: to deploy web applications

Compute optimized: applicatios that require high performance procerrs.

ex: gaming, ML, batch processing.

Memory optimised: applications that require large ammounts of RAM.


Accelerated Computing: hardware accessors. 

ex: floating point number, graphics processing.

HPC Optimized: High perfomance computing

ex: complex simulations (fem), deep learning.

Storage Optimized: High read and write to local staoge. 

ex: big data and DWH.

**Features:**

1. fixed performce
2. burstable performance



[instance type](https://aws.amazon.com/ec2/instance-types/)

#### pricing models


- on demand
- savings plan
- spot instances
- reserved:
  - on-demand reservations
  - capacity blocks for ML
  - dedicated hosts

<i><b>Note</b>

- aws ec2, ebs are billed per seconds. 
- per sec billing is supported for AWS Linux, Redhat, ubuntu and Ubantu pro.
</i>

#### AMI

- Amazon Machine image is a supported image from AWS to launch and instance.
- AMI includes, EBS snapshots, launch permisions, block device mapping
- custom AMI can be created.
- AMIs can be sold and bought from the market place/

#### EBS

- Elastic Block Store is provides scalable and high performance storage for EC2.

- Volumes : attachable storage volumes for EC2.

**types:**

  - gp3
  - gp3 throughput
  - gp3  iops
  - gp2
  - io2 storage
  - io2 iops



[EBS volume types](https://docs.aws.amazon.com/ebs/latest/userguide/ebs-volume-types.html)

- Snapshots : backup for EBS at a particular of time. 

  - standard
  - archive

- EBS benifits include, scalability, backup and recovery, availability, archiving and data protection.


[EBS Volume access](https://docs.aws.amazon.com/ebs/latest/userguide/ebs-using-volumes.html)


using EBS volumes


1. command to list block storage

```bash
lsblk

# to get info of the ebs volume

sudo lsblk -f
```

2. command to create file system - optional (applicable only when the file system is not created for an ebs volume)
  
```bash
sudo mkfs -t xfs /dev/path/to/ebs
```

3. mount 

```bash
sudo mount /dev/path/to/ebs /dir
```

4. un-mount

```bash
sudo umount /dir 

sudo umount -a
```


to add new partitions to a ebs volume


```bash
sudo gdisk /dev/path/to/ebs

commands : 

n - to add new partinions
```


#### ssh to ec2


```bash
ssh -i /path/to/pem ec2-user@publicip/dns
```

#### Security Groups

**Inbound and outbound rules:**


#### ASG

**Auto Scaling:**  Increase  or decrase in compute based on the requirement


- Horizantal 
- Vertical

- Auto Scaling Groups:
- created from a launch template
- desired, min and max count for instances
- ASG policies: 

- target metrics

- cpu unitization
- network (bytes)
- Load balancer no of requets

[ASG reference ](https://docs.aws.amazon.com/autoscaling/ec2/userguide/auto-scaling-groups.html)

[ASG step claning policy](https://docs.aws.amazon.com/autoscaling/ec2/userguide/as-scaling-simple-step.html)



**pricing guide**

[ec2 pricing](https://aws.amazon.com/ec2/pricing/on-demand/)
[ebs pricing](https://aws.amazon.com/ebs/pricing/)



[AWS Pricing Calculator](https://calculator.aws/)


