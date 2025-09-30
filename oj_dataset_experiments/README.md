# Experiments using OJ instead of BCB
In our *Evaluating on Strict Clones* Section (IV.C), we re-run all our experiments after replacing BCB with OJ.
To run these experiments, follow the instructions below.

###### CodeBERT 
```sh
cd oj_dataset_experiments/codebert/
python oj_scb_baseline.py --train_on bcb
python oj_scb_baseline.py --train_on scb
python oj_scb_siamese.py --train_on bcb
python oj_scb_siamese.py --train_on scb
```

###### ASTNN
```sh
cd ../astnn
python pipeline_oj_scb.py
python oj_scb_baseline.py --train_on bcb
python oj_scb_baseline.py --train_on scb
python oj_scb_siamese.py --train_on bcb
python oj_scb_siamese.py --train_on scb
```

###### CodeGrid
```sh
cd ../codegrid
python oj_scb_baseline.py --train_on bcb
python oj_scb_baseline.py --train_on scb
python oj_scb_siamese.py --train_on bcb
python oj_scb_siamese.py --train_on scb
```