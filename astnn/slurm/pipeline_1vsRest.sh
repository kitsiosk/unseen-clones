#!/bin/bash
#SBATCH --job-name="generalization-study"
#SBATCH --mail-user=yourmail@example.com
#SBATCH --mail-type=end,fail
#SBATCH --time=00:10:00
#SBATCH --ntasks=1
#SBATCH --cpus-per-task=4
#SBATCH --mem-per-cpu=8G
#SBATCH --error=pipeline-1vsRest-%j.err
#SBATCH --output=pipeline-1vsRest-%j.out

module purge all
module load mamba

. <path-to-venv>/bin/activate
source activate cudasupport

srun python pipeline_1vsRest.py
