#!/bin/bash
#SBATCH --job-name="generalization-study"
#SBATCH --mail-user=yourmail@example.com
#SBATCH --mail-type=end,fail
#SBATCH --time=01:00:00
#SBATCH --ntasks=1
#SBATCH --cpus-per-task=4
#SBATCH --mem-per-cpu=8G
#SBATCH --gres gpu:1
#SBATCH --error=baseline-bcb-scb-%j.err
#SBATCH --output=baseline-bcb-scb-%j.out

module purge all
module load gpu
module load mamba

. <path-to-venv>/bin/activate
source activate cudasupport

srun python bcb_scb_baseline.py --train_on bcb