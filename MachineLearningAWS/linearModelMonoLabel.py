bucket_name = 'recomendation' 
object_key = 'testFile7.csv'

import os
import sys
import boto3
import re
import sagemaker
from sagemaker import get_execution_role
import pandas as pd
import numpy as np
import io
import sagemaker.amazon.common as smac


if sys.version_info[0] < 3: 
    from StringIO import StringIO # Python 2.x
else:
    from io import StringIO # Python 3.x
#from smart_open import open

# retrieve and parse dataset that will be used to train the algo from our s3 bucket
s3 = boto3.client('s3')
csv_obj = s3.get_object(Bucket=bucket_name, Key=object_key)
body = csv_obj['Body']
csv_string = body.read().decode('utf-8')
df = pd.read_csv(StringIO(csv_string))

# split the data : 60 % for the training, 20 % for the validation and 20 % for the testing
size = len(df)
trainInterval = (int(size*0.6))
validInterval = (int(size*0.8))

train_set = df.loc[0:trainInterval]
valid_set = df.loc[trainInterval+1:validInterval]
test_set = df.loc[validInterval+1:size]

# we drop the predicted result because it makes no sense to have it to train the algo. It is only used to validate the result
x_train = train_set.drop('like', axis = 1)
y_train = train_set['like']

x_valid = valid_set.drop('like', axis = 1)
y_valid = valid_set['like']

x_test = test_set.drop('like', axis = 1)
y_test = test_set['like']




class_estimator = sagemaker.LinearLearner(role=sagemaker.get_execution_role(),
                                               train_instance_count=1,
                                               train_instance_type='ml.t2.medium', 
                                               predictor_type='binary_classifier')
#doesn't work because ml.t2.medium is not powerfull enough to run the algo. See comment bellow for the error message
# ClientError: An error occurred (ValidationException) when calling the CreateTrainingJob operation: 1 validation error detected: Value 'ml.t2.medium' at 'resourceConfig.instanceType' failed to satisfy constraint: Member must satisfy enum value set: [ml.p2.xlarge, ml.m5.4xlarge, ml.m4.16xlarge, ml.p3.16xlarge, ml.m5.large, ml.p2.16xlarge, ml.c4.2xlarge, ml.c5.2xlarge, ml.c4.4xlarge, ml.c5.4xlarge, ml.g4dn.xlarge, ml.g4dn.12xlarge, ml.c4.8xlarge, ml.g4dn.2xlarge, ml.c5.9xlarge, ml.g4dn.4xlarge, ml.c5.xlarge, ml.g4dn.16xlarge, ml.c4.xlarge, ml.g4dn.8xlarge, ml.c5.18xlarge, ml.p3dn.24xlarge, ml.p3.2xlarge, ml.m5.xlarge, ml.m4.10xlarge, ml.m5.12xlarge, ml.m4.xlarge, ml.m5.24xlarge, ml.m4.2xlarge, ml.p2.8xlarge, ml.m5.2xlarge, ml.p3.8xlarge, ml.m4.4xlarge]


train_records = class_estimator.record_set(x_train.values, y_train.values, channel='train')
val_records = class_estimator.record_set(x_valid.values, y_valid.values, channel='validation')
test_records = class_estimator.record_set(x_test.values, y_test.values, channel='test')

class_estimator.fit([train_records, val_records, test_records])