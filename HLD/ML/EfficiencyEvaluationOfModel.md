## Efficiency Evaluation for a machine learning model


- The efficiency of a model is measured by accuracy metrics on the test dataset
- For example suppose we are going to test 100 patient for a given deceise 
- Before report coming doctor need to predict whether they are infected with the deciese or not
- Suppose in actual 50 patient is positive and 50 are negative 




| Actual              | Positive | Negative |
|---------------------|----------|----------|
 Predicted(positve)  | TP       | FP       |
| Predicted(negative) | FN       | TN




we have to term which is used to determine the efficiency of a model 

#### Precision 
- it provide information about positive class prediction again positive predicted by model 
- Precision  = TP/(TP+FP)


#### Recall
- it provide information about positive class prediction against actual positive
- Recall  = TP/(TP+FN)





#### Notes
- As precision and recall is contradictory metrics so model have to have some balence between these value.
- A model is efficiency is measured by F1 score which is nothing but harmonic mean of precesion and recall
     ```F1  =2*(presision*recall)/(precession+recall)```
- here we are given an equal wait for both presision andd recall but in real world we can define the F(beta) where beta give the waight information for presision and recall
