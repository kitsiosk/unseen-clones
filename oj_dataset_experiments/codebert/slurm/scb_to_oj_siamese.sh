#!/bin/bash
#SBATCH --job-name="generalization-study"
#SBATCH --mail-user=yourmail@example.com
#SBATCH --mail-type=end,fail
#SBATCH --time=24:00:00
#SBATCH --ntasks=1
#SBATCH --cpus-per-task=4
#SBATCH --mem-per-cpu=8G
#SBATCH --gres gpu:1
#SBATCH --error=siamese-scb-oj-%j.err
#SBATCH --output=siamese-scb-oj-%j.out

module purge all
module load gpu
module load mamba

. <path-to-venv>/bin/activate
source activate cudasupport

srun python oj_scb_siamese.py --train_on scb